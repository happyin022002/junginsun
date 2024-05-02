/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFSparePartInventoryListVO.java
*@FileTitle : RFSparePartInventoryListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.15  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.generalmanage.reefersparepartmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RFSparePartInventoryListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RFSparePartInventoryListVO> models = new ArrayList<RFSparePartInventoryListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String sprSplDt = null;
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String sprTpCd = null;
	/* Column Info */
	private String invtRmk = null;
	/* Column Info */
	private String dchgDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String sprChkDt = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RFSparePartInventoryListVO() {}

	public RFSparePartInventoryListVO(String ibflag, String pagerows, String updDt, String sprSplDt, String vslCd, String sprTpCd, String invtRmk, String dchgDt, String creDt, String vslSlanCd, String sprChkDt, String creUsrId, String vslEngNm, String updUsrId, String laneCd) {
		this.updDt = updDt;
		this.sprSplDt = sprSplDt;
		this.laneCd = laneCd;
		this.vslCd = vslCd;
		this.sprTpCd = sprTpCd;
		this.invtRmk = invtRmk;
		this.dchgDt = dchgDt;
		this.creDt = creDt;
		this.vslSlanCd = vslSlanCd;
		this.sprChkDt = sprChkDt;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.vslEngNm = vslEngNm;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("spr_spl_dt", getSprSplDt());
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("spr_tp_cd", getSprTpCd());
		this.hashColumns.put("invt_rmk", getInvtRmk());
		this.hashColumns.put("dchg_dt", getDchgDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("spr_chk_dt", getSprChkDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("spr_spl_dt", "sprSplDt");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("spr_tp_cd", "sprTpCd");
		this.hashFields.put("invt_rmk", "invtRmk");
		this.hashFields.put("dchg_dt", "dchgDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("spr_chk_dt", "sprChkDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
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
	 * @return sprSplDt
	 */
	public String getSprSplDt() {
		return this.sprSplDt;
	}
	
	/**
	 * Column Info
	 * @return laneCd
	 */
	public String getLaneCd() {
		return this.laneCd;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return sprTpCd
	 */
	public String getSprTpCd() {
		return this.sprTpCd;
	}
	
	/**
	 * Column Info
	 * @return invtRmk
	 */
	public String getInvtRmk() {
		return this.invtRmk;
	}
	
	/**
	 * Column Info
	 * @return dchgDt
	 */
	public String getDchgDt() {
		return this.dchgDt;
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
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return sprChkDt
	 */
	public String getSprChkDt() {
		return this.sprChkDt;
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
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
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
	 * @param sprSplDt
	 */
	public void setSprSplDt(String sprSplDt) {
		this.sprSplDt = sprSplDt;
	}
	
	/**
	 * Column Info
	 * @param laneCd
	 */
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param sprTpCd
	 */
	public void setSprTpCd(String sprTpCd) {
		this.sprTpCd = sprTpCd;
	}
	
	/**
	 * Column Info
	 * @param invtRmk
	 */
	public void setInvtRmk(String invtRmk) {
		this.invtRmk = invtRmk;
	}
	
	/**
	 * Column Info
	 * @param dchgDt
	 */
	public void setDchgDt(String dchgDt) {
		this.dchgDt = dchgDt;
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
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param sprChkDt
	 */
	public void setSprChkDt(String sprChkDt) {
		this.sprChkDt = sprChkDt;
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
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
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
		setSprSplDt(JSPUtil.getParameter(request, "spr_spl_dt", ""));
		setLaneCd(JSPUtil.getParameter(request, "lane_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSprTpCd(JSPUtil.getParameter(request, "spr_tp_cd", ""));
		setInvtRmk(JSPUtil.getParameter(request, "invt_rmk", ""));
		setDchgDt(JSPUtil.getParameter(request, "dchg_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setSprChkDt(JSPUtil.getParameter(request, "spr_chk_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RFSparePartInventoryListVO[]
	 */
	public RFSparePartInventoryListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RFSparePartInventoryListVO[]
	 */
	public RFSparePartInventoryListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RFSparePartInventoryListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] sprSplDt = (JSPUtil.getParameter(request, prefix	+ "spr_spl_dt", length));
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] sprTpCd = (JSPUtil.getParameter(request, prefix	+ "spr_tp_cd", length));
			String[] invtRmk = (JSPUtil.getParameter(request, prefix	+ "invt_rmk", length));
			String[] dchgDt = (JSPUtil.getParameter(request, prefix	+ "dchg_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] sprChkDt = (JSPUtil.getParameter(request, prefix	+ "spr_chk_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new RFSparePartInventoryListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (sprSplDt[i] != null)
					model.setSprSplDt(sprSplDt[i]);
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (sprTpCd[i] != null)
					model.setSprTpCd(sprTpCd[i]);
				if (invtRmk[i] != null)
					model.setInvtRmk(invtRmk[i]);
				if (dchgDt[i] != null)
					model.setDchgDt(dchgDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (sprChkDt[i] != null)
					model.setSprChkDt(sprChkDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRFSparePartInventoryListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RFSparePartInventoryListVO[]
	 */
	public RFSparePartInventoryListVO[] getRFSparePartInventoryListVOs(){
		RFSparePartInventoryListVO[] vos = (RFSparePartInventoryListVO[])models.toArray(new RFSparePartInventoryListVO[models.size()]);
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
		this.sprSplDt = this.sprSplDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprTpCd = this.sprTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invtRmk = this.invtRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchgDt = this.dchgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprChkDt = this.sprChkDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

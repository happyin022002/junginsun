/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DrwTrdInfoVO.java
*@FileTitle : DrwTrdInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.17  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

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

public class DrwTrdInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DrwTrdInfoVO> models = new ArrayList<DrwTrdInfoVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String fmRgnNm = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String toRgnNm = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String fmRgnCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String toRgnCd = null;
	/* Column Info */
	private String drwTrdCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;
	
	private List<DrwTrdInfoVO> 	drwTrdSaveVOs 	= null;


	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DrwTrdInfoVO() {}

	public DrwTrdInfoVO(String ibflag, String pagerows, String drwTrdCd, String fmRgnCd, String fmRgnNm, String toRgnCd, String toRgnNm, String deltFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.fmRgnNm = fmRgnNm;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.toRgnNm = toRgnNm;
		this.deltFlg = deltFlg;
		this.fmRgnCd = fmRgnCd;
		this.creDt = creDt;
		this.toRgnCd = toRgnCd;
		this.drwTrdCd = drwTrdCd;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("fm_rgn_nm", getFmRgnNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("to_rgn_nm", getToRgnNm());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("fm_rgn_cd", getFmRgnCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("to_rgn_cd", getToRgnCd());
		this.hashColumns.put("drw_trd_cd", getDrwTrdCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("fm_rgn_nm", "fmRgnNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("to_rgn_nm", "toRgnNm");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("fm_rgn_cd", "fmRgnCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("to_rgn_cd", "toRgnCd");
		this.hashFields.put("drw_trd_cd", "drwTrdCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return fmRgnNm
	 */
	public String getFmRgnNm() {
		return this.fmRgnNm;
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
	 * @return toRgnNm
	 */
	public String getToRgnNm() {
		return this.toRgnNm;
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
	 * @return fmRgnCd
	 */
	public String getFmRgnCd() {
		return this.fmRgnCd;
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
	 * @return toRgnCd
	 */
	public String getToRgnCd() {
		return this.toRgnCd;
	}
	
	/**
	 * Column Info
	 * @return drwTrdCd
	 */
	public String getDrwTrdCd() {
		return this.drwTrdCd;
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
	 * @return drwTrdSaveVOs
	 */
	public List<DrwTrdInfoVO> getdrwTrdSaveVOs() {
		return drwTrdSaveVOs;
	}

	/**
	 * @param List<DrwTrdInfoVO> drwTrdSaveVOs
	 */
	public void setdrwTrdSaveVOs(List<DrwTrdInfoVO> drwTrdSaveVOs) {
		this.drwTrdSaveVOs = drwTrdSaveVOs;
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
	 * @param fmRgnNm
	 */
	public void setFmRgnNm(String fmRgnNm) {
		this.fmRgnNm = fmRgnNm;
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
	 * @param toRgnNm
	 */
	public void setToRgnNm(String toRgnNm) {
		this.toRgnNm = toRgnNm;
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
	 * @param fmRgnCd
	 */
	public void setFmRgnCd(String fmRgnCd) {
		this.fmRgnCd = fmRgnCd;
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
	 * @param toRgnCd
	 */
	public void setToRgnCd(String toRgnCd) {
		this.toRgnCd = toRgnCd;
	}
	
	/**
	 * Column Info
	 * @param drwTrdCd
	 */
	public void setDrwTrdCd(String drwTrdCd) {
		this.drwTrdCd = drwTrdCd;
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
		setFmRgnNm(JSPUtil.getParameter(request, prefix + "fm_rgn_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setToRgnNm(JSPUtil.getParameter(request, prefix + "to_rgn_nm", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setFmRgnCd(JSPUtil.getParameter(request, prefix + "fm_rgn_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setToRgnCd(JSPUtil.getParameter(request, prefix + "to_rgn_cd", ""));
		setDrwTrdCd(JSPUtil.getParameter(request, prefix + "drw_trd_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DrwTrdInfoVO[]
	 */
	public DrwTrdInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DrwTrdInfoVO[]
	 */
	public DrwTrdInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DrwTrdInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] fmRgnNm = (JSPUtil.getParameter(request, prefix	+ "fm_rgn_nm", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] toRgnNm = (JSPUtil.getParameter(request, prefix	+ "to_rgn_nm", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] fmRgnCd = (JSPUtil.getParameter(request, prefix	+ "fm_rgn_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] toRgnCd = (JSPUtil.getParameter(request, prefix	+ "to_rgn_cd", length));
			String[] drwTrdCd = (JSPUtil.getParameter(request, prefix	+ "drw_trd_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DrwTrdInfoVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (fmRgnNm[i] != null)
					model.setFmRgnNm(fmRgnNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (toRgnNm[i] != null)
					model.setToRgnNm(toRgnNm[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (fmRgnCd[i] != null)
					model.setFmRgnCd(fmRgnCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (toRgnCd[i] != null)
					model.setToRgnCd(toRgnCd[i]);
				if (drwTrdCd[i] != null)
					model.setDrwTrdCd(drwTrdCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDrwTrdInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DrwTrdInfoVO[]
	 */
	public DrwTrdInfoVO[] getDrwTrdInfoVOs(){
		DrwTrdInfoVO[] vos = (DrwTrdInfoVO[])models.toArray(new DrwTrdInfoVO[models.size()]);
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
		this.fmRgnNm = this.fmRgnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRgnNm = this.toRgnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRgnCd = this.fmRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRgnCd = this.toRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drwTrdCd = this.drwTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

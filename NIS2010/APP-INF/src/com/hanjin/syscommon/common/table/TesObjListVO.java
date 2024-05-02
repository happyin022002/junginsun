/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : TesObjListVO.java
*@FileTitle : TesObjListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.02
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.02  
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TesObjListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TesObjListVO> models = new ArrayList<TesObjListVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String dfltCtnt = null;
	/* Column Info */
	private String minVal = null;
	/* Column Info */
	private String tmlMeasUtCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String objListAbbrNm = null;
	/* Column Info */
	private String tmlValTpCd = null;
	/* Column Info */
	private String deltDt = null;
	/* Column Info */
	private String interUseFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tmlObjListTpCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String maxVal = null;
	/* Column Info */
	private String dfltVal = null;
	/* Column Info */
	private String objListNm = null;
	/* Column Info */
	private String objListNo = null;
	/* Column Info */
	private String objRmk = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TesObjListVO() {}

	public TesObjListVO(String ibflag, String pagerows, String objListNo, String objListNm, String objListAbbrNm, String tmlObjListTpCd, String tmlMeasUtCd, String tmlValTpCd, String dfltCtnt, String dfltVal, String maxVal, String minVal, String objRmk, String interUseFlg, String deltFlg, String deltDt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.deltFlg = deltFlg;
		this.dfltCtnt = dfltCtnt;
		this.minVal = minVal;
		this.tmlMeasUtCd = tmlMeasUtCd;
		this.creDt = creDt;
		this.objListAbbrNm = objListAbbrNm;
		this.tmlValTpCd = tmlValTpCd;
		this.deltDt = deltDt;
		this.interUseFlg = interUseFlg;
		this.pagerows = pagerows;
		this.tmlObjListTpCd = tmlObjListTpCd;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.maxVal = maxVal;
		this.dfltVal = dfltVal;
		this.objListNm = objListNm;
		this.objListNo = objListNo;
		this.objRmk = objRmk;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("dflt_ctnt", getDfltCtnt());
		this.hashColumns.put("min_val", getMinVal());
		this.hashColumns.put("tml_meas_ut_cd", getTmlMeasUtCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("obj_list_abbr_nm", getObjListAbbrNm());
		this.hashColumns.put("tml_val_tp_cd", getTmlValTpCd());
		this.hashColumns.put("delt_dt", getDeltDt());
		this.hashColumns.put("inter_use_flg", getInterUseFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tml_obj_list_tp_cd", getTmlObjListTpCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("max_val", getMaxVal());
		this.hashColumns.put("dflt_val", getDfltVal());
		this.hashColumns.put("obj_list_nm", getObjListNm());
		this.hashColumns.put("obj_list_no", getObjListNo());
		this.hashColumns.put("obj_rmk", getObjRmk());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("dflt_ctnt", "dfltCtnt");
		this.hashFields.put("min_val", "minVal");
		this.hashFields.put("tml_meas_ut_cd", "tmlMeasUtCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("obj_list_abbr_nm", "objListAbbrNm");
		this.hashFields.put("tml_val_tp_cd", "tmlValTpCd");
		this.hashFields.put("delt_dt", "deltDt");
		this.hashFields.put("inter_use_flg", "interUseFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tml_obj_list_tp_cd", "tmlObjListTpCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("max_val", "maxVal");
		this.hashFields.put("dflt_val", "dfltVal");
		this.hashFields.put("obj_list_nm", "objListNm");
		this.hashFields.put("obj_list_no", "objListNo");
		this.hashFields.put("obj_rmk", "objRmk");
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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return dfltCtnt
	 */
	public String getDfltCtnt() {
		return this.dfltCtnt;
	}
	
	/**
	 * Column Info
	 * @return minVal
	 */
	public String getMinVal() {
		return this.minVal;
	}
	
	/**
	 * Column Info
	 * @return tmlMeasUtCd
	 */
	public String getTmlMeasUtCd() {
		return this.tmlMeasUtCd;
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
	 * @return objListAbbrNm
	 */
	public String getObjListAbbrNm() {
		return this.objListAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return tmlValTpCd
	 */
	public String getTmlValTpCd() {
		return this.tmlValTpCd;
	}
	
	/**
	 * Column Info
	 * @return deltDt
	 */
	public String getDeltDt() {
		return this.deltDt;
	}
	
	/**
	 * Column Info
	 * @return interUseFlg
	 */
	public String getInterUseFlg() {
		return this.interUseFlg;
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
	 * @return tmlObjListTpCd
	 */
	public String getTmlObjListTpCd() {
		return this.tmlObjListTpCd;
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
	 * @return maxVal
	 */
	public String getMaxVal() {
		return this.maxVal;
	}
	
	/**
	 * Column Info
	 * @return dfltVal
	 */
	public String getDfltVal() {
		return this.dfltVal;
	}
	
	/**
	 * Column Info
	 * @return objListNm
	 */
	public String getObjListNm() {
		return this.objListNm;
	}
	
	/**
	 * Column Info
	 * @return objListNo
	 */
	public String getObjListNo() {
		return this.objListNo;
	}
	
	/**
	 * Column Info
	 * @return objRmk
	 */
	public String getObjRmk() {
		return this.objRmk;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param dfltCtnt
	 */
	public void setDfltCtnt(String dfltCtnt) {
		this.dfltCtnt = dfltCtnt;
	}
	
	/**
	 * Column Info
	 * @param minVal
	 */
	public void setMinVal(String minVal) {
		this.minVal = minVal;
	}
	
	/**
	 * Column Info
	 * @param tmlMeasUtCd
	 */
	public void setTmlMeasUtCd(String tmlMeasUtCd) {
		this.tmlMeasUtCd = tmlMeasUtCd;
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
	 * @param objListAbbrNm
	 */
	public void setObjListAbbrNm(String objListAbbrNm) {
		this.objListAbbrNm = objListAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param tmlValTpCd
	 */
	public void setTmlValTpCd(String tmlValTpCd) {
		this.tmlValTpCd = tmlValTpCd;
	}
	
	/**
	 * Column Info
	 * @param deltDt
	 */
	public void setDeltDt(String deltDt) {
		this.deltDt = deltDt;
	}
	
	/**
	 * Column Info
	 * @param interUseFlg
	 */
	public void setInterUseFlg(String interUseFlg) {
		this.interUseFlg = interUseFlg;
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
	 * @param tmlObjListTpCd
	 */
	public void setTmlObjListTpCd(String tmlObjListTpCd) {
		this.tmlObjListTpCd = tmlObjListTpCd;
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
	 * @param maxVal
	 */
	public void setMaxVal(String maxVal) {
		this.maxVal = maxVal;
	}
	
	/**
	 * Column Info
	 * @param dfltVal
	 */
	public void setDfltVal(String dfltVal) {
		this.dfltVal = dfltVal;
	}
	
	/**
	 * Column Info
	 * @param objListNm
	 */
	public void setObjListNm(String objListNm) {
		this.objListNm = objListNm;
	}
	
	/**
	 * Column Info
	 * @param objListNo
	 */
	public void setObjListNo(String objListNo) {
		this.objListNo = objListNo;
	}
	
	/**
	 * Column Info
	 * @param objRmk
	 */
	public void setObjRmk(String objRmk) {
		this.objRmk = objRmk;
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
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setDfltCtnt(JSPUtil.getParameter(request, prefix + "dflt_ctnt", ""));
		setMinVal(JSPUtil.getParameter(request, prefix + "min_val", ""));
		setTmlMeasUtCd(JSPUtil.getParameter(request, prefix + "tml_meas_ut_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setObjListAbbrNm(JSPUtil.getParameter(request, prefix + "obj_list_abbr_nm", ""));
		setTmlValTpCd(JSPUtil.getParameter(request, prefix + "tml_val_tp_cd", ""));
		setDeltDt(JSPUtil.getParameter(request, prefix + "delt_dt", ""));
		setInterUseFlg(JSPUtil.getParameter(request, prefix + "inter_use_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTmlObjListTpCd(JSPUtil.getParameter(request, prefix + "tml_obj_list_tp_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMaxVal(JSPUtil.getParameter(request, prefix + "max_val", ""));
		setDfltVal(JSPUtil.getParameter(request, prefix + "dflt_val", ""));
		setObjListNm(JSPUtil.getParameter(request, prefix + "obj_list_nm", ""));
		setObjListNo(JSPUtil.getParameter(request, prefix + "obj_list_no", ""));
		setObjRmk(JSPUtil.getParameter(request, prefix + "obj_rmk", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TesObjListVO[]
	 */
	public TesObjListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TesObjListVO[]
	 */
	public TesObjListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TesObjListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] dfltCtnt = (JSPUtil.getParameter(request, prefix	+ "dflt_ctnt", length));
			String[] minVal = (JSPUtil.getParameter(request, prefix	+ "min_val", length));
			String[] tmlMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "tml_meas_ut_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] objListAbbrNm = (JSPUtil.getParameter(request, prefix	+ "obj_list_abbr_nm", length));
			String[] tmlValTpCd = (JSPUtil.getParameter(request, prefix	+ "tml_val_tp_cd", length));
			String[] deltDt = (JSPUtil.getParameter(request, prefix	+ "delt_dt", length));
			String[] interUseFlg = (JSPUtil.getParameter(request, prefix	+ "inter_use_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tmlObjListTpCd = (JSPUtil.getParameter(request, prefix	+ "tml_obj_list_tp_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] maxVal = (JSPUtil.getParameter(request, prefix	+ "max_val", length));
			String[] dfltVal = (JSPUtil.getParameter(request, prefix	+ "dflt_val", length));
			String[] objListNm = (JSPUtil.getParameter(request, prefix	+ "obj_list_nm", length));
			String[] objListNo = (JSPUtil.getParameter(request, prefix	+ "obj_list_no", length));
			String[] objRmk = (JSPUtil.getParameter(request, prefix	+ "obj_rmk", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new TesObjListVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (dfltCtnt[i] != null)
					model.setDfltCtnt(dfltCtnt[i]);
				if (minVal[i] != null)
					model.setMinVal(minVal[i]);
				if (tmlMeasUtCd[i] != null)
					model.setTmlMeasUtCd(tmlMeasUtCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (objListAbbrNm[i] != null)
					model.setObjListAbbrNm(objListAbbrNm[i]);
				if (tmlValTpCd[i] != null)
					model.setTmlValTpCd(tmlValTpCd[i]);
				if (deltDt[i] != null)
					model.setDeltDt(deltDt[i]);
				if (interUseFlg[i] != null)
					model.setInterUseFlg(interUseFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tmlObjListTpCd[i] != null)
					model.setTmlObjListTpCd(tmlObjListTpCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (maxVal[i] != null)
					model.setMaxVal(maxVal[i]);
				if (dfltVal[i] != null)
					model.setDfltVal(dfltVal[i]);
				if (objListNm[i] != null)
					model.setObjListNm(objListNm[i]);
				if (objListNo[i] != null)
					model.setObjListNo(objListNo[i]);
				if (objRmk[i] != null)
					model.setObjRmk(objRmk[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTesObjListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TesObjListVO[]
	 */
	public TesObjListVO[] getTesObjListVOs(){
		TesObjListVO[] vos = (TesObjListVO[])models.toArray(new TesObjListVO[models.size()]);
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
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltCtnt = this.dfltCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minVal = this.minVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlMeasUtCd = this.tmlMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.objListAbbrNm = this.objListAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlValTpCd = this.tmlValTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltDt = this.deltDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interUseFlg = this.interUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlObjListTpCd = this.tmlObjListTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxVal = this.maxVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltVal = this.dfltVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.objListNm = this.objListNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.objListNo = this.objListNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.objRmk = this.objRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

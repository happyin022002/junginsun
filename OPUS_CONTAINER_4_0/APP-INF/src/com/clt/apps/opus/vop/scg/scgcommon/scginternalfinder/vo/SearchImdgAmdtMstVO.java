/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchImdgAmdtMstVO.java
*@FileTitle : SearchImdgAmdtMstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.17
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.17  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.scgcommon.scginternalfinder.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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

public class SearchImdgAmdtMstVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchImdgAmdtMstVO> models = new ArrayList<SearchImdgAmdtMstVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String actFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String imdgAmdtNo = null;
	/* Column Info */
	private String effFmDt = null;
	/* Column Info */
	private String imdgAmdtStndFlg = null;
	/* Column Info */
	private String imdgAmdtDesc = null;
	/* Column Info */
	private String effToDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchImdgAmdtMstVO() {}

	public SearchImdgAmdtMstVO(String ibflag, String pagerows, String imdgAmdtNo, String imdgAmdtStndFlg, String effFmDt, String effToDt, String imdgAmdtDesc, String actFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.actFlg = actFlg;
		this.creDt = creDt;
		this.imdgAmdtNo = imdgAmdtNo;
		this.effFmDt = effFmDt;
		this.imdgAmdtStndFlg = imdgAmdtStndFlg;
		this.imdgAmdtDesc = imdgAmdtDesc;
		this.effToDt = effToDt;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("act_flg", getActFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("imdg_amdt_no", getImdgAmdtNo());
		this.hashColumns.put("eff_fm_dt", getEffFmDt());
		this.hashColumns.put("imdg_amdt_stnd_flg", getImdgAmdtStndFlg());
		this.hashColumns.put("imdg_amdt_desc", getImdgAmdtDesc());
		this.hashColumns.put("eff_to_dt", getEffToDt());
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
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("act_flg", "actFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("imdg_amdt_no", "imdgAmdtNo");
		this.hashFields.put("eff_fm_dt", "effFmDt");
		this.hashFields.put("imdg_amdt_stnd_flg", "imdgAmdtStndFlg");
		this.hashFields.put("imdg_amdt_desc", "imdgAmdtDesc");
		this.hashFields.put("eff_to_dt", "effToDt");
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
	 * @return actFlg
	 */
	public String getActFlg() {
		return this.actFlg;
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
	 * @return imdgAmdtNo
	 */
	public String getImdgAmdtNo() {
		return this.imdgAmdtNo;
	}
	
	/**
	 * Column Info
	 * @return effFmDt
	 */
	public String getEffFmDt() {
		return this.effFmDt;
	}
	
	/**
	 * Column Info
	 * @return imdgAmdtStndFlg
	 */
	public String getImdgAmdtStndFlg() {
		return this.imdgAmdtStndFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgAmdtDesc
	 */
	public String getImdgAmdtDesc() {
		return this.imdgAmdtDesc;
	}
	
	/**
	 * Column Info
	 * @return effToDt
	 */
	public String getEffToDt() {
		return this.effToDt;
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
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param actFlg
	 */
	public void setActFlg(String actFlg) {
		this.actFlg = actFlg;
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
	 * @param imdgAmdtNo
	 */
	public void setImdgAmdtNo(String imdgAmdtNo) {
		this.imdgAmdtNo = imdgAmdtNo;
	}
	
	/**
	 * Column Info
	 * @param effFmDt
	 */
	public void setEffFmDt(String effFmDt) {
		this.effFmDt = effFmDt;
	}
	
	/**
	 * Column Info
	 * @param imdgAmdtStndFlg
	 */
	public void setImdgAmdtStndFlg(String imdgAmdtStndFlg) {
		this.imdgAmdtStndFlg = imdgAmdtStndFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgAmdtDesc
	 */
	public void setImdgAmdtDesc(String imdgAmdtDesc) {
		this.imdgAmdtDesc = imdgAmdtDesc;
	}
	
	/**
	 * Column Info
	 * @param effToDt
	 */
	public void setEffToDt(String effToDt) {
		this.effToDt = effToDt;
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
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setActFlg(JSPUtil.getParameter(request, prefix + "act_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setImdgAmdtNo(JSPUtil.getParameter(request, prefix + "imdg_amdt_no", ""));
		setEffFmDt(JSPUtil.getParameter(request, prefix + "eff_fm_dt", ""));
		setImdgAmdtStndFlg(JSPUtil.getParameter(request, prefix + "imdg_amdt_stnd_flg", ""));
		setImdgAmdtDesc(JSPUtil.getParameter(request, prefix + "imdg_amdt_desc", ""));
		setEffToDt(JSPUtil.getParameter(request, prefix + "eff_to_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchImdgAmdtMstVO[]
	 */
	public SearchImdgAmdtMstVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchImdgAmdtMstVO[]
	 */
	public SearchImdgAmdtMstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchImdgAmdtMstVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] actFlg = (JSPUtil.getParameter(request, prefix	+ "act_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] imdgAmdtNo = (JSPUtil.getParameter(request, prefix	+ "imdg_amdt_no", length));
			String[] effFmDt = (JSPUtil.getParameter(request, prefix	+ "eff_fm_dt", length));
			String[] imdgAmdtStndFlg = (JSPUtil.getParameter(request, prefix	+ "imdg_amdt_stnd_flg", length));
			String[] imdgAmdtDesc = (JSPUtil.getParameter(request, prefix	+ "imdg_amdt_desc", length));
			String[] effToDt = (JSPUtil.getParameter(request, prefix	+ "eff_to_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchImdgAmdtMstVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (actFlg[i] != null)
					model.setActFlg(actFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (imdgAmdtNo[i] != null)
					model.setImdgAmdtNo(imdgAmdtNo[i]);
				if (effFmDt[i] != null)
					model.setEffFmDt(effFmDt[i]);
				if (imdgAmdtStndFlg[i] != null)
					model.setImdgAmdtStndFlg(imdgAmdtStndFlg[i]);
				if (imdgAmdtDesc[i] != null)
					model.setImdgAmdtDesc(imdgAmdtDesc[i]);
				if (effToDt[i] != null)
					model.setEffToDt(effToDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchImdgAmdtMstVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchImdgAmdtMstVO[]
	 */
	public SearchImdgAmdtMstVO[] getSearchImdgAmdtMstVOs(){
		SearchImdgAmdtMstVO[] vos = (SearchImdgAmdtMstVO[])models.toArray(new SearchImdgAmdtMstVO[models.size()]);
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actFlg = this.actFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgAmdtNo = this.imdgAmdtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFmDt = this.effFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgAmdtStndFlg = this.imdgAmdtStndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgAmdtDesc = this.imdgAmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effToDt = this.effToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

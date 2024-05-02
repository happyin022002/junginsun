/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SamActTpMstVO.java
*@FileTitle : SamActTpMstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.19
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2011.05.19 김보배 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김보배
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SamActTpMstVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SamActTpMstVO> models = new ArrayList<SamActTpMstVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String delChk = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slsActTpCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String slsActSubTpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String slsActTpDesc = null;
	/* Column Info */
	private String slsActSubTpDesc = null;
	/* Column Info */
	private String updUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SamActTpMstVO() {}

	public SamActTpMstVO(String ibflag, String pagerows, String delChk, String userId, String creUsrId, String creDt, String updUsrId, String updDt, String slsActTpCd, String slsActTpDesc, String slsActSubTpCd, String slsActSubTpDesc) {
		this.updDt = updDt;
		this.delChk = delChk;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.slsActTpCd = slsActTpCd;
		this.userId = userId;
		this.slsActSubTpCd = slsActSubTpCd;
		this.creDt = creDt;
		this.slsActTpDesc = slsActTpDesc;
		this.slsActSubTpDesc = slsActSubTpDesc;
		this.updUsrId = updUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("del_chk", getDelChk());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sls_act_tp_cd", getSlsActTpCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("sls_act_sub_tp_cd", getSlsActSubTpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("sls_act_tp_desc", getSlsActTpDesc());
		this.hashColumns.put("sls_act_sub_tp_desc", getSlsActSubTpDesc());
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
		this.hashFields.put("del_chk", "delChk");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sls_act_tp_cd", "slsActTpCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("sls_act_sub_tp_cd", "slsActSubTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("sls_act_tp_desc", "slsActTpDesc");
		this.hashFields.put("sls_act_sub_tp_desc", "slsActSubTpDesc");
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
	 * @return delChk
	 */
	public String getDelChk() {
		return this.delChk;
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
	 * @return slsActTpCd
	 */
	public String getSlsActTpCd() {
		return this.slsActTpCd;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return slsActSubTpCd
	 */
	public String getSlsActSubTpCd() {
		return this.slsActSubTpCd;
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
	 * @return slsActTpDesc
	 */
	public String getSlsActTpDesc() {
		return this.slsActTpDesc;
	}
	
	/**
	 * Column Info
	 * @return slsActSubTpDesc
	 */
	public String getSlsActSubTpDesc() {
		return this.slsActSubTpDesc;
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
	 * @param delChk
	 */
	public void setDelChk(String delChk) {
		this.delChk = delChk;
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
	 * @param slsActTpCd
	 */
	public void setSlsActTpCd(String slsActTpCd) {
		this.slsActTpCd = slsActTpCd;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param slsActSubTpCd
	 */
	public void setSlsActSubTpCd(String slsActSubTpCd) {
		this.slsActSubTpCd = slsActSubTpCd;
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
	 * @param slsActTpDesc
	 */
	public void setSlsActTpDesc(String slsActTpDesc) {
		this.slsActTpDesc = slsActTpDesc;
	}
	
	/**
	 * Column Info
	 * @param slsActSubTpDesc
	 */
	public void setSlsActSubTpDesc(String slsActSubTpDesc) {
		this.slsActSubTpDesc = slsActSubTpDesc;
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
		setDelChk(JSPUtil.getParameter(request, prefix + "del_chk", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSlsActTpCd(JSPUtil.getParameter(request, prefix + "sls_act_tp_cd", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setSlsActSubTpCd(JSPUtil.getParameter(request, prefix + "sls_act_sub_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSlsActTpDesc(JSPUtil.getParameter(request, prefix + "sls_act_tp_desc", ""));
		setSlsActSubTpDesc(JSPUtil.getParameter(request, prefix + "sls_act_sub_tp_desc", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SamActTpMstVO[]
	 */
	public SamActTpMstVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SamActTpMstVO[]
	 */
	public SamActTpMstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SamActTpMstVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] delChk = (JSPUtil.getParameter(request, prefix	+ "del_chk", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slsActTpCd = (JSPUtil.getParameter(request, prefix	+ "sls_act_tp_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] slsActSubTpCd = (JSPUtil.getParameter(request, prefix	+ "sls_act_sub_tp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] slsActTpDesc = (JSPUtil.getParameter(request, prefix	+ "sls_act_tp_desc", length));
			String[] slsActSubTpDesc = (JSPUtil.getParameter(request, prefix	+ "sls_act_sub_tp_desc", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SamActTpMstVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (delChk[i] != null)
					model.setDelChk(delChk[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slsActTpCd[i] != null)
					model.setSlsActTpCd(slsActTpCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (slsActSubTpCd[i] != null)
					model.setSlsActSubTpCd(slsActSubTpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (slsActTpDesc[i] != null)
					model.setSlsActTpDesc(slsActTpDesc[i]);
				if (slsActSubTpDesc[i] != null)
					model.setSlsActSubTpDesc(slsActSubTpDesc[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSamActTpMstVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SamActTpMstVO[]
	 */
	public SamActTpMstVO[] getSamActTpMstVOs(){
		SamActTpMstVO[] vos = (SamActTpMstVO[])models.toArray(new SamActTpMstVO[models.size()]);
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
		this.delChk = this.delChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsActTpCd = this.slsActTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsActSubTpCd = this.slsActSubTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsActTpDesc = this.slsActTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsActSubTpDesc = this.slsActSubTpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

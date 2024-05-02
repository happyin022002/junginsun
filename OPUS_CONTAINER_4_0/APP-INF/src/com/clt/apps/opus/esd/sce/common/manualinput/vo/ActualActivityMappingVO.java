/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ActualActivityMappingVO.java
*@FileTitle : ActualActivityMappingVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.24
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.24  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.common.manualinput.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ActualActivityMappingVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ActualActivityMappingVO> models = new ArrayList<ActualActivityMappingVO>();
	
	/* Column Info */
	private String frmActStsMapgCd = null;
	/* Column Info */
	private String actCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chkActCd = null;
	/* Column Info */
	private String chkActStsMapgCd = null;
	/* Column Info */
	private String actFlg = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String actRcvTpCd = null;
	/* Column Info */
	private String chkActRcvTpCd = null;
	/* Column Info */
	private String actStsMapgCd = null;
	/* Column Info */
	private String frmActCd = null;
	/* Column Info */
	private String railItchgFlg = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ActualActivityMappingVO() {}

	public ActualActivityMappingVO(String ibflag, String pagerows, String actCd, String actRcvTpCd, String actStsMapgCd, String actFlg, String frmActCd, String frmActStsMapgCd, String userId, String chkActCd, String chkActStsMapgCd, String chkActRcvTpCd, String railItchgFlg) {
		this.frmActStsMapgCd = frmActStsMapgCd;
		this.actCd = actCd;
		this.ibflag = ibflag;
		this.chkActCd = chkActCd;
		this.chkActStsMapgCd = chkActStsMapgCd;
		this.actFlg = actFlg;
		this.userId = userId;
		this.actRcvTpCd = actRcvTpCd;
		this.chkActRcvTpCd = chkActRcvTpCd;
		this.actStsMapgCd = actStsMapgCd;
		this.frmActCd = frmActCd;
		this.pagerows = pagerows;
		this.railItchgFlg = railItchgFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("frm_act_sts_mapg_cd", getFrmActStsMapgCd());
		this.hashColumns.put("act_cd", getActCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chk_act_cd", getChkActCd());
		this.hashColumns.put("chk_act_sts_mapg_cd", getChkActStsMapgCd());
		this.hashColumns.put("act_flg", getActFlg());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("act_rcv_tp_cd", getActRcvTpCd());
		this.hashColumns.put("chk_act_rcv_tp_cd", getChkActRcvTpCd());
		this.hashColumns.put("act_sts_mapg_cd", getActStsMapgCd());
		this.hashColumns.put("frm_act_cd", getFrmActCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rail_itchg_flg", getRailItchgFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("frm_act_sts_mapg_cd", "frmActStsMapgCd");
		this.hashFields.put("act_cd", "actCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chk_act_cd", "chkActCd");
		this.hashFields.put("chk_act_sts_mapg_cd", "chkActStsMapgCd");
		this.hashFields.put("act_flg", "actFlg");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("act_rcv_tp_cd", "actRcvTpCd");
		this.hashFields.put("chk_act_rcv_tp_cd", "chkActRcvTpCd");
		this.hashFields.put("act_sts_mapg_cd", "actStsMapgCd");
		this.hashFields.put("frm_act_cd", "frmActCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rail_itchg_flg", "railItchgFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return frmActStsMapgCd
	 */
	public String getFrmActStsMapgCd() {
		return this.frmActStsMapgCd;
	}
	
	/**
	 * Column Info
	 * @return actCd
	 */
	public String getActCd() {
		return this.actCd;
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
	 * @return chkActCd
	 */
	public String getChkActCd() {
		return this.chkActCd;
	}
	
	/**
	 * Column Info
	 * @return chkActStsMapgCd
	 */
	public String getChkActStsMapgCd() {
		return this.chkActStsMapgCd;
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
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return actRcvTpCd
	 */
	public String getActRcvTpCd() {
		return this.actRcvTpCd;
	}
	
	/**
	 * Column Info
	 * @return chkActRcvTpCd
	 */
	public String getChkActRcvTpCd() {
		return this.chkActRcvTpCd;
	}
	
	/**
	 * Column Info
	 * @return actStsMapgCd
	 */
	public String getActStsMapgCd() {
		return this.actStsMapgCd;
	}
	
	/**
	 * Column Info
	 * @return frmActCd
	 */
	public String getFrmActCd() {
		return this.frmActCd;
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
	 * @param frmActStsMapgCd
	 */
	public void setFrmActStsMapgCd(String frmActStsMapgCd) {
		this.frmActStsMapgCd = frmActStsMapgCd;
	}
	
	/**
	 * Column Info
	 * @param actCd
	 */
	public void setActCd(String actCd) {
		this.actCd = actCd;
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
	 * @param chkActCd
	 */
	public void setChkActCd(String chkActCd) {
		this.chkActCd = chkActCd;
	}
	
	/**
	 * Column Info
	 * @param chkActStsMapgCd
	 */
	public void setChkActStsMapgCd(String chkActStsMapgCd) {
		this.chkActStsMapgCd = chkActStsMapgCd;
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
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param actRcvTpCd
	 */
	public void setActRcvTpCd(String actRcvTpCd) {
		this.actRcvTpCd = actRcvTpCd;
	}
	
	/**
	 * Column Info
	 * @param chkActRcvTpCd
	 */
	public void setChkActRcvTpCd(String chkActRcvTpCd) {
		this.chkActRcvTpCd = chkActRcvTpCd;
	}
	
	/**
	 * Column Info
	 * @param actStsMapgCd
	 */
	public void setActStsMapgCd(String actStsMapgCd) {
		this.actStsMapgCd = actStsMapgCd;
	}
	
	/**
	 * Column Info
	 * @param frmActCd
	 */
	public void setFrmActCd(String frmActCd) {
		this.frmActCd = frmActCd;
	}

	public String getRailItchgFlg() {
		return railItchgFlg;
	}

	public void setRailItchgFlg(String railItchgFlg) {
		this.railItchgFlg = railItchgFlg;
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
		setFrmActStsMapgCd(JSPUtil.getParameter(request, prefix + "frm_act_sts_mapg_cd", ""));
		setActCd(JSPUtil.getParameter(request, prefix + "act_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setChkActCd(JSPUtil.getParameter(request, prefix + "chk_act_cd", ""));
		setChkActStsMapgCd(JSPUtil.getParameter(request, prefix + "chk_act_sts_mapg_cd", ""));
		setActFlg(JSPUtil.getParameter(request, prefix + "act_flg", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setActRcvTpCd(JSPUtil.getParameter(request, prefix + "act_rcv_tp_cd", ""));
		setChkActRcvTpCd(JSPUtil.getParameter(request, prefix + "chk_act_rcv_tp_cd", ""));
		setActStsMapgCd(JSPUtil.getParameter(request, prefix + "act_sts_mapg_cd", ""));
		setFrmActCd(JSPUtil.getParameter(request, prefix + "frm_act_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRailItchgFlg(JSPUtil.getParameter(request, prefix + "rail_itchg_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ActualActivityMappingVO[]
	 */
	public ActualActivityMappingVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ActualActivityMappingVO[]
	 */
	public ActualActivityMappingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ActualActivityMappingVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] frmActStsMapgCd = (JSPUtil.getParameter(request, prefix	+ "frm_act_sts_mapg_cd", length));
			String[] actCd = (JSPUtil.getParameter(request, prefix	+ "act_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chkActCd = (JSPUtil.getParameter(request, prefix	+ "chk_act_cd", length));
			String[] chkActStsMapgCd = (JSPUtil.getParameter(request, prefix	+ "chk_act_sts_mapg_cd", length));
			String[] actFlg = (JSPUtil.getParameter(request, prefix	+ "act_flg", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] actRcvTpCd = (JSPUtil.getParameter(request, prefix	+ "act_rcv_tp_cd", length));
			String[] chkActRcvTpCd = (JSPUtil.getParameter(request, prefix	+ "chk_act_rcv_tp_cd", length));
			String[] actStsMapgCd = (JSPUtil.getParameter(request, prefix	+ "act_sts_mapg_cd", length));
			String[] frmActCd = (JSPUtil.getParameter(request, prefix	+ "frm_act_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] railItchgFlg = (JSPUtil.getParameter(request, prefix	+ "rail_itchg_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new ActualActivityMappingVO();
				if (frmActStsMapgCd[i] != null)
					model.setFrmActStsMapgCd(frmActStsMapgCd[i]);
				if (actCd[i] != null)
					model.setActCd(actCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chkActCd[i] != null)
					model.setChkActCd(chkActCd[i]);
				if (chkActStsMapgCd[i] != null)
					model.setChkActStsMapgCd(chkActStsMapgCd[i]);
				if (actFlg[i] != null)
					model.setActFlg(actFlg[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (actRcvTpCd[i] != null)
					model.setActRcvTpCd(actRcvTpCd[i]);
				if (chkActRcvTpCd[i] != null)
					model.setChkActRcvTpCd(chkActRcvTpCd[i]);
				if (actStsMapgCd[i] != null)
					model.setActStsMapgCd(actStsMapgCd[i]);
				if (frmActCd[i] != null)
					model.setFrmActCd(frmActCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (railItchgFlg[i] != null)
					model.setRailItchgFlg(railItchgFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getActualActivityMappingVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ActualActivityMappingVO[]
	 */
	public ActualActivityMappingVO[] getActualActivityMappingVOs(){
		ActualActivityMappingVO[] vos = (ActualActivityMappingVO[])models.toArray(new ActualActivityMappingVO[models.size()]);
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
		this.frmActStsMapgCd = this.frmActStsMapgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCd = this.actCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkActCd = this.chkActCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkActStsMapgCd = this.chkActStsMapgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actFlg = this.actFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRcvTpCd = this.actRcvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkActRcvTpCd = this.chkActRcvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actStsMapgCd = this.actStsMapgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmActCd = this.frmActCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railItchgFlg = this.railItchgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

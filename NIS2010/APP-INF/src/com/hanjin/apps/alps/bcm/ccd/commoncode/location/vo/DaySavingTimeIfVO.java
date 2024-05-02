/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : DaySavingTimeIfVO.java
*@FileTitle : DaySavingTimeIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.08
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.location.vo;
  
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
public class DaySavingTimeIfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DaySavingTimeIfVO> models = new ArrayList<DaySavingTimeIfVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String creDt = null;

	/* Column Info */
	private String creUsrId = null;

	/* Column Info */
	private String deltFlg = null;

	/* Column Info */
	private String dstCntCd = null;

	/* Column Info */
	private String dstId = null;

	/* Column Info */
	private String dstMnts = null;

	/* Column Info */
	private String dstNotAplySteCd = null;

	/* Column Info */
	private String dstYr = null;

	/* Column Info */
	private String eaiEvntDt = null;

	/* Column Info */
	private String eaiIfId = null;

	/* Column Info */
	private String endDstDt = null;

	/* Column Info */
	private String stDstDt = null;

	/* Column Info */
	private String stDstHrmnt = null;

	/* Column Info */
	private String stDstRuleDesc = null;

	/* Column Info */
	private String updDt = null;

	/* Column Info */
	private String updUsrId = null;

	/* Column Info */
	private String cudFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DaySavingTimeIfVO() {}

	public DaySavingTimeIfVO(String ibflag, String pagerows, String creDt, String creUsrId, String deltFlg, String dstCntCd, String dstId, String dstMnts, String dstNotAplySteCd, String dstYr, String eaiEvntDt, String eaiIfId, String endDstDt, String stDstDt, String stDstHrmnt, String stDstRuleDesc, String updDt, String updUsrId, String cudFlg) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.creDt = creDt;
		this.creUsrId = creUsrId;
		this.deltFlg = deltFlg;
		this.dstCntCd = dstCntCd;
		this.dstId = dstId;
		this.dstMnts = dstMnts;
		this.dstNotAplySteCd = dstNotAplySteCd;
		this.dstYr = dstYr;
		this.eaiEvntDt = eaiEvntDt;
		this.eaiIfId = eaiIfId;
		this.endDstDt = endDstDt;
		this.stDstDt = stDstDt;
		this.stDstHrmnt = stDstHrmnt;
		this.stDstRuleDesc = stDstRuleDesc;
		this.updDt = updDt;
		this.updUsrId = updUsrId;
		this.cudFlg = cudFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("dst_cnt_cd", getDstCntCd());
		this.hashColumns.put("dst_id", getDstId());
		this.hashColumns.put("dst_mnts", getDstMnts());
		this.hashColumns.put("dst_not_aply_ste_cd", getDstNotAplySteCd());
		this.hashColumns.put("dst_yr", getDstYr());
		this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
		this.hashColumns.put("eai_if_id", getEaiIfId());
		this.hashColumns.put("end_dst_dt", getEndDstDt());
		this.hashColumns.put("st_dst_dt", getStDstDt());
		this.hashColumns.put("st_dst_hrmnt", getStDstHrmnt());
		this.hashColumns.put("st_dst_rule_desc", getStDstRuleDesc());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cud_flg", getCudFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("dst_cnt_cd", "dstCntCd");
		this.hashFields.put("dst_id", "dstId");
		this.hashFields.put("dst_mnts", "dstMnts");
		this.hashFields.put("dst_not_aply_ste_cd", "dstNotAplySteCd");
		this.hashFields.put("dst_yr", "dstYr");
		this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
		this.hashFields.put("eai_if_id", "eaiIfId");
		this.hashFields.put("end_dst_dt", "endDstDt");
		this.hashFields.put("st_dst_dt", "stDstDt");
		this.hashFields.put("st_dst_hrmnt", "stDstHrmnt");
		this.hashFields.put("st_dst_rule_desc", "stDstRuleDesc");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cud_flg", "cudFlg");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * 
	 * @return String creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 *
	 * @param String creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * 
	 * @return String creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 *
	 * @param String deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * 
	 * @return String deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 *
	 * @param String dstCntCd
	 */
	public void setDstCntCd(String dstCntCd) {
		this.dstCntCd = dstCntCd;
	}
	
	/**
	 * 
	 * @return String dstCntCd
	 */
	public String getDstCntCd() {
		return this.dstCntCd;
	}
	
	/**
	 *
	 * @param String dstId
	 */
	public void setDstId(String dstId) {
		this.dstId = dstId;
	}
	
	/**
	 * 
	 * @return String dstId
	 */
	public String getDstId() {
		return this.dstId;
	}
	
	/**
	 *
	 * @param String dstMnts
	 */
	public void setDstMnts(String dstMnts) {
		this.dstMnts = dstMnts;
	}
	
	/**
	 * 
	 * @return String dstMnts
	 */
	public String getDstMnts() {
		return this.dstMnts;
	}
	
	/**
	 *
	 * @param String dstNotAplySteCd
	 */
	public void setDstNotAplySteCd(String dstNotAplySteCd) {
		this.dstNotAplySteCd = dstNotAplySteCd;
	}
	
	/**
	 * 
	 * @return String dstNotAplySteCd
	 */
	public String getDstNotAplySteCd() {
		return this.dstNotAplySteCd;
	}
	
	/**
	 *
	 * @param String dstYr
	 */
	public void setDstYr(String dstYr) {
		this.dstYr = dstYr;
	}
	
	/**
	 * 
	 * @return String dstYr
	 */
	public String getDstYr() {
		return this.dstYr;
	}
	
	/**
	 *
	 * @param String eaiEvntDt
	 */
	public void setEaiEvntDt(String eaiEvntDt) {
		this.eaiEvntDt = eaiEvntDt;
	}
	
	/**
	 * 
	 * @return String eaiEvntDt
	 */
	public String getEaiEvntDt() {
		return this.eaiEvntDt;
	}
	
	/**
	 *
	 * @param String eaiIfId
	 */
	public void setEaiIfId(String eaiIfId) {
		this.eaiIfId = eaiIfId;
	}
	
	/**
	 * 
	 * @return String eaiIfId
	 */
	public String getEaiIfId() {
		return this.eaiIfId;
	}
	
	/**
	 *
	 * @param String endDstDt
	 */
	public void setEndDstDt(String endDstDt) {
		this.endDstDt = endDstDt;
	}
	
	/**
	 * 
	 * @return String endDstDt
	 */
	public String getEndDstDt() {
		return this.endDstDt;
	}
	
	/**
	 *
	 * @param String stDstDt
	 */
	public void setStDstDt(String stDstDt) {
		this.stDstDt = stDstDt;
	}
	
	/**
	 * 
	 * @return String stDstDt
	 */
	public String getStDstDt() {
		return this.stDstDt;
	}
	
	/**
	 *
	 * @param String stDstHrmnt
	 */
	public void setStDstHrmnt(String stDstHrmnt) {
		this.stDstHrmnt = stDstHrmnt;
	}
	
	/**
	 * 
	 * @return String stDstHrmnt
	 */
	public String getStDstHrmnt() {
		return this.stDstHrmnt;
	}
	
	/**
	 *
	 * @param String stDstRuleDesc
	 */
	public void setStDstRuleDesc(String stDstRuleDesc) {
		this.stDstRuleDesc = stDstRuleDesc;
	}
	
	/**
	 * 
	 * @return String stDstRuleDesc
	 */
	public String getStDstRuleDesc() {
		return this.stDstRuleDesc;
	}
	
	/**
	 *
	 * @param String updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * 
	 * @return String updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 *
	 * @param String updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 
	 * @return String updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 *
	 * @param String cudFlg
	 */
	public void setCudFlg(String cudFlg) {
		this.cudFlg = cudFlg;
	}
	
	/**
	 * 
	 * @return String cudFlg
	 */
	public String getCudFlg() {
		return this.cudFlg;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setDstCntCd(JSPUtil.getParameter(request, prefix + "dst_cnt_cd", ""));
		setDstId(JSPUtil.getParameter(request, prefix + "dst_id", ""));
		setDstMnts(JSPUtil.getParameter(request, prefix + "dst_mnts", ""));
		setDstNotAplySteCd(JSPUtil.getParameter(request, prefix + "dst_not_aply_ste_cd", ""));
		setDstYr(JSPUtil.getParameter(request, prefix + "dst_yr", ""));
		setEaiEvntDt(JSPUtil.getParameter(request, prefix + "eai_evnt_dt", ""));
		setEaiIfId(JSPUtil.getParameter(request, prefix + "eai_if_id", ""));
		setEndDstDt(JSPUtil.getParameter(request, prefix + "end_dst_dt", ""));
		setStDstDt(JSPUtil.getParameter(request, prefix + "st_dst_dt", ""));
		setStDstHrmnt(JSPUtil.getParameter(request, prefix + "st_dst_hrmnt", ""));
		setStDstRuleDesc(JSPUtil.getParameter(request, prefix + "st_dst_rule_desc", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCudFlg(JSPUtil.getParameter(request, prefix + "cud_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DaySavingTimeIfVO[]
	 */
	public DaySavingTimeIfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DaySavingTimeIfVO[]
	 */
	public DaySavingTimeIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DaySavingTimeIfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] dstCntCd = (JSPUtil.getParameter(request, prefix	+ "dst_cnt_cd", length));
			String[] dstId = (JSPUtil.getParameter(request, prefix	+ "dst_id", length));
			String[] dstMnts = (JSPUtil.getParameter(request, prefix	+ "dst_mnts", length));
			String[] dstNotAplySteCd = (JSPUtil.getParameter(request, prefix	+ "dst_not_aply_ste_cd", length));
			String[] dstYr = (JSPUtil.getParameter(request, prefix	+ "dst_yr", length));
			String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix	+ "eai_evnt_dt", length));
			String[] eaiIfId = (JSPUtil.getParameter(request, prefix	+ "eai_if_id", length));
			String[] endDstDt = (JSPUtil.getParameter(request, prefix	+ "end_dst_dt", length));
			String[] stDstDt = (JSPUtil.getParameter(request, prefix	+ "st_dst_dt", length));
			String[] stDstHrmnt = (JSPUtil.getParameter(request, prefix	+ "st_dst_hrmnt", length));
			String[] stDstRuleDesc = (JSPUtil.getParameter(request, prefix	+ "st_dst_rule_desc", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cudFlg = (JSPUtil.getParameter(request, prefix	+ "cud_flg", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new DaySavingTimeIfVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (creDt[i] != null) 
					model.setCreDt(creDt[i]);
				if (creUsrId[i] != null) 
					model.setCreUsrId(creUsrId[i]);
				if (deltFlg[i] != null) 
					model.setDeltFlg(deltFlg[i]);
				if (dstCntCd[i] != null) 
					model.setDstCntCd(dstCntCd[i]);
				if (dstId[i] != null) 
					model.setDstId(dstId[i]);
				if (dstMnts[i] != null) 
					model.setDstMnts(dstMnts[i]);
				if (dstNotAplySteCd[i] != null) 
					model.setDstNotAplySteCd(dstNotAplySteCd[i]);
				if (dstYr[i] != null) 
					model.setDstYr(dstYr[i]);
				if (eaiEvntDt[i] != null) 
					model.setEaiEvntDt(eaiEvntDt[i]);
				if (eaiIfId[i] != null) 
					model.setEaiIfId(eaiIfId[i]);
				if (endDstDt[i] != null) 
					model.setEndDstDt(endDstDt[i]);
				if (stDstDt[i] != null) 
					model.setStDstDt(stDstDt[i]);
				if (stDstHrmnt[i] != null) 
					model.setStDstHrmnt(stDstHrmnt[i]);
				if (stDstRuleDesc[i] != null) 
					model.setStDstRuleDesc(stDstRuleDesc[i]);
				if (updDt[i] != null) 
					model.setUpdDt(updDt[i]);
				if (updUsrId[i] != null) 
					model.setUpdUsrId(updUsrId[i]);
				if (cudFlg[i] != null) 
					model.setCudFlg(cudFlg[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDaySavingTimeIfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DaySavingTimeIfVO[]
	 */
	public DaySavingTimeIfVO[] getDaySavingTimeIfVOs(){
		DaySavingTimeIfVO[] vos = (DaySavingTimeIfVO[])models.toArray(new DaySavingTimeIfVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dstCntCd = this.dstCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dstId = this.dstId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dstMnts = this.dstMnts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dstNotAplySteCd = this.dstNotAplySteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dstYr = this.dstYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiEvntDt = this.eaiEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiIfId = this.eaiIfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endDstDt = this.endDstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stDstDt = this.stDstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stDstHrmnt = this.stDstHrmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stDstRuleDesc = this.stDstRuleDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cudFlg = this.cudFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
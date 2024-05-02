/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ManagerHistoryVO.java
*@FileTitle : ManagerHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.20
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2010.04.20 정행룡 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.codemgt.codemgt.vo;

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
 * @author 정행룡
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ManagerHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ManagerHistoryVO> models = new ArrayList<ManagerHistoryVO>();
	
	/* Column Info */
	private String updDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dwClmStsCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String hdlrOfcCd = null;
	/* Column Info */
	private String dwClmHisSeq = null;
	/* Column Info */
	private String hdlrUsrId = null;
	/* Column Info */
	private String dwClmNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ManagerHistoryVO() {}

	public ManagerHistoryVO(String ibflag, String pagerows, String dwClmNo, String dwClmHisSeq, String dwClmStsCd, String hdlrUsrId, String hdlrOfcCd, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.ibflag = ibflag;
		this.dwClmStsCd = dwClmStsCd;
		this.updUsrId = updUsrId;
		this.hdlrOfcCd = hdlrOfcCd;
		this.dwClmHisSeq = dwClmHisSeq;
		this.hdlrUsrId = hdlrUsrId;
		this.dwClmNo = dwClmNo;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dw_clm_sts_cd", getDwClmStsCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("hdlr_ofc_cd", getHdlrOfcCd());
		this.hashColumns.put("dw_clm_his_seq", getDwClmHisSeq());
		this.hashColumns.put("hdlr_usr_id", getHdlrUsrId());
		this.hashColumns.put("dw_clm_no", getDwClmNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dw_clm_sts_cd", "dwClmStsCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("hdlr_ofc_cd", "hdlrOfcCd");
		this.hashFields.put("dw_clm_his_seq", "dwClmHisSeq");
		this.hashFields.put("hdlr_usr_id", "hdlrUsrId");
		this.hashFields.put("dw_clm_no", "dwClmNo");
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return dwClmStsCd
	 */
	public String getDwClmStsCd() {
		return this.dwClmStsCd;
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
	 * @return hdlrOfcCd
	 */
	public String getHdlrOfcCd() {
		return this.hdlrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dwClmHisSeq
	 */
	public String getDwClmHisSeq() {
		return this.dwClmHisSeq;
	}
	
	/**
	 * Column Info
	 * @return hdlrUsrId
	 */
	public String getHdlrUsrId() {
		return this.hdlrUsrId;
	}
	
	/**
	 * Column Info
	 * @return dwClmNo
	 */
	public String getDwClmNo() {
		return this.dwClmNo;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param dwClmStsCd
	 */
	public void setDwClmStsCd(String dwClmStsCd) {
		this.dwClmStsCd = dwClmStsCd;
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
	 * @param hdlrOfcCd
	 */
	public void setHdlrOfcCd(String hdlrOfcCd) {
		this.hdlrOfcCd = hdlrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dwClmHisSeq
	 */
	public void setDwClmHisSeq(String dwClmHisSeq) {
		this.dwClmHisSeq = dwClmHisSeq;
	}
	
	/**
	 * Column Info
	 * @param hdlrUsrId
	 */
	public void setHdlrUsrId(String hdlrUsrId) {
		this.hdlrUsrId = hdlrUsrId;
	}
	
	/**
	 * Column Info
	 * @param dwClmNo
	 */
	public void setDwClmNo(String dwClmNo) {
		this.dwClmNo = dwClmNo;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDwClmStsCd(JSPUtil.getParameter(request, prefix + "dw_clm_sts_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setHdlrOfcCd(JSPUtil.getParameter(request, prefix + "hdlr_ofc_cd", ""));
		setDwClmHisSeq(JSPUtil.getParameter(request, prefix + "dw_clm_his_seq", ""));
		setHdlrUsrId(JSPUtil.getParameter(request, prefix + "hdlr_usr_id", ""));
		setDwClmNo(JSPUtil.getParameter(request, prefix + "dw_clm_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ManagerHistoryVO[]
	 */
	public ManagerHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ManagerHistoryVO[]
	 */
	public ManagerHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ManagerHistoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dwClmStsCd = (JSPUtil.getParameter(request, prefix	+ "dw_clm_sts_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] hdlrOfcCd = (JSPUtil.getParameter(request, prefix	+ "hdlr_ofc_cd", length));
			String[] dwClmHisSeq = (JSPUtil.getParameter(request, prefix	+ "dw_clm_his_seq", length));
			String[] hdlrUsrId = (JSPUtil.getParameter(request, prefix	+ "hdlr_usr_id", length));
			String[] dwClmNo = (JSPUtil.getParameter(request, prefix	+ "dw_clm_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ManagerHistoryVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dwClmStsCd[i] != null)
					model.setDwClmStsCd(dwClmStsCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (hdlrOfcCd[i] != null)
					model.setHdlrOfcCd(hdlrOfcCd[i]);
				if (dwClmHisSeq[i] != null)
					model.setDwClmHisSeq(dwClmHisSeq[i]);
				if (hdlrUsrId[i] != null)
					model.setHdlrUsrId(hdlrUsrId[i]);
				if (dwClmNo[i] != null)
					model.setDwClmNo(dwClmNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getManagerHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ManagerHistoryVO[]
	 */
	public ManagerHistoryVO[] getManagerHistoryVOs(){
		ManagerHistoryVO[] vos = (ManagerHistoryVO[])models.toArray(new ManagerHistoryVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmStsCd = this.dwClmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrOfcCd = this.hdlrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmHisSeq = this.dwClmHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrUsrId = this.hdlrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmNo = this.dwClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

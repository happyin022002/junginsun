/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PriScgAuthVO.java
*@FileTitle : PriScgAuthVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.25  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.surcharge.surcharge.vo;

import java.lang.reflect.Field;
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

public class PriScgAuthVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriScgAuthVO> models = new ArrayList<PriScgAuthVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String aproAuth = null;
	/* Column Info */
	private String prcCtrtTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String svcScpCd = null;
	/* Page Number */
	private String chkFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PriScgAuthVO() {}

	public PriScgAuthVO(String ibflag, String pagerows, String prcCtrtTpCd, String trdCd, String usrId, String aproAuth, String svcScpCd, String chkFlg ) {
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.trdCd = trdCd;
		this.aproAuth = aproAuth;
		this.prcCtrtTpCd = prcCtrtTpCd;
		this.pagerows = pagerows;
		this.svcScpCd = svcScpCd;
		this.chkFlg = chkFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("apro_auth", getAproAuth());
		this.hashColumns.put("prc_ctrt_tp_cd", getPrcCtrtTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("chk_flg", getChkFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("apro_auth", "aproAuth");
		this.hashFields.put("prc_ctrt_tp_cd", "prcCtrtTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("chk_flg", "chkFlg");
		return this.hashFields;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return aproAuth
	 */
	public String getAproAuth() {
		return this.aproAuth;
	}
	
	/**
	 * Column Info
	 * @return prcCtrtTpCd
	 */
	public String getPrcCtrtTpCd() {
		return this.prcCtrtTpCd;
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
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return chkFlg
	 */
	public String getChkFlg() {
		return this.chkFlg;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param aproAuth
	 */
	public void setAproAuth(String aproAuth) {
		this.aproAuth = aproAuth;
	}
	
	/**
	 * Column Info
	 * @param prcCtrtTpCd
	 */
	public void setPrcCtrtTpCd(String prcCtrtTpCd) {
		this.prcCtrtTpCd = prcCtrtTpCd;
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
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setChkFlg(String chkFlg) {
		this.chkFlg = chkFlg;
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
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setAproAuth(JSPUtil.getParameter(request, prefix + "apro_auth", ""));
		setPrcCtrtTpCd(JSPUtil.getParameter(request, prefix + "prc_ctrt_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setChkFlg(JSPUtil.getParameter(request, prefix + "chk_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriScgAuthVO[]
	 */
	public PriScgAuthVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriScgAuthVO[]
	 */
	public PriScgAuthVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriScgAuthVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] aproAuth = (JSPUtil.getParameter(request, prefix	+ "apro_auth", length));
			String[] prcCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] chkFlg = (JSPUtil.getParameter(request, prefix	+ "chk_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriScgAuthVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (aproAuth[i] != null)
					model.setAproAuth(aproAuth[i]);
				if (prcCtrtTpCd[i] != null)
					model.setPrcCtrtTpCd(prcCtrtTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (chkFlg[i] != null)
					model.setChkFlg(chkFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriScgAuthVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriScgAuthVO[]
	 */
	public PriScgAuthVO[] getPriScgAuthVOs(){
		PriScgAuthVO[] vos = (PriScgAuthVO[])models.toArray(new PriScgAuthVO[models.size()]);
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
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproAuth = this.aproAuth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtTpCd = this.prcCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkFlg = this.chkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchOfficeBKGInControlVO.java
*@FileTitle : SearchOfficeBKGInControlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.10  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchOfficeBKGInControlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOfficeBKGInControlVO> models = new ArrayList<SearchOfficeBKGInControlVO>();
	
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String bkgCtrlTpCd = null;
	/* Column Info */
	private String bkgCtrlRto = null;
	/* Column Info */
	private String bkgCtrlAcctFlg = null;
	/* Column Info */
	private String rdFlg = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String bkgCtrlDtlCd = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchOfficeBKGInControlVO() {}

	public SearchOfficeBKGInControlVO(String ibflag, String pagerows, String trdCd, String subTrdCd, String rlaneCd, String dirCd, String bkgCtrlTpCd, String bkgCtrlAcctFlg, String bkgCtrlDtlCd, String bkgCtrlRto, String creUsrId, String updUsrId, String rdFlg) {
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.trdCd = trdCd;
		this.dirCd = dirCd;
		this.rlaneCd = rlaneCd;
		this.bkgCtrlTpCd = bkgCtrlTpCd;
		this.bkgCtrlRto = bkgCtrlRto;
		this.bkgCtrlAcctFlg = bkgCtrlAcctFlg;
		this.rdFlg = rdFlg;
		this.updUsrId = updUsrId;
		this.bkgCtrlDtlCd = bkgCtrlDtlCd;
		this.subTrdCd = subTrdCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("bkg_ctrl_tp_cd", getBkgCtrlTpCd());
		this.hashColumns.put("bkg_ctrl_rto", getBkgCtrlRto());
		this.hashColumns.put("bkg_ctrl_acct_flg", getBkgCtrlAcctFlg());
		this.hashColumns.put("rd_flg", getRdFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("bkg_ctrl_dtl_cd", getBkgCtrlDtlCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("bkg_ctrl_tp_cd", "bkgCtrlTpCd");
		this.hashFields.put("bkg_ctrl_rto", "bkgCtrlRto");
		this.hashFields.put("bkg_ctrl_acct_flg", "bkgCtrlAcctFlg");
		this.hashFields.put("rd_flg", "rdFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("bkg_ctrl_dtl_cd", "bkgCtrlDtlCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrlTpCd
	 */
	public String getBkgCtrlTpCd() {
		return this.bkgCtrlTpCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrlRto
	 */
	public String getBkgCtrlRto() {
		return this.bkgCtrlRto;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrlAcctFlg
	 */
	public String getBkgCtrlAcctFlg() {
		return this.bkgCtrlAcctFlg;
	}
	
	/**
	 * Column Info
	 * @return rdFlg
	 */
	public String getRdFlg() {
		return this.rdFlg;
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
	 * @return bkgCtrlDtlCd
	 */
	public String getBkgCtrlDtlCd() {
		return this.bkgCtrlDtlCd;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
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
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrlTpCd
	 */
	public void setBkgCtrlTpCd(String bkgCtrlTpCd) {
		this.bkgCtrlTpCd = bkgCtrlTpCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrlRto
	 */
	public void setBkgCtrlRto(String bkgCtrlRto) {
		this.bkgCtrlRto = bkgCtrlRto;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrlAcctFlg
	 */
	public void setBkgCtrlAcctFlg(String bkgCtrlAcctFlg) {
		this.bkgCtrlAcctFlg = bkgCtrlAcctFlg;
	}
	
	/**
	 * Column Info
	 * @param rdFlg
	 */
	public void setRdFlg(String rdFlg) {
		this.rdFlg = rdFlg;
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
	 * @param bkgCtrlDtlCd
	 */
	public void setBkgCtrlDtlCd(String bkgCtrlDtlCd) {
		this.bkgCtrlDtlCd = bkgCtrlDtlCd;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
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
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setBkgCtrlTpCd(JSPUtil.getParameter(request, prefix + "bkg_ctrl_tp_cd", ""));
		setBkgCtrlRto(JSPUtil.getParameter(request, prefix + "bkg_ctrl_rto", ""));
		setBkgCtrlAcctFlg(JSPUtil.getParameter(request, prefix + "bkg_ctrl_acct_flg", ""));
		setRdFlg(JSPUtil.getParameter(request, prefix + "rd_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setBkgCtrlDtlCd(JSPUtil.getParameter(request, prefix + "bkg_ctrl_dtl_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchOfficeBKGInControlVO[]
	 */
	public SearchOfficeBKGInControlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchOfficeBKGInControlVO[]
	 */
	public SearchOfficeBKGInControlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchOfficeBKGInControlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] bkgCtrlTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_tp_cd", length));
			String[] bkgCtrlRto = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_rto", length));
			String[] bkgCtrlAcctFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_acct_flg", length));
			String[] rdFlg = (JSPUtil.getParameter(request, prefix	+ "rd_flg", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] bkgCtrlDtlCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_dtl_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOfficeBKGInControlVO();
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (bkgCtrlTpCd[i] != null)
					model.setBkgCtrlTpCd(bkgCtrlTpCd[i]);
				if (bkgCtrlRto[i] != null)
					model.setBkgCtrlRto(bkgCtrlRto[i]);
				if (bkgCtrlAcctFlg[i] != null)
					model.setBkgCtrlAcctFlg(bkgCtrlAcctFlg[i]);
				if (rdFlg[i] != null)
					model.setRdFlg(rdFlg[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (bkgCtrlDtlCd[i] != null)
					model.setBkgCtrlDtlCd(bkgCtrlDtlCd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchOfficeBKGInControlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchOfficeBKGInControlVO[]
	 */
	public SearchOfficeBKGInControlVO[] getSearchOfficeBKGInControlVOs(){
		SearchOfficeBKGInControlVO[] vos = (SearchOfficeBKGInControlVO[])models.toArray(new SearchOfficeBKGInControlVO[models.size()]);
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
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlTpCd = this.bkgCtrlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlRto = this.bkgCtrlRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlAcctFlg = this.bkgCtrlAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdFlg = this.rdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlDtlCd = this.bkgCtrlDtlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

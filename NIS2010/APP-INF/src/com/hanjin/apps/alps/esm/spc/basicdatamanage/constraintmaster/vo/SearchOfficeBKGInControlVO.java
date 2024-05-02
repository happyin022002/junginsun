/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchOfficeBKGInControlVO.java
*@FileTitle : SearchOfficeBKGInControlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.24  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo;

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

public class SearchOfficeBKGInControlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchOfficeBKGInControlVO> models = new ArrayList<SearchOfficeBKGInControlVO>();
	
	/* Column Info */
	private String rdFlg = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String bkgCtrlTpCd = null;
	/* Column Info */
	private String bkgCtrlDtlCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgCtrlLaneFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgCtrlAcctFlg = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String bkgCtrlRto = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchOfficeBKGInControlVO() {}

	public SearchOfficeBKGInControlVO(String ibflag, String pagerows, String creUsrId, String bkgCtrlLaneFlg, String trdCd, String dirCd, String rlaneCd, String bkgCtrlTpCd, String bkgCtrlRto, String bkgCtrlAcctFlg, String rdFlg, String updUsrId, String bkgCtrlDtlCd, String subTrdCd) {
		this.rdFlg = rdFlg;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.bkgCtrlTpCd = bkgCtrlTpCd;
		this.bkgCtrlDtlCd = bkgCtrlDtlCd;
		this.pagerows = pagerows;
		this.bkgCtrlLaneFlg = bkgCtrlLaneFlg;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.bkgCtrlAcctFlg = bkgCtrlAcctFlg;
		this.dirCd = dirCd;
		this.bkgCtrlRto = bkgCtrlRto;
		this.subTrdCd = subTrdCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rd_flg", getRdFlg());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("bkg_ctrl_tp_cd", getBkgCtrlTpCd());
		this.hashColumns.put("bkg_ctrl_dtl_cd", getBkgCtrlDtlCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_ctrl_lane_flg", getBkgCtrlLaneFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_ctrl_acct_flg", getBkgCtrlAcctFlg());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("bkg_ctrl_rto", getBkgCtrlRto());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rd_flg", "rdFlg");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("bkg_ctrl_tp_cd", "bkgCtrlTpCd");
		this.hashFields.put("bkg_ctrl_dtl_cd", "bkgCtrlDtlCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_ctrl_lane_flg", "bkgCtrlLaneFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_ctrl_acct_flg", "bkgCtrlAcctFlg");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("bkg_ctrl_rto", "bkgCtrlRto");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
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
	 * @return bkgCtrlDtlCd
	 */
	public String getBkgCtrlDtlCd() {
		return this.bkgCtrlDtlCd;
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
	 * @return bkgCtrlLaneFlg
	 */
	public String getBkgCtrlLaneFlg() {
		return this.bkgCtrlLaneFlg;
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
	 * @return bkgCtrlAcctFlg
	 */
	public String getBkgCtrlAcctFlg() {
		return this.bkgCtrlAcctFlg;
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
	 * @return bkgCtrlRto
	 */
	public String getBkgCtrlRto() {
		return this.bkgCtrlRto;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
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
	 * @param rdFlg
	 */
	public void setRdFlg(String rdFlg) {
		this.rdFlg = rdFlg;
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
	 * @param bkgCtrlDtlCd
	 */
	public void setBkgCtrlDtlCd(String bkgCtrlDtlCd) {
		this.bkgCtrlDtlCd = bkgCtrlDtlCd;
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
	 * @param bkgCtrlLaneFlg
	 */
	public void setBkgCtrlLaneFlg(String bkgCtrlLaneFlg) {
		this.bkgCtrlLaneFlg = bkgCtrlLaneFlg;
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
	 * @param bkgCtrlAcctFlg
	 */
	public void setBkgCtrlAcctFlg(String bkgCtrlAcctFlg) {
		this.bkgCtrlAcctFlg = bkgCtrlAcctFlg;
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
	 * @param bkgCtrlRto
	 */
	public void setBkgCtrlRto(String bkgCtrlRto) {
		this.bkgCtrlRto = bkgCtrlRto;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
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
		setRdFlg(JSPUtil.getParameter(request, prefix + "rd_flg", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setBkgCtrlTpCd(JSPUtil.getParameter(request, prefix + "bkg_ctrl_tp_cd", ""));
		setBkgCtrlDtlCd(JSPUtil.getParameter(request, prefix + "bkg_ctrl_dtl_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBkgCtrlLaneFlg(JSPUtil.getParameter(request, prefix + "bkg_ctrl_lane_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgCtrlAcctFlg(JSPUtil.getParameter(request, prefix + "bkg_ctrl_acct_flg", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setBkgCtrlRto(JSPUtil.getParameter(request, prefix + "bkg_ctrl_rto", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
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
			String[] rdFlg = (JSPUtil.getParameter(request, prefix	+ "rd_flg", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] bkgCtrlTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_tp_cd", length));
			String[] bkgCtrlDtlCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_dtl_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgCtrlLaneFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_lane_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgCtrlAcctFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_acct_flg", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] bkgCtrlRto = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrl_rto", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchOfficeBKGInControlVO();
				if (rdFlg[i] != null)
					model.setRdFlg(rdFlg[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (bkgCtrlTpCd[i] != null)
					model.setBkgCtrlTpCd(bkgCtrlTpCd[i]);
				if (bkgCtrlDtlCd[i] != null)
					model.setBkgCtrlDtlCd(bkgCtrlDtlCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgCtrlLaneFlg[i] != null)
					model.setBkgCtrlLaneFlg(bkgCtrlLaneFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgCtrlAcctFlg[i] != null)
					model.setBkgCtrlAcctFlg(bkgCtrlAcctFlg[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (bkgCtrlRto[i] != null)
					model.setBkgCtrlRto(bkgCtrlRto[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
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
		this.rdFlg = this.rdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlTpCd = this.bkgCtrlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlDtlCd = this.bkgCtrlDtlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlLaneFlg = this.bkgCtrlLaneFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlAcctFlg = this.bkgCtrlAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrlRto = this.bkgCtrlRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

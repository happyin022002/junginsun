/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgListForVslSkdCngNoticeVO.java
*@FileTitle : BkgListForVslSkdCngNoticeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.11  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgListForVslSkdCngNoticeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgListForVslSkdCngNoticeVO> models = new ArrayList<BkgListForVslSkdCngNoticeVO>();
	
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String rcvUsrId = null;
	/* Column Info */
	private String rcvUsrNm = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String rcvEmlList = null;
	/* Column Info */
	private String typeCd = null;
	/* Column Info */
	private String bkgNoList = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgListForVslSkdCngNoticeVO() {}

	public BkgListForVslSkdCngNoticeVO(String ibflag, String pagerows, String bkgNoList, String vvd, String portCd, String ydCd, String typeCd, String remark, String bkgOfcCd, String rcvEmlList, String rcvUsrNm, String rcvUsrId) {
		this.bkgOfcCd = bkgOfcCd;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.remark = remark;
		this.ydCd = ydCd;
		this.rcvUsrId = rcvUsrId;
		this.rcvUsrNm = rcvUsrNm;
		this.portCd = portCd;
		this.rcvEmlList = rcvEmlList;
		this.typeCd = typeCd;
		this.bkgNoList = bkgNoList;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("rcv_usr_id", getRcvUsrId());
		this.hashColumns.put("rcv_usr_nm", getRcvUsrNm());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("rcv_eml_list", getRcvEmlList());
		this.hashColumns.put("type_cd", getTypeCd());
		this.hashColumns.put("bkg_no_list", getBkgNoList());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("rcv_usr_id", "rcvUsrId");
		this.hashFields.put("rcv_usr_nm", "rcvUsrNm");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("rcv_eml_list", "rcvEmlList");
		this.hashFields.put("type_cd", "typeCd");
		this.hashFields.put("bkg_no_list", "bkgNoList");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return rcvUsrId
	 */
	public String getRcvUsrId() {
		return this.rcvUsrId;
	}
	
	/**
	 * Column Info
	 * @return rcvUsrNm
	 */
	public String getRcvUsrNm() {
		return this.rcvUsrNm;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return rcvEmlList
	 */
	public String getRcvEmlList() {
		return this.rcvEmlList;
	}
	
	/**
	 * Column Info
	 * @return typeCd
	 */
	public String getTypeCd() {
		return this.typeCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNoList
	 */
	public String getBkgNoList() {
		return this.bkgNoList;
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
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param rcvUsrId
	 */
	public void setRcvUsrId(String rcvUsrId) {
		this.rcvUsrId = rcvUsrId;
	}
	
	/**
	 * Column Info
	 * @param rcvUsrNm
	 */
	public void setRcvUsrNm(String rcvUsrNm) {
		this.rcvUsrNm = rcvUsrNm;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param rcvEmlList
	 */
	public void setRcvEmlList(String rcvEmlList) {
		this.rcvEmlList = rcvEmlList;
	}
	
	/**
	 * Column Info
	 * @param typeCd
	 */
	public void setTypeCd(String typeCd) {
		this.typeCd = typeCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNoList
	 */
	public void setBkgNoList(String bkgNoList) {
		this.bkgNoList = bkgNoList;
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
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRemark(JSPUtil.getParameter(request, prefix + "remark", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setRcvUsrId(JSPUtil.getParameter(request, prefix + "rcv_usr_id", ""));
		setRcvUsrNm(JSPUtil.getParameter(request, prefix + "rcv_usr_nm", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setRcvEmlList(JSPUtil.getParameter(request, prefix + "rcv_eml_list", ""));
		setTypeCd(JSPUtil.getParameter(request, prefix + "type_cd", ""));
		setBkgNoList(JSPUtil.getParameter(request, prefix + "bkg_no_list", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgListForVslSkdCngNoticeVO[]
	 */
	public BkgListForVslSkdCngNoticeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgListForVslSkdCngNoticeVO[]
	 */
	public BkgListForVslSkdCngNoticeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgListForVslSkdCngNoticeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] rcvUsrId = (JSPUtil.getParameter(request, prefix	+ "rcv_usr_id", length));
			String[] rcvUsrNm = (JSPUtil.getParameter(request, prefix	+ "rcv_usr_nm", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] rcvEmlList = (JSPUtil.getParameter(request, prefix	+ "rcv_eml_list", length));
			String[] typeCd = (JSPUtil.getParameter(request, prefix	+ "type_cd", length));
			String[] bkgNoList = (JSPUtil.getParameter(request, prefix	+ "bkg_no_list", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgListForVslSkdCngNoticeVO();
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (rcvUsrId[i] != null)
					model.setRcvUsrId(rcvUsrId[i]);
				if (rcvUsrNm[i] != null)
					model.setRcvUsrNm(rcvUsrNm[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (rcvEmlList[i] != null)
					model.setRcvEmlList(rcvEmlList[i]);
				if (typeCd[i] != null)
					model.setTypeCd(typeCd[i]);
				if (bkgNoList[i] != null)
					model.setBkgNoList(bkgNoList[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgListForVslSkdCngNoticeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgListForVslSkdCngNoticeVO[]
	 */
	public BkgListForVslSkdCngNoticeVO[] getBkgListForVslSkdCngNoticeVOs(){
		BkgListForVslSkdCngNoticeVO[] vos = (BkgListForVslSkdCngNoticeVO[])models.toArray(new BkgListForVslSkdCngNoticeVO[models.size()]);
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
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvUsrId = this.rcvUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvUsrNm = this.rcvUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvEmlList = this.rcvEmlList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeCd = this.typeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoList = this.bkgNoList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

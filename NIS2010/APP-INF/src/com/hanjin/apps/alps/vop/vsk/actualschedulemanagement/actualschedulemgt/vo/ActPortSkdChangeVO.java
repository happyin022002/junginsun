/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActPortSkdChangeVO.java
*@FileTitle : ActPortSkdChangeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.03
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2009.12.03 정진우 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo;

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
 * @author 정진우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ActPortSkdChangeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ActPortSkdChangeVO> models = new ArrayList<ActPortSkdChangeVO>();
	
	/* Column Info */
	private String atdLocTime = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String allChk = null;
	/* Column Info */
	private String atbLocTime = null;
	/* Column Info */
	private String ataLocTime = null;
	/* Column Info */
	private String usrChk = null;
	/* Column Info */
	private String bkgVrtChk = null;
	/* Column Info */
	private String bkgChk = null;
	/* Column Info */
	private String atbChk = null;
	/* Column Info */
	private String atdChk = null;
	/* Column Info */
	private String ataChk = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ActPortSkdChangeVO() {}

	public ActPortSkdChangeVO(String ibflag, String pagerows, String ataChk, String atbChk, String atdChk, String usrChk, String ataLocTime, String atbLocTime, String atdLocTime, String allChk, String bkgChk, String bkgVrtChk) {
		this.atdLocTime = atdLocTime;
		this.ibflag = ibflag;
		this.allChk = allChk;
		this.atbLocTime = atbLocTime;
		this.ataLocTime = ataLocTime;
		this.usrChk = usrChk;
		this.bkgVrtChk = bkgVrtChk;
		this.bkgChk = bkgChk;
		this.atbChk = atbChk;
		this.atdChk = atdChk;
		this.ataChk = ataChk;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("atd_loc_time", getAtdLocTime());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("all_chk", getAllChk());
		this.hashColumns.put("atb_loc_time", getAtbLocTime());
		this.hashColumns.put("ata_loc_time", getAtaLocTime());
		this.hashColumns.put("usr_chk", getUsrChk());
		this.hashColumns.put("bkg_vrt_chk", getBkgVrtChk());
		this.hashColumns.put("bkg_chk", getBkgChk());
		this.hashColumns.put("atb_chk", getAtbChk());
		this.hashColumns.put("atd_chk", getAtdChk());
		this.hashColumns.put("ata_chk", getAtaChk());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("atd_loc_time", "atdLocTime");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("all_chk", "allChk");
		this.hashFields.put("atb_loc_time", "atbLocTime");
		this.hashFields.put("ata_loc_time", "ataLocTime");
		this.hashFields.put("usr_chk", "usrChk");
		this.hashFields.put("bkg_vrt_chk", "bkgVrtChk");
		this.hashFields.put("bkg_chk", "bkgChk");
		this.hashFields.put("atb_chk", "atbChk");
		this.hashFields.put("atd_chk", "atdChk");
		this.hashFields.put("ata_chk", "ataChk");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return atdLocTime
	 */
	public String getAtdLocTime() {
		return this.atdLocTime;
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
	 * @return allChk
	 */
	public String getAllChk() {
		return this.allChk;
	}
	
	/**
	 * Column Info
	 * @return atbLocTime
	 */
	public String getAtbLocTime() {
		return this.atbLocTime;
	}
	
	/**
	 * Column Info
	 * @return ataLocTime
	 */
	public String getAtaLocTime() {
		return this.ataLocTime;
	}
	
	/**
	 * Column Info
	 * @return usrChk
	 */
	public String getUsrChk() {
		return this.usrChk;
	}
	
	/**
	 * Column Info
	 * @return bkgVrtChk
	 */
	public String getBkgVrtChk() {
		return this.bkgVrtChk;
	}
	
	/**
	 * Column Info
	 * @return bkgChk
	 */
	public String getBkgChk() {
		return this.bkgChk;
	}
	
	/**
	 * Column Info
	 * @return atbChk
	 */
	public String getAtbChk() {
		return this.atbChk;
	}
	
	/**
	 * Column Info
	 * @return atdChk
	 */
	public String getAtdChk() {
		return this.atdChk;
	}
	
	/**
	 * Column Info
	 * @return ataChk
	 */
	public String getAtaChk() {
		return this.ataChk;
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
	 * @param atdLocTime
	 */
	public void setAtdLocTime(String atdLocTime) {
		this.atdLocTime = atdLocTime;
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
	 * @param allChk
	 */
	public void setAllChk(String allChk) {
		this.allChk = allChk;
	}
	
	/**
	 * Column Info
	 * @param atbLocTime
	 */
	public void setAtbLocTime(String atbLocTime) {
		this.atbLocTime = atbLocTime;
	}
	
	/**
	 * Column Info
	 * @param ataLocTime
	 */
	public void setAtaLocTime(String ataLocTime) {
		this.ataLocTime = ataLocTime;
	}
	
	/**
	 * Column Info
	 * @param usrChk
	 */
	public void setUsrChk(String usrChk) {
		this.usrChk = usrChk;
	}
	
	/**
	 * Column Info
	 * @param bkgVrtChk
	 */
	public void setBkgVrtChk(String bkgVrtChk) {
		this.bkgVrtChk = bkgVrtChk;
	}
	
	/**
	 * Column Info
	 * @param bkgChk
	 */
	public void setBkgChk(String bkgChk) {
		this.bkgChk = bkgChk;
	}
	
	/**
	 * Column Info
	 * @param atbChk
	 */
	public void setAtbChk(String atbChk) {
		this.atbChk = atbChk;
	}
	
	/**
	 * Column Info
	 * @param atdChk
	 */
	public void setAtdChk(String atdChk) {
		this.atdChk = atdChk;
	}
	
	/**
	 * Column Info
	 * @param ataChk
	 */
	public void setAtaChk(String ataChk) {
		this.ataChk = ataChk;
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
		setAtdLocTime(JSPUtil.getParameter(request, "atd_loc_time", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAllChk(JSPUtil.getParameter(request, "all_chk", ""));
		setAtbLocTime(JSPUtil.getParameter(request, "atb_loc_time", ""));
		setAtaLocTime(JSPUtil.getParameter(request, "ata_loc_time", ""));
		setUsrChk(JSPUtil.getParameter(request, "usr_chk", ""));
		setBkgVrtChk(JSPUtil.getParameter(request, "bkg_vrt_chk", ""));
		setBkgChk(JSPUtil.getParameter(request, "bkg_chk", ""));
		setAtbChk(JSPUtil.getParameter(request, "atb_chk", ""));
		setAtdChk(JSPUtil.getParameter(request, "atd_chk", ""));
		setAtaChk(JSPUtil.getParameter(request, "ata_chk", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ActPortSkdChangeVO[]
	 */
	public ActPortSkdChangeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ActPortSkdChangeVO[]
	 */
	public ActPortSkdChangeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ActPortSkdChangeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] atdLocTime = (JSPUtil.getParameter(request, prefix	+ "atd_loc_time", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] allChk = (JSPUtil.getParameter(request, prefix	+ "all_chk", length));
			String[] atbLocTime = (JSPUtil.getParameter(request, prefix	+ "atb_loc_time", length));
			String[] ataLocTime = (JSPUtil.getParameter(request, prefix	+ "ata_loc_time", length));
			String[] usrChk = (JSPUtil.getParameter(request, prefix	+ "usr_chk", length));
			String[] bkgVrtChk = (JSPUtil.getParameter(request, prefix	+ "bkg_vrt_chk", length));
			String[] bkgChk = (JSPUtil.getParameter(request, prefix	+ "bkg_chk", length));
			String[] atbChk = (JSPUtil.getParameter(request, prefix	+ "atb_chk", length));
			String[] atdChk = (JSPUtil.getParameter(request, prefix	+ "atd_chk", length));
			String[] ataChk = (JSPUtil.getParameter(request, prefix	+ "ata_chk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new ActPortSkdChangeVO();
				if (atdLocTime[i] != null)
					model.setAtdLocTime(atdLocTime[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (allChk[i] != null)
					model.setAllChk(allChk[i]);
				if (atbLocTime[i] != null)
					model.setAtbLocTime(atbLocTime[i]);
				if (ataLocTime[i] != null)
					model.setAtaLocTime(ataLocTime[i]);
				if (usrChk[i] != null)
					model.setUsrChk(usrChk[i]);
				if (bkgVrtChk[i] != null)
					model.setBkgVrtChk(bkgVrtChk[i]);
				if (bkgChk[i] != null)
					model.setBkgChk(bkgChk[i]);
				if (atbChk[i] != null)
					model.setAtbChk(atbChk[i]);
				if (atdChk[i] != null)
					model.setAtdChk(atdChk[i]);
				if (ataChk[i] != null)
					model.setAtaChk(ataChk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getActPortSkdChangeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ActPortSkdChangeVO[]
	 */
	public ActPortSkdChangeVO[] getActPortSkdChangeVOs(){
		ActPortSkdChangeVO[] vos = (ActPortSkdChangeVO[])models.toArray(new ActPortSkdChangeVO[models.size()]);
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
		this.atdLocTime = this.atdLocTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allChk = this.allChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atbLocTime = this.atbLocTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ataLocTime = this.ataLocTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrChk = this.usrChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgVrtChk = this.bkgVrtChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgChk = this.bkgChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atbChk = this.atbChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atdChk = this.atdChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ataChk = this.ataChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

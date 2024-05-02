/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TdrBsaVO.java
*@FileTitle : TdrBsaVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.17
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.10.17 장석현 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo;

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
 * @author 장석현
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TdrBsaVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TdrBsaVO> models = new ArrayList<TdrBsaVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String voyNo = null;
	/* Column Info */
	private String hc40Qty = null;
	/* Column Info */
	private String updateTime = null;
	/* Column Info */
	private String ttlRat = null;
	/* Column Info */
	private String ovRat45 = null;
	/* Column Info */
	private String hc20Rat = null;
	/* Column Info */
	private String hc40Rat = null;
	/* Column Info */
	private String ttlQty = null;
	/* Column Info */
	private String qty45 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String unRat45 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String callInd = null;
	/* Column Info */
	private String ttlWgt = null;
	/* Column Info */
	private String oprCd = null;
	/* Column Info */
	private String teuWgt = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String hc20Qty = null;
	/* Column Info */
	private String updateUser = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TdrBsaVO() {}

	public TdrBsaVO(String ibflag, String pagerows, String vslCd, String voyNo, String dirCd, String portCd, String callInd, String oprCd, String ttlQty, String ttlWgt, String hc40Qty, String hc40Rat, String hc20Qty, String hc20Rat, String qty45, String unRat45, String ovRat45, String ttlRat, String updateUser, String updateTime, String teuWgt) {
		this.vslCd = vslCd;
		this.voyNo = voyNo;
		this.hc40Qty = hc40Qty;
		this.updateTime = updateTime;
		this.ttlRat = ttlRat;
		this.ovRat45 = ovRat45;
		this.hc20Rat = hc20Rat;
		this.hc40Rat = hc40Rat;
		this.ttlQty = ttlQty;
		this.qty45 = qty45;
		this.pagerows = pagerows;
		this.unRat45 = unRat45;
		this.ibflag = ibflag;
		this.callInd = callInd;
		this.ttlWgt = ttlWgt;
		this.oprCd = oprCd;
		this.teuWgt = teuWgt;
		this.dirCd = dirCd;
		this.portCd = portCd;
		this.hc20Qty = hc20Qty;
		this.updateUser = updateUser;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("voy_no", getVoyNo());
		this.hashColumns.put("hc40_qty", getHc40Qty());
		this.hashColumns.put("update_time", getUpdateTime());
		this.hashColumns.put("ttl_rat", getTtlRat());
		this.hashColumns.put("ov_rat_45", getOvRat45());
		this.hashColumns.put("hc20_rat", getHc20Rat());
		this.hashColumns.put("hc40_rat", getHc40Rat());
		this.hashColumns.put("ttl_qty", getTtlQty());
		this.hashColumns.put("qty_45", getQty45());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("un_rat_45", getUnRat45());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("call_ind", getCallInd());
		this.hashColumns.put("ttl_wgt", getTtlWgt());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("teu_wgt", getTeuWgt());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("hc20_qty", getHc20Qty());
		this.hashColumns.put("update_user", getUpdateUser());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("voy_no", "voyNo");
		this.hashFields.put("hc40_qty", "hc40Qty");
		this.hashFields.put("update_time", "updateTime");
		this.hashFields.put("ttl_rat", "ttlRat");
		this.hashFields.put("ov_rat_45", "ovRat45");
		this.hashFields.put("hc20_rat", "hc20Rat");
		this.hashFields.put("hc40_rat", "hc40Rat");
		this.hashFields.put("ttl_qty", "ttlQty");
		this.hashFields.put("qty_45", "qty45");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("un_rat_45", "unRat45");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("call_ind", "callInd");
		this.hashFields.put("ttl_wgt", "ttlWgt");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("teu_wgt", "teuWgt");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("hc20_qty", "hc20Qty");
		this.hashFields.put("update_user", "updateUser");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return voyNo
	 */
	public String getVoyNo() {
		return this.voyNo;
	}
	
	/**
	 * Column Info
	 * @return hc40Qty
	 */
	public String getHc40Qty() {
		return this.hc40Qty;
	}
	
	/**
	 * Column Info
	 * @return updateTime
	 */
	public String getUpdateTime() {
		return this.updateTime;
	}
	
	/**
	 * Column Info
	 * @return ttlRat
	 */
	public String getTtlRat() {
		return this.ttlRat;
	}
	
	/**
	 * Column Info
	 * @return ovRat45
	 */
	public String getOvRat45() {
		return this.ovRat45;
	}
	
	/**
	 * Column Info
	 * @return hc20Rat
	 */
	public String getHc20Rat() {
		return this.hc20Rat;
	}
	
	/**
	 * Column Info
	 * @return hc40Rat
	 */
	public String getHc40Rat() {
		return this.hc40Rat;
	}
	
	/**
	 * Column Info
	 * @return ttlQty
	 */
	public String getTtlQty() {
		return this.ttlQty;
	}
	
	/**
	 * Column Info
	 * @return qty45
	 */
	public String getQty45() {
		return this.qty45;
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
	 * @return unRat45
	 */
	public String getUnRat45() {
		return this.unRat45;
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
	 * @return callInd
	 */
	public String getCallInd() {
		return this.callInd;
	}
	
	/**
	 * Column Info
	 * @return ttlWgt
	 */
	public String getTtlWgt() {
		return this.ttlWgt;
	}
	
	/**
	 * Column Info
	 * @return oprCd
	 */
	public String getOprCd() {
		return this.oprCd;
	}
	
	/**
	 * Column Info
	 * @return teuWgt
	 */
	public String getTeuWgt() {
		return this.teuWgt;
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
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return hc20Qty
	 */
	public String getHc20Qty() {
		return this.hc20Qty;
	}
	
	/**
	 * Column Info
	 * @return updateUser
	 */
	public String getUpdateUser() {
		return this.updateUser;
	}
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param voyNo
	 */
	public void setVoyNo(String voyNo) {
		this.voyNo = voyNo;
	}
	
	/**
	 * Column Info
	 * @param hc40Qty
	 */
	public void setHc40Qty(String hc40Qty) {
		this.hc40Qty = hc40Qty;
	}
	
	/**
	 * Column Info
	 * @param updateTime
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	/**
	 * Column Info
	 * @param ttlRat
	 */
	public void setTtlRat(String ttlRat) {
		this.ttlRat = ttlRat;
	}
	
	/**
	 * Column Info
	 * @param ovRat45
	 */
	public void setOvRat45(String ovRat45) {
		this.ovRat45 = ovRat45;
	}
	
	/**
	 * Column Info
	 * @param hc20Rat
	 */
	public void setHc20Rat(String hc20Rat) {
		this.hc20Rat = hc20Rat;
	}
	
	/**
	 * Column Info
	 * @param hc40Rat
	 */
	public void setHc40Rat(String hc40Rat) {
		this.hc40Rat = hc40Rat;
	}
	
	/**
	 * Column Info
	 * @param ttlQty
	 */
	public void setTtlQty(String ttlQty) {
		this.ttlQty = ttlQty;
	}
	
	/**
	 * Column Info
	 * @param qty45
	 */
	public void setQty45(String qty45) {
		this.qty45 = qty45;
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
	 * @param unRat45
	 */
	public void setUnRat45(String unRat45) {
		this.unRat45 = unRat45;
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
	 * @param callInd
	 */
	public void setCallInd(String callInd) {
		this.callInd = callInd;
	}
	
	/**
	 * Column Info
	 * @param ttlWgt
	 */
	public void setTtlWgt(String ttlWgt) {
		this.ttlWgt = ttlWgt;
	}
	
	/**
	 * Column Info
	 * @param oprCd
	 */
	public void setOprCd(String oprCd) {
		this.oprCd = oprCd;
	}
	
	/**
	 * Column Info
	 * @param teuWgt
	 */
	public void setTeuWgt(String teuWgt) {
		this.teuWgt = teuWgt;
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
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param hc20Qty
	 */
	public void setHc20Qty(String hc20Qty) {
		this.hc20Qty = hc20Qty;
	}
	
	/**
	 * Column Info
	 * @param updateUser
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setVoyNo(JSPUtil.getParameter(request, "voy_no", ""));
		setHc40Qty(JSPUtil.getParameter(request, "hc40_qty", ""));
		setUpdateTime(JSPUtil.getParameter(request, "update_time", ""));
		setTtlRat(JSPUtil.getParameter(request, "ttl_rat", ""));
		setOvRat45(JSPUtil.getParameter(request, "ov_rat_45", ""));
		setHc20Rat(JSPUtil.getParameter(request, "hc20_rat", ""));
		setHc40Rat(JSPUtil.getParameter(request, "hc40_rat", ""));
		setTtlQty(JSPUtil.getParameter(request, "ttl_qty", ""));
		setQty45(JSPUtil.getParameter(request, "qty_45", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setUnRat45(JSPUtil.getParameter(request, "un_rat_45", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCallInd(JSPUtil.getParameter(request, "call_ind", ""));
		setTtlWgt(JSPUtil.getParameter(request, "ttl_wgt", ""));
		setOprCd(JSPUtil.getParameter(request, "opr_cd", ""));
		setTeuWgt(JSPUtil.getParameter(request, "teu_wgt", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setHc20Qty(JSPUtil.getParameter(request, "hc20_qty", ""));
		setUpdateUser(JSPUtil.getParameter(request, "update_user", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TdrBsaVO[]
	 */
	public TdrBsaVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TdrBsaVO[]
	 */
	public TdrBsaVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TdrBsaVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] voyNo = (JSPUtil.getParameter(request, prefix	+ "voy_no", length));
			String[] hc40Qty = (JSPUtil.getParameter(request, prefix	+ "hc40_qty", length));
			String[] updateTime = (JSPUtil.getParameter(request, prefix	+ "update_time", length));
			String[] ttlRat = (JSPUtil.getParameter(request, prefix	+ "ttl_rat", length));
			String[] ovRat45 = (JSPUtil.getParameter(request, prefix	+ "ov_rat_45", length));
			String[] hc20Rat = (JSPUtil.getParameter(request, prefix	+ "hc20_rat", length));
			String[] hc40Rat = (JSPUtil.getParameter(request, prefix	+ "hc40_rat", length));
			String[] ttlQty = (JSPUtil.getParameter(request, prefix	+ "ttl_qty", length));
			String[] qty45 = (JSPUtil.getParameter(request, prefix	+ "qty_45", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] unRat45 = (JSPUtil.getParameter(request, prefix	+ "un_rat_45", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] callInd = (JSPUtil.getParameter(request, prefix	+ "call_ind", length));
			String[] ttlWgt = (JSPUtil.getParameter(request, prefix	+ "ttl_wgt", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] teuWgt = (JSPUtil.getParameter(request, prefix	+ "teu_wgt", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] hc20Qty = (JSPUtil.getParameter(request, prefix	+ "hc20_qty", length));
			String[] updateUser = (JSPUtil.getParameter(request, prefix	+ "update_user", length));
			
			for (int i = 0; i < length; i++) {
				model = new TdrBsaVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (voyNo[i] != null)
					model.setVoyNo(voyNo[i]);
				if (hc40Qty[i] != null)
					model.setHc40Qty(hc40Qty[i]);
				if (updateTime[i] != null)
					model.setUpdateTime(updateTime[i]);
				if (ttlRat[i] != null)
					model.setTtlRat(ttlRat[i]);
				if (ovRat45[i] != null)
					model.setOvRat45(ovRat45[i]);
				if (hc20Rat[i] != null)
					model.setHc20Rat(hc20Rat[i]);
				if (hc40Rat[i] != null)
					model.setHc40Rat(hc40Rat[i]);
				if (ttlQty[i] != null)
					model.setTtlQty(ttlQty[i]);
				if (qty45[i] != null)
					model.setQty45(qty45[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (unRat45[i] != null)
					model.setUnRat45(unRat45[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (callInd[i] != null)
					model.setCallInd(callInd[i]);
				if (ttlWgt[i] != null)
					model.setTtlWgt(ttlWgt[i]);
				if (oprCd[i] != null)
					model.setOprCd(oprCd[i]);
				if (teuWgt[i] != null)
					model.setTeuWgt(teuWgt[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (hc20Qty[i] != null)
					model.setHc20Qty(hc20Qty[i]);
				if (updateUser[i] != null)
					model.setUpdateUser(updateUser[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTdrBsaVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TdrBsaVO[]
	 */
	public TdrBsaVO[] getTdrBsaVOs(){
		TdrBsaVO[] vos = (TdrBsaVO[])models.toArray(new TdrBsaVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyNo = this.voyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hc40Qty = this.hc40Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updateTime = this.updateTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlRat = this.ttlRat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovRat45 = this.ovRat45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hc20Rat = this.hc20Rat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hc40Rat = this.hc40Rat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlQty = this.ttlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qty45 = this.qty45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unRat45 = this.unRat45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callInd = this.callInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlWgt = this.ttlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teuWgt = this.teuWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hc20Qty = this.hc20Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updateUser = this.updateUser .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

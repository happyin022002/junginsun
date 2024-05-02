/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TroSplitVO.java
*@FileTitle : TroSplitVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.12
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.11.12 류대영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo;

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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TroSplitVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TroSplitVO> models = new ArrayList<TroSplitVO>();
	
	/* Column Info */
	private String hualage = null;
	/* Column Info */
	private String troSubSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String troTp = null;
	/* Column Info */
	private String troSeq = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String door = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TroSplitVO() {}

	public TroSplitVO(String ibflag, String pagerows, String troSeq, String troSubSeq, String cntrTpszCd, String hualage, String door, String troTp) {
		this.hualage = hualage;
		this.troSubSeq = troSubSeq;
		this.ibflag = ibflag;
		this.troTp = troTp;
		this.troSeq = troSeq;
		this.cntrTpszCd = cntrTpszCd;
		this.door = door;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("hualage", getHualage());
		this.hashColumns.put("tro_sub_seq", getTroSubSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tro_tp", getTroTp());
		this.hashColumns.put("tro_seq", getTroSeq());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("door", getDoor());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("hualage", "hualage");
		this.hashFields.put("tro_sub_seq", "troSubSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tro_tp", "troTp");
		this.hashFields.put("tro_seq", "troSeq");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("door", "door");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return hualage
	 */
	public String getHualage() {
		return this.hualage;
	}
	
	/**
	 * Column Info
	 * @return troSubSeq
	 */
	public String getTroSubSeq() {
		return this.troSubSeq;
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
	 * @return troTp
	 */
	public String getTroTp() {
		return this.troTp;
	}
	
	/**
	 * Column Info
	 * @return troSeq
	 */
	public String getTroSeq() {
		return this.troSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return door
	 */
	public String getDoor() {
		return this.door;
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
	 * @param hualage
	 */
	public void setHualage(String hualage) {
		this.hualage = hualage;
	}
	
	/**
	 * Column Info
	 * @param troSubSeq
	 */
	public void setTroSubSeq(String troSubSeq) {
		this.troSubSeq = troSubSeq;
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
	 * @param troTp
	 */
	public void setTroTp(String troTp) {
		this.troTp = troTp;
	}
	
	/**
	 * Column Info
	 * @param troSeq
	 */
	public void setTroSeq(String troSeq) {
		this.troSeq = troSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param door
	 */
	public void setDoor(String door) {
		this.door = door;
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
		setHualage(JSPUtil.getParameter(request, "hualage", ""));
		setTroSubSeq(JSPUtil.getParameter(request, "tro_sub_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTroTp(JSPUtil.getParameter(request, "tro_tp", ""));
		setTroSeq(JSPUtil.getParameter(request, "tro_seq", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setDoor(JSPUtil.getParameter(request, "door", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TroSplitVO[]
	 */
	public TroSplitVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TroSplitVO[]
	 */
	public TroSplitVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TroSplitVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] hualage = (JSPUtil.getParameter(request, prefix	+ "hualage", length));
			String[] troSubSeq = (JSPUtil.getParameter(request, prefix	+ "tro_sub_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] troTp = (JSPUtil.getParameter(request, prefix	+ "tro_tp", length));
			String[] troSeq = (JSPUtil.getParameter(request, prefix	+ "tro_seq", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] door = (JSPUtil.getParameter(request, prefix	+ "door", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new TroSplitVO();
				if (hualage[i] != null)
					model.setHualage(hualage[i]);
				if (troSubSeq[i] != null)
					model.setTroSubSeq(troSubSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (troTp[i] != null)
					model.setTroTp(troTp[i]);
				if (troSeq[i] != null)
					model.setTroSeq(troSeq[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (door[i] != null)
					model.setDoor(door[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTroSplitVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TroSplitVO[]
	 */
	public TroSplitVO[] getTroSplitVOs(){
		TroSplitVO[] vos = (TroSplitVO[])models.toArray(new TroSplitVO[models.size()]);
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
		this.hualage = this.hualage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSubSeq = this.troSubSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troTp = this.troTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSeq = this.troSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.door = this.door .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

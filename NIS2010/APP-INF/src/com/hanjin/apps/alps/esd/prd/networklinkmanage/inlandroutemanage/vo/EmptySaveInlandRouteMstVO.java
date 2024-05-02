/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : EmptySaveInlandRouteMstVO.java
*@FileTitle : EmptySaveInlandRouteMstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo;

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

public class EmptySaveInlandRouteMstVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EmptySaveInlandRouteMstVO> models = new ArrayList<EmptySaveInlandRouteMstVO>();
	
	/* Column Info */
	private String r5Flg = null;
	/* Column Info */
	private String r8Flg = null;
	/* Column Info */
	private String d2Flg = null;
	/* Column Info */
	private String routOrgNodCd = null;
	/* Column Info */
	private String o5Flg = null;
	/* Column Info */
	private String d4Flg = null;
	/* Column Info */
	private String a2Flg = null;
	/* Column Info */
	private String a4Flg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String d5Flg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String o4Flg = null;
	/* Column Info */
	private String o2Flg = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String d7Flg = null;
	/* Column Info */
	private String iDelFlag = null;
	/* Column Info */
	private String routDestNodCd = null;
	/* Column Info */
	private String r2Flg = null;
	/* Column Info */
	private String a5Flg = null;
	/* Column Info */
	private String wrsChk = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EmptySaveInlandRouteMstVO() {}

	public EmptySaveInlandRouteMstVO(String ibflag, String pagerows, String r5Flg, String d2Flg, String routOrgNodCd, String d4Flg, String a2Flg, String a4Flg, String a5Flg, String routSeq, String d5Flg, String creUsrId, String o4Flg, String o5Flg, String o2Flg, String creOfcCd, String iDelFlag, String d7Flg, String routDestNodCd, String r2Flg, String updUsrId, String wrsChk, String r8Flg) {
		this.r5Flg = r5Flg;
		this.r8Flg = r8Flg;
		this.d2Flg = d2Flg;
		this.routOrgNodCd = routOrgNodCd;
		this.o5Flg = o5Flg;
		this.d4Flg = d4Flg;
		this.a2Flg = a2Flg;
		this.a4Flg = a4Flg;
		this.pagerows = pagerows;
		this.routSeq = routSeq;
		this.d5Flg = d5Flg;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.o4Flg = o4Flg;
		this.o2Flg = o2Flg;
		this.creOfcCd = creOfcCd;
		this.d7Flg = d7Flg;
		this.iDelFlag = iDelFlag;
		this.routDestNodCd = routDestNodCd;
		this.r2Flg = r2Flg;
		this.a5Flg = a5Flg;
		this.wrsChk = wrsChk;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("r5_flg", getR5Flg());
		this.hashColumns.put("r8_flg", getR8Flg());
		this.hashColumns.put("d2_flg", getD2Flg());
		this.hashColumns.put("rout_org_nod_cd", getRoutOrgNodCd());
		this.hashColumns.put("o5_flg", getO5Flg());
		this.hashColumns.put("d4_flg", getD4Flg());
		this.hashColumns.put("a2_flg", getA2Flg());
		this.hashColumns.put("a4_flg", getA4Flg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("d5_flg", getD5Flg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("o4_flg", getO4Flg());
		this.hashColumns.put("o2_flg", getO2Flg());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("d7_flg", getD7Flg());
		this.hashColumns.put("i_del_flag", getIDelFlag());
		this.hashColumns.put("rout_dest_nod_cd", getRoutDestNodCd());
		this.hashColumns.put("r2_flg", getR2Flg());
		this.hashColumns.put("a5_flg", getA5Flg());
		this.hashColumns.put("wrs_chk", getWrsChk());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("r5_flg", "r5Flg");
		this.hashFields.put("r8_flg", "r8Flg");
		this.hashFields.put("d2_flg", "d2Flg");
		this.hashFields.put("rout_org_nod_cd", "routOrgNodCd");
		this.hashFields.put("o5_flg", "o5Flg");
		this.hashFields.put("d4_flg", "d4Flg");
		this.hashFields.put("a2_flg", "a2Flg");
		this.hashFields.put("a4_flg", "a4Flg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("d5_flg", "d5Flg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("o4_flg", "o4Flg");
		this.hashFields.put("o2_flg", "o2Flg");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("d7_flg", "d7Flg");
		this.hashFields.put("i_del_flag", "iDelFlag");
		this.hashFields.put("rout_dest_nod_cd", "routDestNodCd");
		this.hashFields.put("r2_flg", "r2Flg");
		this.hashFields.put("a5_flg", "a5Flg");
		this.hashFields.put("wrs_chk", "wrsChk");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return r5Flg
	 */
	public String getR5Flg() {
		return this.r5Flg;
	}
	
	/**
	 * Column Info
	 * @return r8Flg
	 */
	public String getR8Flg() {
		return this.r8Flg;
	}
	
	/**
	 * Column Info
	 * @return d2Flg
	 */
	public String getD2Flg() {
		return this.d2Flg;
	}
	
	/**
	 * Column Info
	 * @return routOrgNodCd
	 */
	public String getRoutOrgNodCd() {
		return this.routOrgNodCd;
	}
	
	/**
	 * Column Info
	 * @return o5Flg
	 */
	public String getO5Flg() {
		return this.o5Flg;
	}
	
	/**
	 * Column Info
	 * @return d4Flg
	 */
	public String getD4Flg() {
		return this.d4Flg;
	}
	
	/**
	 * Column Info
	 * @return a2Flg
	 */
	public String getA2Flg() {
		return this.a2Flg;
	}
	
	/**
	 * Column Info
	 * @return a4Flg
	 */
	public String getA4Flg() {
		return this.a4Flg;
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
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
	}
	
	/**
	 * Column Info
	 * @return d5Flg
	 */
	public String getD5Flg() {
		return this.d5Flg;
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
	 * @return o4Flg
	 */
	public String getO4Flg() {
		return this.o4Flg;
	}
	
	/**
	 * Column Info
	 * @return o2Flg
	 */
	public String getO2Flg() {
		return this.o2Flg;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return d7Flg
	 */
	public String getD7Flg() {
		return this.d7Flg;
	}
	
	/**
	 * Column Info
	 * @return iDelFlag
	 */
	public String getIDelFlag() {
		return this.iDelFlag;
	}
	
	/**
	 * Column Info
	 * @return routDestNodCd
	 */
	public String getRoutDestNodCd() {
		return this.routDestNodCd;
	}
	
	/**
	 * Column Info
	 * @return r2Flg
	 */
	public String getR2Flg() {
		return this.r2Flg;
	}
	
	/**
	 * Column Info
	 * @return a5Flg
	 */
	public String getA5Flg() {
		return this.a5Flg;
	}
	
	/**
	 * Column Info
	 * @return wrsChk
	 */
	public String getWrsChk() {
		return this.wrsChk;
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
	 * @param r5Flg
	 */
	public void setR5Flg(String r5Flg) {
		this.r5Flg = r5Flg;
	}
	
	/**
	 * Column Info
	 * @param r8Flg
	 */
	public void setR8Flg(String r8Flg) {
		this.r8Flg = r8Flg;
	}
	
	/**
	 * Column Info
	 * @param d2Flg
	 */
	public void setD2Flg(String d2Flg) {
		this.d2Flg = d2Flg;
	}
	
	/**
	 * Column Info
	 * @param routOrgNodCd
	 */
	public void setRoutOrgNodCd(String routOrgNodCd) {
		this.routOrgNodCd = routOrgNodCd;
	}
	
	/**
	 * Column Info
	 * @param o5Flg
	 */
	public void setO5Flg(String o5Flg) {
		this.o5Flg = o5Flg;
	}
	
	/**
	 * Column Info
	 * @param d4Flg
	 */
	public void setD4Flg(String d4Flg) {
		this.d4Flg = d4Flg;
	}
	
	/**
	 * Column Info
	 * @param a2Flg
	 */
	public void setA2Flg(String a2Flg) {
		this.a2Flg = a2Flg;
	}
	
	/**
	 * Column Info
	 * @param a4Flg
	 */
	public void setA4Flg(String a4Flg) {
		this.a4Flg = a4Flg;
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
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
	}
	
	/**
	 * Column Info
	 * @param d5Flg
	 */
	public void setD5Flg(String d5Flg) {
		this.d5Flg = d5Flg;
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
	 * @param o4Flg
	 */
	public void setO4Flg(String o4Flg) {
		this.o4Flg = o4Flg;
	}
	
	/**
	 * Column Info
	 * @param o2Flg
	 */
	public void setO2Flg(String o2Flg) {
		this.o2Flg = o2Flg;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param d7Flg
	 */
	public void setD7Flg(String d7Flg) {
		this.d7Flg = d7Flg;
	}
	
	/**
	 * Column Info
	 * @param iDelFlag
	 */
	public void setIDelFlag(String iDelFlag) {
		this.iDelFlag = iDelFlag;
	}
	
	/**
	 * Column Info
	 * @param routDestNodCd
	 */
	public void setRoutDestNodCd(String routDestNodCd) {
		this.routDestNodCd = routDestNodCd;
	}
	
	/**
	 * Column Info
	 * @param r2Flg
	 */
	public void setR2Flg(String r2Flg) {
		this.r2Flg = r2Flg;
	}
	
	/**
	 * Column Info
	 * @param a5Flg
	 */
	public void setA5Flg(String a5Flg) {
		this.a5Flg = a5Flg;
	}
	
	/**
	 * Column Info
	 * @param wrsChk
	 */
	public void setWrsChk(String wrsChk) {
		this.wrsChk = wrsChk;
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
		setR5Flg(JSPUtil.getParameter(request, prefix + "r5_flg", ""));
		setR8Flg(JSPUtil.getParameter(request, prefix + "r8_flg", ""));
		setD2Flg(JSPUtil.getParameter(request, prefix + "d2_flg", ""));
		setRoutOrgNodCd(JSPUtil.getParameter(request, prefix + "rout_org_nod_cd", ""));
		setO5Flg(JSPUtil.getParameter(request, prefix + "o5_flg", ""));
		setD4Flg(JSPUtil.getParameter(request, prefix + "d4_flg", ""));
		setA2Flg(JSPUtil.getParameter(request, prefix + "a2_flg", ""));
		setA4Flg(JSPUtil.getParameter(request, prefix + "a4_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRoutSeq(JSPUtil.getParameter(request, prefix + "rout_seq", ""));
		setD5Flg(JSPUtil.getParameter(request, prefix + "d5_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setO4Flg(JSPUtil.getParameter(request, prefix + "o4_flg", ""));
		setO2Flg(JSPUtil.getParameter(request, prefix + "o2_flg", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setD7Flg(JSPUtil.getParameter(request, prefix + "d7_flg", ""));
		setIDelFlag(JSPUtil.getParameter(request, prefix + "i_del_flag", ""));
		setRoutDestNodCd(JSPUtil.getParameter(request, prefix + "rout_dest_nod_cd", ""));
		setR2Flg(JSPUtil.getParameter(request, prefix + "r2_flg", ""));
		setA5Flg(JSPUtil.getParameter(request, prefix + "a5_flg", ""));
		setWrsChk(JSPUtil.getParameter(request, prefix + "wrs_chk", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EmptySaveInlandRouteMstVO[]
	 */
	public EmptySaveInlandRouteMstVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EmptySaveInlandRouteMstVO[]
	 */
	public EmptySaveInlandRouteMstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EmptySaveInlandRouteMstVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] r5Flg = (JSPUtil.getParameter(request, prefix	+ "r5_flg", length));
			String[] r8Flg = (JSPUtil.getParameter(request, prefix	+ "r8_flg", length));
			String[] d2Flg = (JSPUtil.getParameter(request, prefix	+ "d2_flg", length));
			String[] routOrgNodCd = (JSPUtil.getParameter(request, prefix	+ "rout_org_nod_cd", length));
			String[] o5Flg = (JSPUtil.getParameter(request, prefix	+ "o5_flg", length));
			String[] d4Flg = (JSPUtil.getParameter(request, prefix	+ "d4_flg", length));
			String[] a2Flg = (JSPUtil.getParameter(request, prefix	+ "a2_flg", length));
			String[] a4Flg = (JSPUtil.getParameter(request, prefix	+ "a4_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] d5Flg = (JSPUtil.getParameter(request, prefix	+ "d5_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] o4Flg = (JSPUtil.getParameter(request, prefix	+ "o4_flg", length));
			String[] o2Flg = (JSPUtil.getParameter(request, prefix	+ "o2_flg", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] d7Flg = (JSPUtil.getParameter(request, prefix	+ "d7_flg", length));
			String[] iDelFlag = (JSPUtil.getParameter(request, prefix	+ "i_del_flag", length));
			String[] routDestNodCd = (JSPUtil.getParameter(request, prefix	+ "rout_dest_nod_cd", length));
			String[] r2Flg = (JSPUtil.getParameter(request, prefix	+ "r2_flg", length));
			String[] a5Flg = (JSPUtil.getParameter(request, prefix	+ "a5_flg", length));
			String[] wrsChk = (JSPUtil.getParameter(request, prefix	+ "wrs_chk", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new EmptySaveInlandRouteMstVO();
				if (r5Flg[i] != null)
					model.setR5Flg(r5Flg[i]);
				if (r8Flg[i] != null)
					model.setR8Flg(r8Flg[i]);
				if (d2Flg[i] != null)
					model.setD2Flg(d2Flg[i]);
				if (routOrgNodCd[i] != null)
					model.setRoutOrgNodCd(routOrgNodCd[i]);
				if (o5Flg[i] != null)
					model.setO5Flg(o5Flg[i]);
				if (d4Flg[i] != null)
					model.setD4Flg(d4Flg[i]);
				if (a2Flg[i] != null)
					model.setA2Flg(a2Flg[i]);
				if (a4Flg[i] != null)
					model.setA4Flg(a4Flg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (d5Flg[i] != null)
					model.setD5Flg(d5Flg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (o4Flg[i] != null)
					model.setO4Flg(o4Flg[i]);
				if (o2Flg[i] != null)
					model.setO2Flg(o2Flg[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (d7Flg[i] != null)
					model.setD7Flg(d7Flg[i]);
				if (iDelFlag[i] != null)
					model.setIDelFlag(iDelFlag[i]);
				if (routDestNodCd[i] != null)
					model.setRoutDestNodCd(routDestNodCd[i]);
				if (r2Flg[i] != null)
					model.setR2Flg(r2Flg[i]);
				if (a5Flg[i] != null)
					model.setA5Flg(a5Flg[i]);
				if (wrsChk[i] != null)
					model.setWrsChk(wrsChk[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEmptySaveInlandRouteMstVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EmptySaveInlandRouteMstVO[]
	 */
	public EmptySaveInlandRouteMstVO[] getEmptySaveInlandRouteMstVOs(){
		EmptySaveInlandRouteMstVO[] vos = (EmptySaveInlandRouteMstVO[])models.toArray(new EmptySaveInlandRouteMstVO[models.size()]);
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
		this.r5Flg = this.r5Flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r8Flg = this.r8Flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2Flg = this.d2Flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routOrgNodCd = this.routOrgNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o5Flg = this.o5Flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d4Flg = this.d4Flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a2Flg = this.a2Flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a4Flg = this.a4Flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d5Flg = this.d5Flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o4Flg = this.o4Flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.o2Flg = this.o2Flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d7Flg = this.d7Flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iDelFlag = this.iDelFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routDestNodCd = this.routDestNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r2Flg = this.r2Flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.a5Flg = this.a5Flg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrsChk = this.wrsChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
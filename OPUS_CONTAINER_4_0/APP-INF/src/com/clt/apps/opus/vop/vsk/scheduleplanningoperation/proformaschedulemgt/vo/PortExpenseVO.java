/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortExpenseVO.java
*@FileTitle : PortExpenseVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.21
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.07.21 서창열 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 서창열
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PortExpenseVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PortExpenseVO> models = new ArrayList<PortExpenseVO>();
	
	/* Column Info */
	private String classCnt = null;
	/* Column Info */
	private String classCnt02 = null;
	/* Column Info */
	private String classCnt01 = null;
	/* Column Info */
	private String sumClass03 = null;
	/* Column Info */
	private String classCnt03 = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslClass01 = null;
	/* Column Info */
	private String sumClass02 = null;
	/* Column Info */
	private String vslClass02 = null;
	/* Column Info */
	private String sumClass01 = null;
	/* Column Info */
	private String classAvg = null;
	/* Column Info */
	private String vslClass03 = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String portRotnSeq = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String clptSeq = null;
	/* Column Info */
	private String sltPrcWrkYr = null;
	/* Column Info */
	private String bseQtrCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PortExpenseVO() {}

	public PortExpenseVO(String ibflag, String pagerows, String ydCd, String portRotnSeq, String classCnt, String vslClass01, String classCnt01, String vslClass02, String classCnt02, String vslClass03, String classCnt03, String sumClass01, String sumClass02, String sumClass03, String classAvg, String skdDirCd, String portCd, String clptSeq,String sltPrcWrkYr, String bseQtrCd) {
		this.classCnt = classCnt;
		this.classCnt02 = classCnt02;
		this.classCnt01 = classCnt01;
		this.sumClass03 = sumClass03;
		this.classCnt03 = classCnt03;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.vslClass01 = vslClass01;
		this.sumClass02 = sumClass02;
		this.vslClass02 = vslClass02;
		this.sumClass01 = sumClass01;
		this.classAvg = classAvg;
		this.vslClass03 = vslClass03;
		this.ydCd = ydCd;
		this.portRotnSeq = portRotnSeq;
		this.skdDirCd = skdDirCd;
		this.portCd = portCd;
		this.clptSeq = clptSeq;
		this.sltPrcWrkYr = sltPrcWrkYr;
		this.bseQtrCd = bseQtrCd;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("class_cnt", getClassCnt());
		this.hashColumns.put("class_cnt02", getClassCnt02());
		this.hashColumns.put("class_cnt01", getClassCnt01());
		this.hashColumns.put("sum_class03", getSumClass03());
		this.hashColumns.put("class_cnt03", getClassCnt03());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_class01", getVslClass01());
		this.hashColumns.put("sum_class02", getSumClass02());
		this.hashColumns.put("vsl_class02", getVslClass02());
		this.hashColumns.put("sum_class01", getSumClass01());
		this.hashColumns.put("class_avg", getClassAvg());
		this.hashColumns.put("vsl_class03", getVslClass03());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("port_rotn_seq", getPortRotnSeq());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("clpt_seq", getClptSeq());
		this.hashColumns.put("slt_prc_wrk_yr", getSltPrcWrkYr());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("class_cnt", "classCnt");
		this.hashFields.put("class_cnt02", "classCnt02");
		this.hashFields.put("class_cnt01", "classCnt01");
		this.hashFields.put("sum_class03", "sumClass03");
		this.hashFields.put("class_cnt03", "classCnt03");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_class01", "vslClass01");
		this.hashFields.put("sum_class02", "sumClass02");
		this.hashFields.put("vsl_class02", "vslClass02");
		this.hashFields.put("sum_class01", "sumClass01");
		this.hashFields.put("class_avg", "classAvg");
		this.hashFields.put("vsl_class03", "vslClass03");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("port_rotn_seq", "portRotnSeq");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("clpt_seq", "clptSeq");
		this.hashFields.put("slt_prc_wrk_yr", "sltPrcWrkYr");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return classCnt
	 */
	public String getClassCnt() {
		return this.classCnt;
	}
	
	/**
	 * Column Info
	 * @return classCnt02
	 */
	public String getClassCnt02() {
		return this.classCnt02;
	}
	
	/**
	 * Column Info
	 * @return classCnt01
	 */
	public String getClassCnt01() {
		return this.classCnt01;
	}
	
	/**
	 * Column Info
	 * @return sumClass03
	 */
	public String getSumClass03() {
		return this.sumClass03;
	}
	
	/**
	 * Column Info
	 * @return classCnt03
	 */
	public String getClassCnt03() {
		return this.classCnt03;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return vslClass01
	 */
	public String getVslClass01() {
		return this.vslClass01;
	}
	
	/**
	 * Column Info
	 * @return sumClass02
	 */
	public String getSumClass02() {
		return this.sumClass02;
	}
	
	/**
	 * Column Info
	 * @return vslClass02
	 */
	public String getVslClass02() {
		return this.vslClass02;
	}
	
	/**
	 * Column Info
	 * @return sumClass01
	 */
	public String getSumClass01() {
		return this.sumClass01;
	}
	
	/**
	 * Column Info
	 * @return classAvg
	 */
	public String getClassAvg() {
		return this.classAvg;
	}
	
	/**
	 * Column Info
	 * @return vslClass03
	 */
	public String getVslClass03() {
		return this.vslClass03;
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
	 * @return portRotnSeq
	 */
	public String getPortRotnSeq() {
		return this.portRotnSeq;
	}
	
	/**
	 * Column Info
	 * @return portRotnSeq
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return portRotnSeq
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return portRotnSeq
	 */
	public String getClptSeq() {
		return this.clptSeq;
	}
	
	/**
	 * Column Info
	 * @return sltPrcWrkYr
	 */
	public String getSltPrcWrkYr() {
		return this.sltPrcWrkYr;
	}
	
	/**
	 * Column Info
	 * @return bseQtrCd
	 */
	public String getBseQtrCd() {
		return this.bseQtrCd;
	}
	

	/**
	 * Column Info
	 * @param classCnt
	 */
	public void setClassCnt(String classCnt) {
		this.classCnt = classCnt;
	}
	
	/**
	 * Column Info
	 * @param classCnt02
	 */
	public void setClassCnt02(String classCnt02) {
		this.classCnt02 = classCnt02;
	}
	
	/**
	 * Column Info
	 * @param classCnt01
	 */
	public void setClassCnt01(String classCnt01) {
		this.classCnt01 = classCnt01;
	}
	
	/**
	 * Column Info
	 * @param sumClass03
	 */
	public void setSumClass03(String sumClass03) {
		this.sumClass03 = sumClass03;
	}
	
	/**
	 * Column Info
	 * @param classCnt03
	 */
	public void setClassCnt03(String classCnt03) {
		this.classCnt03 = classCnt03;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param vslClass01
	 */
	public void setVslClass01(String vslClass01) {
		this.vslClass01 = vslClass01;
	}
	
	/**
	 * Column Info
	 * @param sumClass02
	 */
	public void setSumClass02(String sumClass02) {
		this.sumClass02 = sumClass02;
	}
	
	/**
	 * Column Info
	 * @param vslClass02
	 */
	public void setVslClass02(String vslClass02) {
		this.vslClass02 = vslClass02;
	}
	
	/**
	 * Column Info
	 * @param sumClass01
	 */
	public void setSumClass01(String sumClass01) {
		this.sumClass01 = sumClass01;
	}
	
	/**
	 * Column Info
	 * @param classAvg
	 */
	public void setClassAvg(String classAvg) {
		this.classAvg = classAvg;
	}
	
	/**
	 * Column Info
	 * @param vslClass03
	 */
	public void setVslClass03(String vslClass03) {
		this.vslClass03 = vslClass03;
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
	 * @param portRotnSeq
	 */
	public void setPortRotnSeq(String portRotnSeq) {
		this.portRotnSeq = portRotnSeq;
	}
	
	/**
	 * Column Info
	 * @param portRotnSeq
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param portRotnSeq
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param portRotnSeq
	 */
	public void setClptSeq(String clptSeq) {
		this.clptSeq = clptSeq;
	}
	
	/**
	 * Column Info
	 * @param sltPrcWrkYr
	 */
	public void setSltPrcWrkYr(String sltPrcWrkYr) {
		this.sltPrcWrkYr = sltPrcWrkYr;
	}
	
	/**
	 * Column Info
	 * @param bseQtrCd
	 */
	public void setBseQtrCd(String bseQtrCd) {
		this.bseQtrCd = bseQtrCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setClassCnt(JSPUtil.getParameter(request, "class_cnt", ""));
		setClassCnt02(JSPUtil.getParameter(request, "class_cnt02", ""));
		setClassCnt01(JSPUtil.getParameter(request, "class_cnt01", ""));
		setSumClass03(JSPUtil.getParameter(request, "sum_class03", ""));
		setClassCnt03(JSPUtil.getParameter(request, "class_cnt03", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslClass01(JSPUtil.getParameter(request, "vsl_class01", ""));
		setSumClass02(JSPUtil.getParameter(request, "sum_class02", ""));
		setVslClass02(JSPUtil.getParameter(request, "vsl_class02", ""));
		setSumClass01(JSPUtil.getParameter(request, "sum_class01", ""));
		setClassAvg(JSPUtil.getParameter(request, "class_avg", ""));
		setVslClass03(JSPUtil.getParameter(request, "vsl_class03", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setPortRotnSeq(JSPUtil.getParameter(request, "port_rotn_seq", ""));
		
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setClptSeq(JSPUtil.getParameter(request, "clpt_seq", ""));
		setSltPrcWrkYr(JSPUtil.getParameter(request, "slt_prc_wrk_yr", ""));
		setBseQtrCd(JSPUtil.getParameter(request, "bse_qtr_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PortExpenseVO[]
	 */
	public PortExpenseVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PortExpenseVO[]
	 */
	public PortExpenseVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PortExpenseVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] classCnt = (JSPUtil.getParameter(request, prefix	+ "class_cnt", length));
			String[] classCnt02 = (JSPUtil.getParameter(request, prefix	+ "class_cnt02", length));
			String[] classCnt01 = (JSPUtil.getParameter(request, prefix	+ "class_cnt01", length));
			String[] sumClass03 = (JSPUtil.getParameter(request, prefix	+ "sum_class03", length));
			String[] classCnt03 = (JSPUtil.getParameter(request, prefix	+ "class_cnt03", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslClass01 = (JSPUtil.getParameter(request, prefix	+ "vsl_class01", length));
			String[] sumClass02 = (JSPUtil.getParameter(request, prefix	+ "sum_class02", length));
			String[] vslClass02 = (JSPUtil.getParameter(request, prefix	+ "vsl_class02", length));
			String[] sumClass01 = (JSPUtil.getParameter(request, prefix	+ "sum_class01", length));
			String[] classAvg = (JSPUtil.getParameter(request, prefix	+ "class_avg", length));
			String[] vslClass03 = (JSPUtil.getParameter(request, prefix	+ "vsl_class03", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] portRotnSeq = (JSPUtil.getParameter(request, prefix	+ "port_rotn_seq", length));
			
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] clptSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_seq", length));
			String[] sltPrcWrkYr = (JSPUtil.getParameter(request, prefix	+ "slt_prc_wrk_yr", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PortExpenseVO();
				if (classCnt[i] != null)
					model.setClassCnt(classCnt[i]);
				if (classCnt02[i] != null)
					model.setClassCnt02(classCnt02[i]);
				if (classCnt01[i] != null)
					model.setClassCnt01(classCnt01[i]);
				if (sumClass03[i] != null)
					model.setSumClass03(sumClass03[i]);
				if (classCnt03[i] != null)
					model.setClassCnt03(classCnt03[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslClass01[i] != null)
					model.setVslClass01(vslClass01[i]);
				if (sumClass02[i] != null)
					model.setSumClass02(sumClass02[i]);
				if (vslClass02[i] != null)
					model.setVslClass02(vslClass02[i]);
				if (sumClass01[i] != null)
					model.setSumClass01(sumClass01[i]);
				if (classAvg[i] != null)
					model.setClassAvg(classAvg[i]);
				if (vslClass03[i] != null)
					model.setVslClass03(vslClass03[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (portRotnSeq[i] != null)
					model.setPortRotnSeq(portRotnSeq[i]);
				
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (clptSeq[i] != null)
					model.setClptSeq(clptSeq[i]);
				if (sltPrcWrkYr[i] != null)
					model.setSltPrcWrkYr(sltPrcWrkYr[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPortExpenseVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PortExpenseVO[]
	 */
	public PortExpenseVO[] getPortExpenseVOs(){
		PortExpenseVO[] vos = (PortExpenseVO[])models.toArray(new PortExpenseVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.classCnt = this.classCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.classCnt02 = this.classCnt02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.classCnt01 = this.classCnt01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumClass03 = this.sumClass03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.classCnt03 = this.classCnt03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClass01 = this.vslClass01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumClass02 = this.sumClass02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClass02 = this.vslClass02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumClass01 = this.sumClass01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.classAvg = this.classAvg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslClass03 = this.vslClass03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portRotnSeq = this.portRotnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptSeq = this.clptSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sltPrcWrkYr = this.sltPrcWrkYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

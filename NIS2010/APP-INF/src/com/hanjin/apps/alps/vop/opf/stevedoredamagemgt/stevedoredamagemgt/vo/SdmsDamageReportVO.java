/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SdmsDamageReportVO.java
*@FileTitle : SdmsDamageReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.07.02 이선영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이선영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SdmsDamageReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SdmsDamageReportVO> models = new ArrayList<SdmsDamageReportVO>();
	
	/* Column Info */
	private String grp = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String matl = null;
	/* Column Info */
	private String unkCnt = null;
	/* Column Info */
	private String repCnt = null;
	/* Column Info */
	private String dmgCnt = null;
	/* Column Info */
	private String mach = null;
	/* Column Info */
	private String hull = null;
	/* Column Info */
	private String supCnt = null;
	/* Column Info */
	private String period = null;
	/* Column Info */
	private String quoCnt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SdmsDamageReportVO() {}

	public SdmsDamageReportVO(String ibflag, String pagerows, String grp, String period, String dmgCnt, String repCnt, String supCnt, String quoCnt, String unkCnt, String hull, String matl, String mach) {
		this.grp = grp;
		this.ibflag = ibflag;
		this.matl = matl;
		this.unkCnt = unkCnt;
		this.repCnt = repCnt;
		this.dmgCnt = dmgCnt;
		this.mach = mach;
		this.hull = hull;
		this.supCnt = supCnt;
		this.period = period;
		this.quoCnt = quoCnt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("grp", getGrp());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("matl", getMatl());
		this.hashColumns.put("unk_cnt", getUnkCnt());
		this.hashColumns.put("rep_cnt", getRepCnt());
		this.hashColumns.put("dmg_cnt", getDmgCnt());
		this.hashColumns.put("mach", getMach());
		this.hashColumns.put("hull", getHull());
		this.hashColumns.put("sup_cnt", getSupCnt());
		this.hashColumns.put("period", getPeriod());
		this.hashColumns.put("quo_cnt", getQuoCnt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("grp", "grp");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("matl", "matl");
		this.hashFields.put("unk_cnt", "unkCnt");
		this.hashFields.put("rep_cnt", "repCnt");
		this.hashFields.put("dmg_cnt", "dmgCnt");
		this.hashFields.put("mach", "mach");
		this.hashFields.put("hull", "hull");
		this.hashFields.put("sup_cnt", "supCnt");
		this.hashFields.put("period", "period");
		this.hashFields.put("quo_cnt", "quoCnt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return grp
	 */
	public String getGrp() {
		return this.grp;
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
	 * @return matl
	 */
	public String getMatl() {
		return this.matl;
	}
	
	/**
	 * Column Info
	 * @return unkCnt
	 */
	public String getUnkCnt() {
		return this.unkCnt;
	}
	
	/**
	 * Column Info
	 * @return repCnt
	 */
	public String getRepCnt() {
		return this.repCnt;
	}
	
	/**
	 * Column Info
	 * @return dmgCnt
	 */
	public String getDmgCnt() {
		return this.dmgCnt;
	}
	
	/**
	 * Column Info
	 * @return mach
	 */
	public String getMach() {
		return this.mach;
	}
	
	/**
	 * Column Info
	 * @return hull
	 */
	public String getHull() {
		return this.hull;
	}
	
	/**
	 * Column Info
	 * @return supCnt
	 */
	public String getSupCnt() {
		return this.supCnt;
	}
	
	/**
	 * Column Info
	 * @return period
	 */
	public String getPeriod() {
		return this.period;
	}
	
	/**
	 * Column Info
	 * @return quoCnt
	 */
	public String getQuoCnt() {
		return this.quoCnt;
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
	 * @param grp
	 */
	public void setGrp(String grp) {
		this.grp = grp;
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
	 * @param matl
	 */
	public void setMatl(String matl) {
		this.matl = matl;
	}
	
	/**
	 * Column Info
	 * @param unkCnt
	 */
	public void setUnkCnt(String unkCnt) {
		this.unkCnt = unkCnt;
	}
	
	/**
	 * Column Info
	 * @param repCnt
	 */
	public void setRepCnt(String repCnt) {
		this.repCnt = repCnt;
	}
	
	/**
	 * Column Info
	 * @param dmgCnt
	 */
	public void setDmgCnt(String dmgCnt) {
		this.dmgCnt = dmgCnt;
	}
	
	/**
	 * Column Info
	 * @param mach
	 */
	public void setMach(String mach) {
		this.mach = mach;
	}
	
	/**
	 * Column Info
	 * @param hull
	 */
	public void setHull(String hull) {
		this.hull = hull;
	}
	
	/**
	 * Column Info
	 * @param supCnt
	 */
	public void setSupCnt(String supCnt) {
		this.supCnt = supCnt;
	}
	
	/**
	 * Column Info
	 * @param period
	 */
	public void setPeriod(String period) {
		this.period = period;
	}
	
	/**
	 * Column Info
	 * @param quoCnt
	 */
	public void setQuoCnt(String quoCnt) {
		this.quoCnt = quoCnt;
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
		setGrp(JSPUtil.getParameter(request, "grp", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMatl(JSPUtil.getParameter(request, "matl", ""));
		setUnkCnt(JSPUtil.getParameter(request, "unk_cnt", ""));
		setRepCnt(JSPUtil.getParameter(request, "rep_cnt", ""));
		setDmgCnt(JSPUtil.getParameter(request, "dmg_cnt", ""));
		setMach(JSPUtil.getParameter(request, "mach", ""));
		setHull(JSPUtil.getParameter(request, "hull", ""));
		setSupCnt(JSPUtil.getParameter(request, "sup_cnt", ""));
		setPeriod(JSPUtil.getParameter(request, "period", ""));
		setQuoCnt(JSPUtil.getParameter(request, "quo_cnt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SdmsDamageReportVO[]
	 */
	public SdmsDamageReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SdmsDamageReportVO[]
	 */
	public SdmsDamageReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SdmsDamageReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] grp = (JSPUtil.getParameter(request, prefix	+ "grp", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] matl = (JSPUtil.getParameter(request, prefix	+ "matl", length));
			String[] unkCnt = (JSPUtil.getParameter(request, prefix	+ "unk_cnt", length));
			String[] repCnt = (JSPUtil.getParameter(request, prefix	+ "rep_cnt", length));
			String[] dmgCnt = (JSPUtil.getParameter(request, prefix	+ "dmg_cnt", length));
			String[] mach = (JSPUtil.getParameter(request, prefix	+ "mach", length));
			String[] hull = (JSPUtil.getParameter(request, prefix	+ "hull", length));
			String[] supCnt = (JSPUtil.getParameter(request, prefix	+ "sup_cnt", length));
			String[] period = (JSPUtil.getParameter(request, prefix	+ "period", length));
			String[] quoCnt = (JSPUtil.getParameter(request, prefix	+ "quo_cnt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SdmsDamageReportVO();
				if (grp[i] != null)
					model.setGrp(grp[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (matl[i] != null)
					model.setMatl(matl[i]);
				if (unkCnt[i] != null)
					model.setUnkCnt(unkCnt[i]);
				if (repCnt[i] != null)
					model.setRepCnt(repCnt[i]);
				if (dmgCnt[i] != null)
					model.setDmgCnt(dmgCnt[i]);
				if (mach[i] != null)
					model.setMach(mach[i]);
				if (hull[i] != null)
					model.setHull(hull[i]);
				if (supCnt[i] != null)
					model.setSupCnt(supCnt[i]);
				if (period[i] != null)
					model.setPeriod(period[i]);
				if (quoCnt[i] != null)
					model.setQuoCnt(quoCnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSdmsDamageReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SdmsDamageReportVO[]
	 */
	public SdmsDamageReportVO[] getSdmsDamageReportVOs(){
		SdmsDamageReportVO[] vos = (SdmsDamageReportVO[])models.toArray(new SdmsDamageReportVO[models.size()]);
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
		this.grp = this.grp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.matl = this.matl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unkCnt = this.unkCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCnt = this.repCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgCnt = this.dmgCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mach = this.mach .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hull = this.hull .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.supCnt = this.supCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.period = this.period .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.quoCnt = this.quoCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

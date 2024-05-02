/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VosiUpdateMonitoringVO.java
*@FileTitle : VosiUpdateMonitoringVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.16 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.vesseloperationsupportmonitoring.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VosiUpdateMonitoringVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VosiUpdateMonitoringVO> models = new ArrayList<VosiUpdateMonitoringVO>();
	
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String gcrn2nd2 = null;
	/* Column Info */
	private String gubun = null;
	/* Column Info */
	private String tot2nd = null;
	/* Column Info */
	private String rail1st2 = null;
	/* Column Info */
	private String fcrn1st2 = null;
	/* Column Info */
	private String manu1st2 = null;
	/* Column Info */
	private String bwin2nd2 = null;
	/* Column Info */
	private String gstr2nd2 = null;
	/* Column Info */
	private String gcrn1st2 = null;
	/* Column Info */
	private String tot1st = null;
	/* Column Info */
	private String bwin1st2 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rail2nd2 = null;
	/* Column Info */
	private String gstr1st2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String truc2nd2 = null;
	/* Column Info */
	private String fcrn2nd2 = null;
	/* Column Info */
	private String manu2nd2 = null;
	/* Column Info */
	private String truc1st2 = null;
	/* Column Info */
	private String nonw1st2 = null;
	/* Column Info */
	private String nonw2nd2 = null;
	/* Column Info */
	private String rhq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VosiUpdateMonitoringVO() {}

	public VosiUpdateMonitoringVO(String ibflag, String pagerows, String rhq, String port, String manu1st2, String manu2nd2, String nonw1st2, String nonw2nd2, String truc1st2, String truc2nd2, String rail1st2, String rail2nd2, String gcrn1st2, String gcrn2nd2, String fcrn1st2, String fcrn2nd2, String gstr1st2, String gstr2nd2, String bwin1st2, String bwin2nd2, String tot1st, String tot2nd, String gubun) {
		this.port = port;
		this.gcrn2nd2 = gcrn2nd2;
		this.gubun = gubun;
		this.tot2nd = tot2nd;
		this.rail1st2 = rail1st2;
		this.fcrn1st2 = fcrn1st2;
		this.manu1st2 = manu1st2;
		this.bwin2nd2 = bwin2nd2;
		this.gstr2nd2 = gstr2nd2;
		this.gcrn1st2 = gcrn1st2;
		this.tot1st = tot1st;
		this.bwin1st2 = bwin1st2;
		this.pagerows = pagerows;
		this.rail2nd2 = rail2nd2;
		this.gstr1st2 = gstr1st2;
		this.ibflag = ibflag;
		this.truc2nd2 = truc2nd2;
		this.fcrn2nd2 = fcrn2nd2;
		this.manu2nd2 = manu2nd2;
		this.truc1st2 = truc1st2;
		this.nonw1st2 = nonw1st2;
		this.nonw2nd2 = nonw2nd2;
		this.rhq = rhq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("gcrn_2nd2", getGcrn2nd2());
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("tot_2nd", getTot2nd());
		this.hashColumns.put("rail_1st2", getRail1st2());
		this.hashColumns.put("fcrn_1st2", getFcrn1st2());
		this.hashColumns.put("manu_1st2", getManu1st2());
		this.hashColumns.put("bwin_2nd2", getBwin2nd2());
		this.hashColumns.put("gstr_2nd2", getGstr2nd2());
		this.hashColumns.put("gcrn_1st2", getGcrn1st2());
		this.hashColumns.put("tot_1st", getTot1st());
		this.hashColumns.put("bwin_1st2", getBwin1st2());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rail_2nd2", getRail2nd2());
		this.hashColumns.put("gstr_1st2", getGstr1st2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("truc_2nd2", getTruc2nd2());
		this.hashColumns.put("fcrn_2nd2", getFcrn2nd2());
		this.hashColumns.put("manu_2nd2", getManu2nd2());
		this.hashColumns.put("truc_1st2", getTruc1st2());
		this.hashColumns.put("nonw_1st2", getNonw1st2());
		this.hashColumns.put("nonw_2nd2", getNonw2nd2());
		this.hashColumns.put("rhq", getRhq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("port", "port");
		this.hashFields.put("gcrn_2nd2", "gcrn2nd2");
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("tot_2nd", "tot2nd");
		this.hashFields.put("rail_1st2", "rail1st2");
		this.hashFields.put("fcrn_1st2", "fcrn1st2");
		this.hashFields.put("manu_1st2", "manu1st2");
		this.hashFields.put("bwin_2nd2", "bwin2nd2");
		this.hashFields.put("gstr_2nd2", "gstr2nd2");
		this.hashFields.put("gcrn_1st2", "gcrn1st2");
		this.hashFields.put("tot_1st", "tot1st");
		this.hashFields.put("bwin_1st2", "bwin1st2");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rail_2nd2", "rail2nd2");
		this.hashFields.put("gstr_1st2", "gstr1st2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("truc_2nd2", "truc2nd2");
		this.hashFields.put("fcrn_2nd2", "fcrn2nd2");
		this.hashFields.put("manu_2nd2", "manu2nd2");
		this.hashFields.put("truc_1st2", "truc1st2");
		this.hashFields.put("nonw_1st2", "nonw1st2");
		this.hashFields.put("nonw_2nd2", "nonw2nd2");
		this.hashFields.put("rhq", "rhq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return port
	 */
	public String getPort() {
		return this.port;
	}
	
	/**
	 * Column Info
	 * @return gcrn2nd2
	 */
	public String getGcrn2nd2() {
		return this.gcrn2nd2;
	}
	
	/**
	 * Column Info
	 * @return gubun
	 */
	public String getGubun() {
		return this.gubun;
	}
	
	/**
	 * Column Info
	 * @return tot2nd
	 */
	public String getTot2nd() {
		return this.tot2nd;
	}
	
	/**
	 * Column Info
	 * @return rail1st2
	 */
	public String getRail1st2() {
		return this.rail1st2;
	}
	
	/**
	 * Column Info
	 * @return fcrn1st2
	 */
	public String getFcrn1st2() {
		return this.fcrn1st2;
	}
	
	/**
	 * Column Info
	 * @return manu1st2
	 */
	public String getManu1st2() {
		return this.manu1st2;
	}
	
	/**
	 * Column Info
	 * @return bwin2nd2
	 */
	public String getBwin2nd2() {
		return this.bwin2nd2;
	}
	
	/**
	 * Column Info
	 * @return gstr2nd2
	 */
	public String getGstr2nd2() {
		return this.gstr2nd2;
	}
	
	/**
	 * Column Info
	 * @return gcrn1st2
	 */
	public String getGcrn1st2() {
		return this.gcrn1st2;
	}
	
	/**
	 * Column Info
	 * @return tot1st
	 */
	public String getTot1st() {
		return this.tot1st;
	}
	
	/**
	 * Column Info
	 * @return bwin1st2
	 */
	public String getBwin1st2() {
		return this.bwin1st2;
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
	 * @return rail2nd2
	 */
	public String getRail2nd2() {
		return this.rail2nd2;
	}
	
	/**
	 * Column Info
	 * @return gstr1st2
	 */
	public String getGstr1st2() {
		return this.gstr1st2;
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
	 * @return truc2nd2
	 */
	public String getTruc2nd2() {
		return this.truc2nd2;
	}
	
	/**
	 * Column Info
	 * @return fcrn2nd2
	 */
	public String getFcrn2nd2() {
		return this.fcrn2nd2;
	}
	
	/**
	 * Column Info
	 * @return manu2nd2
	 */
	public String getManu2nd2() {
		return this.manu2nd2;
	}
	
	/**
	 * Column Info
	 * @return truc1st2
	 */
	public String getTruc1st2() {
		return this.truc1st2;
	}
	
	/**
	 * Column Info
	 * @return nonw1st2
	 */
	public String getNonw1st2() {
		return this.nonw1st2;
	}
	
	/**
	 * Column Info
	 * @return nonw2nd2
	 */
	public String getNonw2nd2() {
		return this.nonw2nd2;
	}
	
	/**
	 * Column Info
	 * @return rhq
	 */
	public String getRhq() {
		return this.rhq;
	}
	

	/**
	 * Column Info
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Column Info
	 * @param gcrn2nd2
	 */
	public void setGcrn2nd2(String gcrn2nd2) {
		this.gcrn2nd2 = gcrn2nd2;
	}
	
	/**
	 * Column Info
	 * @param gubun
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	
	/**
	 * Column Info
	 * @param tot2nd
	 */
	public void setTot2nd(String tot2nd) {
		this.tot2nd = tot2nd;
	}
	
	/**
	 * Column Info
	 * @param rail1st2
	 */
	public void setRail1st2(String rail1st2) {
		this.rail1st2 = rail1st2;
	}
	
	/**
	 * Column Info
	 * @param fcrn1st2
	 */
	public void setFcrn1st2(String fcrn1st2) {
		this.fcrn1st2 = fcrn1st2;
	}
	
	/**
	 * Column Info
	 * @param manu1st2
	 */
	public void setManu1st2(String manu1st2) {
		this.manu1st2 = manu1st2;
	}
	
	/**
	 * Column Info
	 * @param bwin2nd2
	 */
	public void setBwin2nd2(String bwin2nd2) {
		this.bwin2nd2 = bwin2nd2;
	}
	
	/**
	 * Column Info
	 * @param gstr2nd2
	 */
	public void setGstr2nd2(String gstr2nd2) {
		this.gstr2nd2 = gstr2nd2;
	}
	
	/**
	 * Column Info
	 * @param gcrn1st2
	 */
	public void setGcrn1st2(String gcrn1st2) {
		this.gcrn1st2 = gcrn1st2;
	}
	
	/**
	 * Column Info
	 * @param tot1st
	 */
	public void setTot1st(String tot1st) {
		this.tot1st = tot1st;
	}
	
	/**
	 * Column Info
	 * @param bwin1st2
	 */
	public void setBwin1st2(String bwin1st2) {
		this.bwin1st2 = bwin1st2;
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
	 * @param rail2nd2
	 */
	public void setRail2nd2(String rail2nd2) {
		this.rail2nd2 = rail2nd2;
	}
	
	/**
	 * Column Info
	 * @param gstr1st2
	 */
	public void setGstr1st2(String gstr1st2) {
		this.gstr1st2 = gstr1st2;
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
	 * @param truc2nd2
	 */
	public void setTruc2nd2(String truc2nd2) {
		this.truc2nd2 = truc2nd2;
	}
	
	/**
	 * Column Info
	 * @param fcrn2nd2
	 */
	public void setFcrn2nd2(String fcrn2nd2) {
		this.fcrn2nd2 = fcrn2nd2;
	}
	
	/**
	 * Column Info
	 * @param manu2nd2
	 */
	public void setManu2nd2(String manu2nd2) {
		this.manu2nd2 = manu2nd2;
	}
	
	/**
	 * Column Info
	 * @param truc1st2
	 */
	public void setTruc1st2(String truc1st2) {
		this.truc1st2 = truc1st2;
	}
	
	/**
	 * Column Info
	 * @param nonw1st2
	 */
	public void setNonw1st2(String nonw1st2) {
		this.nonw1st2 = nonw1st2;
	}
	
	/**
	 * Column Info
	 * @param nonw2nd2
	 */
	public void setNonw2nd2(String nonw2nd2) {
		this.nonw2nd2 = nonw2nd2;
	}
	
	/**
	 * Column Info
	 * @param rhq
	 */
	public void setRhq(String rhq) {
		this.rhq = rhq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPort(JSPUtil.getParameter(request, "port", ""));
		setGcrn2nd2(JSPUtil.getParameter(request, "gcrn_2nd2", ""));
		setGubun(JSPUtil.getParameter(request, "gubun", ""));
		setTot2nd(JSPUtil.getParameter(request, "tot_2nd", ""));
		setRail1st2(JSPUtil.getParameter(request, "rail_1st2", ""));
		setFcrn1st2(JSPUtil.getParameter(request, "fcrn_1st2", ""));
		setManu1st2(JSPUtil.getParameter(request, "manu_1st2", ""));
		setBwin2nd2(JSPUtil.getParameter(request, "bwin_2nd2", ""));
		setGstr2nd2(JSPUtil.getParameter(request, "gstr_2nd2", ""));
		setGcrn1st2(JSPUtil.getParameter(request, "gcrn_1st2", ""));
		setTot1st(JSPUtil.getParameter(request, "tot_1st", ""));
		setBwin1st2(JSPUtil.getParameter(request, "bwin_1st2", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRail2nd2(JSPUtil.getParameter(request, "rail_2nd2", ""));
		setGstr1st2(JSPUtil.getParameter(request, "gstr_1st2", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTruc2nd2(JSPUtil.getParameter(request, "truc_2nd2", ""));
		setFcrn2nd2(JSPUtil.getParameter(request, "fcrn_2nd2", ""));
		setManu2nd2(JSPUtil.getParameter(request, "manu_2nd2", ""));
		setTruc1st2(JSPUtil.getParameter(request, "truc_1st2", ""));
		setNonw1st2(JSPUtil.getParameter(request, "nonw_1st2", ""));
		setNonw2nd2(JSPUtil.getParameter(request, "nonw_2nd2", ""));
		setRhq(JSPUtil.getParameter(request, "rhq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VosiUpdateMonitoringVO[]
	 */
	public VosiUpdateMonitoringVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VosiUpdateMonitoringVO[]
	 */
	public VosiUpdateMonitoringVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VosiUpdateMonitoringVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] gcrn2nd2 = (JSPUtil.getParameter(request, prefix	+ "gcrn_2nd2", length));
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun", length));
			String[] tot2nd = (JSPUtil.getParameter(request, prefix	+ "tot_2nd", length));
			String[] rail1st2 = (JSPUtil.getParameter(request, prefix	+ "rail_1st2", length));
			String[] fcrn1st2 = (JSPUtil.getParameter(request, prefix	+ "fcrn_1st2", length));
			String[] manu1st2 = (JSPUtil.getParameter(request, prefix	+ "manu_1st2", length));
			String[] bwin2nd2 = (JSPUtil.getParameter(request, prefix	+ "bwin_2nd2", length));
			String[] gstr2nd2 = (JSPUtil.getParameter(request, prefix	+ "gstr_2nd2", length));
			String[] gcrn1st2 = (JSPUtil.getParameter(request, prefix	+ "gcrn_1st2", length));
			String[] tot1st = (JSPUtil.getParameter(request, prefix	+ "tot_1st", length));
			String[] bwin1st2 = (JSPUtil.getParameter(request, prefix	+ "bwin_1st2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rail2nd2 = (JSPUtil.getParameter(request, prefix	+ "rail_2nd2", length));
			String[] gstr1st2 = (JSPUtil.getParameter(request, prefix	+ "gstr_1st2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] truc2nd2 = (JSPUtil.getParameter(request, prefix	+ "truc_2nd2", length));
			String[] fcrn2nd2 = (JSPUtil.getParameter(request, prefix	+ "fcrn_2nd2", length));
			String[] manu2nd2 = (JSPUtil.getParameter(request, prefix	+ "manu_2nd2", length));
			String[] truc1st2 = (JSPUtil.getParameter(request, prefix	+ "truc_1st2", length));
			String[] nonw1st2 = (JSPUtil.getParameter(request, prefix	+ "nonw_1st2", length));
			String[] nonw2nd2 = (JSPUtil.getParameter(request, prefix	+ "nonw_2nd2", length));
			String[] rhq = (JSPUtil.getParameter(request, prefix	+ "rhq", length));
			
			for (int i = 0; i < length; i++) {
				model = new VosiUpdateMonitoringVO();
				if (port[i] != null)
					model.setPort(port[i]);
				if (gcrn2nd2[i] != null)
					model.setGcrn2nd2(gcrn2nd2[i]);
				if (gubun[i] != null)
					model.setGubun(gubun[i]);
				if (tot2nd[i] != null)
					model.setTot2nd(tot2nd[i]);
				if (rail1st2[i] != null)
					model.setRail1st2(rail1st2[i]);
				if (fcrn1st2[i] != null)
					model.setFcrn1st2(fcrn1st2[i]);
				if (manu1st2[i] != null)
					model.setManu1st2(manu1st2[i]);
				if (bwin2nd2[i] != null)
					model.setBwin2nd2(bwin2nd2[i]);
				if (gstr2nd2[i] != null)
					model.setGstr2nd2(gstr2nd2[i]);
				if (gcrn1st2[i] != null)
					model.setGcrn1st2(gcrn1st2[i]);
				if (tot1st[i] != null)
					model.setTot1st(tot1st[i]);
				if (bwin1st2[i] != null)
					model.setBwin1st2(bwin1st2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rail2nd2[i] != null)
					model.setRail2nd2(rail2nd2[i]);
				if (gstr1st2[i] != null)
					model.setGstr1st2(gstr1st2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (truc2nd2[i] != null)
					model.setTruc2nd2(truc2nd2[i]);
				if (fcrn2nd2[i] != null)
					model.setFcrn2nd2(fcrn2nd2[i]);
				if (manu2nd2[i] != null)
					model.setManu2nd2(manu2nd2[i]);
				if (truc1st2[i] != null)
					model.setTruc1st2(truc1st2[i]);
				if (nonw1st2[i] != null)
					model.setNonw1st2(nonw1st2[i]);
				if (nonw2nd2[i] != null)
					model.setNonw2nd2(nonw2nd2[i]);
				if (rhq[i] != null)
					model.setRhq(rhq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVosiUpdateMonitoringVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VosiUpdateMonitoringVO[]
	 */
	public VosiUpdateMonitoringVO[] getVosiUpdateMonitoringVOs(){
		VosiUpdateMonitoringVO[] vos = (VosiUpdateMonitoringVO[])models.toArray(new VosiUpdateMonitoringVO[models.size()]);
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
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gcrn2nd2 = this.gcrn2nd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubun = this.gubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tot2nd = this.tot2nd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail1st2 = this.rail1st2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcrn1st2 = this.fcrn1st2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manu1st2 = this.manu1st2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bwin2nd2 = this.bwin2nd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gstr2nd2 = this.gstr2nd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gcrn1st2 = this.gcrn1st2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tot1st = this.tot1st .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bwin1st2 = this.bwin1st2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail2nd2 = this.rail2nd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gstr1st2 = this.gstr1st2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.truc2nd2 = this.truc2nd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcrn2nd2 = this.fcrn2nd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manu2nd2 = this.manu2nd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.truc1st2 = this.truc1st2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonw1st2 = this.nonw1st2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonw2nd2 = this.nonw2nd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhq = this.rhq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

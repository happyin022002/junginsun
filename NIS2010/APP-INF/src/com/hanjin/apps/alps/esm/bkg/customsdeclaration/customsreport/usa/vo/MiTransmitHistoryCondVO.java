/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MiTransmitHistoryCondVO.java
*@FileTitle : MiTransmitHistoryCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.05.28 김도완 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.AmsReportListCondVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김도완
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MiTransmitHistoryCondVO extends AmsReportListCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<MiTransmitHistoryCondVO> models = new ArrayList<MiTransmitHistoryCondVO>();
	
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String tod = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String gubun = null;
	/* Column Info */
	private String tot = null;
	/* Column Info */
	private String fromd = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String fromt = null;
	/* Column Info */
	private String pod = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MiTransmitHistoryCondVO() {}

	public MiTransmitHistoryCondVO(String ibflag, String pagerows, String fromd, String fromt, String tod, String tot, String vvd, String pol, String pod, String gubun) {
		this.vvd = vvd;
		this.tod = tod;
		this.ibflag = ibflag;
		this.gubun = gubun;
		this.tot = tot;
		this.fromd = fromd;
		this.pol = pol;
		this.fromt = fromt;
		this.pod = pod;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("tod", getTod());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("tot", getTot());
		this.hashColumns.put("fromd", getFromd());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("fromt", getFromt());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("tod", "tod");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("tot", "tot");
		this.hashFields.put("fromd", "fromd");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("fromt", "fromt");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return tod
	 */
	public String getTod() {
		return this.tod;
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
	 * @return gubun
	 */
	public String getGubun() {
		return this.gubun;
	}
	
	/**
	 * Column Info
	 * @return tot
	 */
	public String getTot() {
		return this.tot;
	}
	
	/**
	 * Column Info
	 * @return fromd
	 */
	public String getFromd() {
		return this.fromd;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}
	
	/**
	 * Column Info
	 * @return fromt
	 */
	public String getFromt() {
		return this.fromt;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param tod
	 */
	public void setTod(String tod) {
		this.tod = tod;
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
	 * @param gubun
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	
	/**
	 * Column Info
	 * @param tot
	 */
	public void setTot(String tot) {
		this.tot = tot;
	}
	
	/**
	 * Column Info
	 * @param fromd
	 */
	public void setFromd(String fromd) {
		this.fromd = fromd;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}
	
	/**
	 * Column Info
	 * @param fromt
	 */
	public void setFromt(String fromt) {
		this.fromt = fromt;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
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
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setTod(JSPUtil.getParameter(request, "tod", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGubun(JSPUtil.getParameter(request, "gubun", ""));
		setTot(JSPUtil.getParameter(request, "tot", ""));
		setFromd(JSPUtil.getParameter(request, "fromd", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setFromt(JSPUtil.getParameter(request, "fromt", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MiTransmitHistoryCondVO[]
	 */
	public MiTransmitHistoryCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MiTransmitHistoryCondVO[]
	 */
	public MiTransmitHistoryCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MiTransmitHistoryCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd".trim(), length));
			String[] tod = (JSPUtil.getParameter(request, prefix	+ "tod".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun".trim(), length));
			String[] tot = (JSPUtil.getParameter(request, prefix	+ "tot".trim(), length));
			String[] fromd = (JSPUtil.getParameter(request, prefix	+ "fromd".trim(), length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol".trim(), length));
			String[] fromt = (JSPUtil.getParameter(request, prefix	+ "fromt".trim(), length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new MiTransmitHistoryCondVO();
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (tod[i] != null)
					model.setTod(tod[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (gubun[i] != null)
					model.setGubun(gubun[i]);
				if (tot[i] != null)
					model.setTot(tot[i]);
				if (fromd[i] != null)
					model.setFromd(fromd[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (fromt[i] != null)
					model.setFromt(fromt[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMiTransmitHistoryCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MiTransmitHistoryCondVO[]
	 */
	public MiTransmitHistoryCondVO[] getMiTransmitHistoryCondVOs(){
		MiTransmitHistoryCondVO[] vos = (MiTransmitHistoryCondVO[])models.toArray(new MiTransmitHistoryCondVO[models.size()]);
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
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tod = this.tod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubun = this.gubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tot = this.tot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromd = this.fromd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromt = this.fromt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

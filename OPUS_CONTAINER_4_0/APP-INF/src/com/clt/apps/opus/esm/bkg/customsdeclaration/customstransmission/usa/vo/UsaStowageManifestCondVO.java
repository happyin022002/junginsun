/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaStowageManifestCondVO.java
*@FileTitle : UsaStowageManifestCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.08.12 김도완 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.StowageManifestCondVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김도완
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaStowageManifestCondVO extends StowageManifestCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaStowageManifestCondVO> models = new ArrayList<UsaStowageManifestCondVO>();
	
	/* Column Info */
	private String allerror = null;
	/* Column Info */
	private String cntropr = null;
	/* Column Info */
	private String excludeca = null;
	/* Column Info */
	private String pageno = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lastpol = null;
	/* Column Info */
	private String tmp2 = null;
	/* Column Info */
	private String tmp1 = null;
	/* Column Info */
	private String tmp4 = null;
	/* Column Info */
	private String tmp3 = null;
	/* Column Info */
	private String tmp5 = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String pod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaStowageManifestCondVO() {}

	public UsaStowageManifestCondVO(String ibflag, String pagerows, String vvd, String allerror, String lastpol, String pol, String pod, String cntropr, String excludeca, String pageno, String tmp1, String tmp2, String tmp3, String tmp4, String tmp5) {
		this.allerror = allerror;
		this.cntropr = cntropr;
		this.excludeca = excludeca;
		this.pageno = pageno;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.lastpol = lastpol;
		this.tmp2 = tmp2;
		this.tmp1 = tmp1;
		this.tmp4 = tmp4;
		this.tmp3 = tmp3;
		this.tmp5 = tmp5;
		this.pol = pol;
		this.pod = pod;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("allerror", getAllerror());
		this.hashColumns.put("cntropr", getCntropr());
		this.hashColumns.put("excludeca", getExcludeca());
		this.hashColumns.put("pageno", getPageno());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lastpol", getLastpol());
		this.hashColumns.put("tmp2", getTmp2());
		this.hashColumns.put("tmp1", getTmp1());
		this.hashColumns.put("tmp4", getTmp4());
		this.hashColumns.put("tmp3", getTmp3());
		this.hashColumns.put("tmp5", getTmp5());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("pod", getPod());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("allerror", "allerror");
		this.hashFields.put("cntropr", "cntropr");
		this.hashFields.put("excludeca", "excludeca");
		this.hashFields.put("pageno", "pageno");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lastpol", "lastpol");
		this.hashFields.put("tmp2", "tmp2");
		this.hashFields.put("tmp1", "tmp1");
		this.hashFields.put("tmp4", "tmp4");
		this.hashFields.put("tmp3", "tmp3");
		this.hashFields.put("tmp5", "tmp5");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("pod", "pod");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return allerror
	 */
	public String getAllerror() {
		return this.allerror;
	}
	
	/**
	 * Column Info
	 * @return cntropr
	 */
	public String getCntropr() {
		return this.cntropr;
	}
	
	/**
	 * Column Info
	 * @return excludeca
	 */
	public String getExcludeca() {
		return this.excludeca;
	}
	
	/**
	 * Column Info
	 * @return pageno
	 */
	public String getPageno() {
		return this.pageno;
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
	 * @return lastpol
	 */
	public String getLastpol() {
		return this.lastpol;
	}
	
	/**
	 * Column Info
	 * @return tmp2
	 */
	public String getTmp2() {
		return this.tmp2;
	}
	
	/**
	 * Column Info
	 * @return tmp1
	 */
	public String getTmp1() {
		return this.tmp1;
	}
	
	/**
	 * Column Info
	 * @return tmp4
	 */
	public String getTmp4() {
		return this.tmp4;
	}
	
	/**
	 * Column Info
	 * @return tmp3
	 */
	public String getTmp3() {
		return this.tmp3;
	}
	
	/**
	 * Column Info
	 * @return tmp5
	 */
	public String getTmp5() {
		return this.tmp5;
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
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	

	/**
	 * Column Info
	 * @param allerror
	 */
	public void setAllerror(String allerror) {
		this.allerror = allerror;
	}
	
	/**
	 * Column Info
	 * @param cntropr
	 */
	public void setCntropr(String cntropr) {
		this.cntropr = cntropr;
	}
	
	/**
	 * Column Info
	 * @param excludeca
	 */
	public void setExcludeca(String excludeca) {
		this.excludeca = excludeca;
	}
	
	/**
	 * Column Info
	 * @param pageno
	 */
	public void setPageno(String pageno) {
		this.pageno = pageno;
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
	 * @param lastpol
	 */
	public void setLastpol(String lastpol) {
		this.lastpol = lastpol;
	}
	
	/**
	 * Column Info
	 * @param tmp2
	 */
	public void setTmp2(String tmp2) {
		this.tmp2 = tmp2;
	}
	
	/**
	 * Column Info
	 * @param tmp1
	 */
	public void setTmp1(String tmp1) {
		this.tmp1 = tmp1;
	}
	
	/**
	 * Column Info
	 * @param tmp4
	 */
	public void setTmp4(String tmp4) {
		this.tmp4 = tmp4;
	}
	
	/**
	 * Column Info
	 * @param tmp3
	 */
	public void setTmp3(String tmp3) {
		this.tmp3 = tmp3;
	}
	
	/**
	 * Column Info
	 * @param tmp5
	 */
	public void setTmp5(String tmp5) {
		this.tmp5 = tmp5;
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
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAllerror(JSPUtil.getParameter(request, "allerror", ""));
		setCntropr(JSPUtil.getParameter(request, "cntropr", ""));
		setExcludeca(JSPUtil.getParameter(request, "excludeca", ""));
		setPageno(JSPUtil.getParameter(request, "pageno", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLastpol(JSPUtil.getParameter(request, "lastpol", ""));
		setTmp2(JSPUtil.getParameter(request, "tmp2", ""));
		setTmp1(JSPUtil.getParameter(request, "tmp1", ""));
		setTmp4(JSPUtil.getParameter(request, "tmp4", ""));
		setTmp3(JSPUtil.getParameter(request, "tmp3", ""));
		setTmp5(JSPUtil.getParameter(request, "tmp5", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaStowageManifestCondVO[]
	 */
	public UsaStowageManifestCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaStowageManifestCondVO[]
	 */
	public UsaStowageManifestCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaStowageManifestCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] allerror = (JSPUtil.getParameter(request, prefix	+ "allerror", length));
			String[] cntropr = (JSPUtil.getParameter(request, prefix	+ "cntropr", length));
			String[] excludeca = (JSPUtil.getParameter(request, prefix	+ "excludeca", length));
			String[] pageno = (JSPUtil.getParameter(request, prefix	+ "pageno", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lastpol = (JSPUtil.getParameter(request, prefix	+ "lastpol", length));
			String[] tmp2 = (JSPUtil.getParameter(request, prefix	+ "tmp2", length));
			String[] tmp1 = (JSPUtil.getParameter(request, prefix	+ "tmp1", length));
			String[] tmp4 = (JSPUtil.getParameter(request, prefix	+ "tmp4", length));
			String[] tmp3 = (JSPUtil.getParameter(request, prefix	+ "tmp3", length));
			String[] tmp5 = (JSPUtil.getParameter(request, prefix	+ "tmp5", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaStowageManifestCondVO();
				if (allerror[i] != null)
					model.setAllerror(allerror[i]);
				if (cntropr[i] != null)
					model.setCntropr(cntropr[i]);
				if (excludeca[i] != null)
					model.setExcludeca(excludeca[i]);
				if (pageno[i] != null)
					model.setPageno(pageno[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lastpol[i] != null)
					model.setLastpol(lastpol[i]);
				if (tmp2[i] != null)
					model.setTmp2(tmp2[i]);
				if (tmp1[i] != null)
					model.setTmp1(tmp1[i]);
				if (tmp4[i] != null)
					model.setTmp4(tmp4[i]);
				if (tmp3[i] != null)
					model.setTmp3(tmp3[i]);
				if (tmp5[i] != null)
					model.setTmp5(tmp5[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaStowageManifestCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaStowageManifestCondVO[]
	 */
	public UsaStowageManifestCondVO[] getUsaStowageManifestCondVOs(){
		UsaStowageManifestCondVO[] vos = (UsaStowageManifestCondVO[])models.toArray(new UsaStowageManifestCondVO[models.size()]);
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
		this.allerror = this.allerror .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntropr = this.cntropr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.excludeca = this.excludeca .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageno = this.pageno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastpol = this.lastpol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp2 = this.tmp2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp1 = this.tmp1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp4 = this.tmp4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp3 = this.tmp3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp5 = this.tmp5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

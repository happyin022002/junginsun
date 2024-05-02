/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RejectEdiVvdVO.java
*@FileTitle : RejectEdiVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.08.05 전용진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * @author 전용진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RejectEdiVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RejectEdiVvdVO> models = new ArrayList<RejectEdiVvdVO>();
	
	/* Column Info */
	private String vvdpodunlc = null;
	/* Column Info */
	private String vvdloyd = null;
	/* Column Info */
	private String vdpodname = null;
	/* Column Info */
	private String vvddir = null;
	/* Column Info */
	private String vvdpodeta = null;
	/* Column Info */
	private String ref1vvdvoy = null;
	/* Column Info */
	private String vvdpodname = null;
	/* Column Info */
	private String vvdvslCallSign = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvdvslname = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdvoy = null;
	/* Column Info */
	private String vvdpoleta = null;
	/* Column Info */
	private String vvdpolname = null;
	/* Column Info */
	private String vvdpoletd = null;
	/* Column Info */
	private String vvdpolunlc = null;
	/* Column Info */
	private String vvdcode = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RejectEdiVvdVO() {}

	public RejectEdiVvdVO(String ibflag, String pagerows, String vvdcode, String vvdloyd, String vvdvslname, String vvdvslCallSign, String vvdvoy, String vvddir, String vvdpolunlc, String vvdpolname, String vvdpodunlc, String vdpodname, String ref1vvdvoy, String vvdpodname, String vvdpoleta, String vvdpoletd, String vvdpodeta) {
		this.vvdpodunlc = vvdpodunlc;
		this.vvdloyd = vvdloyd;
		this.vdpodname = vdpodname;
		this.vvddir = vvddir;
		this.vvdpodeta = vvdpodeta;
		this.ref1vvdvoy = ref1vvdvoy;
		this.vvdpodname = vvdpodname;
		this.vvdvslCallSign = vvdvslCallSign;
		this.pagerows = pagerows;
		this.vvdvslname = vvdvslname;
		this.ibflag = ibflag;
		this.vvdvoy = vvdvoy;
		this.vvdpoleta = vvdpoleta;
		this.vvdpolname = vvdpolname;
		this.vvdpoletd = vvdpoletd;
		this.vvdpolunlc = vvdpolunlc;
		this.vvdcode = vvdcode;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vvdpodunlc", getVvdpodunlc());
		this.hashColumns.put("vvdloyd", getVvdloyd());
		this.hashColumns.put("vdpodname", getVdpodname());
		this.hashColumns.put("vvddir", getVvddir());
		this.hashColumns.put("vvdpodeta", getVvdpodeta());
		this.hashColumns.put("ref1vvdvoy", getRef1vvdvoy());
		this.hashColumns.put("vvdpodname", getVvdpodname());
		this.hashColumns.put("vvdvsl_call_sign", getVvdvslCallSign());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvdvslname", getVvdvslname());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvdvoy", getVvdvoy());
		this.hashColumns.put("vvdpoleta", getVvdpoleta());
		this.hashColumns.put("vvdpolname", getVvdpolname());
		this.hashColumns.put("vvdpoletd", getVvdpoletd());
		this.hashColumns.put("vvdpolunlc", getVvdpolunlc());
		this.hashColumns.put("vvdcode", getVvdcode());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vvdpodunlc", "vvdpodunlc");
		this.hashFields.put("vvdloyd", "vvdloyd");
		this.hashFields.put("vdpodname", "vdpodname");
		this.hashFields.put("vvddir", "vvddir");
		this.hashFields.put("vvdpodeta", "vvdpodeta");
		this.hashFields.put("ref1vvdvoy", "ref1vvdvoy");
		this.hashFields.put("vvdpodname", "vvdpodname");
		this.hashFields.put("vvdvsl_call_sign", "vvdvslCallSign");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvdvslname", "vvdvslname");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvdvoy", "vvdvoy");
		this.hashFields.put("vvdpoleta", "vvdpoleta");
		this.hashFields.put("vvdpolname", "vvdpolname");
		this.hashFields.put("vvdpoletd", "vvdpoletd");
		this.hashFields.put("vvdpolunlc", "vvdpolunlc");
		this.hashFields.put("vvdcode", "vvdcode");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vvdpodunlc
	 */
	public String getVvdpodunlc() {
		return this.vvdpodunlc;
	}
	
	/**
	 * Column Info
	 * @return vvdloyd
	 */
	public String getVvdloyd() {
		return this.vvdloyd;
	}
	
	/**
	 * Column Info
	 * @return vdpodname
	 */
	public String getVdpodname() {
		return this.vdpodname;
	}
	
	/**
	 * Column Info
	 * @return vvddir
	 */
	public String getVvddir() {
		return this.vvddir;
	}
	
	/**
	 * Column Info
	 * @return vvdpodeta
	 */
	public String getVvdpodeta() {
		return this.vvdpodeta;
	}
	
	/**
	 * Column Info
	 * @return ref1vvdvoy
	 */
	public String getRef1vvdvoy() {
		return this.ref1vvdvoy;
	}
	
	/**
	 * Column Info
	 * @return vvdpodname
	 */
	public String getVvdpodname() {
		return this.vvdpodname;
	}
	
	/**
	 * Column Info
	 * @return vvdvslCallSign
	 */
	public String getVvdvslCallSign() {
		return this.vvdvslCallSign;
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
	 * @return vvdvslname
	 */
	public String getVvdvslname() {
		return this.vvdvslname;
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
	 * @return vvdvoy
	 */
	public String getVvdvoy() {
		return this.vvdvoy;
	}
	
	/**
	 * Column Info
	 * @return vvdpoleta
	 */
	public String getVvdpoleta() {
		return this.vvdpoleta;
	}
	
	/**
	 * Column Info
	 * @return vvdpolname
	 */
	public String getVvdpolname() {
		return this.vvdpolname;
	}
	
	/**
	 * Column Info
	 * @return vvdpoletd
	 */
	public String getVvdpoletd() {
		return this.vvdpoletd;
	}
	
	/**
	 * Column Info
	 * @return vvdpolunlc
	 */
	public String getVvdpolunlc() {
		return this.vvdpolunlc;
	}
	
	/**
	 * Column Info
	 * @return vvdcode
	 */
	public String getVvdcode() {
		return this.vvdcode;
	}
	

	/**
	 * Column Info
	 * @param vvdpodunlc
	 */
	public void setVvdpodunlc(String vvdpodunlc) {
		this.vvdpodunlc = vvdpodunlc;
	}
	
	/**
	 * Column Info
	 * @param vvdloyd
	 */
	public void setVvdloyd(String vvdloyd) {
		this.vvdloyd = vvdloyd;
	}
	
	/**
	 * Column Info
	 * @param vdpodname
	 */
	public void setVdpodname(String vdpodname) {
		this.vdpodname = vdpodname;
	}
	
	/**
	 * Column Info
	 * @param vvddir
	 */
	public void setVvddir(String vvddir) {
		this.vvddir = vvddir;
	}
	
	/**
	 * Column Info
	 * @param vvdpodeta
	 */
	public void setVvdpodeta(String vvdpodeta) {
		this.vvdpodeta = vvdpodeta;
	}
	
	/**
	 * Column Info
	 * @param ref1vvdvoy
	 */
	public void setRef1vvdvoy(String ref1vvdvoy) {
		this.ref1vvdvoy = ref1vvdvoy;
	}
	
	/**
	 * Column Info
	 * @param vvdpodname
	 */
	public void setVvdpodname(String vvdpodname) {
		this.vvdpodname = vvdpodname;
	}
	
	/**
	 * Column Info
	 * @param vvdvslCallSign
	 */
	public void setVvdvslCallSign(String vvdvslCallSign) {
		this.vvdvslCallSign = vvdvslCallSign;
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
	 * @param vvdvslname
	 */
	public void setVvdvslname(String vvdvslname) {
		this.vvdvslname = vvdvslname;
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
	 * @param vvdvoy
	 */
	public void setVvdvoy(String vvdvoy) {
		this.vvdvoy = vvdvoy;
	}
	
	/**
	 * Column Info
	 * @param vvdpoleta
	 */
	public void setVvdpoleta(String vvdpoleta) {
		this.vvdpoleta = vvdpoleta;
	}
	
	/**
	 * Column Info
	 * @param vvdpolname
	 */
	public void setVvdpolname(String vvdpolname) {
		this.vvdpolname = vvdpolname;
	}
	
	/**
	 * Column Info
	 * @param vvdpoletd
	 */
	public void setVvdpoletd(String vvdpoletd) {
		this.vvdpoletd = vvdpoletd;
	}
	
	/**
	 * Column Info
	 * @param vvdpolunlc
	 */
	public void setVvdpolunlc(String vvdpolunlc) {
		this.vvdpolunlc = vvdpolunlc;
	}
	
	/**
	 * Column Info
	 * @param vvdcode
	 */
	public void setVvdcode(String vvdcode) {
		this.vvdcode = vvdcode;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVvdpodunlc(JSPUtil.getParameter(request, "vvdpodunlc", ""));
		setVvdloyd(JSPUtil.getParameter(request, "vvdloyd", ""));
		setVdpodname(JSPUtil.getParameter(request, "vdpodname", ""));
		setVvddir(JSPUtil.getParameter(request, "vvddir", ""));
		setVvdpodeta(JSPUtil.getParameter(request, "vvdpodeta", ""));
		setRef1vvdvoy(JSPUtil.getParameter(request, "ref1vvdvoy", ""));
		setVvdpodname(JSPUtil.getParameter(request, "vvdpodname", ""));
		setVvdvslCallSign(JSPUtil.getParameter(request, "vvdvsl_call_sign", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvdvslname(JSPUtil.getParameter(request, "vvdvslname", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVvdvoy(JSPUtil.getParameter(request, "vvdvoy", ""));
		setVvdpoleta(JSPUtil.getParameter(request, "vvdpoleta", ""));
		setVvdpolname(JSPUtil.getParameter(request, "vvdpolname", ""));
		setVvdpoletd(JSPUtil.getParameter(request, "vvdpoletd", ""));
		setVvdpolunlc(JSPUtil.getParameter(request, "vvdpolunlc", ""));
		setVvdcode(JSPUtil.getParameter(request, "vvdcode", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RejectEdiVvdVO[]
	 */
	public RejectEdiVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RejectEdiVvdVO[]
	 */
	public RejectEdiVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RejectEdiVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vvdpodunlc = (JSPUtil.getParameter(request, prefix	+ "vvdpodunlc", length));
			String[] vvdloyd = (JSPUtil.getParameter(request, prefix	+ "vvdloyd", length));
			String[] vdpodname = (JSPUtil.getParameter(request, prefix	+ "vdpodname", length));
			String[] vvddir = (JSPUtil.getParameter(request, prefix	+ "vvddir", length));
			String[] vvdpodeta = (JSPUtil.getParameter(request, prefix	+ "vvdpodeta", length));
			String[] ref1vvdvoy = (JSPUtil.getParameter(request, prefix	+ "ref1vvdvoy", length));
			String[] vvdpodname = (JSPUtil.getParameter(request, prefix	+ "vvdpodname", length));
			String[] vvdvslCallSign = (JSPUtil.getParameter(request, prefix	+ "vvdvsl_call_sign", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvdvslname = (JSPUtil.getParameter(request, prefix	+ "vvdvslname", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdvoy = (JSPUtil.getParameter(request, prefix	+ "vvdvoy", length));
			String[] vvdpoleta = (JSPUtil.getParameter(request, prefix	+ "vvdpoleta", length));
			String[] vvdpolname = (JSPUtil.getParameter(request, prefix	+ "vvdpolname", length));
			String[] vvdpoletd = (JSPUtil.getParameter(request, prefix	+ "vvdpoletd", length));
			String[] vvdpolunlc = (JSPUtil.getParameter(request, prefix	+ "vvdpolunlc", length));
			String[] vvdcode = (JSPUtil.getParameter(request, prefix	+ "vvdcode", length));
			
			for (int i = 0; i < length; i++) {
				model = new RejectEdiVvdVO();
				if (vvdpodunlc[i] != null)
					model.setVvdpodunlc(vvdpodunlc[i]);
				if (vvdloyd[i] != null)
					model.setVvdloyd(vvdloyd[i]);
				if (vdpodname[i] != null)
					model.setVdpodname(vdpodname[i]);
				if (vvddir[i] != null)
					model.setVvddir(vvddir[i]);
				if (vvdpodeta[i] != null)
					model.setVvdpodeta(vvdpodeta[i]);
				if (ref1vvdvoy[i] != null)
					model.setRef1vvdvoy(ref1vvdvoy[i]);
				if (vvdpodname[i] != null)
					model.setVvdpodname(vvdpodname[i]);
				if (vvdvslCallSign[i] != null)
					model.setVvdvslCallSign(vvdvslCallSign[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvdvslname[i] != null)
					model.setVvdvslname(vvdvslname[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdvoy[i] != null)
					model.setVvdvoy(vvdvoy[i]);
				if (vvdpoleta[i] != null)
					model.setVvdpoleta(vvdpoleta[i]);
				if (vvdpolname[i] != null)
					model.setVvdpolname(vvdpolname[i]);
				if (vvdpoletd[i] != null)
					model.setVvdpoletd(vvdpoletd[i]);
				if (vvdpolunlc[i] != null)
					model.setVvdpolunlc(vvdpolunlc[i]);
				if (vvdcode[i] != null)
					model.setVvdcode(vvdcode[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRejectEdiVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RejectEdiVvdVO[]
	 */
	public RejectEdiVvdVO[] getRejectEdiVvdVOs(){
		RejectEdiVvdVO[] vos = (RejectEdiVvdVO[])models.toArray(new RejectEdiVvdVO[models.size()]);
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
		this.vvdpodunlc = this.vvdpodunlc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdloyd = this.vvdloyd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vdpodname = this.vdpodname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvddir = this.vvddir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdpodeta = this.vvdpodeta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ref1vvdvoy = this.ref1vvdvoy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdpodname = this.vvdpodname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdvslCallSign = this.vvdvslCallSign .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdvslname = this.vvdvslname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdvoy = this.vvdvoy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdpoleta = this.vvdpoleta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdpolname = this.vvdpolname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdpoletd = this.vvdpoletd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdpolunlc = this.vvdpolunlc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdcode = this.vvdcode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

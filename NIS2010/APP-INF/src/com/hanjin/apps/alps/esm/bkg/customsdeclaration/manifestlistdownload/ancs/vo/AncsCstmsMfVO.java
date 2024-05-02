/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AncsCstmsMfVO.java
*@FileTitle : AncsCstmsMfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.06.02 정재엽 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정재엽
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AncsCstmsMfVO extends ManifestListDetailVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<AncsCstmsMfVO> models = new ArrayList<AncsCstmsMfVO>();
	
	/* Column Info */
	private String cntrDiff = null;
	/* Column Info */
	private String diff = null;
	/* Column Info */
	private String cntrDnld = null;
	/* Column Info */
	private String polAtd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntr = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrAcpt = null;
	/* Column Info */
	private String bl = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String bdr = null;
	/* Column Info */
	private String bdrDate = null;
	/* Column Info */
	private String dnld = null;
	/* Column Info */
	private String acpt = null;
	/* Column Info */
	private String pod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AncsCstmsMfVO() {}

	public AncsCstmsMfVO(String ibflag, String pagerows, String pol, String polAtd, String pod, String bdr, String bdrDate, String bl, String dnld, String acpt, String diff, String cntr, String cntrDnld, String cntrAcpt, String cntrDiff) {
		this.cntrDiff = cntrDiff;
		this.diff = diff;
		this.cntrDnld = cntrDnld;
		this.polAtd = polAtd;
		this.pagerows = pagerows;
		this.cntr = cntr;
		this.ibflag = ibflag;
		this.cntrAcpt = cntrAcpt;
		this.bl = bl;
		this.pol = pol;
		this.bdr = bdr;
		this.bdrDate = bdrDate;
		this.dnld = dnld;
		this.acpt = acpt;
		this.pod = pod;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_diff", getCntrDiff());
		this.hashColumns.put("diff", getDiff());
		this.hashColumns.put("cntr_dnld", getCntrDnld());
		this.hashColumns.put("pol_atd", getPolAtd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr", getCntr());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_acpt", getCntrAcpt());
		this.hashColumns.put("bl", getBl());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("bdr", getBdr());
		this.hashColumns.put("bdr_date", getBdrDate());
		this.hashColumns.put("dnld", getDnld());
		this.hashColumns.put("acpt", getAcpt());
		this.hashColumns.put("pod", getPod());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_diff", "cntrDiff");
		this.hashFields.put("diff", "diff");
		this.hashFields.put("cntr_dnld", "cntrDnld");
		this.hashFields.put("pol_atd", "polAtd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr", "cntr");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_acpt", "cntrAcpt");
		this.hashFields.put("bl", "bl");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("bdr", "bdr");
		this.hashFields.put("bdr_date", "bdrDate");
		this.hashFields.put("dnld", "dnld");
		this.hashFields.put("acpt", "acpt");
		this.hashFields.put("pod", "pod");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrDiff
	 */
	public String getCntrDiff() {
		return this.cntrDiff;
	}
	
	/**
	 * Column Info
	 * @return diff
	 */
	public String getDiff() {
		return this.diff;
	}
	
	/**
	 * Column Info
	 * @return cntrDnld
	 */
	public String getCntrDnld() {
		return this.cntrDnld;
	}
	
	/**
	 * Column Info
	 * @return polAtd
	 */
	public String getPolAtd() {
		return this.polAtd;
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
	 * @return cntr
	 */
	public String getCntr() {
		return this.cntr;
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
	 * @return cntrAcpt
	 */
	public String getCntrAcpt() {
		return this.cntrAcpt;
	}
	
	/**
	 * Column Info
	 * @return bl
	 */
	public String getBl() {
		return this.bl;
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
	 * @return bdr
	 */
	public String getBdr() {
		return this.bdr;
	}
	
	/**
	 * Column Info
	 * @return bdrDate
	 */
	public String getBdrDate() {
		return this.bdrDate;
	}
	
	/**
	 * Column Info
	 * @return dnld
	 */
	public String getDnld() {
		return this.dnld;
	}
	
	/**
	 * Column Info
	 * @return acpt
	 */
	public String getAcpt() {
		return this.acpt;
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
	 * @param cntrDiff
	 */
	public void setCntrDiff(String cntrDiff) {
		this.cntrDiff = cntrDiff;
	}
	
	/**
	 * Column Info
	 * @param diff
	 */
	public void setDiff(String diff) {
		this.diff = diff;
	}
	
	/**
	 * Column Info
	 * @param cntrDnld
	 */
	public void setCntrDnld(String cntrDnld) {
		this.cntrDnld = cntrDnld;
	}
	
	/**
	 * Column Info
	 * @param polAtd
	 */
	public void setPolAtd(String polAtd) {
		this.polAtd = polAtd;
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
	 * @param cntr
	 */
	public void setCntr(String cntr) {
		this.cntr = cntr;
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
	 * @param cntrAcpt
	 */
	public void setCntrAcpt(String cntrAcpt) {
		this.cntrAcpt = cntrAcpt;
	}
	
	/**
	 * Column Info
	 * @param bl
	 */
	public void setBl(String bl) {
		this.bl = bl;
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
	 * @param bdr
	 */
	public void setBdr(String bdr) {
		this.bdr = bdr;
	}
	
	/**
	 * Column Info
	 * @param bdrDate
	 */
	public void setBdrDate(String bdrDate) {
		this.bdrDate = bdrDate;
	}
	
	/**
	 * Column Info
	 * @param dnld
	 */
	public void setDnld(String dnld) {
		this.dnld = dnld;
	}
	
	/**
	 * Column Info
	 * @param acpt
	 */
	public void setAcpt(String acpt) {
		this.acpt = acpt;
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
		setCntrDiff(JSPUtil.getParameter(request, "cntr_diff", ""));
		setDiff(JSPUtil.getParameter(request, "diff", ""));
		setCntrDnld(JSPUtil.getParameter(request, "cntr_dnld", ""));
		setPolAtd(JSPUtil.getParameter(request, "pol_atd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCntr(JSPUtil.getParameter(request, "cntr", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrAcpt(JSPUtil.getParameter(request, "cntr_acpt", ""));
		setBl(JSPUtil.getParameter(request, "bl", ""));
		setPol(JSPUtil.getParameter(request, "pol", ""));
		setBdr(JSPUtil.getParameter(request, "bdr", ""));
		setBdrDate(JSPUtil.getParameter(request, "bdr_date", ""));
		setDnld(JSPUtil.getParameter(request, "dnld", ""));
		setAcpt(JSPUtil.getParameter(request, "acpt", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AncsCstmsMfVOVO[]
	 */
	public AncsCstmsMfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AncsCstmsMfVOVO[]
	 */
	public AncsCstmsMfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AncsCstmsMfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrDiff = (JSPUtil.getParameter(request, prefix	+ "cntr_diff".trim(), length));
			String[] diff = (JSPUtil.getParameter(request, prefix	+ "diff".trim(), length));
			String[] cntrDnld = (JSPUtil.getParameter(request, prefix	+ "cntr_dnld".trim(), length));
			String[] polAtd = (JSPUtil.getParameter(request, prefix	+ "pol_atd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] cntr = (JSPUtil.getParameter(request, prefix	+ "cntr".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] cntrAcpt = (JSPUtil.getParameter(request, prefix	+ "cntr_acpt".trim(), length));
			String[] bl = (JSPUtil.getParameter(request, prefix	+ "bl".trim(), length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol".trim(), length));
			String[] bdr = (JSPUtil.getParameter(request, prefix	+ "bdr".trim(), length));
			String[] bdrDate = (JSPUtil.getParameter(request, prefix	+ "bdr_date".trim(), length));
			String[] dnld = (JSPUtil.getParameter(request, prefix	+ "dnld".trim(), length));
			String[] acpt = (JSPUtil.getParameter(request, prefix	+ "acpt".trim(), length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new AncsCstmsMfVO();
				if (cntrDiff[i] != null)
					model.setCntrDiff(cntrDiff[i]);
				if (diff[i] != null)
					model.setDiff(diff[i]);
				if (cntrDnld[i] != null)
					model.setCntrDnld(cntrDnld[i]);
				if (polAtd[i] != null)
					model.setPolAtd(polAtd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntr[i] != null)
					model.setCntr(cntr[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrAcpt[i] != null)
					model.setCntrAcpt(cntrAcpt[i]);
				if (bl[i] != null)
					model.setBl(bl[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (bdr[i] != null)
					model.setBdr(bdr[i]);
				if (bdrDate[i] != null)
					model.setBdrDate(bdrDate[i]);
				if (dnld[i] != null)
					model.setDnld(dnld[i]);
				if (acpt[i] != null)
					model.setAcpt(acpt[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAncsCstmsMfVOVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AncsCstmsMfVOVO[]
	 */
	public AncsCstmsMfVO[] getAncsCstmsMfVOVOs(){
		AncsCstmsMfVO[] vos = (AncsCstmsMfVO[])models.toArray(new AncsCstmsMfVO[models.size()]);
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
		this.cntrDiff = this.cntrDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diff = this.diff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDnld = this.cntrDnld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polAtd = this.polAtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr = this.cntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrAcpt = this.cntrAcpt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bl = this.bl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdr = this.bdr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrDate = this.bdrDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dnld = this.dnld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acpt = this.acpt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

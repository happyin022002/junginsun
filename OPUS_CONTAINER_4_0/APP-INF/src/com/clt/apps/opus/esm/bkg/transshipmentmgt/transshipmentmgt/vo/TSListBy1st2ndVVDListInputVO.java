/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TSListBy1st2ndVVDListInputVO.java
*@FileTitle : TSListBy1st2ndVVDListInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.06.09 최영희 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo;

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
 * @author 최영희
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TSListBy1st2ndVVDListInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TSListBy1st2ndVVDListInputVO> models = new ArrayList<TSListBy1st2ndVVDListInputVO>();
	
	/* Column Info */
	private String durTo = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String durFrom = null;
	/* Column Info */
	private String faxmail = null;
	/* Column Info */
	private String discLoadCd = null;
	/* Column Info */
	private String searchKindCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String locYdCd = null;
	/* Column Info */
	private String opCd = null;
	/* Column Info */
	private String special = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TSListBy1st2ndVVDListInputVO() {}

	public TSListBy1st2ndVVDListInputVO(String ibflag, String pagerows, String locCd, String locYdCd, String vpsEtdDt, String vvd, String polCd, String podCd, String durFrom, String durTo, String opCd, String special, String faxmail, String searchKindCd, String discLoadCd) {
		this.durTo = durTo;
		this.vpsEtdDt = vpsEtdDt;
		this.durFrom = durFrom;
		this.faxmail = faxmail;
		this.discLoadCd = discLoadCd;
		this.searchKindCd = searchKindCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.polCd = polCd;
		this.locYdCd = locYdCd;
		this.opCd = opCd;
		this.special = special;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dur_to", getDurTo());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("dur_from", getDurFrom());
		this.hashColumns.put("faxmail", getFaxmail());
		this.hashColumns.put("disc_load_cd", getDiscLoadCd());
		this.hashColumns.put("search_kind_cd", getSearchKindCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("loc_yd_cd", getLocYdCd());
		this.hashColumns.put("op_cd", getOpCd());
		this.hashColumns.put("special", getSpecial());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dur_to", "durTo");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("dur_from", "durFrom");
		this.hashFields.put("faxmail", "faxmail");
		this.hashFields.put("disc_load_cd", "discLoadCd");
		this.hashFields.put("search_kind_cd", "searchKindCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("loc_yd_cd", "locYdCd");
		this.hashFields.put("op_cd", "opCd");
		this.hashFields.put("special", "special");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return durTo
	 */
	public String getDurTo() {
		return this.durTo;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return durFrom
	 */
	public String getDurFrom() {
		return this.durFrom;
	}
	
	/**
	 * Column Info
	 * @return faxmail
	 */
	public String getFaxmail() {
		return this.faxmail;
	}
	
	/**
	 * Column Info
	 * @return discLoadCd
	 */
	public String getDiscLoadCd() {
		return this.discLoadCd;
	}
	
	/**
	 * Column Info
	 * @return searchKindCd
	 */
	public String getSearchKindCd() {
		return this.searchKindCd;
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
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return locYdCd
	 */
	public String getLocYdCd() {
		return this.locYdCd;
	}
	
	/**
	 * Column Info
	 * @return opCd
	 */
	public String getOpCd() {
		return this.opCd;
	}
	
	/**
	 * Column Info
	 * @return special
	 */
	public String getSpecial() {
		return this.special;
	}
	

	/**
	 * Column Info
	 * @param durTo
	 */
	public void setDurTo(String durTo) {
		this.durTo = durTo;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param durFrom
	 */
	public void setDurFrom(String durFrom) {
		this.durFrom = durFrom;
	}
	
	/**
	 * Column Info
	 * @param faxmail
	 */
	public void setFaxmail(String faxmail) {
		this.faxmail = faxmail;
	}
	
	/**
	 * Column Info
	 * @param discLoadCd
	 */
	public void setDiscLoadCd(String discLoadCd) {
		this.discLoadCd = discLoadCd;
	}
	
	/**
	 * Column Info
	 * @param searchKindCd
	 */
	public void setSearchKindCd(String searchKindCd) {
		this.searchKindCd = searchKindCd;
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
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param locYdCd
	 */
	public void setLocYdCd(String locYdCd) {
		this.locYdCd = locYdCd;
	}
	
	/**
	 * Column Info
	 * @param opCd
	 */
	public void setOpCd(String opCd) {
		this.opCd = opCd;
	}
	
	/**
	 * Column Info
	 * @param special
	 */
	public void setSpecial(String special) {
		this.special = special;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDurTo(JSPUtil.getParameter(request, "dur_to", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, "vps_etd_dt", ""));
		setDurFrom(JSPUtil.getParameter(request, "dur_from", ""));
		setFaxmail(JSPUtil.getParameter(request, "faxmail", ""));
		setDiscLoadCd(JSPUtil.getParameter(request, "disc_load_cd", ""));
		setSearchKindCd(JSPUtil.getParameter(request, "search_kind_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setLocYdCd(JSPUtil.getParameter(request, "loc_yd_cd", ""));
		setOpCd(JSPUtil.getParameter(request, "op_cd", ""));
		setSpecial(JSPUtil.getParameter(request, "special", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TSListBy1st2ndVVDListInputVO[]
	 */
	public TSListBy1st2ndVVDListInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TSListBy1st2ndVVDListInputVO[]
	 */
	public TSListBy1st2ndVVDListInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TSListBy1st2ndVVDListInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] durTo = (JSPUtil.getParameter(request, prefix	+ "dur_to".trim(), length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt".trim(), length));
			String[] durFrom = (JSPUtil.getParameter(request, prefix	+ "dur_from".trim(), length));
			String[] faxmail = (JSPUtil.getParameter(request, prefix	+ "faxmail".trim(), length));
			String[] discLoadCd = (JSPUtil.getParameter(request, prefix	+ "disc_load_cd".trim(), length));
			String[] searchKindCd = (JSPUtil.getParameter(request, prefix	+ "search_kind_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd".trim(), length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd".trim(), length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd".trim(), length));
			String[] locYdCd = (JSPUtil.getParameter(request, prefix	+ "loc_yd_cd".trim(), length));
			String[] opCd = (JSPUtil.getParameter(request, prefix	+ "op_cd".trim(), length));
			String[] special = (JSPUtil.getParameter(request, prefix	+ "special".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new TSListBy1st2ndVVDListInputVO();
				if (durTo[i] != null)
					model.setDurTo(durTo[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (durFrom[i] != null)
					model.setDurFrom(durFrom[i]);
				if (faxmail[i] != null)
					model.setFaxmail(faxmail[i]);
				if (discLoadCd[i] != null)
					model.setDiscLoadCd(discLoadCd[i]);
				if (searchKindCd[i] != null)
					model.setSearchKindCd(searchKindCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (locYdCd[i] != null)
					model.setLocYdCd(locYdCd[i]);
				if (opCd[i] != null)
					model.setOpCd(opCd[i]);
				if (special[i] != null)
					model.setSpecial(special[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTSListBy1st2ndVVDListInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TSListBy1st2ndVVDListInputVO[]
	 */
	public TSListBy1st2ndVVDListInputVO[] getTSListBy1st2ndVVDListInputVOs(){
		TSListBy1st2ndVVDListInputVO[] vos = (TSListBy1st2ndVVDListInputVO[])models.toArray(new TSListBy1st2ndVVDListInputVO[models.size()]);
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
		this.durTo = this.durTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.durFrom = this.durFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxmail = this.faxmail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.discLoadCd = this.discLoadCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchKindCd = this.searchKindCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locYdCd = this.locYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCd = this.opCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.special = this.special .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

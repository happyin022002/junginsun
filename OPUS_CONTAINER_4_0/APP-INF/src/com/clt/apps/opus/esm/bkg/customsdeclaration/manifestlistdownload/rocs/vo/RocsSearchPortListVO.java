/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RocsSearchPortListVO.java
*@FileTitle : RocsSearchPortListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.06.10 임재택 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 임재택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RocsSearchPortListVO extends ManifestListVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<RocsSearchPortListVO> models = new ArrayList<RocsSearchPortListVO>();
	
	/* Column Info */
	private String inclCount = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String exclCount = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String trnkBdrFlg = null;
	/* Column Info */
	private String trnkAutoBdrDt = null;
	/* Column Info */
	private String pod = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RocsSearchPortListVO() {}

	public RocsSearchPortListVO(String ibflag, String pagerows, String vpsPortCd, String vpsEtdDt, String pod, String trnkBdrFlg, String trnkAutoBdrDt, String inclCount, String exclCount) {
		this.inclCount = inclCount;
		this.vpsPortCd = vpsPortCd;
		this.exclCount = exclCount;
		this.ibflag = ibflag;
		this.vpsEtdDt = vpsEtdDt;
		this.trnkBdrFlg = trnkBdrFlg;
		this.trnkAutoBdrDt = trnkAutoBdrDt;
		this.pod = pod;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("incl_count", getInclCount());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("excl_count", getExclCount());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("trnk_bdr_flg", getTrnkBdrFlg());
		this.hashColumns.put("trnk_auto_bdr_dt", getTrnkAutoBdrDt());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("incl_count", "inclCount");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("excl_count", "exclCount");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("trnk_bdr_flg", "trnkBdrFlg");
		this.hashFields.put("trnk_auto_bdr_dt", "trnkAutoBdrDt");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inclCount
	 */
	public String getInclCount() {
		return this.inclCount;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return exclCount
	 */
	public String getExclCount() {
		return this.exclCount;
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
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return trnkBdrFlg
	 */
	public String getTrnkBdrFlg() {
		return this.trnkBdrFlg;
	}
	
	/**
	 * Column Info
	 * @return trnkAutoBdrDt
	 */
	public String getTrnkAutoBdrDt() {
		return this.trnkAutoBdrDt;
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
	 * @param inclCount
	 */
	public void setInclCount(String inclCount) {
		this.inclCount = inclCount;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param exclCount
	 */
	public void setExclCount(String exclCount) {
		this.exclCount = exclCount;
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
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param trnkBdrFlg
	 */
	public void setTrnkBdrFlg(String trnkBdrFlg) {
		this.trnkBdrFlg = trnkBdrFlg;
	}
	
	/**
	 * Column Info
	 * @param trnkAutoBdrDt
	 */
	public void setTrnkAutoBdrDt(String trnkAutoBdrDt) {
		this.trnkAutoBdrDt = trnkAutoBdrDt;
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
		setInclCount(JSPUtil.getParameter(request, "incl_count", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setExclCount(JSPUtil.getParameter(request, "excl_count", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, "vps_etd_dt", ""));
		setTrnkBdrFlg(JSPUtil.getParameter(request, "trnk_bdr_flg", ""));
		setTrnkAutoBdrDt(JSPUtil.getParameter(request, "trnk_auto_bdr_dt", ""));
		setPod(JSPUtil.getParameter(request, "pod", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RocsSearchPortListVO[]
	 */
	public RocsSearchPortListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RocsSearchPortListVO[]
	 */
	public RocsSearchPortListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RocsSearchPortListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inclCount = (JSPUtil.getParameter(request, prefix	+ "incl_count".trim(), length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd".trim(), length));
			String[] exclCount = (JSPUtil.getParameter(request, prefix	+ "excl_count".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt".trim(), length));
			String[] trnkBdrFlg = (JSPUtil.getParameter(request, prefix	+ "trnk_bdr_flg".trim(), length));
			String[] trnkAutoBdrDt = (JSPUtil.getParameter(request, prefix	+ "trnk_auto_bdr_dt".trim(), length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new RocsSearchPortListVO();
				if (inclCount[i] != null)
					model.setInclCount(inclCount[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (exclCount[i] != null)
					model.setExclCount(exclCount[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (trnkBdrFlg[i] != null)
					model.setTrnkBdrFlg(trnkBdrFlg[i]);
				if (trnkAutoBdrDt[i] != null)
					model.setTrnkAutoBdrDt(trnkAutoBdrDt[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRocsSearchPortListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RocsSearchPortListVO[]
	 */
	public RocsSearchPortListVO[] getRocsSearchPortListVOs(){
		RocsSearchPortListVO[] vos = (RocsSearchPortListVO[])models.toArray(new RocsSearchPortListVO[models.size()]);
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
		this.inclCount = this.inclCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exclCount = this.exclCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkBdrFlg = this.trnkBdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkAutoBdrDt = this.trnkAutoBdrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

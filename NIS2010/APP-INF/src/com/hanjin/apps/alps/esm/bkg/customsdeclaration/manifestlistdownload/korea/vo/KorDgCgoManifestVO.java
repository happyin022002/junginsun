/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorDgCgoManifestVO.java
*@FileTitle : KorDgCgoManifestVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.08.26 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.DgCgoManifestVO;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박상훈
 * @since J2EE 1.6
 * @see DgCgoManifestVO
 */

public class KorDgCgoManifestVO extends DgCgoManifestVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorDgCgoManifestVO> models = new ArrayList<KorDgCgoManifestVO>();
	
	/* Column Info */
	private String currentCheck = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	
	private KorBkgDgCgoVO[] korBkgDgCgoVOs = null;
	private KorIbDgCgoVO[] korIbDgCgoVOs = null;
	private KorObDgCgoVO[] korObDgCgoVOs = null;
	private KorBkgDgVvdVO korBkgDgVvdVO = null;
	private KorDgVvdVO korDgVvdVO = null;
	private String userId = null;

	/**
	 * @return the korObDgCgoVOs
	 */
	public KorObDgCgoVO[] getKorObDgCgoVOs() {
		return korObDgCgoVOs;
	}

	/**
	 * @param korObDgCgoVOs the korObDgCgoVOs to set
	 */
	public void setKorObDgCgoVOs(KorObDgCgoVO[] korObDgCgoVOs) {
		this.korObDgCgoVOs = korObDgCgoVOs;
	}

	/**
	 * @return the korDgVvdVO
	 */
	public KorDgVvdVO getKorDgVvdVO() {
		return korDgVvdVO;
	}

	/**
	 * @param korDgVvdVO the korDgVvdVO to set
	 */
	public void setKorDgVvdVO(KorDgVvdVO korDgVvdVO) {
		this.korDgVvdVO = korDgVvdVO;
	}

	/**
	 * @return the korBkgDgVvdVO
	 */
	public KorBkgDgVvdVO getKorBkgDgVvdVO() {
		return korBkgDgVvdVO;
	}

	/**
	 * @param korBkgDgVvdVO the korBkgDgVvdVO to set
	 */
	public void setKorBkgDgVvdVO(KorBkgDgVvdVO korBkgDgVvdVO) {
		this.korBkgDgVvdVO = korBkgDgVvdVO;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the korBkgDgCgoVOs
	 */
	public KorBkgDgCgoVO[] getKorBkgDgCgoVOs() {
		return korBkgDgCgoVOs;
	}

	/**
	 * @param korBkgDgCgoVOs the korBkgDgCgoVOs to set
	 */
	public void setKorBkgDgCgoVOs(KorBkgDgCgoVO[] korBkgDgCgoVOs) {
		this.korBkgDgCgoVOs = korBkgDgCgoVOs;
	}

	/**
	 * @return the korIbDgCgoVOs
	 */
	public KorIbDgCgoVO[] getKorIbDgCgoVOs() {
		return korIbDgCgoVOs;
	}

	/**
	 * @param korIbDgCgoVOs the korIbDgCgoVOs to set
	 */
	public void setKorIbDgCgoVOs(KorIbDgCgoVO[] korIbDgCgoVOs) {
		this.korIbDgCgoVOs = korIbDgCgoVOs;
	}

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorDgCgoManifestVO() {}

	public KorDgCgoManifestVO(String ibflag, String pagerows, String vvd, String polCd, String podCd, String currentCheck) {
		this.currentCheck = currentCheck;
		this.podCd = podCd;
		this.vvd = vvd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("current_check", getCurrentCheck());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("current_check", "currentCheck");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return currentCheck
	 */
	public String getCurrentCheck() {
		return this.currentCheck;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @param currentCheck
	 */
	public void setCurrentCheck(String currentCheck) {
		this.currentCheck = currentCheck;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
		setCurrentCheck(JSPUtil.getParameter(request, "current_check", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorDgCgoManifestVO[]
	 */
	public KorDgCgoManifestVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorDgCgoManifestVO[]
	 */
	public KorDgCgoManifestVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorDgCgoManifestVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currentCheck = (JSPUtil.getParameter(request, prefix	+ "current_check", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorDgCgoManifestVO();
				if (currentCheck[i] != null)
					model.setCurrentCheck(currentCheck[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorDgCgoManifestVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorDgCgoManifestVO[]
	 */
	public KorDgCgoManifestVO[] getKorDgCgoManifestVOs(){
		KorDgCgoManifestVO[] vos = (KorDgCgoManifestVO[])models.toArray(new KorDgCgoManifestVO[models.size()]);
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
		this.currentCheck = this.currentCheck .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EstmPerformanceChangeStatusVO.java
*@FileTitle : EstmPerformanceChangeStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.10
*@LastModifier : 조병연
*@LastVersion : 1.0
* 2012.01.10 조병연 
* 1.0 Creation
* -------------------------------------------------------
* 2012.01.10 조병연[CHM-201215460-01]
* Title : [ALPS JOO] Estimate Performance Change Status I 신규개발 (2011년 12월 4차)
* 내용 :
* 매월 결산 후 "공동운항 선복 용/대선료 실적 현황" 보고 시, 전월 대상항차의 Estimate 변동 현황 분석을 위해 
* 첨부와 같이 신규개발을 요청 드립니다.
* (동일한 대상 기간의 추정실적 Data를 비교하여 변동 건을 포착/분석하는 기능)

* - 기대효과 1 : 기존의 Excel 수작업 업무를 시스템화함으로써 업무 편의성 및 효율성 제고
* - 기대효과 2 : Initial Estimate(ALPS BSA 모듈의 Data) 뿐 아니라 Adjusted Estimate
*   (ALPS JOO 모듈의 추정실적 생성 메뉴에서 User가 Manual로 조정한 Data)까지 자동으로 비교함으로써 변동 현황 
*   분석의 다각화 가능
*   
* 2012.02.10 조병연[CHM-201216005-01]
* Title : [ALPS JOO] Estimate Performance Change Status I 조회 범위 변경
* 내용 :
*	- 검색조건에 ‘Changed only’ 추가
*	- BSA 및 Slot Price 등이 변경되지 않은 건까지 모두 조회
=========================================================*/

package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo;

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
 * @author 박희동
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EstmPerformanceChangeStatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EstmPerformanceChangeStatusVO> models = new ArrayList<EstmPerformanceChangeStatusVO>();
	
	/* Column Info */
	private String exeYrmon = null;
	/* Column Info */
	private String revYrmon = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String joCrrCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String revYrmonFr = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String estmCondFlg = null;
	/* Column Info */
	private String reDivrCd = null;
	/* Column Info */
	private String diffOption = null;
	/* Column Info */
	private String joStlJbCd = null;
	/* Column Info */
	private String revYrmonTo = null;
	/* Column Info */
	private String estmOption = null;
	/* Column Info */
	private String changedOption = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EstmPerformanceChangeStatusVO() {}

	public EstmPerformanceChangeStatusVO(String ibflag, String pagerows, String exeYrmon, String revYrmon, String revYrmonFr, String revYrmonTo, String reDivrCd, String trdCd, String rlaneCd, String joCrrCd, String joStlJbCd, String diffOption, String vvd, String estmCondFlg, String estmOption, String changedOption) {
		this.exeYrmon = exeYrmon;
		this.revYrmon = revYrmon;
		this.trdCd = trdCd;
		this.joCrrCd = joCrrCd;
		this.rlaneCd = rlaneCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.revYrmonFr = revYrmonFr;
		this.ibflag = ibflag;
		this.estmCondFlg = estmCondFlg;
		this.reDivrCd = reDivrCd;
		this.diffOption = diffOption;
		this.joStlJbCd = joStlJbCd;
		this.revYrmonTo = revYrmonTo;
		this.estmOption = estmOption;
		this.changedOption = changedOption;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("exe_yrmon", getExeYrmon());
		this.hashColumns.put("rev_yrmon", getRevYrmon());

		this.hashColumns.put("rev_yrmon_fr", getRevYrmonFr());
		this.hashColumns.put("rev_yrmon_to", getRevYrmonTo());

		this.hashColumns.put("re_divr_cd", getReDivrCd());
		
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("jo_crr_cd", getJoCrrCd());

		this.hashColumns.put("vvd", getVvd());

		this.hashColumns.put("jo_stl_jb_cd", getJoStlJbCd());

		this.hashColumns.put("estm_option", getEstmOption());
		
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("estm_cond_flg", getEstmCondFlg());
		this.hashColumns.put("diff_option", getDiffOption());

		this.hashColumns.put("changed_option", getChangedOption());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("exe_yrmon", "exeYrmon");
		this.hashFields.put("rev_yrmon", "revYrmon");

		this.hashFields.put("rev_yrmon_fr", "revYrmonFr");
		this.hashFields.put("rev_yrmon_to", "revYrmonTo");

		this.hashFields.put("re_divr_cd", "reDivrCd");
		
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("jo_crr_cd", "joCrrCd");
		this.hashFields.put("rlane_cd", "rlaneCd");

		this.hashFields.put("vvd", "vvd");

		this.hashFields.put("jo_stl_jb_cd", "joStlJbCd");

		this.hashFields.put("estm_option", "estmOption");
		
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("estm_cond_flg", "estmCondFlg");
		this.hashFields.put("diff_option", "diffOption");

		this.hashFields.put("changed_option", "changedOption");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return exeYrmon
	 */
	public String getExeYrmon() {
		return this.exeYrmon;
	}

	/**
	 * Column Info
	 * @return revYrmon
	 */
	public String getRevYrmon() {
		return this.revYrmon;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return joCrrCd
	 */
	public String getJoCrrCd() {
		return this.joCrrCd;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
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
	 * @return revYrmonFr
	 */
	public String getRevYrmonFr() {
		return this.revYrmonFr;
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
	 * @return estmCondFlg
	 */
	public String getEstmCondFlg() {
		return this.estmCondFlg;
	}
	
	/**
	 * Column Info
	 * @return reDivrCd
	 */
	public String getReDivrCd() {
		return this.reDivrCd;
	}
	
	/**
	 * Column Info
	 * @return diffOption
	 */
	public String getDiffOption() {
		return this.diffOption;
	}
	
	/**
	 * Column Info
	 * @return joStlJbCd
	 */
	public String getJoStlJbCd() {
		return this.joStlJbCd;
	}
	
	/**
	 * Column Info
	 * @return revYrmonTo
	 */
	public String getRevYrmonTo() {
		return this.revYrmonTo;
	}

	/**
	 * Column Info
	 * @return estmOption
	 */
	public String getEstmOption() {
		return this.estmOption;
	}

	
	/**
	 * Column Info
	 * @return changedOption
	 */
	public String getChangedOption() {
		return this.changedOption;
	}
	

	/**
	 * Column Info
	 * @param exeYrmon
	 */
	public void setExeYrmon(String exeYrmon) {
		this.exeYrmon = exeYrmon;
	}

	/**
	 * Column Info
	 * @param revYrmon
	 */
	public void setRevYrmon(String revYrmon) {
		this.revYrmon = revYrmon;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param joCrrCd
	 */
	public void setJoCrrCd(String joCrrCd) {
		this.joCrrCd = joCrrCd;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param revYrmonFr
	 */
	public void setRevYrmonFr(String revYrmonFr) {
		this.revYrmonFr = revYrmonFr;
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
	 * @param estmCondFlg
	 */
	public void setEstmCondFlg(String estmCondFlg) {
		this.estmCondFlg = estmCondFlg;
	}
	
	/**
	 * Column Info
	 * @param reDivrCd
	 */
	public void setReDivrCd(String reDivrCd) {
		this.reDivrCd = reDivrCd;
	}
	
	/**
	 * Column Info
	 * @param diffOption
	 */
	public void setDiffOption(String diffOption) {
		this.diffOption = diffOption;
	}
	
	/**
	 * Column Info
	 * @param joStlJbCd
	 */
	public void setJoStlJbCd(String joStlJbCd) {
		this.joStlJbCd = joStlJbCd;
	}
	
	/**
	 * Column Info
	 * @param revYrmonTo
	 */
	public void setRevYrmonTo(String revYrmonTo) {
		this.revYrmonTo = revYrmonTo;
	}

	/**
	 * Column Info
	 * @param estmOption
	 */
	public void setEstmOption(String estmOption) {
		this.estmOption = estmOption;
	}

	/**
	 * Column Info
	 * @param changedOption
	 */
	public void setChangedOption(String changedOption) {
		this.changedOption = changedOption;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setExeYrmon(JSPUtil.getParameter(request, "exe_yrmon", ""));
		setRevYrmon(JSPUtil.getParameter(request, "rev_yrmon", ""));

		setRevYrmonFr(JSPUtil.getParameter(request, "rev_yrmon_fr", ""));
		setRevYrmonTo(JSPUtil.getParameter(request, "rev_yrmon_to", ""));

		setReDivrCd(JSPUtil.getParameter(request, "re_divr_cd", ""));
		
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setJoCrrCd(JSPUtil.getParameter(request, "jo_crr_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));

		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setJoStlJbCd(JSPUtil.getParameter(request, "jo_stl_jb_cd", ""));

		setEstmOption(JSPUtil.getParameter(request, "estm_option", ""));
		
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEstmCondFlg(JSPUtil.getParameter(request, "estm_cond_flg", ""));
		setDiffOption(JSPUtil.getParameter(request, "diff_option", ""));
		
		setChangedOption(JSPUtil.getParameter(request, "changed_option", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EstmConditionVO[]
	 */
	public EstmPerformanceChangeStatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EstmConditionVO[]
	 */
	public EstmPerformanceChangeStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EstmPerformanceChangeStatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] exeYrmon = (JSPUtil.getParameter(request, prefix	+ "exe_yrmon", length));
			String[] revYrmon = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon", length));
			
			String[] revYrmonFr = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon_fr", length));
			String[] revYrmonTo = (JSPUtil.getParameter(request, prefix	+ "rev_yrmon_to", length));

			String[] reDivrCd = (JSPUtil.getParameter(request, prefix	+ "re_divr_cd", length));

			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] joCrrCd = (JSPUtil.getParameter(request, prefix	+ "jo_crr_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));

			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] joStlJbCd = (JSPUtil.getParameter(request, prefix	+ "jo_stl_jb_cd", length));

			String[] estmOption = (JSPUtil.getParameter(request, prefix	+ "estm_option", length));
			
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] estmCondFlg = (JSPUtil.getParameter(request, prefix	+ "estm_cond_flg", length));
			String[] diffOption = (JSPUtil.getParameter(request, prefix	+ "diff_option", length));

			String[] changedOption = (JSPUtil.getParameter(request, prefix	+ "changed_option", length));
			
			for (int i = 0; i < length; i++) {
				model = new EstmPerformanceChangeStatusVO();
				if (exeYrmon[i] != null)
					model.setExeYrmon(exeYrmon[i]);
				if (revYrmon[i] != null)
					model.setRevYrmon(revYrmon[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (joCrrCd[i] != null)
					model.setJoCrrCd(joCrrCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (revYrmonFr[i] != null)
					model.setRevYrmonFr(revYrmonFr[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (estmCondFlg[i] != null)
					model.setEstmCondFlg(estmCondFlg[i]);
				if (reDivrCd[i] != null)
					model.setReDivrCd(reDivrCd[i]);
				if (diffOption[i] != null)
					model.setDiffOption(diffOption[i]);
				if (joStlJbCd[i] != null)
					model.setJoStlJbCd(joStlJbCd[i]);
				if (revYrmonTo[i] != null)
					model.setRevYrmonTo(revYrmonTo[i]);
				if (estmOption[i] != null)
					model.setEstmOption(estmOption[i]);
				if (changedOption[i] != null)
					model.setChangedOption(changedOption[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEstmPerformanceChangeStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EstmConditionVO[]
	 */
	public EstmPerformanceChangeStatusVO[] getEstmPerformanceChangeStatusVOs(){
		EstmPerformanceChangeStatusVO[] vos = (EstmPerformanceChangeStatusVO[])models.toArray(new EstmPerformanceChangeStatusVO[models.size()]);
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
		this.exeYrmon = this.exeYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon = this.revYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joCrrCd = this.joCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmonFr = this.revYrmonFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmCondFlg = this.estmCondFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reDivrCd = this.reDivrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffOption = this.diffOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joStlJbCd = this.joStlJbCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmonTo = this.revYrmonTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmOption = this.estmOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.changedOption = this.changedOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

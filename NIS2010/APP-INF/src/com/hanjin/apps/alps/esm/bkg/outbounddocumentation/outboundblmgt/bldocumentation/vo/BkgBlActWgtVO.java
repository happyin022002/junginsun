/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BkgBlActWgtVO.java
*@FileTitle : BkgBlActWgtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.19
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2011.07.19 조원주 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 조원주
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgBlActWgtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgBlActWgtVO> models = new ArrayList<BkgBlActWgtVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oldDelNodCd = null;
	/* Column Info */
	private String oldPodNodCd = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String actWgt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgBlActWgtVO() {}

	public BkgBlActWgtVO(String ibflag, String pagerows, String actWgt, String wgtUtCd, String oldPodNodCd, String oldDelNodCd) {
		this.ibflag = ibflag;
		this.oldDelNodCd = oldDelNodCd;
		this.oldPodNodCd = oldPodNodCd;
		this.wgtUtCd = wgtUtCd;
		this.actWgt = actWgt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("old_del_nod_cd", getOldDelNodCd());
		this.hashColumns.put("old_pod_nod_cd", getOldPodNodCd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("old_del_nod_cd", "oldDelNodCd");
		this.hashFields.put("old_pod_nod_cd", "oldPodNodCd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return oldDelNodCd
	 */
	public String getOldDelNodCd() {
		return this.oldDelNodCd;
	}
	
	/**
	 * Column Info
	 * @return oldPodNodCd
	 */
	public String getOldPodNodCd() {
		return this.oldPodNodCd;
	}
	
	/**
	 * Column Info
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @param oldDelNodCd
	 */
	public void setOldDelNodCd(String oldDelNodCd) {
		this.oldDelNodCd = oldDelNodCd;
	}
	
	/**
	 * Column Info
	 * @param oldPodNodCd
	 */
	public void setOldPodNodCd(String oldPodNodCd) {
		this.oldPodNodCd = oldPodNodCd;
	}
	
	/**
	 * Column Info
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOldDelNodCd(JSPUtil.getParameter(request, prefix + "old_del_nod_cd", ""));
		setOldPodNodCd(JSPUtil.getParameter(request, prefix + "old_pod_nod_cd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgBlActWgtVO[]
	 */
	public BkgBlActWgtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgBlActWgtVO[]
	 */
	public BkgBlActWgtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgBlActWgtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oldDelNodCd = (JSPUtil.getParameter(request, prefix	+ "old_del_nod_cd", length));
			String[] oldPodNodCd = (JSPUtil.getParameter(request, prefix	+ "old_pod_nod_cd", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgBlActWgtVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oldDelNodCd[i] != null)
					model.setOldDelNodCd(oldDelNodCd[i]);
				if (oldPodNodCd[i] != null)
					model.setOldPodNodCd(oldPodNodCd[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgBlActWgtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgBlActWgtVO[]
	 */
	public BkgBlActWgtVO[] getBkgBlActWgtVOs(){
		BkgBlActWgtVO[] vos = (BkgBlActWgtVO[])models.toArray(new BkgBlActWgtVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldDelNodCd = this.oldDelNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPodNodCd = this.oldPodNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

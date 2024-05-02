/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BkgQtyInfoVO.java
*@FileTitle : BkgQtyInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.01
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.08.01 김봉균 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo;

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
 * @author 김봉균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgQtyInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgQtyInfoVO> models = new ArrayList<BkgQtyInfoVO>();
	
	/* Column Info */
	private String feu = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rfeu = null;
	/* Column Info */
	private String rteu = null;
	/* Column Info */
	private String box = null;
	/* Column Info */
	private String teu = null;
	/* Column Info */
	private String rbox = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgQtyInfoVO() {}

	public BkgQtyInfoVO(String ibflag, String pagerows, String box, String teu, String feu, String rbox, String rteu, String rfeu) {
		this.feu = feu;
		this.ibflag = ibflag;
		this.rfeu = rfeu;
		this.rteu = rteu;
		this.box = box;
		this.teu = teu;
		this.rbox = rbox;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("feu", getFeu());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rfeu", getRfeu());
		this.hashColumns.put("rteu", getRteu());
		this.hashColumns.put("box", getBox());
		this.hashColumns.put("teu", getTeu());
		this.hashColumns.put("rbox", getRbox());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("feu", "feu");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rfeu", "rfeu");
		this.hashFields.put("rteu", "rteu");
		this.hashFields.put("box", "box");
		this.hashFields.put("teu", "teu");
		this.hashFields.put("rbox", "rbox");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return feu
	 */
	public String getFeu() {
		return this.feu;
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
	 * @return rfeu
	 */
	public String getRfeu() {
		return this.rfeu;
	}
	
	/**
	 * Column Info
	 * @return rteu
	 */
	public String getRteu() {
		return this.rteu;
	}
	
	/**
	 * Column Info
	 * @return box
	 */
	public String getBox() {
		return this.box;
	}
	
	/**
	 * Column Info
	 * @return teu
	 */
	public String getTeu() {
		return this.teu;
	}
	
	/**
	 * Column Info
	 * @return rbox
	 */
	public String getRbox() {
		return this.rbox;
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
	 * @param feu
	 */
	public void setFeu(String feu) {
		this.feu = feu;
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
	 * @param rfeu
	 */
	public void setRfeu(String rfeu) {
		this.rfeu = rfeu;
	}
	
	/**
	 * Column Info
	 * @param rteu
	 */
	public void setRteu(String rteu) {
		this.rteu = rteu;
	}
	
	/**
	 * Column Info
	 * @param box
	 */
	public void setBox(String box) {
		this.box = box;
	}
	
	/**
	 * Column Info
	 * @param teu
	 */
	public void setTeu(String teu) {
		this.teu = teu;
	}
	
	/**
	 * Column Info
	 * @param rbox
	 */
	public void setRbox(String rbox) {
		this.rbox = rbox;
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
		setFeu(JSPUtil.getParameter(request, prefix + "feu", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRfeu(JSPUtil.getParameter(request, prefix + "rfeu", ""));
		setRteu(JSPUtil.getParameter(request, prefix + "rteu", ""));
		setBox(JSPUtil.getParameter(request, prefix + "box", ""));
		setTeu(JSPUtil.getParameter(request, prefix + "teu", ""));
		setRbox(JSPUtil.getParameter(request, prefix + "rbox", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgQtyInfoVO[]
	 */
	public BkgQtyInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgQtyInfoVO[]
	 */
	public BkgQtyInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgQtyInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] feu = (JSPUtil.getParameter(request, prefix	+ "feu", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rfeu = (JSPUtil.getParameter(request, prefix	+ "rfeu", length));
			String[] rteu = (JSPUtil.getParameter(request, prefix	+ "rteu", length));
			String[] box = (JSPUtil.getParameter(request, prefix	+ "box", length));
			String[] teu = (JSPUtil.getParameter(request, prefix	+ "teu", length));
			String[] rbox = (JSPUtil.getParameter(request, prefix	+ "rbox", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgQtyInfoVO();
				if (feu[i] != null)
					model.setFeu(feu[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rfeu[i] != null)
					model.setRfeu(rfeu[i]);
				if (rteu[i] != null)
					model.setRteu(rteu[i]);
				if (box[i] != null)
					model.setBox(box[i]);
				if (teu[i] != null)
					model.setTeu(teu[i]);
				if (rbox[i] != null)
					model.setRbox(rbox[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgQtyInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgQtyInfoVO[]
	 */
	public BkgQtyInfoVO[] getBkgQtyInfoVOs(){
		BkgQtyInfoVO[] vos = (BkgQtyInfoVO[])models.toArray(new BkgQtyInfoVO[models.size()]);
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
		this.feu = this.feu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfeu = this.rfeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rteu = this.rteu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.box = this.box .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.teu = this.teu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rbox = this.rbox .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

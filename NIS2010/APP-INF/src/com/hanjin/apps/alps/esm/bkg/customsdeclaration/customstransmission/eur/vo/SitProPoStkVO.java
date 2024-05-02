/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SitProPoStkVO.java
*@FileTitle : SitProPoStkVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.10.12 경종윤 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo;

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
 * @author 경종윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SitProPoStkVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SitProPoStkVO> models = new ArrayList<SitProPoStkVO>();
	
	/* Column Info */
	private String postockpkg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String poseq = null;
	/* Column Info */
	private String pono = null;
	/* Column Info */
	private String postockcd = null;
	/* Column Info */
	private String postock = null;
	/* Column Info */
	private String pomea = null;
	/* Column Info */
	private String podesc = null;
	/* Column Info */
	private String powgt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SitProPoStkVO() {}

	public SitProPoStkVO(String ibflag, String pagerows, String pono, String poseq, String postock, String podesc, String postockcd, String postockpkg, String powgt, String pomea) {
		this.postockpkg = postockpkg;
		this.ibflag = ibflag;
		this.poseq = poseq;
		this.pono = pono;
		this.postockcd = postockcd;
		this.postock = postock;
		this.pomea = pomea;
		this.podesc = podesc;
		this.powgt = powgt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("postockpkg", getPostockpkg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("poseq", getPoseq());
		this.hashColumns.put("pono", getPono());
		this.hashColumns.put("postockcd", getPostockcd());
		this.hashColumns.put("postock", getPostock());
		this.hashColumns.put("pomea", getPomea());
		this.hashColumns.put("podesc", getPodesc());
		this.hashColumns.put("powgt", getPowgt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("postockpkg", "postockpkg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("poseq", "poseq");
		this.hashFields.put("pono", "pono");
		this.hashFields.put("postockcd", "postockcd");
		this.hashFields.put("postock", "postock");
		this.hashFields.put("pomea", "pomea");
		this.hashFields.put("podesc", "podesc");
		this.hashFields.put("powgt", "powgt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return postockpkg
	 */
	public String getPostockpkg() {
		return this.postockpkg;
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
	 * @return poseq
	 */
	public String getPoseq() {
		return this.poseq;
	}
	
	/**
	 * Column Info
	 * @return pono
	 */
	public String getPono() {
		return this.pono;
	}
	
	/**
	 * Column Info
	 * @return postockcd
	 */
	public String getPostockcd() {
		return this.postockcd;
	}
	
	/**
	 * Column Info
	 * @return postock
	 */
	public String getPostock() {
		return this.postock;
	}
	
	/**
	 * Column Info
	 * @return pomea
	 */
	public String getPomea() {
		return this.pomea;
	}
	
	/**
	 * Column Info
	 * @return podesc
	 */
	public String getPodesc() {
		return this.podesc;
	}
	
	/**
	 * Column Info
	 * @return powgt
	 */
	public String getPowgt() {
		return this.powgt;
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
	 * @param postockpkg
	 */
	public void setPostockpkg(String postockpkg) {
		this.postockpkg = postockpkg;
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
	 * @param poseq
	 */
	public void setPoseq(String poseq) {
		this.poseq = poseq;
	}
	
	/**
	 * Column Info
	 * @param pono
	 */
	public void setPono(String pono) {
		this.pono = pono;
	}
	
	/**
	 * Column Info
	 * @param postockcd
	 */
	public void setPostockcd(String postockcd) {
		this.postockcd = postockcd;
	}
	
	/**
	 * Column Info
	 * @param postock
	 */
	public void setPostock(String postock) {
		this.postock = postock;
	}
	
	/**
	 * Column Info
	 * @param pomea
	 */
	public void setPomea(String pomea) {
		this.pomea = pomea;
	}
	
	/**
	 * Column Info
	 * @param podesc
	 */
	public void setPodesc(String podesc) {
		this.podesc = podesc;
	}
	
	/**
	 * Column Info
	 * @param powgt
	 */
	public void setPowgt(String powgt) {
		this.powgt = powgt;
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
		setPostockpkg(JSPUtil.getParameter(request, "postockpkg", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPoseq(JSPUtil.getParameter(request, "poseq", ""));
		setPono(JSPUtil.getParameter(request, "pono", ""));
		setPostockcd(JSPUtil.getParameter(request, "postockcd", ""));
		setPostock(JSPUtil.getParameter(request, "postock", ""));
		setPomea(JSPUtil.getParameter(request, "pomea", ""));
		setPodesc(JSPUtil.getParameter(request, "podesc", ""));
		setPowgt(JSPUtil.getParameter(request, "powgt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SitProPoStkVO[]
	 */
	public SitProPoStkVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SitProPoStkVO[]
	 */
	public SitProPoStkVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SitProPoStkVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] postockpkg = (JSPUtil.getParameter(request, prefix	+ "postockpkg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] poseq = (JSPUtil.getParameter(request, prefix	+ "poseq", length));
			String[] pono = (JSPUtil.getParameter(request, prefix	+ "pono", length));
			String[] postockcd = (JSPUtil.getParameter(request, prefix	+ "postockcd", length));
			String[] postock = (JSPUtil.getParameter(request, prefix	+ "postock", length));
			String[] pomea = (JSPUtil.getParameter(request, prefix	+ "pomea", length));
			String[] podesc = (JSPUtil.getParameter(request, prefix	+ "podesc", length));
			String[] powgt = (JSPUtil.getParameter(request, prefix	+ "powgt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SitProPoStkVO();
				if (postockpkg[i] != null)
					model.setPostockpkg(postockpkg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (poseq[i] != null)
					model.setPoseq(poseq[i]);
				if (pono[i] != null)
					model.setPono(pono[i]);
				if (postockcd[i] != null)
					model.setPostockcd(postockcd[i]);
				if (postock[i] != null)
					model.setPostock(postock[i]);
				if (pomea[i] != null)
					model.setPomea(pomea[i]);
				if (podesc[i] != null)
					model.setPodesc(podesc[i]);
				if (powgt[i] != null)
					model.setPowgt(powgt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSitProPoStkVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SitProPoStkVO[]
	 */
	public SitProPoStkVO[] getSitProPoStkVOs(){
		SitProPoStkVO[] vos = (SitProPoStkVO[])models.toArray(new SitProPoStkVO[models.size()]);
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
		this.postockpkg = this.postockpkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poseq = this.poseq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pono = this.pono .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postockcd = this.postockcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postock = this.postock .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pomea = this.pomea .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podesc = this.podesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.powgt = this.powgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

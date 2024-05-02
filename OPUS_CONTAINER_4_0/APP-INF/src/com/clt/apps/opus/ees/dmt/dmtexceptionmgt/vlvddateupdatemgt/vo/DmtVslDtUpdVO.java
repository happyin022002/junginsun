/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DmtVslDtUpdVO.java
*@FileTitle : DmtVslDtUpdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : Kim Jae Jin
*@LastVersion : 1.0
* 2009.08.26 Kim Jae Jin 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.vlvddateupdatemgt.vo;

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
 * @author Kim Jae Jin
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DmtVslDtUpdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DmtVslDtUpdVO> models = new ArrayList<DmtVslDtUpdVO>();
	
	/* Column Info */
	private String eta = null;
	/* Column Info */
	private String vldaten = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String lastvl = null;
	/* Column Info */
	private String updatei = null;
	/* Column Info */
	private String updaten = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String updateo = null;
	/* Column Info */
	private String vvd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String updated = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String firstvl = null;
	/* Column Info */
	private String vldateb = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DmtVslDtUpdVO() {}

	public DmtVslDtUpdVO(String ibflag, String pagerows, String seq, String lane, String vvd, String eta, String etd, String firstvl, String lastvl, String vldaten, String vldateb, String updated, String updateo, String updatei, String updaten) {
		this.eta = eta;
		this.vldaten = vldaten;
		this.etd = etd;
		this.lastvl = lastvl;
		this.updatei = updatei;
		this.updaten = updaten;
		this.pagerows = pagerows;
		this.lane = lane;
		this.updateo = updateo;
		this.vvd = vvd;
		this.ibflag = ibflag;
		this.updated = updated;
		this.seq = seq;
		this.firstvl = firstvl;
		this.vldateb = vldateb;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("vldaten", getVldaten());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("lastvl", getLastvl());
		this.hashColumns.put("updatei", getUpdatei());
		this.hashColumns.put("updaten", getUpdaten());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("updateo", getUpdateo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("updated", getUpdated());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("firstvl", getFirstvl());
		this.hashColumns.put("vldateb", getVldateb());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eta", "eta");
		this.hashFields.put("vldaten", "vldaten");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("lastvl", "lastvl");
		this.hashFields.put("updatei", "updatei");
		this.hashFields.put("updaten", "updaten");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("updateo", "updateo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("updated", "updated");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("firstvl", "firstvl");
		this.hashFields.put("vldateb", "vldateb");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eta
	 */
	public String getEta() {
		return this.eta;
	}
	
	/**
	 * Column Info
	 * @return vldaten
	 */
	public String getVldaten() {
		return this.vldaten;
	}
	
	/**
	 * Column Info
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
	}
	
	/**
	 * Column Info
	 * @return lastvl
	 */
	public String getLastvl() {
		return this.lastvl;
	}
	
	/**
	 * Column Info
	 * @return updatei
	 */
	public String getUpdatei() {
		return this.updatei;
	}
	
	/**
	 * Column Info
	 * @return updaten
	 */
	public String getUpdaten() {
		return this.updaten;
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
	 * @return lane
	 */
	public String getLane() {
		return this.lane;
	}
	
	/**
	 * Column Info
	 * @return updateo
	 */
	public String getUpdateo() {
		return this.updateo;
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
	 * @return updated
	 */
	public String getUpdated() {
		return this.updated;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return firstvl
	 */
	public String getFirstvl() {
		return this.firstvl;
	}
	
	/**
	 * Column Info
	 * @return vldateb
	 */
	public String getVldateb() {
		return this.vldateb;
	}
	

	/**
	 * Column Info
	 * @param eta
	 */
	public void setEta(String eta) {
		this.eta = eta;
	}
	
	/**
	 * Column Info
	 * @param vldaten
	 */
	public void setVldaten(String vldaten) {
		this.vldaten = vldaten;
	}
	
	/**
	 * Column Info
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
	}
	
	/**
	 * Column Info
	 * @param lastvl
	 */
	public void setLastvl(String lastvl) {
		this.lastvl = lastvl;
	}
	
	/**
	 * Column Info
	 * @param updatei
	 */
	public void setUpdatei(String updatei) {
		this.updatei = updatei;
	}
	
	/**
	 * Column Info
	 * @param updaten
	 */
	public void setUpdaten(String updaten) {
		this.updaten = updaten;
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
	 * @param lane
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}
	
	/**
	 * Column Info
	 * @param updateo
	 */
	public void setUpdateo(String updateo) {
		this.updateo = updateo;
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
	 * @param updated
	 */
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param firstvl
	 */
	public void setFirstvl(String firstvl) {
		this.firstvl = firstvl;
	}
	
	/**
	 * Column Info
	 * @param vldateb
	 */
	public void setVldateb(String vldateb) {
		this.vldateb = vldateb;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEta(JSPUtil.getParameter(request, "eta", ""));
		setVldaten(JSPUtil.getParameter(request, "vldaten", ""));
		setEtd(JSPUtil.getParameter(request, "etd", ""));
		setLastvl(JSPUtil.getParameter(request, "lastvl", ""));
		setUpdatei(JSPUtil.getParameter(request, "updatei", ""));
		setUpdaten(JSPUtil.getParameter(request, "updaten", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setUpdateo(JSPUtil.getParameter(request, "updateo", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUpdated(JSPUtil.getParameter(request, "updated", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setFirstvl(JSPUtil.getParameter(request, "firstvl", ""));
		setVldateb(JSPUtil.getParameter(request, "vldateb", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DmtVslDtUpdVO[]
	 */
	public DmtVslDtUpdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DmtVslDtUpdVO[]
	 */
	public DmtVslDtUpdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DmtVslDtUpdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] vldaten = (JSPUtil.getParameter(request, prefix	+ "vldaten", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] lastvl = (JSPUtil.getParameter(request, prefix	+ "lastvl", length));
			String[] updatei = (JSPUtil.getParameter(request, prefix	+ "updatei", length));
			String[] updaten = (JSPUtil.getParameter(request, prefix	+ "updaten", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] updateo = (JSPUtil.getParameter(request, prefix	+ "updateo", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] updated = (JSPUtil.getParameter(request, prefix	+ "updated", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] firstvl = (JSPUtil.getParameter(request, prefix	+ "firstvl", length));
			String[] vldateb = (JSPUtil.getParameter(request, prefix	+ "vldateb", length));
			
			for (int i = 0; i < length; i++) {
				model = new DmtVslDtUpdVO();
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (vldaten[i] != null)
					model.setVldaten(vldaten[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (lastvl[i] != null)
					model.setLastvl(lastvl[i]);
				if (updatei[i] != null)
					model.setUpdatei(updatei[i]);
				if (updaten[i] != null)
					model.setUpdaten(updaten[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (updateo[i] != null)
					model.setUpdateo(updateo[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (updated[i] != null)
					model.setUpdated(updated[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (firstvl[i] != null)
					model.setFirstvl(firstvl[i]);
				if (vldateb[i] != null)
					model.setVldateb(vldateb[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDmtVslDtUpdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DmtVslDtUpdVO[]
	 */
	public DmtVslDtUpdVO[] getDmtVslDtUpdVOs(){
		DmtVslDtUpdVO[] vos = (DmtVslDtUpdVO[])models.toArray(new DmtVslDtUpdVO[models.size()]);
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
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vldaten = this.vldaten .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lastvl = this.lastvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updatei = this.updatei .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updaten = this.updaten .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updateo = this.updateo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updated = this.updated .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.firstvl = this.firstvl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vldateb = this.vldateb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

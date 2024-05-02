/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OfficeYardListVO.java
*@FileTitle : OfficeYardListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.10.13 문중철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecollectionreport.vo;

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
 * @author 문중철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OfficeYardListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OfficeYardListVO> models = new ArrayList<OfficeYardListVO>();
	
	/* Column Info */
	private String yardname = null;
	/* Column Info */
	private String marine = null;
	/* Column Info */
	private String barge = null;
	/* Column Info */
	private String dmtofc = null;
	/* Column Info */
	private String pseudo = null;
	/* Column Info */
	private String cy = null;
	/* Column Info */
	private String ctrlofc = null;
	/* Column Info */
	private String cfs = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String character = null;
	/* Column Info */
	private String ydcode = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ib = null;
	/* Column Info */
	private String ob = null;
	/* Column Info */
	private String rail = null;
	/* Column Info */
	private String del = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public OfficeYardListVO() {}

	public OfficeYardListVO(String ibflag, String pagerows, String dmtofc, String ib, String ob, String ydcode, String yardname, String del, String character, String marine, String cy, String cfs, String rail, String barge, String pseudo, String ctrlofc) {
		this.yardname = yardname;
		this.marine = marine;
		this.barge = barge;
		this.dmtofc = dmtofc;
		this.pseudo = pseudo;
		this.cy = cy;
		this.ctrlofc = ctrlofc;
		this.cfs = cfs;
		this.pagerows = pagerows;
		this.character = character;
		this.ydcode = ydcode;
		this.ibflag = ibflag;
		this.ib = ib;
		this.ob = ob;
		this.rail = rail;
		this.del = del;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("yardname", getYardname());
		this.hashColumns.put("marine", getMarine());
		this.hashColumns.put("barge", getBarge());
		this.hashColumns.put("dmtofc", getDmtofc());
		this.hashColumns.put("pseudo", getPseudo());
		this.hashColumns.put("cy", getCy());
		this.hashColumns.put("ctrlofc", getCtrlofc());
		this.hashColumns.put("cfs", getCfs());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("character", getCharacter());
		this.hashColumns.put("ydcode", getYdcode());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ib", getIb());
		this.hashColumns.put("ob", getOb());
		this.hashColumns.put("rail", getRail());
		this.hashColumns.put("del", getDel());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("yardname", "yardname");
		this.hashFields.put("marine", "marine");
		this.hashFields.put("barge", "barge");
		this.hashFields.put("dmtofc", "dmtofc");
		this.hashFields.put("pseudo", "pseudo");
		this.hashFields.put("cy", "cy");
		this.hashFields.put("ctrlofc", "ctrlofc");
		this.hashFields.put("cfs", "cfs");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("character", "character");
		this.hashFields.put("ydcode", "ydcode");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ib", "ib");
		this.hashFields.put("ob", "ob");
		this.hashFields.put("rail", "rail");
		this.hashFields.put("del", "del");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return yardname
	 */
	public String getYardname() {
		return this.yardname;
	}
	
	/**
	 * Column Info
	 * @return marine
	 */
	public String getMarine() {
		return this.marine;
	}
	
	/**
	 * Column Info
	 * @return barge
	 */
	public String getBarge() {
		return this.barge;
	}
	
	/**
	 * Column Info
	 * @return dmtofc
	 */
	public String getDmtofc() {
		return this.dmtofc;
	}
	
	/**
	 * Column Info
	 * @return pseudo
	 */
	public String getPseudo() {
		return this.pseudo;
	}
	
	/**
	 * Column Info
	 * @return cy
	 */
	public String getCy() {
		return this.cy;
	}
	
	/**
	 * Column Info
	 * @return ctrlofc
	 */
	public String getCtrlofc() {
		return this.ctrlofc;
	}
	
	/**
	 * Column Info
	 * @return cfs
	 */
	public String getCfs() {
		return this.cfs;
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
	 * @return character
	 */
	public String getCharacter() {
		return this.character;
	}
	
	/**
	 * Column Info
	 * @return ydcode
	 */
	public String getYdcode() {
		return this.ydcode;
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
	 * @return ib
	 */
	public String getIb() {
		return this.ib;
	}
	
	/**
	 * Column Info
	 * @return ob
	 */
	public String getOb() {
		return this.ob;
	}
	
	/**
	 * Column Info
	 * @return rail
	 */
	public String getRail() {
		return this.rail;
	}
	
	/**
	 * Column Info
	 * @return del
	 */
	public String getDel() {
		return this.del;
	}
	

	/**
	 * Column Info
	 * @param yardname
	 */
	public void setYardname(String yardname) {
		this.yardname = yardname;
	}
	
	/**
	 * Column Info
	 * @param marine
	 */
	public void setMarine(String marine) {
		this.marine = marine;
	}
	
	/**
	 * Column Info
	 * @param barge
	 */
	public void setBarge(String barge) {
		this.barge = barge;
	}
	
	/**
	 * Column Info
	 * @param dmtofc
	 */
	public void setDmtofc(String dmtofc) {
		this.dmtofc = dmtofc;
	}
	
	/**
	 * Column Info
	 * @param pseudo
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	/**
	 * Column Info
	 * @param cy
	 */
	public void setCy(String cy) {
		this.cy = cy;
	}
	
	/**
	 * Column Info
	 * @param ctrlofc
	 */
	public void setCtrlofc(String ctrlofc) {
		this.ctrlofc = ctrlofc;
	}
	
	/**
	 * Column Info
	 * @param cfs
	 */
	public void setCfs(String cfs) {
		this.cfs = cfs;
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
	 * @param character
	 */
	public void setCharacter(String character) {
		this.character = character;
	}
	
	/**
	 * Column Info
	 * @param ydcode
	 */
	public void setYdcode(String ydcode) {
		this.ydcode = ydcode;
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
	 * @param ib
	 */
	public void setIb(String ib) {
		this.ib = ib;
	}
	
	/**
	 * Column Info
	 * @param ob
	 */
	public void setOb(String ob) {
		this.ob = ob;
	}
	
	/**
	 * Column Info
	 * @param rail
	 */
	public void setRail(String rail) {
		this.rail = rail;
	}
	
	/**
	 * Column Info
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setYardname(JSPUtil.getParameter(request, "yardname", ""));
		setMarine(JSPUtil.getParameter(request, "marine", ""));
		setBarge(JSPUtil.getParameter(request, "barge", ""));
		setDmtofc(JSPUtil.getParameter(request, "dmtofc", ""));
		setPseudo(JSPUtil.getParameter(request, "pseudo", ""));
		setCy(JSPUtil.getParameter(request, "cy", ""));
		setCtrlofc(JSPUtil.getParameter(request, "ctrlofc", ""));
		setCfs(JSPUtil.getParameter(request, "cfs", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCharacter(JSPUtil.getParameter(request, "character", ""));
		setYdcode(JSPUtil.getParameter(request, "ydcode", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setIb(JSPUtil.getParameter(request, "ib", ""));
		setOb(JSPUtil.getParameter(request, "ob", ""));
		setRail(JSPUtil.getParameter(request, "rail", ""));
		setDel(JSPUtil.getParameter(request, "del", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OfficeYardListVO[]
	 */
	public OfficeYardListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OfficeYardListVO[]
	 */
	public OfficeYardListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OfficeYardListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] yardname = (JSPUtil.getParameter(request, prefix	+ "yardname", length));
			String[] marine = (JSPUtil.getParameter(request, prefix	+ "marine", length));
			String[] barge = (JSPUtil.getParameter(request, prefix	+ "barge", length));
			String[] dmtofc = (JSPUtil.getParameter(request, prefix	+ "dmtofc", length));
			String[] pseudo = (JSPUtil.getParameter(request, prefix	+ "pseudo", length));
			String[] cy = (JSPUtil.getParameter(request, prefix	+ "cy", length));
			String[] ctrlofc = (JSPUtil.getParameter(request, prefix	+ "ctrlofc", length));
			String[] cfs = (JSPUtil.getParameter(request, prefix	+ "cfs", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] character = (JSPUtil.getParameter(request, prefix	+ "character", length));
			String[] ydcode = (JSPUtil.getParameter(request, prefix	+ "ydcode", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ib = (JSPUtil.getParameter(request, prefix	+ "ib", length));
			String[] ob = (JSPUtil.getParameter(request, prefix	+ "ob", length));
			String[] rail = (JSPUtil.getParameter(request, prefix	+ "rail", length));
			String[] del = (JSPUtil.getParameter(request, prefix	+ "del", length));
			
			for (int i = 0; i < length; i++) {
				model = new OfficeYardListVO();
				if (yardname[i] != null)
					model.setYardname(yardname[i]);
				if (marine[i] != null)
					model.setMarine(marine[i]);
				if (barge[i] != null)
					model.setBarge(barge[i]);
				if (dmtofc[i] != null)
					model.setDmtofc(dmtofc[i]);
				if (pseudo[i] != null)
					model.setPseudo(pseudo[i]);
				if (cy[i] != null)
					model.setCy(cy[i]);
				if (ctrlofc[i] != null)
					model.setCtrlofc(ctrlofc[i]);
				if (cfs[i] != null)
					model.setCfs(cfs[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (character[i] != null)
					model.setCharacter(character[i]);
				if (ydcode[i] != null)
					model.setYdcode(ydcode[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ib[i] != null)
					model.setIb(ib[i]);
				if (ob[i] != null)
					model.setOb(ob[i]);
				if (rail[i] != null)
					model.setRail(rail[i]);
				if (del[i] != null)
					model.setDel(del[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOfficeYardListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OfficeYardListVO[]
	 */
	public OfficeYardListVO[] getOfficeYardListVOs(){
		OfficeYardListVO[] vos = (OfficeYardListVO[])models.toArray(new OfficeYardListVO[models.size()]);
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
		this.yardname = this.yardname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.marine = this.marine .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.barge = this.barge .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmtofc = this.dmtofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pseudo = this.pseudo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cy = this.cy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlofc = this.ctrlofc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfs = this.cfs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.character = this.character .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydcode = this.ydcode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ib = this.ib .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ob = this.ob .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rail = this.rail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del = this.del .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

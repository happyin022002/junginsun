/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : NoticeHistVO.java
*@FileTitle : NoticeHistVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.08.13 이남경 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

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
 * @author 이남경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class NoticeHistVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<NoticeHistVO> models = new ArrayList<NoticeHistVO>();
	
	/* Column Info */
	private String office = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String via = null;
	/* Column Info */
	private String item = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String toB = null;
	/* Column Info */
	private String toA = null;
	/* Column Info */
	private String frmA = null;
	/* Column Info */
	private String frmB = null;
	/* Column Info */
	private String kind = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public NoticeHistVO() {}

	public NoticeHistVO(String ibflag, String pagerows, String item, String frmA, String frmB, String toA, String toB, String via, String creDt, String creUsrId, String office, String kind) {
		this.office = office;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.via = via;
		this.item = item;
		this.creDt = creDt;
		this.toB = toB;
		this.toA = toA;
		this.frmA = frmA;
		this.frmB = frmB;
		this.pagerows = pagerows;
		this.kind = kind;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("office", getOffice());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("via", getVia());
		this.hashColumns.put("item", getItem());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("to_b", getToB());
		this.hashColumns.put("to_a", getToA());
		this.hashColumns.put("frm_a", getFrmA());
		this.hashColumns.put("frm_b", getFrmB());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("kind", getKind());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("office", "office");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("via", "via");
		this.hashFields.put("item", "item");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("to_b", "toB");
		this.hashFields.put("to_a", "toA");
		this.hashFields.put("frm_a", "frmA");
		this.hashFields.put("frm_b", "frmB");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("kind", "kind");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return office
	 */
	public String getOffice() {
		return this.office;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return via
	 */
	public String getVia() {
		return this.via;
	}
	
	/**
	 * Column Info
	 * @return item
	 */
	public String getItem() {
		return this.item;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return toB
	 */
	public String getToB() {
		return this.toB;
	}
	
	/**
	 * Column Info
	 * @return toA
	 */
	public String getToA() {
		return this.toA;
	}
	
	/**
	 * Column Info
	 * @return frmA
	 */
	public String getFrmA() {
		return this.frmA;
	}
	
	/**
	 * Column Info
	 * @return frmB
	 */
	public String getFrmB() {
		return this.frmB;
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
	 * @param office
	 */
	public void setOffice(String office) {
		this.office = office;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param via
	 */
	public void setVia(String via) {
		this.via = via;
	}
	
	/**
	 * Column Info
	 * @param item
	 */
	public void setItem(String item) {
		this.item = item;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param toB
	 */
	public void setToB(String toB) {
		this.toB = toB;
	}
	
	/**
	 * Column Info
	 * @param toA
	 */
	public void setToA(String toA) {
		this.toA = toA;
	}
	
	/**
	 * Column Info
	 * @param frmA
	 */
	public void setFrmA(String frmA) {
		this.frmA = frmA;
	}
	
	/**
	 * Column Info
	 * @param frmB
	 */
	public void setFrmB(String frmB) {
		this.frmB = frmB;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * @return the kind
	 */
	public String getKind() {
		return kind;
	}

	/**
	 * @param kind the kind to set
	 */
	public void setKind(String kind) {
		this.kind = kind;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setOffice(JSPUtil.getParameter(request, "office", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVia(JSPUtil.getParameter(request, "via", ""));
		setItem(JSPUtil.getParameter(request, "item", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setToB(JSPUtil.getParameter(request, "to_b", ""));
		setToA(JSPUtil.getParameter(request, "to_a", ""));
		setFrmA(JSPUtil.getParameter(request, "frm_a", ""));
		setFrmB(JSPUtil.getParameter(request, "frm_b", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setKind(JSPUtil.getParameter(request, "kind", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return NoticeHistVO[]
	 */
	public NoticeHistVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return NoticeHistVO[]
	 */
	public NoticeHistVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		NoticeHistVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] office = (JSPUtil.getParameter(request, prefix	+ "office", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] via = (JSPUtil.getParameter(request, prefix	+ "via", length));
			String[] item = (JSPUtil.getParameter(request, prefix	+ "item", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] toB = (JSPUtil.getParameter(request, prefix	+ "to_b", length));
			String[] toA = (JSPUtil.getParameter(request, prefix	+ "to_a", length));
			String[] frmA = (JSPUtil.getParameter(request, prefix	+ "frm_a", length));
			String[] frmB = (JSPUtil.getParameter(request, prefix	+ "frm_b", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] kind = (JSPUtil.getParameter(request, prefix   + "kind", length));
			
			for (int i = 0; i < length; i++) {
				model = new NoticeHistVO();
				if (office[i] != null)
					model.setOffice(office[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (via[i] != null)
					model.setVia(via[i]);
				if (item[i] != null)
					model.setItem(item[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (toB[i] != null)
					model.setToB(toB[i]);
				if (toA[i] != null)
					model.setToA(toA[i]);
				if (frmA[i] != null)
					model.setFrmA(frmA[i]);
				if (frmB[i] != null)
					model.setFrmB(frmB[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (kind[i] != null)
					model.setKind(kind[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getNoticeHistVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return NoticeHistVO[]
	 */
	public NoticeHistVO[] getNoticeHistVOs(){
		NoticeHistVO[] vos = (NoticeHistVO[])models.toArray(new NoticeHistVO[models.size()]);
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
		this.office = this.office .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.via = this.via .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.item = this.item .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toB = this.toB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toA = this.toA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmA = this.frmA .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmB = this.frmB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kind = this.kind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

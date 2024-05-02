/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CondDryDockScheduleVO.java
*@FileTitle : CondDryDockScheduleVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.05.04 윤세영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 윤세영
 * @since J2EE 1.5
 * @see ESM_FMS_0055HTMLAction
 */

public class CondDryDockScheduleVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CondDryDockScheduleVO> models = new ArrayList<CondDryDockScheduleVO>();
	
	/* Column Info */
	private String frDuration = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String ownrSeq = null;
	/* Column Info */
	private String toDuration = null;
	/* Column Info */
	private String vslDzndCapaFr = null;
	/* Column Info */
	private String vslDzndCapaTo = null;
	/* Column Info */
	private String fletCtrtTpCd = null;
	/* Column Info */
	private String reflectionCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String fletDckSveyTpCd = null;
	/* Column Info */
	private String ydSeq = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CondDryDockScheduleVO() {}

	public CondDryDockScheduleVO(String ibflag, String pagerows, String vslCd, String laneCd, String fletCtrtTpCd, String vslDzndCapaFr, String vslDzndCapaTo, String fletDckSveyTpCd, String toDuration, String frDuration, String ownrSeq, String reflectionCd, String ydSeq) {
		this.frDuration = frDuration;
		this.ibflag = ibflag;
		this.ownrSeq = ownrSeq;
		this.toDuration = toDuration;
		this.vslDzndCapaFr = vslDzndCapaFr;
		this.vslDzndCapaTo = vslDzndCapaTo;
		this.fletCtrtTpCd = fletCtrtTpCd;
		this.reflectionCd = reflectionCd;
		this.vslCd = vslCd;
		this.pagerows = pagerows;
		this.laneCd = laneCd;
		this.fletDckSveyTpCd = fletDckSveyTpCd;
		this.ydSeq = ydSeq;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fr_duration", getFrDuration());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ownr_seq", getOwnrSeq());
		this.hashColumns.put("to_duration", getToDuration());
		this.hashColumns.put("vsl_dznd_capa_fr", getVslDzndCapaFr());
		this.hashColumns.put("vsl_dznd_capa_to", getVslDzndCapaTo());
		this.hashColumns.put("flet_ctrt_tp_cd", getFletCtrtTpCd());
		this.hashColumns.put("reflection_cd", getReflectionCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("flet_dck_svey_tp_cd", getFletDckSveyTpCd());
		this.hashColumns.put("ydSeq", getYdSeq());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fr_duration", "frDuration");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ownr_seq", "ownrSeq");
		this.hashFields.put("to_duration", "toDuration");
		this.hashFields.put("vsl_dznd_capa_fr", "vslDzndCapaFr");
		this.hashFields.put("vsl_dznd_capa_to", "vslDzndCapaTo");
		this.hashFields.put("flet_ctrt_tp_cd", "fletCtrtTpCd");
		this.hashFields.put("reflection_cd", "reflectionCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("flet_dck_svey_tp_cd", "fletDckSveyTpCd");
		this.hashFields.put("ydSeq", "ydSeq");
		return this.hashFields;
	}
	
	public String getFrDuration() {
		return this.frDuration;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getOwnrSeq() {
		return this.ownrSeq;
	}
	public String getToDuration() {
		return this.toDuration;
	}
	public String getVslDzndCapaFr() {
		return this.vslDzndCapaFr;
	}
	public String getVslDzndCapaTo() {
		return this.vslDzndCapaTo;
	}
	public String getFletCtrtTpCd() {
		return this.fletCtrtTpCd;
	}
	public String getReflectionCd() {
		return this.reflectionCd;
	}
	public String getVslCd() {
		return this.vslCd;
	}
	public String getPagerows() {
		return this.pagerows;
	}
	public String getLaneCd() {
		return this.laneCd;
	}
	public String getFletDckSveyTpCd() {
		return this.fletDckSveyTpCd;
	}
	public String getYdSeq() {
		return this.ydSeq;
	}

	public void setFrDuration(String frDuration) {
		this.frDuration = frDuration;
		//this.frDuration=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setOwnrSeq(String ownrSeq) {
		this.ownrSeq = ownrSeq;
		//this.ownrSeq=true;
	}
	public void setToDuration(String toDuration) {
		this.toDuration = toDuration;
		//this.toDuration=true;
	}
	public void setVslDzndCapaFr(String vslDzndCapaFr) {
		this.vslDzndCapaFr = vslDzndCapaFr;
		//this.vslDzndCapaFr=true;
	}
	public void setVslDzndCapaTo(String vslDzndCapaTo) {
		this.vslDzndCapaTo = vslDzndCapaTo;
		//this.vslDzndCapaTo=true;
	}
	public void setFletCtrtTpCd(String fletCtrtTpCd) {
		this.fletCtrtTpCd = fletCtrtTpCd;
		//this.fletCtrtTpCd=true;
	}
	public void setReflectionCd(String reflectionCd) {
		this.reflectionCd = reflectionCd;
		//this.reflectionCd=true;
	}
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
		//this.vslCd=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
		//this.laneCd=true;
	}
	public void setFletDckSveyTpCd(String fletDckSveyTpCd) {
		this.fletDckSveyTpCd = fletDckSveyTpCd;
		//this.fletDckSveyTpCd=true;
	}
	public void setYdSeq(String ydSeq) {
		this.ydSeq = ydSeq;
		//this.ydSeq=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setFrDuration(JSPUtil.getParameter(request, "fr_duration", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOwnrSeq(JSPUtil.getParameter(request, "ownr_seq", ""));
		setToDuration(JSPUtil.getParameter(request, "to_duration", ""));
		setVslDzndCapaFr(JSPUtil.getParameter(request, "vsl_dznd_capa_fr", ""));
		setVslDzndCapaTo(JSPUtil.getParameter(request, "vsl_dznd_capa_to", ""));
		setFletCtrtTpCd(JSPUtil.getParameter(request, "flet_ctrt_tp_cd", ""));
		setReflectionCd(JSPUtil.getParameter(request, "reflection_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLaneCd(JSPUtil.getParameter(request, "lane_cd", ""));
		setFletDckSveyTpCd(JSPUtil.getParameter(request, "flet_dck_svey_tp_cd", ""));
		setYdSeq(JSPUtil.getParameter(request, "ydSeq", ""));
	}

	public CondDryDockScheduleVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CondDryDockScheduleVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CondDryDockScheduleVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] frDuration = (JSPUtil.getParameter(request, prefix	+ "fr_duration".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] ownrSeq = (JSPUtil.getParameter(request, prefix	+ "ownr_seq".trim(), length));
			String[] toDuration = (JSPUtil.getParameter(request, prefix	+ "to_duration".trim(), length));
			String[] vslDzndCapaFr = (JSPUtil.getParameter(request, prefix	+ "vsl_dznd_capa_fr".trim(), length));
			String[] vslDzndCapaTo = (JSPUtil.getParameter(request, prefix	+ "vsl_dznd_capa_to".trim(), length));
			String[] fletCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_ctrt_tp_cd".trim(), length));
			String[] reflectionCd = (JSPUtil.getParameter(request, prefix	+ "reflection_cd".trim(), length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd".trim(), length));
			String[] fletDckSveyTpCd = (JSPUtil.getParameter(request, prefix	+ "flet_dck_svey_tp_cd".trim(), length));
			String[] ydSeq = (JSPUtil.getParameter(request, prefix	+ "ydSeq".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CondDryDockScheduleVO();
				if (frDuration[i] != null)
					model.setFrDuration(frDuration[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ownrSeq[i] != null)
					model.setOwnrSeq(ownrSeq[i]);
				if (toDuration[i] != null)
					model.setToDuration(toDuration[i]);
				if (vslDzndCapaFr[i] != null)
					model.setVslDzndCapaFr(vslDzndCapaFr[i]);
				if (vslDzndCapaTo[i] != null)
					model.setVslDzndCapaTo(vslDzndCapaTo[i]);
				if (fletCtrtTpCd[i] != null)
					model.setFletCtrtTpCd(fletCtrtTpCd[i]);
				if (reflectionCd[i] != null)
					model.setReflectionCd(reflectionCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (fletDckSveyTpCd[i] != null)
					model.setFletDckSveyTpCd(fletDckSveyTpCd[i]);
				if (ydSeq[i] != null)
					model.setYdSeq(ydSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getCondDryDockScheduleVOs();
	}

	public CondDryDockScheduleVO[] getCondDryDockScheduleVOs(){
		CondDryDockScheduleVO[] vos = (CondDryDockScheduleVO[])models.toArray(new CondDryDockScheduleVO[models.size()]);
		return vos;
	}
	
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
		} catch (Exception ex) {}
		return ret.toString();
	}
	
	/**
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
	private String[] getField(Field[] field, int i) throws IllegalAccessException {
		String[] arr;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.frDuration = this.frDuration .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrSeq = this.ownrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDuration = this.toDuration .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDzndCapaFr = this.vslDzndCapaFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDzndCapaTo = this.vslDzndCapaTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtTpCd = this.fletCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reflectionCd = this.reflectionCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletDckSveyTpCd = this.fletDckSveyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydSeq = this.ydSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortLogHeadVO.java
*@FileTitle : PortLogHeadVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.16  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PortLogHeadVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PortLogHeadVO> models = new ArrayList<PortLogHeadVO>();
	
	/* Column Info */
	private String lostTime = null;
	/* Column Info */
	private String moveHandl = null;
	/* Column Info */
	private String tmnlNet = null;
	/* Column Info */
	private String grossWork = null;
	/* Column Info */
	private String tmnlGross = null;
	/* Column Info */
	private String avgCrane = null;
	/* Column Info */
	private String grossGang = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String netWork = null;
	/* Column Info */
	private String perGangGross = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String commence = null;
	/* Column Info */
	private String complete = null;
	/* Column Info */
	private String hatchHandl = null;
	/* Column Info */
	private String netGang = null;
	/* Column Info */
	private String gearHandl = null;
	/* Column Info */
	private String usedCrane = null;
	/* Column Info */
	private String perGanNet = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PortLogHeadVO() {}

	public PortLogHeadVO(String ibflag, String pagerows, String usedCrane, String avgCrane, String grossWork, String netWork, String lostTime, String grossGang, String netGang, String hatchHandl, String gearHandl, String moveHandl, String tmnlGross, String tmnlNet, String perGangGross, String perGanNet, String commence, String complete) {
		this.lostTime = lostTime;
		this.moveHandl = moveHandl;
		this.tmnlNet = tmnlNet;
		this.grossWork = grossWork;
		this.tmnlGross = tmnlGross;
		this.avgCrane = avgCrane;
		this.grossGang = grossGang;
		this.pagerows = pagerows;
		this.netWork = netWork;
		this.perGangGross = perGangGross;
		this.ibflag = ibflag;
		this.commence = commence;
		this.complete = complete;
		this.hatchHandl = hatchHandl;
		this.netGang = netGang;
		this.gearHandl = gearHandl;
		this.usedCrane = usedCrane;
		this.perGanNet = perGanNet;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lost_time", getLostTime());
		this.hashColumns.put("move_handl", getMoveHandl());
		this.hashColumns.put("tmnl_net", getTmnlNet());
		this.hashColumns.put("gross_work", getGrossWork());
		this.hashColumns.put("tmnl_gross", getTmnlGross());
		this.hashColumns.put("avg_crane", getAvgCrane());
		this.hashColumns.put("gross_gang", getGrossGang());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("net_work", getNetWork());
		this.hashColumns.put("per_gang_gross", getPerGangGross());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("commence", getCommence());
		this.hashColumns.put("complete", getComplete());
		this.hashColumns.put("hatch_handl", getHatchHandl());
		this.hashColumns.put("net_gang", getNetGang());
		this.hashColumns.put("gear_handl", getGearHandl());
		this.hashColumns.put("used_crane", getUsedCrane());
		this.hashColumns.put("per_gan_net", getPerGanNet());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lost_time", "lostTime");
		this.hashFields.put("move_handl", "moveHandl");
		this.hashFields.put("tmnl_net", "tmnlNet");
		this.hashFields.put("gross_work", "grossWork");
		this.hashFields.put("tmnl_gross", "tmnlGross");
		this.hashFields.put("avg_crane", "avgCrane");
		this.hashFields.put("gross_gang", "grossGang");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("net_work", "netWork");
		this.hashFields.put("per_gang_gross", "perGangGross");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("commence", "commence");
		this.hashFields.put("complete", "complete");
		this.hashFields.put("hatch_handl", "hatchHandl");
		this.hashFields.put("net_gang", "netGang");
		this.hashFields.put("gear_handl", "gearHandl");
		this.hashFields.put("used_crane", "usedCrane");
		this.hashFields.put("per_gan_net", "perGanNet");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return lostTime
	 */
	public String getLostTime() {
		return this.lostTime;
	}
	
	/**
	 * Column Info
	 * @return moveHandl
	 */
	public String getMoveHandl() {
		return this.moveHandl;
	}
	
	/**
	 * Column Info
	 * @return tmnlNet
	 */
	public String getTmnlNet() {
		return this.tmnlNet;
	}
	
	/**
	 * Column Info
	 * @return grossWork
	 */
	public String getGrossWork() {
		return this.grossWork;
	}
	
	/**
	 * Column Info
	 * @return tmnlGross
	 */
	public String getTmnlGross() {
		return this.tmnlGross;
	}
	
	/**
	 * Column Info
	 * @return avgCrane
	 */
	public String getAvgCrane() {
		return this.avgCrane;
	}
	
	/**
	 * Column Info
	 * @return grossGang
	 */
	public String getGrossGang() {
		return this.grossGang;
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
	 * @return netWork
	 */
	public String getNetWork() {
		return this.netWork;
	}
	
	/**
	 * Column Info
	 * @return perGangGross
	 */
	public String getPerGangGross() {
		return this.perGangGross;
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
	 * @return commence
	 */
	public String getCommence() {
		return this.commence;
	}
	
	/**
	 * Column Info
	 * @return complete
	 */
	public String getComplete() {
		return this.complete;
	}
	
	/**
	 * Column Info
	 * @return hatchHandl
	 */
	public String getHatchHandl() {
		return this.hatchHandl;
	}
	
	/**
	 * Column Info
	 * @return netGang
	 */
	public String getNetGang() {
		return this.netGang;
	}
	
	/**
	 * Column Info
	 * @return gearHandl
	 */
	public String getGearHandl() {
		return this.gearHandl;
	}
	
	/**
	 * Column Info
	 * @return usedCrane
	 */
	public String getUsedCrane() {
		return this.usedCrane;
	}
	
	/**
	 * Column Info
	 * @return perGanNet
	 */
	public String getPerGanNet() {
		return this.perGanNet;
	}
	

	/**
	 * Column Info
	 * @param lostTime
	 */
	public void setLostTime(String lostTime) {
		this.lostTime = lostTime;
	}
	
	/**
	 * Column Info
	 * @param moveHandl
	 */
	public void setMoveHandl(String moveHandl) {
		this.moveHandl = moveHandl;
	}
	
	/**
	 * Column Info
	 * @param tmnlNet
	 */
	public void setTmnlNet(String tmnlNet) {
		this.tmnlNet = tmnlNet;
	}
	
	/**
	 * Column Info
	 * @param grossWork
	 */
	public void setGrossWork(String grossWork) {
		this.grossWork = grossWork;
	}
	
	/**
	 * Column Info
	 * @param tmnlGross
	 */
	public void setTmnlGross(String tmnlGross) {
		this.tmnlGross = tmnlGross;
	}
	
	/**
	 * Column Info
	 * @param avgCrane
	 */
	public void setAvgCrane(String avgCrane) {
		this.avgCrane = avgCrane;
	}
	
	/**
	 * Column Info
	 * @param grossGang
	 */
	public void setGrossGang(String grossGang) {
		this.grossGang = grossGang;
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
	 * @param netWork
	 */
	public void setNetWork(String netWork) {
		this.netWork = netWork;
	}
	
	/**
	 * Column Info
	 * @param perGangGross
	 */
	public void setPerGangGross(String perGangGross) {
		this.perGangGross = perGangGross;
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
	 * @param commence
	 */
	public void setCommence(String commence) {
		this.commence = commence;
	}
	
	/**
	 * Column Info
	 * @param complete
	 */
	public void setComplete(String complete) {
		this.complete = complete;
	}
	
	/**
	 * Column Info
	 * @param hatchHandl
	 */
	public void setHatchHandl(String hatchHandl) {
		this.hatchHandl = hatchHandl;
	}
	
	/**
	 * Column Info
	 * @param netGang
	 */
	public void setNetGang(String netGang) {
		this.netGang = netGang;
	}
	
	/**
	 * Column Info
	 * @param gearHandl
	 */
	public void setGearHandl(String gearHandl) {
		this.gearHandl = gearHandl;
	}
	
	/**
	 * Column Info
	 * @param usedCrane
	 */
	public void setUsedCrane(String usedCrane) {
		this.usedCrane = usedCrane;
	}
	
	/**
	 * Column Info
	 * @param perGanNet
	 */
	public void setPerGanNet(String perGanNet) {
		this.perGanNet = perGanNet;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setLostTime(JSPUtil.getParameter(request, "lost_time", ""));
		setMoveHandl(JSPUtil.getParameter(request, "move_handl", ""));
		setTmnlNet(JSPUtil.getParameter(request, "tmnl_net", ""));
		setGrossWork(JSPUtil.getParameter(request, "gross_work", ""));
		setTmnlGross(JSPUtil.getParameter(request, "tmnl_gross", ""));
		setAvgCrane(JSPUtil.getParameter(request, "avg_crane", ""));
		setGrossGang(JSPUtil.getParameter(request, "gross_gang", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setNetWork(JSPUtil.getParameter(request, "net_work", ""));
		setPerGangGross(JSPUtil.getParameter(request, "per_gang_gross", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCommence(JSPUtil.getParameter(request, "commence", ""));
		setComplete(JSPUtil.getParameter(request, "complete", ""));
		setHatchHandl(JSPUtil.getParameter(request, "hatch_handl", ""));
		setNetGang(JSPUtil.getParameter(request, "net_gang", ""));
		setGearHandl(JSPUtil.getParameter(request, "gear_handl", ""));
		setUsedCrane(JSPUtil.getParameter(request, "used_crane", ""));
		setPerGanNet(JSPUtil.getParameter(request, "per_gan_net", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PortLogHeadVO[]
	 */
	public PortLogHeadVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PortLogHeadVO[]
	 */
	public PortLogHeadVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PortLogHeadVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lostTime = (JSPUtil.getParameter(request, prefix	+ "lost_time", length));
			String[] moveHandl = (JSPUtil.getParameter(request, prefix	+ "move_handl", length));
			String[] tmnlNet = (JSPUtil.getParameter(request, prefix	+ "tmnl_net", length));
			String[] grossWork = (JSPUtil.getParameter(request, prefix	+ "gross_work", length));
			String[] tmnlGross = (JSPUtil.getParameter(request, prefix	+ "tmnl_gross", length));
			String[] avgCrane = (JSPUtil.getParameter(request, prefix	+ "avg_crane", length));
			String[] grossGang = (JSPUtil.getParameter(request, prefix	+ "gross_gang", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] netWork = (JSPUtil.getParameter(request, prefix	+ "net_work", length));
			String[] perGangGross = (JSPUtil.getParameter(request, prefix	+ "per_gang_gross", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] commence = (JSPUtil.getParameter(request, prefix	+ "commence", length));
			String[] complete = (JSPUtil.getParameter(request, prefix	+ "complete", length));
			String[] hatchHandl = (JSPUtil.getParameter(request, prefix	+ "hatch_handl", length));
			String[] netGang = (JSPUtil.getParameter(request, prefix	+ "net_gang", length));
			String[] gearHandl = (JSPUtil.getParameter(request, prefix	+ "gear_handl", length));
			String[] usedCrane = (JSPUtil.getParameter(request, prefix	+ "used_crane", length));
			String[] perGanNet = (JSPUtil.getParameter(request, prefix	+ "per_gan_net", length));
			
			for (int i = 0; i < length; i++) {
				model = new PortLogHeadVO();
				if (lostTime[i] != null)
					model.setLostTime(lostTime[i]);
				if (moveHandl[i] != null)
					model.setMoveHandl(moveHandl[i]);
				if (tmnlNet[i] != null)
					model.setTmnlNet(tmnlNet[i]);
				if (grossWork[i] != null)
					model.setGrossWork(grossWork[i]);
				if (tmnlGross[i] != null)
					model.setTmnlGross(tmnlGross[i]);
				if (avgCrane[i] != null)
					model.setAvgCrane(avgCrane[i]);
				if (grossGang[i] != null)
					model.setGrossGang(grossGang[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (netWork[i] != null)
					model.setNetWork(netWork[i]);
				if (perGangGross[i] != null)
					model.setPerGangGross(perGangGross[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (commence[i] != null)
					model.setCommence(commence[i]);
				if (complete[i] != null)
					model.setComplete(complete[i]);
				if (hatchHandl[i] != null)
					model.setHatchHandl(hatchHandl[i]);
				if (netGang[i] != null)
					model.setNetGang(netGang[i]);
				if (gearHandl[i] != null)
					model.setGearHandl(gearHandl[i]);
				if (usedCrane[i] != null)
					model.setUsedCrane(usedCrane[i]);
				if (perGanNet[i] != null)
					model.setPerGanNet(perGanNet[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPortLogHeadVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PortLogHeadVO[]
	 */
	public PortLogHeadVO[] getPortLogHeadVOs(){
		PortLogHeadVO[] vos = (PortLogHeadVO[])models.toArray(new PortLogHeadVO[models.size()]);
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
		this.lostTime = this.lostTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.moveHandl = this.moveHandl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmnlNet = this.tmnlNet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grossWork = this.grossWork .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmnlGross = this.tmnlGross .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avgCrane = this.avgCrane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grossGang = this.grossGang .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWork = this.netWork .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perGangGross = this.perGangGross .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commence = this.commence .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.complete = this.complete .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hatchHandl = this.hatchHandl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netGang = this.netGang .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gearHandl = this.gearHandl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usedCrane = this.usedCrane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perGanNet = this.perGanNet .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

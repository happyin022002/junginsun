/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VLVDUpdateStatusVO.java
*@FileTitle : VLVDUpdateStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.09.25 우경민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo;

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
 * @author 우경민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class VLVDUpdateStatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<VLVDUpdateStatusVO> models = new ArrayList<VLVDUpdateStatusVO>();
	
	/* Column Info */
	private String port = null;
	/* Column Info */
	private String pStatus = null;
	/* Column Info */
	private String pVvd = null;
	/* Column Info */
	private String bkg2 = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String bkg1 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lane = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String edi2 = null;
	/* Column Info */
	private String pDate1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String result1 = null;
	/* Column Info */
	private String result2 = null;
	/* Column Info */
	private String man2 = null;
	/* Column Info */
	private String total1 = null;
	/* Column Info */
	private String pDate2 = null;
	/* Column Info */
	private String total2 = null;
	/* Column Info */
	private String pYard1 = null;
	/* Column Info */
	private String pYard2 = null;
	/* Column Info */
	private String pVslSvcTpCd = null;
	/* Column Info */
	private String man1 = null;
	/* Column Info */
	private String edi1 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public VLVDUpdateStatusVO() {}

	public VLVDUpdateStatusVO(String ibflag, String pagerows, String vvd, String lane, String etd, String port, String bkg1, String edi1, String man1, String total1, String result1, String bkg2, String edi2, String man2, String total2, String result2, String pDate1, String pDate2, String pVvd, String pVslSvcTpCd, String pYard1, String pStatus, String pYard2) {
		this.port = port;
		this.pStatus = pStatus;
		this.pVvd = pVvd;
		this.bkg2 = bkg2;
		this.etd = etd;
		this.bkg1 = bkg1;
		this.pagerows = pagerows;
		this.lane = lane;
		this.vvd = vvd;
		this.edi2 = edi2;
		this.pDate1 = pDate1;
		this.ibflag = ibflag;
		this.result1 = result1;
		this.result2 = result2;
		this.man2 = man2;
		this.total1 = total1;
		this.pDate2 = pDate2;
		this.total2 = total2;
		this.pYard1 = pYard1;
		this.pVslSvcTpCd = pVslSvcTpCd;
		this.man1 = man1;
		this.edi1 = edi1;
		this.pYard2 = pYard2;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("port", getPort());
		this.hashColumns.put("p_status", getPStatus());
		this.hashColumns.put("p_vvd", getPVvd());
		this.hashColumns.put("bkg2", getBkg2());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("bkg1", getBkg1());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("lane", getLane());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("edi2", getEdi2());
		this.hashColumns.put("p_date1", getPDate1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("result1", getResult1());
		this.hashColumns.put("result2", getResult2());
		this.hashColumns.put("man2", getMan2());
		this.hashColumns.put("total1", getTotal1());
		this.hashColumns.put("p_date2", getPDate2());
		this.hashColumns.put("total2", getTotal2());
		this.hashColumns.put("p_yard1", getPYard1());
		this.hashColumns.put("p_vsl_svc_tp_cd", getPVslSvcTpCd());
		this.hashColumns.put("man1", getMan1());
		this.hashColumns.put("edi1", getEdi1());
		this.hashColumns.put("p_yard2", getPYard2());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("port", "port");
		this.hashFields.put("p_status", "pStatus");
		this.hashFields.put("p_vvd", "pVvd");
		this.hashFields.put("bkg2", "bkg2");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("bkg1", "bkg1");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("edi2", "edi2");
		this.hashFields.put("p_date1", "pDate1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("result1", "result1");
		this.hashFields.put("result2", "result2");
		this.hashFields.put("man2", "man2");
		this.hashFields.put("total1", "total1");
		this.hashFields.put("p_date2", "pDate2");
		this.hashFields.put("total2", "total2");
		this.hashFields.put("p_yard1", "pYard1");
		this.hashFields.put("p_vsl_svc_tp_cd", "pVslSvcTpCd");
		this.hashFields.put("man1", "man1");
		this.hashFields.put("edi1", "edi1");
		this.hashFields.put("p_yard2", "pYard2");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return port
	 */
	public String getPort() {
		return this.port;
	}
	
	/**
	 * Column Info
	 * @return pStatus
	 */
	public String getPStatus() {
		return this.pStatus;
	}
	
	/**
	 * Column Info
	 * @return pVvd
	 */
	public String getPVvd() {
		return this.pVvd;
	}
	
	/**
	 * Column Info
	 * @return bkg2
	 */
	public String getBkg2() {
		return this.bkg2;
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
	 * @return bkg1
	 */
	public String getBkg1() {
		return this.bkg1;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return edi2
	 */
	public String getEdi2() {
		return this.edi2;
	}
	
	/**
	 * Column Info
	 * @return pDate1
	 */
	public String getPDate1() {
		return this.pDate1;
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
	 * @return result1
	 */
	public String getResult1() {
		return this.result1;
	}
	
	/**
	 * Column Info
	 * @return result2
	 */
	public String getResult2() {
		return this.result2;
	}
	
	/**
	 * Column Info
	 * @return man2
	 */
	public String getMan2() {
		return this.man2;
	}
	
	/**
	 * Column Info
	 * @return total1
	 */
	public String getTotal1() {
		return this.total1;
	}
	
	/**
	 * Column Info
	 * @return pDate2
	 */
	public String getPDate2() {
		return this.pDate2;
	}
	
	/**
	 * Column Info
	 * @return total2
	 */
	public String getTotal2() {
		return this.total2;
	}
	
	/**
	 * Column Info
	 * @return pYard1
	 */
	public String getPYard1() {
		return this.pYard1;
	}
	
	/**
	 * Column Info
	 * @return pVslSvcTpCd
	 */
	public String getPVslSvcTpCd() {
		return this.pVslSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @return man1
	 */
	public String getMan1() {
		return this.man1;
	}
	
	/**
	 * Column Info
	 * @return edi1
	 */
	public String getEdi1() {
		return this.edi1;
	}
	
	/**
	 * Column Info
	 * @return pYard2
	 */
	public String getPYard2() {
		return this.pYard2;
	}

	/**
	 * Column Info
	 * @param port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Column Info
	 * @param pStatus
	 */
	public void setPStatus(String pStatus) {
		this.pStatus = pStatus;
	}
	
	/**
	 * Column Info
	 * @param pVvd
	 */
	public void setPVvd(String pVvd) {
		this.pVvd = pVvd;
	}
	
	/**
	 * Column Info
	 * @param bkg2
	 */
	public void setBkg2(String bkg2) {
		this.bkg2 = bkg2;
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
	 * @param bkg1
	 */
	public void setBkg1(String bkg1) {
		this.bkg1 = bkg1;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param edi2
	 */
	public void setEdi2(String edi2) {
		this.edi2 = edi2;
	}
	
	/**
	 * Column Info
	 * @param pDate1
	 */
	public void setPDate1(String pDate1) {
		this.pDate1 = pDate1;
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
	 * @param result1
	 */
	public void setResult1(String result1) {
		this.result1 = result1;
	}
	
	/**
	 * Column Info
	 * @param result2
	 */
	public void setResult2(String result2) {
		this.result2 = result2;
	}
	
	/**
	 * Column Info
	 * @param man2
	 */
	public void setMan2(String man2) {
		this.man2 = man2;
	}
	
	/**
	 * Column Info
	 * @param total1
	 */
	public void setTotal1(String total1) {
		this.total1 = total1;
	}
	
	/**
	 * Column Info
	 * @param pDate2
	 */
	public void setPDate2(String pDate2) {
		this.pDate2 = pDate2;
	}
	
	/**
	 * Column Info
	 * @param total2
	 */
	public void setTotal2(String total2) {
		this.total2 = total2;
	}
	
	/**
	 * Column Info
	 * @param pYard1
	 */
	public void setPYard1(String pYard1) {
		this.pYard1 = pYard1;
	}
	
	/**
	 * Column Info
	 * @param pVslSvcTpCd
	 */
	public void setPVslSvcTpCd(String pVslSvcTpCd) {
		this.pVslSvcTpCd = pVslSvcTpCd;
	}
	
	/**
	 * Column Info
	 * @param man1
	 */
	public void setMan1(String man1) {
		this.man1 = man1;
	}
	
	/**
	 * Column Info
	 * @param edi1
	 */
	public void setEdi1(String edi1) {
		this.edi1 = edi1;
	}
	
	/**
	 * Column Info
	 * @param pYard2
	 */
	public void setPYard2(String pYard2) {
		this.pYard2 = pYard2;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPort(JSPUtil.getParameter(request, "port", ""));
		setPStatus(JSPUtil.getParameter(request, "p_status", ""));
		setPVvd(JSPUtil.getParameter(request, "p_vvd", ""));
		setBkg2(JSPUtil.getParameter(request, "bkg2", ""));
		setEtd(JSPUtil.getParameter(request, "etd", ""));
		setBkg1(JSPUtil.getParameter(request, "bkg1", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLane(JSPUtil.getParameter(request, "lane", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setEdi2(JSPUtil.getParameter(request, "edi2", ""));
		setPDate1(JSPUtil.getParameter(request, "p_date1", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setResult1(JSPUtil.getParameter(request, "result1", ""));
		setResult2(JSPUtil.getParameter(request, "result2", ""));
		setMan2(JSPUtil.getParameter(request, "man2", ""));
		setTotal1(JSPUtil.getParameter(request, "total1", ""));
		setPDate2(JSPUtil.getParameter(request, "p_date2", ""));
		setTotal2(JSPUtil.getParameter(request, "total2", ""));
		setPYard1(JSPUtil.getParameter(request, "p_yard1", ""));
		setPVslSvcTpCd(JSPUtil.getParameter(request, "p_vsl_svc_tp_cd", ""));
		setMan1(JSPUtil.getParameter(request, "man1", ""));
		setEdi1(JSPUtil.getParameter(request, "edi1", ""));
		setPYard2(JSPUtil.getParameter(request, "p_yard2", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VLVDUpdateStatusVO[]
	 */
	public VLVDUpdateStatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VLVDUpdateStatusVO[]
	 */
	public VLVDUpdateStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VLVDUpdateStatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] port = (JSPUtil.getParameter(request, prefix	+ "port", length));
			String[] pStatus = (JSPUtil.getParameter(request, prefix	+ "p_status", length));
			String[] pVvd = (JSPUtil.getParameter(request, prefix	+ "p_vvd", length));
			String[] bkg2 = (JSPUtil.getParameter(request, prefix	+ "bkg2", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] bkg1 = (JSPUtil.getParameter(request, prefix	+ "bkg1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lane = (JSPUtil.getParameter(request, prefix	+ "lane", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] edi2 = (JSPUtil.getParameter(request, prefix	+ "edi2", length));
			String[] pDate1 = (JSPUtil.getParameter(request, prefix	+ "p_date1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] result1 = (JSPUtil.getParameter(request, prefix	+ "result1", length));
			String[] result2 = (JSPUtil.getParameter(request, prefix	+ "result2", length));
			String[] man2 = (JSPUtil.getParameter(request, prefix	+ "man2", length));
			String[] total1 = (JSPUtil.getParameter(request, prefix	+ "total1", length));
			String[] pDate2 = (JSPUtil.getParameter(request, prefix	+ "p_date2", length));
			String[] total2 = (JSPUtil.getParameter(request, prefix	+ "total2", length));
			String[] pYard1 = (JSPUtil.getParameter(request, prefix	+ "p_yard1", length));
			String[] pVslSvcTpCd = (JSPUtil.getParameter(request, prefix	+ "p_vsl_svc_tp_cd", length));
			String[] man1 = (JSPUtil.getParameter(request, prefix	+ "man1", length));
			String[] edi1 = (JSPUtil.getParameter(request, prefix	+ "edi1", length));
			String[] pYard2 = (JSPUtil.getParameter(request, prefix	+ "p_yard2", length));
			
			for (int i = 0; i < length; i++) {
				model = new VLVDUpdateStatusVO();
				if (port[i] != null)
					model.setPort(port[i]);
				if (pStatus[i] != null)
					model.setPStatus(pStatus[i]);
				if (pVvd[i] != null)
					model.setPVvd(pVvd[i]);
				if (bkg2[i] != null)
					model.setBkg2(bkg2[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (bkg1[i] != null)
					model.setBkg1(bkg1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lane[i] != null)
					model.setLane(lane[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (edi2[i] != null)
					model.setEdi2(edi2[i]);
				if (pDate1[i] != null)
					model.setPDate1(pDate1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (result1[i] != null)
					model.setResult1(result1[i]);
				if (result2[i] != null)
					model.setResult2(result2[i]);
				if (man2[i] != null)
					model.setMan2(man2[i]);
				if (total1[i] != null)
					model.setTotal1(total1[i]);
				if (pDate2[i] != null)
					model.setPDate2(pDate2[i]);
				if (total2[i] != null)
					model.setTotal2(total2[i]);
				if (pYard1[i] != null)
					model.setPYard1(pYard1[i]);
				if (pVslSvcTpCd[i] != null)
					model.setPVslSvcTpCd(pVslSvcTpCd[i]);
				if (man1[i] != null)
					model.setMan1(man1[i]);
				if (edi1[i] != null)
					model.setEdi1(edi1[i]);
				if (pYard2[i] != null)
					model.setPYard2(pYard2[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVLVDUpdateStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VLVDUpdateStatusVO[]
	 */
	public VLVDUpdateStatusVO[] getVLVDUpdateStatusVOs(){
		VLVDUpdateStatusVO[] vos = (VLVDUpdateStatusVO[])models.toArray(new VLVDUpdateStatusVO[models.size()]);
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
		this.port = this.port .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pStatus = this.pStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pVvd = this.pVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg2 = this.bkg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg1 = this.bkg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane = this.lane .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edi2 = this.edi2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate1 = this.pDate1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.result1 = this.result1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.result2 = this.result2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.man2 = this.man2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.total1 = this.total1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate2 = this.pDate2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.total2 = this.total2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard1 = this.pYard1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pVslSvcTpCd = this.pVslSvcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.man1 = this.man1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edi1 = this.edi1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

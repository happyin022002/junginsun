/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgCstmsAdvScacVO.java
*@FileTitle : BkgCstmsAdvScacVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.22 강동윤 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

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
 * @author 강동윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgCstmsAdvScacVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCstmsAdvScacVO> models = new ArrayList<BkgCstmsAdvScacVO>();
	
	/* Column Info */
	private String portCdMax = null;
	/* Column Info */
	private String updDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String portCdCount = null;
	/* Column Info */
	private String scacCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String hblLen = null;
	/* Column Info */
	private String usaCstmsFileCd = null;
	/* Column Info */
	private String scacNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgCstmsAdvScacVO() {}

	public BkgCstmsAdvScacVO(String ibflag, String pagerows, String scacCd, String scacNm, String usaCstmsFileCd, String hblLen, String diffRmk, String userId, String updDt, String portCd, String portCdMax, String portCdCount) {
		this.portCdMax = portCdMax;
		this.updDt = updDt;
		this.ibflag = ibflag;
		this.diffRmk = diffRmk;
		this.portCdCount = portCdCount;
		this.scacCd = scacCd;
		this.userId = userId;
		this.portCd = portCd;
		this.hblLen = hblLen;
		this.usaCstmsFileCd = usaCstmsFileCd;
		this.scacNm = scacNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("port_cd_max", getPortCdMax());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("port_cd_count", getPortCdCount());
		this.hashColumns.put("scac_cd", getScacCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("hbl_len", getHblLen());
		this.hashColumns.put("usa_cstms_file_cd", getUsaCstmsFileCd());
		this.hashColumns.put("scac_nm", getScacNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("port_cd_max", "portCdMax");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("port_cd_count", "portCdCount");
		this.hashFields.put("scac_cd", "scacCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("hbl_len", "hblLen");
		this.hashFields.put("usa_cstms_file_cd", "usaCstmsFileCd");
		this.hashFields.put("scac_nm", "scacNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return portCdMax
	 */
	public String getPortCdMax() {
		return this.portCdMax;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return portCdCount
	 */
	public String getPortCdCount() {
		return this.portCdCount;
	}
	
	/**
	 * Column Info
	 * @return scacCd
	 */
	public String getScacCd() {
		return this.scacCd;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return hblLen
	 */
	public String getHblLen() {
		return this.hblLen;
	}
	
	/**
	 * Column Info
	 * @return usaCstmsFileCd
	 */
	public String getUsaCstmsFileCd() {
		return this.usaCstmsFileCd;
	}
	
	/**
	 * Column Info
	 * @return scacNm
	 */
	public String getScacNm() {
		return this.scacNm;
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
	 * @param portCdMax
	 */
	public void setPortCdMax(String portCdMax) {
		this.portCdMax = portCdMax;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param portCdCount
	 */
	public void setPortCdCount(String portCdCount) {
		this.portCdCount = portCdCount;
	}
	
	/**
	 * Column Info
	 * @param scacCd
	 */
	public void setScacCd(String scacCd) {
		this.scacCd = scacCd;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param hblLen
	 */
	public void setHblLen(String hblLen) {
		this.hblLen = hblLen;
	}
	
	/**
	 * Column Info
	 * @param usaCstmsFileCd
	 */
	public void setUsaCstmsFileCd(String usaCstmsFileCd) {
		this.usaCstmsFileCd = usaCstmsFileCd;
	}
	
	/**
	 * Column Info
	 * @param scacNm
	 */
	public void setScacNm(String scacNm) {
		this.scacNm = scacNm;
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
		setPortCdMax(JSPUtil.getParameter(request, "port_cd_max", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setPortCdCount(JSPUtil.getParameter(request, "port_cd_count", ""));
		setScacCd(JSPUtil.getParameter(request, "scac_cd", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setHblLen(JSPUtil.getParameter(request, "hbl_len", ""));
		setUsaCstmsFileCd(JSPUtil.getParameter(request, "usa_cstms_file_cd", ""));
		setScacNm(JSPUtil.getParameter(request, "scac_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCstmsAdvScacVO[]
	 */
	public BkgCstmsAdvScacVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCstmsAdvScacVO[]
	 */
	public BkgCstmsAdvScacVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCstmsAdvScacVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] portCdMax = (JSPUtil.getParameter(request, prefix	+ "port_cd_max".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk".trim(), length));
			String[] portCdCount = (JSPUtil.getParameter(request, prefix	+ "port_cd_count".trim(), length));
			String[] scacCd = (JSPUtil.getParameter(request, prefix	+ "scac_cd".trim(), length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id".trim(), length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd".trim(), length));
			String[] hblLen = (JSPUtil.getParameter(request, prefix	+ "hbl_len".trim(), length));
			String[] usaCstmsFileCd = (JSPUtil.getParameter(request, prefix	+ "usa_cstms_file_cd".trim(), length));
			String[] scacNm = (JSPUtil.getParameter(request, prefix	+ "scac_nm".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCstmsAdvScacVO();
				if (portCdMax[i] != null)
					model.setPortCdMax(portCdMax[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (portCdCount[i] != null)
					model.setPortCdCount(portCdCount[i]);
				if (scacCd[i] != null)
					model.setScacCd(scacCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (hblLen[i] != null)
					model.setHblLen(hblLen[i]);
				if (usaCstmsFileCd[i] != null)
					model.setUsaCstmsFileCd(usaCstmsFileCd[i]);
				if (scacNm[i] != null)
					model.setScacNm(scacNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCstmsAdvScacVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCstmsAdvScacVO[]
	 */
	public BkgCstmsAdvScacVO[] getBkgCstmsAdvScacVOs(){
		BkgCstmsAdvScacVO[] vos = (BkgCstmsAdvScacVO[])models.toArray(new BkgCstmsAdvScacVO[models.size()]);
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
		this.portCdMax = this.portCdMax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCdCount = this.portCdCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scacCd = this.scacCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblLen = this.hblLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaCstmsFileCd = this.usaCstmsFileCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scacNm = this.scacNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BlKeyVO.java
*@FileTitle : BlKeyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.06.03 김도완 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlKeyVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;
/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김도완
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaBlKeyVO extends BlKeyVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaBlKeyVO> models = new ArrayList<UsaBlKeyVO>();
	
	/* Column Info */
	private String blNoChk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String blNoTp = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String blKey = null;
	/* Column Info */
	private String hisTpId = null;
	
	/* Page Number */
	private String pagerows = null;
	private String usrId = null;
	public void setUsrId(String usrId){
		this.usrId = usrId;
	}
	public String getUsrId(String usrId){
		return this.usrId;
	}

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaBlKeyVO() {}

	public UsaBlKeyVO(String ibflag, String pagerows, String cntCd, String blNo, String blNoTp, String blNoChk, String blKey, String hisTpId) {
		this.blNoChk = blNoChk;
		this.ibflag = ibflag;
		this.cntCd = cntCd;
		this.blNoTp = blNoTp;
		this.blNo = blNo;
		this.blKey = blKey;
		this.hisTpId = hisTpId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_no_chk", getBlNoChk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("bl_no_tp", getBlNoTp());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bl_key", getBlKey());
		this.hashColumns.put("hisTpId", getHisTpId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_no_chk", "blNoChk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("bl_no_tp", "blNoTp");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("bl_key", "blKey");
		this.hashFields.put("hisTpId", "hisTpId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return blNoChk
	 */
	public String getBlNoChk() {
		return this.blNoChk;
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
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return blNoTp
	 */
	public String getBlNoTp() {
		return this.blNoTp;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return blKey
	 */
	public String getBlKey() {
		return this.blKey;
	}

	/**
	 * Column Info
	 * @return blKey
	 */
	public String getHisTpId() {
		return this.hisTpId;
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
	 * @param blNoChk
	 */
	public void setBlNoChk(String blNoChk) {
		this.blNoChk = blNoChk;
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
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param blNoTp
	 */
	public void setBlNoTp(String blNoTp) {
		this.blNoTp = blNoTp;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param blKey
	 */
	public void setBlKey(String blKey) {
		this.blKey = blKey;
	}

	/**
	 * Column Info
	 * @param blKey
	 */
	public void setHisTpId(String hisTpId) {
		this.hisTpId = hisTpId;
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
		setBlNoChk(JSPUtil.getParameter(request, "bl_no_chk", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setBlNoTp(JSPUtil.getParameter(request, "bl_no_tp", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setBlKey(JSPUtil.getParameter(request, "bl_key", ""));
		setHisTpId(JSPUtil.getParameter(request, "his_tp_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaBlKeyVO[]
	 */
	public UsaBlKeyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaBlKeyVO[]
	 */
	public UsaBlKeyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaBlKeyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blNoChk = (JSPUtil.getParameter(request, prefix	+ "bl_no_chk".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd".trim(), length));
			String[] blNoTp = (JSPUtil.getParameter(request, prefix	+ "bl_no_tp".trim(), length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no".trim(), length));
			String[] blKey = (JSPUtil.getParameter(request, prefix	+ "bl_key".trim(), length));
			String[] hisTpId = (JSPUtil.getParameter(request, prefix	+ "his_tp_id".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaBlKeyVO();
				if (blNoChk[i] != null)
					model.setBlNoChk(blNoChk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (blNoTp[i] != null)
					model.setBlNoTp(blNoTp[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (blKey[i] != null)
					model.setBlKey(blKey[i]);
				if (hisTpId[i] != null)
					model.setHisTpId(hisTpId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaBlKeyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaBlKeyVO[]
	 */
	public UsaBlKeyVO[] getUsaBlKeyVOs(){
		UsaBlKeyVO[] vos = (UsaBlKeyVO[])models.toArray(new UsaBlKeyVO[models.size()]);
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
		this.blNoChk = this.blNoChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNoTp = this.blNoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blKey = this.blKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

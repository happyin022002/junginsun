/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BsaCrrRgstVO.java
*@FileTitle : BsaCrrRgstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2009.09.03 남궁진호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.vo;

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
 * @author 남궁진호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BsaAddCarrierSaveVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BsaAddCarrierSaveVO> models = new ArrayList<BsaAddCarrierSaveVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bsaOpJbCd = null;
	/* Column Info */
	private String crrDpNo = null;
	/* Column Info */
	private String bsaOpCd = null;
	/* Column Info */
	private String aplyFlg = null;
	/* Column Info */
	private String crrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String crrcd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BsaAddCarrierSaveVO() {}

	public BsaAddCarrierSaveVO(String ibflag, String pagerows, String bsaOpCd, String bsaOpJbCd, String crrCd, String crrDpNo, String aplyFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.updDt = updDt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.bsaOpJbCd = bsaOpJbCd;
		this.crrDpNo = crrDpNo;
		this.creDt = creDt;
		this.bsaOpCd = bsaOpCd;
		this.aplyFlg = aplyFlg;
		this.updUsrId = updUsrId;
		this.crrCd = crrCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bsa_op_jb_cd", getBsaOpJbCd());
		this.hashColumns.put("crr_dp_no", getCrrDpNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("bsa_op_cd", getBsaOpCd());
		this.hashColumns.put("aply_flg", getAplyFlg());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("crr_cd", getCrrCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bsa_op_jb_cd", "bsaOpJbCd");
		this.hashFields.put("crr_dp_no", "crrDpNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bsa_op_cd", "bsaOpCd");
		this.hashFields.put("aply_flg", "aplyFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("crr_cd", "crrCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return bsaOpJbCd
	 */
	public String getBsaOpJbCd() {
		return this.bsaOpJbCd;
	}
	
	/**
	 * Column Info
	 * @return crrDpNo
	 */
	public String getCrrDpNo() {
		return this.crrDpNo;
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
	 * @return bsaOpCd
	 */
	public String getBsaOpCd() {
		return this.bsaOpCd;
	}
	
	/**
	 * Column Info
	 * @return aplyFlg
	 */
	public String getAplyFlg() {
		return this.aplyFlg;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return crrCd
	 */
	public String getCrrCd() {
		return this.crrCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param bsaOpJbCd
	 */
	public void setBsaOpJbCd(String bsaOpJbCd) {
		this.bsaOpJbCd = bsaOpJbCd;
	}
	
	/**
	 * Column Info
	 * @param crrDpNo
	 */
	public void setCrrDpNo(String crrDpNo) {
		this.crrDpNo = crrDpNo;
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
	 * @param bsaOpCd
	 */
	public void setBsaOpCd(String bsaOpCd) {
		this.bsaOpCd = bsaOpCd;
	}
	
	/**
	 * Column Info
	 * @param aplyFlg
	 */
	public void setAplyFlg(String aplyFlg) {
		this.aplyFlg = aplyFlg;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param crrCd
	 */
	public void setCrrCd(String crrCd) {
		this.crrCd = crrCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Page Number
	 * @param crrcd
	 */
	public String getCrrcd() {
		return crrcd;
	}
	
	/**
	 * Page Number
	 * @param crrcd
	 */
	public void setCrrcd(String crrcd) {
		this.crrcd = crrcd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBsaOpJbCd(JSPUtil.getParameter(request, "bsa_op_jb_cd", ""));
		setCrrDpNo(JSPUtil.getParameter(request, "crr_dp_no", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setBsaOpCd(JSPUtil.getParameter(request, "bsa_op_cd", ""));
		setAplyFlg(JSPUtil.getParameter(request, "aply_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setCrrCd(JSPUtil.getParameter(request, "crr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCrrcd(JSPUtil.getParameter(request, "crr_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BsaCrrRgstVO[]
	 */
	public BsaAddCarrierSaveVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BsaCrrRgstVO[]
	 */
	public BsaAddCarrierSaveVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BsaAddCarrierSaveVO model = null;
		
		String[] arrCrrCd =null;
		String[] tmp = request.getParameterValues( "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues("ibflag").length;
  		setCrrcd(JSPUtil.getParameter(request, "crr_cd", ""));
  		if (getCrrcd().length()>0){ 
  			crrcd = getCrrcd().substring(1); 
		}
  		
  		arrCrrCd = crrcd.split("[|]");	
  		
		try {
			String[] ibflag 	= null;
			String[] bsaOpCd 	= null;
			String[] aplyFlg 	= null;
			
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < arrCrrCd.length; j++) {
					model = new BsaAddCarrierSaveVO();
					ibflag 	= (JSPUtil.getParameter(request, prefix	+ "ibflag"+j, length));
					bsaOpCd = (JSPUtil.getParameter(request, prefix	+ "bsa_op_cd"+j, length));
					aplyFlg = (JSPUtil.getParameter(request, prefix	+ "aply_flg"+j, length));
					
					if(ibflag[i].equals("U")){				
						if (ibflag[i] != null)		model.setIbflag(ibflag[i]);
						if (bsaOpCd[i] != null)		model.setBsaOpCd(bsaOpCd[i].substring(0,1));
						if (bsaOpCd[i] != null)		model.setBsaOpJbCd(bsaOpCd[i].substring(2,5));
						if (bsaOpCd[i] != null)		model.setCrrCd(bsaOpCd[i].substring(6,9));
						if (aplyFlg[i] != null)		model.setAplyFlg(aplyFlg[i]);
						models.add(model);
					}
				}
			}

		} catch (Exception e) {
			return null;
		}
		return getBsaCrrRgstSaveVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BsaCrrRgstVO[]
	 */
	public BsaAddCarrierSaveVO[] getBsaCrrRgstSaveVOs(){
		BsaAddCarrierSaveVO[] vos = (BsaAddCarrierSaveVO[])models.toArray(new BsaAddCarrierSaveVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaOpJbCd = this.bsaOpJbCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrDpNo = this.crrDpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaOpCd = this.bsaOpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aplyFlg = this.aplyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrCd = this.crrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

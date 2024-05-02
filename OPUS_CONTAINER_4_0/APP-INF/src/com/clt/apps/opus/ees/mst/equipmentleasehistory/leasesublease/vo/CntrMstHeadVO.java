/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrMstHeadVO.java
*@FileTitle : CntrMstHeadVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.06.09 이호선 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo;

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
 * @author 이호선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CntrMstHeadVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CntrMstHeadVO> models = new ArrayList<CntrMstHeadVO>();
	
	/* Column Info */
	private String cntrTpszIsoCd = null;
	/* Column Info */
	private String chkDgt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ownrCoCd = null;
	/* Column Info */
	private String cntrUseCoCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cntrOldVanFlg = null;
	/* Column Info */
	private String aciacDivCd = null;
	/* Column Info */
	private String lstmCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CntrMstHeadVO() {}

	public CntrMstHeadVO(String ibflag, String pagerows, String cntrNo, String chkDgt, String aciacDivCd, String cntrTpszCd, String lstmCd, String cntrTpszIsoCd, String cntrOldVanFlg, String ownrCoCd, String cntrUseCoCd) {
		this.cntrTpszIsoCd = cntrTpszIsoCd;
		this.chkDgt = chkDgt;
		this.ibflag = ibflag;
		this.ownrCoCd = ownrCoCd;
		this.cntrUseCoCd = cntrUseCoCd;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.cntrOldVanFlg = cntrOldVanFlg;
		this.aciacDivCd = aciacDivCd;
		this.lstmCd = lstmCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_tpsz_iso_cd", getCntrTpszIsoCd());
		this.hashColumns.put("chk_dgt", getChkDgt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ownr_co_cd", getOwnrCoCd());
		this.hashColumns.put("cntr_use_co_cd", getCntrUseCoCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cntr_old_van_flg", getCntrOldVanFlg());
		this.hashColumns.put("aciac_div_cd", getAciacDivCd());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_tpsz_iso_cd", "cntrTpszIsoCd");
		this.hashFields.put("chk_dgt", "chkDgt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ownr_co_cd", "ownrCoCd");
		this.hashFields.put("cntr_use_co_cd", "cntrUseCoCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_old_van_flg", "cntrOldVanFlg");
		this.hashFields.put("aciac_div_cd", "aciacDivCd");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszIsoCd
	 */
	public String getCntrTpszIsoCd() {
		return this.cntrTpszIsoCd;
	}
	
	/**
	 * Column Info
	 * @return chkDgt
	 */
	public String getChkDgt() {
		return this.chkDgt;
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
	 * @return ownrCoCd
	 */
	public String getOwnrCoCd() {
		return this.ownrCoCd;
	}
	
	/**
	 * Column Info
	 * @return cntrUseCoCd
	 */
	public String getCntrUseCoCd() {
		return this.cntrUseCoCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return cntrOldVanFlg
	 */
	public String getCntrOldVanFlg() {
		return this.cntrOldVanFlg;
	}
	
	/**
	 * Column Info
	 * @return aciacDivCd
	 */
	public String getAciacDivCd() {
		return this.aciacDivCd;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
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
	 * @param cntrTpszIsoCd
	 */
	public void setCntrTpszIsoCd(String cntrTpszIsoCd) {
		this.cntrTpszIsoCd = cntrTpszIsoCd;
	}
	
	/**
	 * Column Info
	 * @param chkDgt
	 */
	public void setChkDgt(String chkDgt) {
		this.chkDgt = chkDgt;
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
	 * @param ownrCoCd
	 */
	public void setOwnrCoCd(String ownrCoCd) {
		this.ownrCoCd = ownrCoCd;
	}
	
	/**
	 * Column Info
	 * @param cntrUseCoCd
	 */
	public void setCntrUseCoCd(String cntrUseCoCd) {
		this.cntrUseCoCd = cntrUseCoCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param cntrOldVanFlg
	 */
	public void setCntrOldVanFlg(String cntrOldVanFlg) {
		this.cntrOldVanFlg = cntrOldVanFlg;
	}
	
	/**
	 * Column Info
	 * @param aciacDivCd
	 */
	public void setAciacDivCd(String aciacDivCd) {
		this.aciacDivCd = aciacDivCd;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
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
		setCntrTpszIsoCd(JSPUtil.getParameter(request, "cntr_tpsz_iso_cd", ""));
		setChkDgt(JSPUtil.getParameter(request, "chk_dgt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOwnrCoCd(JSPUtil.getParameter(request, "ownr_co_cd", ""));
		setCntrUseCoCd(JSPUtil.getParameter(request, "cntr_use_co_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCntrOldVanFlg(JSPUtil.getParameter(request, "cntr_old_van_flg", ""));
		setAciacDivCd(JSPUtil.getParameter(request, "aciac_div_cd", ""));
		setLstmCd(JSPUtil.getParameter(request, "lstm_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrMstHeadVO[]
	 */
	public CntrMstHeadVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CntrMstHeadVO[]
	 */
	public CntrMstHeadVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CntrMstHeadVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrTpszIsoCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_iso_cd".trim(), length));
			String[] chkDgt = (JSPUtil.getParameter(request, prefix	+ "chk_dgt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] ownrCoCd = (JSPUtil.getParameter(request, prefix	+ "ownr_co_cd".trim(), length));
			String[] cntrUseCoCd = (JSPUtil.getParameter(request, prefix	+ "cntr_use_co_cd".trim(), length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no".trim(), length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd".trim(), length));
			String[] cntrOldVanFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_old_van_flg".trim(), length));
			String[] aciacDivCd = (JSPUtil.getParameter(request, prefix	+ "aciac_div_cd".trim(), length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CntrMstHeadVO();
				if (cntrTpszIsoCd[i] != null)
					model.setCntrTpszIsoCd(cntrTpszIsoCd[i]);
				if (chkDgt[i] != null)
					model.setChkDgt(chkDgt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ownrCoCd[i] != null)
					model.setOwnrCoCd(ownrCoCd[i]);
				if (cntrUseCoCd[i] != null)
					model.setCntrUseCoCd(cntrUseCoCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cntrOldVanFlg[i] != null)
					model.setCntrOldVanFlg(cntrOldVanFlg[i]);
				if (aciacDivCd[i] != null)
					model.setAciacDivCd(aciacDivCd[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCntrMstHeadVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CntrMstHeadVO[]
	 */
	public CntrMstHeadVO[] getCntrMstHeadVOs(){
		CntrMstHeadVO[] vos = (CntrMstHeadVO[])models.toArray(new CntrMstHeadVO[models.size()]);
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
		this.cntrTpszIsoCd = this.cntrTpszIsoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkDgt = this.chkDgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrCoCd = this.ownrCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrUseCoCd = this.cntrUseCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrOldVanFlg = this.cntrOldVanFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aciacDivCd = this.aciacDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

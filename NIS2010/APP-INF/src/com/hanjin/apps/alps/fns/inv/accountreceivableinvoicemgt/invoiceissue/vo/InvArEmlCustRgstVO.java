/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceDueDtVO.java
*@FileTitle : InvoiceDueDtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.06.26 정휘택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정휘택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvArEmlCustRgstVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
		
	/* Column Info */
    private Collection<InvArEmlCustRgstVO> models = new ArrayList<InvArEmlCustRgstVO>();
    /* Column Info */
    private String updDt = null;
    /* Column Info */
    private String creDt = null;
    /* Column Info */
    private String pagerows = null;
    /* Column Info */
    private String creUsrId = null;
    /* Column Info */
    private String updUsrId = null;
    /* Column Info */
    private String ibflag = null;
    /* Column Info */
    private String arOfcCd = null;
    /* Column Info */
    private String custCntCd= null;
    /* Column Info */
    private String custSeq= null;
    /* Column Info */
    private String custNm = null;
    /* Column Info */
    private String invEmlSplitFlg = null;
    /* Column Info */
    private String custRmk = null;
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();
	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvArEmlCustRgstVO() {}

	public InvArEmlCustRgstVO(String ibflag, String pagerows, String creDt, String updDt, String creUsrId, String updUsrId, String arOfcCd, String custCntCd, String custSeq, String custNm, String invEmlSplitFlg, String custRmk){
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.creDt = creDt;
        this.updDt = updDt;
        this.creUsrId = creUsrId;
        this.updUsrId = updUsrId;
        this.arOfcCd = arOfcCd;
        this.custCntCd = custCntCd;
        this.custSeq = custSeq;
        this.custNm = custNm;
        this.invEmlSplitFlg = invEmlSplitFlg;
        this.custRmk = custRmk;
    }
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
        hashColumns.put("upd_dt", getUpdDt());
        hashColumns.put("cre_dt", getCreDt());
        hashColumns.put("pagerows", getPagerows());
        hashColumns.put("cre_usr_id", getCreUsrId());
        hashColumns.put("ibflag", getIbflag());
        hashColumns.put("upd_usr_id", getUpdUsrId());
        hashColumns.put("ar_ofc_cd", getArOfcCd());
        hashColumns.put("cust_cnt_cd", getCustCntCd());
        hashColumns.put("cust_seq", getCustSeq());
        hashColumns.put("cust_nm", getCustNm());
        hashColumns.put("inv_eml_split_flg", getInvEmlSplitFlg());
        hashColumns.put("cust_rmk", getCustRmk());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
        hashFields.put("upd_dt", "updDt");
        hashFields.put("cre_dt", "creDt");
        hashFields.put("pagerows", "pagerows");
        hashFields.put("cre_usr_id", "creUsrId");
        hashFields.put("ibflag", "ibflag");
        hashFields.put("upd_usr_id", "updUsrId");
        hashFields.put("ar_ofc_cd", "arOfcCd");
        hashFields.put("cust_cnt_cd", "custCntCd");
        hashFields.put("cust_seq", "custSeq");
        hashFields.put("cust_nm", "custNm");
        hashFields.put("inv_eml_split_flg", "invEmlSplitFlg");
        hashFields.put("cust_rmk", "custRmk");
		return this.hashFields;
	}

	/**
	 * @return the updDt
	 */
	public String getUpdDt() {
		return updDt;
	}

	/**
	 * @param updDt the updDt to set
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}

	/**
	 * @return the creDt
	 */
	public String getCreDt() {
		return creDt;
	}

	/**
	 * @param creDt the creDt to set
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}

	/**
	 * @return the creUsrId
	 */
	public String getCreUsrId() {
		return creUsrId;
	}

	/**
	 * @param creUsrId the creUsrId to set
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * @return the updUsrId
	 */
	public String getUpdUsrId() {
		return updUsrId;
	}

	/**
	 * @param updUsrId the updUsrId to set
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}

	/**
	 * @return the ibflag
	 */
	public String getIbflag() {
		return ibflag;
	}

	/**
	 * @param ibflag the ibflag to set
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * @return the arOfcCd
	 */
	public String getArOfcCd() {
		return arOfcCd;
	}

	/**
	 * @param arOfcCd the arOfcCd to set
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}

	/**
	 * @return the custCntCd
	 */
	public String getCustCntCd() {
		return custCntCd;
	}

	/**
	 * @param custCntCd the custCntCd to set
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}

	/**
	 * @return the custSeq
	 */
	public String getCustSeq() {
		return custSeq;
	}

	/**
	 * @param custSeq the custSeq to set
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	/**
	 * @return the custNm
	 */
	public String getCustNm() {
		return custNm;
	}

	/**
	 * @param custNm the custNm to set
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}

	/**
	 * @return the invEmlSplitFlg
	 */
	public String getInvEmlSplitFlg() {
		return invEmlSplitFlg;
	}

	/**
	 * @param invEmlSplitFlg the invEmlSplitFlg to set
	 */
	public void setInvEmlSplitFlg(String invEmlSplitFlg) {
		this.invEmlSplitFlg = invEmlSplitFlg;
	}

	/**
	 * @return the custRmk
	 */
	public String getCustRmk() {
		return custRmk;
	}

	/**
	 * @param custRmk the custRmk to set
	 */
	public void setCustRmk(String custRmk) {
		this.custRmk = custRmk;
	}
		
	/**
	 * @return the pagerows
	 */
	public String getPagerows() {
		return pagerows;
	}

	/**
	 * @param pagerows the pagerows to set
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	public void fromRequest(HttpServletRequest request) {
        setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
        setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
        setArOfcCd(JSPUtil.getParameter(request, "ar_ofc_cd", ""));
        setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
        setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
        setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
        setInvEmlSplitFlg(JSPUtil.getParameter(request, "inv_eml_split_flg", ""));
        setCustRmk(JSPUtil.getParameter(request, "cust_rmk", ""));
	}

	public InvArEmlCustRgstVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public InvArEmlCustRgstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvArEmlCustRgstVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String updDt[] = JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("upd_dt").toString(), length);
            String creDt[] = JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("cre_dt").toString(), length);
            String pagerows[] = JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("pagerows").toString(), length);
            String creUsrId[] = JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("cre_usr_id").toString(), length);
            String ibflag[] = JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("ibflag").toString(), length);
            String updUsrId[] = JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("upd_usr_id").toString(), length);
            String arOfcCd[] = JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("ar_ofc_cd").toString(), length);
            String custCntCd[] = JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("cust_cnt_cd").toString(), length);
            String custSeq[] = JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("cust_seq").toString(), length);
            String custNm[] = JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("cust_nm").toString(), length);
            String invEmlSplitFlg[] = JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("inv_eml_split_flg").toString(), length);
            String custRmk[] = JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("cust_rmk").toString(), length);
            for(int i = 0; i < length; i++){
                model = new InvArEmlCustRgstVO();
                if(updDt[i] != null)
                    model.setUpdDt(updDt[i]);
                if(creDt[i] != null)
                    model.setCreDt(creDt[i]);
                if(pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if(creUsrId[i] != null)
                    model.setCreUsrId(creUsrId[i]);
                if(ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if(updUsrId[i] != null)
                    model.setUpdUsrId(updUsrId[i]);
                if(arOfcCd[i] != null)
                    model.setArOfcCd(arOfcCd[i]);
                if(custCntCd[i] != null)
                    model.setCustCntCd(custCntCd[i]);
                if(custSeq[i] != null)
                    model.setCustSeq(custSeq[i]);
                if(custNm[i] != null)
                    model.setCustNm(custNm[i]);
                if(invEmlSplitFlg[i] != null)
                    model.setInvEmlSplitFlg(invEmlSplitFlg[i]);
                if(custRmk[i] != null)
                    model.setCustRmk(custRmk[i]);
                models.add(model);
			}

		} catch (Exception e) {}
		return getArEmlCustRgstVOs();
	}

    public InvArEmlCustRgstVO[] getArEmlCustRgstVOs(){
        InvArEmlCustRgstVO vos[] = (InvArEmlCustRgstVO[])models.toArray(new InvArEmlCustRgstVO[models.size()]);
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
	 * @exception IllegalAccessException
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
		updDt = updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        creDt = creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        pagerows = pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        creUsrId = creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        ibflag = ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        updUsrId = updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        arOfcCd = arOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        custCntCd = custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        custSeq = custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        custNm = custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        invEmlSplitFlg = invEmlSplitFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        custRmk = custRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

}

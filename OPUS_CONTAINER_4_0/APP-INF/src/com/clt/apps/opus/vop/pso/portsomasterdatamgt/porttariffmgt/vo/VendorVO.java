/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VendorVO.java
*@FileTitle : VendorVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.04.29 김진일 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 김진일
 * @since J2EE 1.5
 */
public class VendorVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<VendorVO> models = new ArrayList<VendorVO>();

    /* Status */
    private String ibflag = null;

    /* Column Info */
    private String vndrSeq = null;

    /* Column Info */
    private String vndrCntCd = null;

    /* Column Info */
    private String tcnt = null;

    /* Column Info */
    private String vndrNm = null;

    /* Column Info */
    private String ofcCd = null;

    /* Column Info */
    private String vndrLglEngNm = null;

    /* Column Info */
    private String deltFlg = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String cnlAgnFlg = null;

    /*	hashColumnInpo	*/
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	hashFildInpo	*/
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public VendorVO() {
    }

    public VendorVO(String ibflag, String pagerows, String tcnt, String ofcCd, String vndrCntCd, String vndrLglEngNm, String vndrSeq, String vndrNm, String deltFlg, String cnlAgnFlg) {
        this.ibflag = ibflag;
        this.vndrSeq = vndrSeq;
        this.vndrCntCd = vndrCntCd;
        this.tcnt = tcnt;
        this.vndrNm = vndrNm;
        this.ofcCd = ofcCd;
        this.vndrLglEngNm = vndrLglEngNm;
        this.deltFlg = deltFlg;
        this.pagerows = pagerows;
        this.cnlAgnFlg = cnlAgnFlg;
    }

    /**
	 * hashColumnInpo
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("vndr_cnt_cd", getVndrCntCd());
        this.hashColumns.put("tcnt", getTcnt());
        this.hashColumns.put("vndr_nm", getVndrNm());
        this.hashColumns.put("ofc_cd", getOfcCd());
        this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
        this.hashColumns.put("delt_flg", getDeltFlg());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("cnl_agn_flg", getCnlAgnFlg());
        return this.hashColumns;
    }

    /**
	 * hashFildInpo
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("vndr_cnt_cd", "vndrCntCd");
        this.hashFields.put("tcnt", "tcnt");
        this.hashFields.put("vndr_nm", "vndrNm");
        this.hashFields.put("ofc_cd", "ofcCd");
        this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
        this.hashFields.put("delt_flg", "deltFlg");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("cnl_agn_flg", "cnlAgnFlg");
        return this.hashFields;
    }

    public String getIbflag() {
        return this.ibflag;
    }

    public String getVndrSeq() {
        return this.vndrSeq;
    }

    public String getVndrCntCd() {
        return this.vndrCntCd;
    }

    public String getTcnt() {
        return this.tcnt;
    }

    public String getVndrNm() {
        return this.vndrNm;
    }

    public String getOfcCd() {
        return this.ofcCd;
    }

    public String getVndrLglEngNm() {
        return this.vndrLglEngNm;
    }

    public String getPagerows() {
        return this.pagerows;
    }

    public String getDeltFlg() {
        return this.deltFlg;
    }

    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    public void setVndrSeq(String vndrSeq) {
        this.vndrSeq = vndrSeq;
    }

    public void setVndrCntCd(String vndrCntCd) {
        this.vndrCntCd = vndrCntCd;
    }

    public void setTcnt(String tcnt) {
        this.tcnt = tcnt;
    }

    public void setVndrNm(String vndrNm) {
        this.vndrNm = vndrNm;
    }

    public void setOfcCd(String ofcCd) {
        this.ofcCd = ofcCd;
    }

    public void setVndrLglEngNm(String vndrLglEngNm) {
        this.vndrLglEngNm = vndrLglEngNm;
    }

    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setDeltFlg(String deltFlg) {
        this.deltFlg = deltFlg;
    }

    public void setCnlAgnFlg(String cnlAgnFlg) {
        this.cnlAgnFlg = cnlAgnFlg;
    }

    public String getCnlAgnFlg() {
        return this.cnlAgnFlg;
    }

    public void fromRequest(HttpServletRequest request) {
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
        setVndrCntCd(JSPUtil.getParameter(request, "vndr_cnt_cd", ""));
        setTcnt(JSPUtil.getParameter(request, "tcnt", ""));
        setVndrNm(JSPUtil.getParameter(request, "vndr_nm", ""));
        setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
        setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
        setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setCnlAgnFlg(JSPUtil.getParameter(request, "cnl_agn_flg", ""));
    }

    public VendorVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    public VendorVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        VendorVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq".trim(), length));
            String[] vndrCntCd = (JSPUtil.getParameter(request, prefix + "vndr_cnt_cd".trim(), length));
            String[] tcnt = (JSPUtil.getParameter(request, prefix + "tcnt".trim(), length));
            String[] vndrNm = (JSPUtil.getParameter(request, prefix + "vndr_nm".trim(), length));
            String[] ofcCd = (JSPUtil.getParameter(request, prefix + "ofc_cd".trim(), length));
            String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm".trim(), length));
            String[] deltFlg = (JSPUtil.getParameter(request, prefix + "delt_flg".trim(), length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));
            String[] cnlAgnFlg = (JSPUtil.getParameter(request, prefix + "cnl_agn_flg", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new VendorVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
                if (vndrCntCd[i] != null)
                    model.setVndrCntCd(vndrCntCd[i]);
                if (tcnt[i] != null)
                    model.setTcnt(tcnt[i]);
                if (vndrNm[i] != null)
                    model.setVndrNm(vndrNm[i]);
                if (ofcCd[i] != null)
                    model.setOfcCd(ofcCd[i]);
                if (vndrLglEngNm[i] != null)
                    model.setVndrLglEngNm(vndrLglEngNm[i]);
                if (deltFlg[i] != null)
                    model.setDeltFlg(deltFlg[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (cnlAgnFlg[i] != null) 
		    		model.setCnlAgnFlg(cnlAgnFlg[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getVendorVOs();
    }

    public VendorVO[] getVendorVOs() {
        VendorVO[] vos = (VendorVO[]) models.toArray(new VendorVO[models.size()]);
        return vos;
    }

    public String toString() {
        StringBuffer ret = new StringBuffer();
        Field[] field = this.getClass().getDeclaredFields();
        String space = "";
        try {
            for (int i = 0; i < field.length; i++) {
                String[] arr = null;
                arr = getField(field, i);
                if (arr != null) {
                    for (int j = 0; j < arr.length; j++) {
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
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 * @throws IllegalAccessException
	 */
    private String[] getField(Field[] field, int i) throws IllegalAccessException {
        String[] arr;
        try {
            arr = (String[]) field[i].get(this);
        } catch (Exception ex) {
            arr = new String[1];
            arr[0] = String.valueOf(field[i].get(this));
        }
        return arr;
    }

    /**
	* DataFormat 설정
	*/
    public void onDataFormat() {
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrCntCd = this.vndrCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tcnt = this.tcnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrNm = this.vndrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ofcCd = this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrLglEngNm = this.vndrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.deltFlg = this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cnlAgnFlg = this.cnlAgnFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}

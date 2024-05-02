/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortTariffListVO.java
*@FileTitle : PortTariffListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.07.30 김진일 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.vo;

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
 * @author 김진일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class PortTariffListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<PortTariffListVO> models = new ArrayList<PortTariffListVO>();

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String updMnuNo = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String effDt = null;

    /* Column Info */
    private String ydCd = null;

    /* Column Info */
    private String ydChgVerSeq = null;

    /* Column Info */
    private String vndrSeq = null;

    /* Column Info */
    private String acctCd = null;

    /* Column Info */
    private String lgsCostCd = null;

    /* Column Info */
    private String vndrAbbrNm = null;

    /* Column Info */
    private String year = null;

    /* Column Info */
    private String ydChgNo = null;

    /* Column Info */
    private String portCd = null;

    /* Column Info */
    private String lgsCostFullNm = null;

    /* Column Info */
    private String acctEngNm = null;

    /* Column Info */
    private String currCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public PortTariffListVO() {
    }

    public PortTariffListVO(String ibflag, String pagerows, String ydCd, String acctCd, String lgsCostCd, String vndrSeq, String vndrAbbrNm, String ydChgNo, String ydChgVerSeq, String updMnuNo, String year, String portCd, String effDt, String lgsCostFullNm, String acctEngNm, String currCd) {
        this.pagerows = pagerows;
        this.updMnuNo = updMnuNo;
        this.ibflag = ibflag;
        this.effDt = effDt;
        this.ydCd = ydCd;
        this.ydChgVerSeq = ydChgVerSeq;
        this.vndrSeq = vndrSeq;
        this.acctCd = acctCd;
        this.lgsCostCd = lgsCostCd;
        this.vndrAbbrNm = vndrAbbrNm;
        this.year = year;
        this.ydChgNo = ydChgNo;
        this.portCd = portCd;
        this.lgsCostFullNm = lgsCostFullNm;
        this.acctEngNm = acctEngNm;
        this.currCd = currCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("upd_mnu_no", getUpdMnuNo());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("eff_dt", getEffDt());
        this.hashColumns.put("yd_cd", getYdCd());
        this.hashColumns.put("yd_chg_ver_seq", getYdChgVerSeq());
        this.hashColumns.put("vndr_seq", getVndrSeq());
        this.hashColumns.put("acct_cd", getAcctCd());
        this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
        this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
        this.hashColumns.put("year", getYear());
        this.hashColumns.put("yd_chg_no", getYdChgNo());
        this.hashColumns.put("port_cd", getPortCd());
        this.hashColumns.put("lgs_cost_full_nm", getLgsCostFullNm());
        this.hashColumns.put("acct_eng_nm", getAcctEngNm());
        this.hashColumns.put("curr_cd", getCurrCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("upd_mnu_no", "updMnuNo");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("eff_dt", "effDt");
        this.hashFields.put("yd_cd", "ydCd");
        this.hashFields.put("yd_chg_ver_seq", "ydChgVerSeq");
        this.hashFields.put("vndr_seq", "vndrSeq");
        this.hashFields.put("acct_cd", "acctCd");
        this.hashFields.put("lgs_cost_cd", "lgsCostCd");
        this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
        this.hashFields.put("year", "year");
        this.hashFields.put("yd_chg_no", "ydChgNo");
        this.hashFields.put("port_cd", "portCd");
        this.hashFields.put("lgs_cost_full_nm", "lgsCostFullNm");
        this.hashFields.put("acct_eng_nm", "acctEngNm");
        this.hashFields.put("curr_cd", "currCd");
        return this.hashFields;
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
	 * @return updMnuNo
	 */
    public String getUpdMnuNo() {
        return this.updMnuNo;
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
	 * @return effDt
	 */
    public String getEffDt() {
        return this.effDt;
    }

    /**
	 * Column Info
	 * @return ydCd
	 */
    public String getYdCd() {
        return this.ydCd;
    }

    /**
	 * Column Info
	 * @return ydChgVerSeq
	 */
    public String getYdChgVerSeq() {
        return this.ydChgVerSeq;
    }

    /**
	 * Column Info
	 * @return vndrSeq
	 */
    public String getVndrSeq() {
        return this.vndrSeq;
    }

    /**
	 * Column Info
	 * @return acctCd
	 */
    public String getAcctCd() {
        return this.acctCd;
    }

    /**
	 * Column Info
	 * @return lgsCostCd
	 */
    public String getLgsCostCd() {
        return this.lgsCostCd;
    }

    /**
	 * Column Info
	 * @return vndrAbbrNm
	 */
    public String getVndrAbbrNm() {
        return this.vndrAbbrNm;
    }

    /**
	 * Column Info
	 * @return year
	 */
    public String getYear() {
        return this.year;
    }

    /**
	 * Column Info
	 * @return ydChgNo
	 */
    public String getYdChgNo() {
        return this.ydChgNo;
    }

    /**
	 * Column Info
	 * @return portCd
	 */
    public String getPortCd() {
        return this.portCd;
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
	 * @param updMnuNo
	 */
    public void setUpdMnuNo(String updMnuNo) {
        this.updMnuNo = updMnuNo;
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
	 * @param effDt
	 */
    public void setEffDt(String effDt) {
        this.effDt = effDt;
    }

    /**
	 * Column Info
	 * @param ydCd
	 */
    public void setYdCd(String ydCd) {
        this.ydCd = ydCd;
    }

    /**
	 * Column Info
	 * @param ydChgVerSeq
	 */
    public void setYdChgVerSeq(String ydChgVerSeq) {
        this.ydChgVerSeq = ydChgVerSeq;
    }

    /**
	 * Column Info
	 * @param vndrSeq
	 */
    public void setVndrSeq(String vndrSeq) {
        this.vndrSeq = vndrSeq;
    }

    /**
	 * Column Info
	 * @param acctCd
	 */
    public void setAcctCd(String acctCd) {
        this.acctCd = acctCd;
    }

    /**
	 * Column Info
	 * @param lgsCostCd
	 */
    public void setLgsCostCd(String lgsCostCd) {
        this.lgsCostCd = lgsCostCd;
    }

    /**
	 * Column Info
	 * @param vndrAbbrNm
	 */
    public void setVndrAbbrNm(String vndrAbbrNm) {
        this.vndrAbbrNm = vndrAbbrNm;
    }

    /**
	 * Column Info
	 * @param year
	 */
    public void setYear(String year) {
        this.year = year;
    }

    /**
	 * Column Info
	 * @param ydChgNo
	 */
    public void setYdChgNo(String ydChgNo) {
        this.ydChgNo = ydChgNo;
    }

    /**
	 * Column Info
	 * @param portCd
	 */
    public void setPortCd(String portCd) {
        this.portCd = portCd;
    }

    public void setLgsCostFullNm(String lgsCostFullNm) {
        this.lgsCostFullNm = lgsCostFullNm;
    }

    public String getLgsCostFullNm() {
        return this.lgsCostFullNm;
    }

    public void setAcctEngNm(String acctEngNm) {
        this.acctEngNm = acctEngNm;
    }

    public String getAcctEngNm() {
        return this.acctEngNm;
    }

    public void setCurrCd(String currCd) {
        this.currCd = currCd;
    }

    public String getCurrCd() {
        return this.currCd;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setUpdMnuNo(JSPUtil.getParameter(request, "upd_mnu_no", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
        setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
        setYdChgVerSeq(JSPUtil.getParameter(request, "yd_chg_ver_seq", ""));
        setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
        setAcctCd(JSPUtil.getParameter(request, "acct_cd", ""));
        setLgsCostCd(JSPUtil.getParameter(request, "lgs_cost_cd", ""));
        setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
        setYear(JSPUtil.getParameter(request, "year", ""));
        setYdChgNo(JSPUtil.getParameter(request, "yd_chg_no", ""));
        setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
        setLgsCostFullNm(JSPUtil.getParameter(request, "lgs_cost_full_nm", ""));
        setAcctEngNm(JSPUtil.getParameter(request, "acct_eng_nm", ""));
        setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PortTariffListVO[]
	 */
    public PortTariffListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PortTariffListVO[]
	 */
    public PortTariffListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        PortTariffListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] updMnuNo = (JSPUtil.getParameter(request, prefix + "upd_mnu_no", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] effDt = (JSPUtil.getParameter(request, prefix + "eff_dt", length));
            String[] ydCd = (JSPUtil.getParameter(request, prefix + "yd_cd", length));
            String[] ydChgVerSeq = (JSPUtil.getParameter(request, prefix + "yd_chg_ver_seq", length));
            String[] vndrSeq = (JSPUtil.getParameter(request, prefix + "vndr_seq", length));
            String[] acctCd = (JSPUtil.getParameter(request, prefix + "acct_cd", length));
            String[] lgsCostCd = (JSPUtil.getParameter(request, prefix + "lgs_cost_cd", length));
            String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix + "vndr_abbr_nm", length));
            String[] year = (JSPUtil.getParameter(request, prefix + "year", length));
            String[] ydChgNo = (JSPUtil.getParameter(request, prefix + "yd_chg_no", length));
            String[] portCd = (JSPUtil.getParameter(request, prefix + "port_cd", length));
            String[] lgsCostFullNm = (JSPUtil.getParameter(request, prefix + "lgs_cost_full_nm", length));
            String[] acctEngNm = (JSPUtil.getParameter(request, prefix + "acct_eng_nm", length));
            String[] currCd = (JSPUtil.getParameter(request, prefix + "curr_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new PortTariffListVO();
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (updMnuNo[i] != null)
                    model.setUpdMnuNo(updMnuNo[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (effDt[i] != null)
                    model.setEffDt(effDt[i]);
                if (ydCd[i] != null)
                    model.setYdCd(ydCd[i]);
                if (ydChgVerSeq[i] != null)
                    model.setYdChgVerSeq(ydChgVerSeq[i]);
                if (vndrSeq[i] != null)
                    model.setVndrSeq(vndrSeq[i]);
                if (acctCd[i] != null)
                    model.setAcctCd(acctCd[i]);
                if (lgsCostCd[i] != null)
                    model.setLgsCostCd(lgsCostCd[i]);
                if (vndrAbbrNm[i] != null)
                    model.setVndrAbbrNm(vndrAbbrNm[i]);
                if (year[i] != null)
                    model.setYear(year[i]);
                if (ydChgNo[i] != null)
                    model.setYdChgNo(ydChgNo[i]);
                if (portCd[i] != null)
                    model.setPortCd(portCd[i]);
                if (lgsCostFullNm[i] != null)
                    model.setLgsCostFullNm(lgsCostFullNm[i]);
                if (acctEngNm[i] != null)
                    model.setAcctEngNm(acctEngNm[i]);
                if (currCd[i] != null) 
		    		model.setCurrCd(currCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getPortTariffListVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return PortTariffListVO[]
	 */
    public PortTariffListVO[] getPortTariffListVOs() {
        PortTariffListVO[] vos = (PortTariffListVO[]) models.toArray(new PortTariffListVO[models.size()]);
        return vos;
    }

    /**
	 * VO Class의 내용을 String으로 변환
	 */
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
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
    private String[] getField(Field[] field, int i) {
        String[] arr = null;
        try {
            arr = (String[]) field[i].get(this);
        } catch (Exception ex) {
            arr = null;
        }
        return arr;
    }

    /**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
    public void unDataFormat() {
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.updMnuNo = this.updMnuNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.effDt = this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydCd = this.ydCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydChgVerSeq = this.ydChgVerSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrSeq = this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctCd = this.acctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lgsCostCd = this.lgsCostCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vndrAbbrNm = this.vndrAbbrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.year = this.year.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ydChgNo = this.ydChgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portCd = this.portCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lgsCostFullNm = this.lgsCostFullNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.acctEngNm = this.acctEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.currCd = this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}
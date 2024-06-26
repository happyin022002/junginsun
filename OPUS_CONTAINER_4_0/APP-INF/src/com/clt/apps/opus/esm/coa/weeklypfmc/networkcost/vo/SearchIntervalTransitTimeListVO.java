/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchIntervalTransitTimeListVO.java
*@FileTitle : SearchIntervalTransitTimeListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.10.15 김기대 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.networkcost.vo;

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
 * @author 김기대
 * @since J2EE 1.6
 * @see AbstractValueObject 
 */
public class SearchIntervalTransitTimeListVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<SearchIntervalTransitTimeListVO> models = new ArrayList<SearchIntervalTransitTimeListVO>();

    /* Column Info */
    private String portDys = null;

    /* Column Info */
    private String iocCd = null;

    /* Column Info */
    private String vslCd = null;

    /* Column Info */
    private String vvdRmk = null;

    /* Column Info */
    private String skdVoyNo = null;

    /* Column Info */
    private String trdCd = null;

    /* Column Info */
    private String rlaneCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String seaDys = null;

    /* Column Info */
    private String aplyVoyRto = null;

    /* Column Info */
    private String clptSeq = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String locCd = null;

    /* Column Info */
    private String vslDblCallSeq = null;

    /* Column Info */
    private String slanCd = null;

    /* Column Info */
    private String ttlTzDys = null;

    /* Column Info */
    private String contiNm = null;

    /* Column Info */
    private String dirCd = null;

    /* Column Info */
    private String costYrwk = null;

    /* Column Info */
    private String pndlmRto = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public SearchIntervalTransitTimeListVO() {
    }

    public SearchIntervalTransitTimeListVO(String ibflag, String pagerows, String costYrwk, String vslCd, String skdVoyNo, String dirCd, String contiNm, String slanCd, String trdCd, String rlaneCd, String iocCd, String locCd, String vslDblCallSeq, String clptSeq, String portDys, String seaDys, String ttlTzDys, String aplyVoyRto, String vvdRmk, String pndlmRto) {
        this.portDys = portDys;
        this.iocCd = iocCd;
        this.vslCd = vslCd;
        this.vvdRmk = vvdRmk;
        this.skdVoyNo = skdVoyNo;
        this.trdCd = trdCd;
        this.rlaneCd = rlaneCd;
        this.pagerows = pagerows;
        this.seaDys = seaDys;
        this.aplyVoyRto = aplyVoyRto;
        this.clptSeq = clptSeq;
        this.ibflag = ibflag;
        this.locCd = locCd;
        this.vslDblCallSeq = vslDblCallSeq;
        this.slanCd = slanCd;
        this.ttlTzDys = ttlTzDys;
        this.contiNm = contiNm;
        this.dirCd = dirCd;
        this.costYrwk = costYrwk;
        this.pndlmRto = pndlmRto;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("port_dys", getPortDys());
        this.hashColumns.put("ioc_cd", getIocCd());
        this.hashColumns.put("vsl_cd", getVslCd());
        this.hashColumns.put("vvd_rmk", getVvdRmk());
        this.hashColumns.put("skd_voy_no", getSkdVoyNo());
        this.hashColumns.put("trd_cd", getTrdCd());
        this.hashColumns.put("rlane_cd", getRlaneCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("sea_dys", getSeaDys());
        this.hashColumns.put("aply_voy_rto", getAplyVoyRto());
        this.hashColumns.put("clpt_seq", getClptSeq());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("loc_cd", getLocCd());
        this.hashColumns.put("vsl_dbl_call_seq", getVslDblCallSeq());
        this.hashColumns.put("slan_cd", getSlanCd());
        this.hashColumns.put("ttl_tz_dys", getTtlTzDys());
        this.hashColumns.put("conti_nm", getContiNm());
        this.hashColumns.put("dir_cd", getDirCd());
        this.hashColumns.put("cost_yrwk", getCostYrwk());
        this.hashColumns.put("pndlm_rto", getPndlmRto());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("port_dys", "portDys");
        this.hashFields.put("ioc_cd", "iocCd");
        this.hashFields.put("vsl_cd", "vslCd");
        this.hashFields.put("vvd_rmk", "vvdRmk");
        this.hashFields.put("skd_voy_no", "skdVoyNo");
        this.hashFields.put("trd_cd", "trdCd");
        this.hashFields.put("rlane_cd", "rlaneCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("sea_dys", "seaDys");
        this.hashFields.put("aply_voy_rto", "aplyVoyRto");
        this.hashFields.put("clpt_seq", "clptSeq");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("loc_cd", "locCd");
        this.hashFields.put("vsl_dbl_call_seq", "vslDblCallSeq");
        this.hashFields.put("slan_cd", "slanCd");
        this.hashFields.put("ttl_tz_dys", "ttlTzDys");
        this.hashFields.put("conti_nm", "contiNm");
        this.hashFields.put("dir_cd", "dirCd");
        this.hashFields.put("cost_yrwk", "costYrwk");
        this.hashFields.put("pndlm_rto", "pndlmRto");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return portDys
	 */
    public String getPortDys() {
        return this.portDys;
    }

    /**
	 * Column Info
	 * @return iocCd
	 */
    public String getIocCd() {
        return this.iocCd;
    }

    /**
	 * Column Info
	 * @return vslCd
	 */
    public String getVslCd() {
        return this.vslCd;
    }

    /**
	 * Column Info
	 * @return vvdRmk
	 */
    public String getVvdRmk() {
        return this.vvdRmk;
    }

    /**
	 * Column Info
	 * @return skdVoyNo
	 */
    public String getSkdVoyNo() {
        return this.skdVoyNo;
    }

    /**
	 * Column Info
	 * @return trdCd
	 */
    public String getTrdCd() {
        return this.trdCd;
    }

    /**
	 * Column Info
	 * @return rlaneCd
	 */
    public String getRlaneCd() {
        return this.rlaneCd;
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
	 * @return seaDys
	 */
    public String getSeaDys() {
        return this.seaDys;
    }

    /**
	 * Column Info
	 * @return aplyVoyRto
	 */
    public String getAplyVoyRto() {
        return this.aplyVoyRto;
    }

    /**
	 * Column Info
	 * @return clptSeq
	 */
    public String getClptSeq() {
        return this.clptSeq;
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
	 * @return locCd
	 */
    public String getLocCd() {
        return this.locCd;
    }

    /**
	 * Column Info
	 * @return vslDblCallSeq
	 */
    public String getVslDblCallSeq() {
        return this.vslDblCallSeq;
    }

    /**
	 * Column Info
	 * @return slanCd
	 */
    public String getSlanCd() {
        return this.slanCd;
    }

    /**
	 * Column Info
	 * @return ttlTzDys
	 */
    public String getTtlTzDys() {
        return this.ttlTzDys;
    }

    /**
	 * Column Info
	 * @return contiNm
	 */
    public String getContiNm() {
        return this.contiNm;
    }

    /**
	 * Column Info
	 * @return dirCd
	 */
    public String getDirCd() {
        return this.dirCd;
    }

    /**
	 * Column Info
	 * @return costYrwk
	 */
    public String getCostYrwk() {
        return this.costYrwk;
    }

    /**
	 * Column Info
	 * @param portDys
	 */
    public void setPortDys(String portDys) {
        this.portDys = portDys;
    }

    /**
	 * Column Info
	 * @param iocCd
	 */
    public void setIocCd(String iocCd) {
        this.iocCd = iocCd;
    }

    /**
	 * Column Info
	 * @param vslCd
	 */
    public void setVslCd(String vslCd) {
        this.vslCd = vslCd;
    }

    /**
	 * Column Info
	 * @param vvdRmk
	 */
    public void setVvdRmk(String vvdRmk) {
        this.vvdRmk = vvdRmk;
    }

    /**
	 * Column Info
	 * @param skdVoyNo
	 */
    public void setSkdVoyNo(String skdVoyNo) {
        this.skdVoyNo = skdVoyNo;
    }

    /**
	 * Column Info
	 * @param trdCd
	 */
    public void setTrdCd(String trdCd) {
        this.trdCd = trdCd;
    }

    /**
	 * Column Info
	 * @param rlaneCd
	 */
    public void setRlaneCd(String rlaneCd) {
        this.rlaneCd = rlaneCd;
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
	 * @param seaDys
	 */
    public void setSeaDys(String seaDys) {
        this.seaDys = seaDys;
    }

    /**
	 * Column Info
	 * @param aplyVoyRto
	 */
    public void setAplyVoyRto(String aplyVoyRto) {
        this.aplyVoyRto = aplyVoyRto;
    }

    /**
	 * Column Info
	 * @param clptSeq
	 */
    public void setClptSeq(String clptSeq) {
        this.clptSeq = clptSeq;
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
	 * @param locCd
	 */
    public void setLocCd(String locCd) {
        this.locCd = locCd;
    }

    /**
	 * Column Info
	 * @param vslDblCallSeq
	 */
    public void setVslDblCallSeq(String vslDblCallSeq) {
        this.vslDblCallSeq = vslDblCallSeq;
    }

    /**
	 * Column Info
	 * @param slanCd
	 */
    public void setSlanCd(String slanCd) {
        this.slanCd = slanCd;
    }

    /**
	 * Column Info
	 * @param ttlTzDys
	 */
    public void setTtlTzDys(String ttlTzDys) {
        this.ttlTzDys = ttlTzDys;
    }

    /**
	 * Column Info
	 * @param contiNm
	 */
    public void setContiNm(String contiNm) {
        this.contiNm = contiNm;
    }

    /**
	 * Column Info
	 * @param dirCd
	 */
    public void setDirCd(String dirCd) {
        this.dirCd = dirCd;
    }

    /**
	 * Column Info
	 * @param costYrwk
	 */
    public void setCostYrwk(String costYrwk) {
        this.costYrwk = costYrwk;
    }

    public void setPndlmRto(String pndlmRto) {
        this.pndlmRto = pndlmRto;
    }

    public String getPndlmRto() {
        return this.pndlmRto;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setPortDys(JSPUtil.getParameter(request, "port_dys", ""));
        setIocCd(JSPUtil.getParameter(request, "ioc_cd", ""));
        setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
        setVvdRmk(JSPUtil.getParameter(request, "vvd_rmk", ""));
        setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
        setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
        setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setSeaDys(JSPUtil.getParameter(request, "sea_dys", ""));
        setAplyVoyRto(JSPUtil.getParameter(request, "aply_voy_rto", ""));
        setClptSeq(JSPUtil.getParameter(request, "clpt_seq", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
        setVslDblCallSeq(JSPUtil.getParameter(request, "vsl_dbl_call_seq", ""));
        setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
        setTtlTzDys(JSPUtil.getParameter(request, "ttl_tz_dys", ""));
        setContiNm(JSPUtil.getParameter(request, "conti_nm", ""));
        setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
        setCostYrwk(JSPUtil.getParameter(request, "cost_yrwk", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchIntervalTransitTimeListVO[]
	 */
    public SearchIntervalTransitTimeListVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchIntervalTransitTimeListVO[]
	 */
    public SearchIntervalTransitTimeListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        SearchIntervalTransitTimeListVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] portDys = (JSPUtil.getParameter(request, prefix + "port_dys", length));
            String[] iocCd = (JSPUtil.getParameter(request, prefix + "ioc_cd", length));
            String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
            String[] vvdRmk = (JSPUtil.getParameter(request, prefix + "vvd_rmk", length));
            String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
            String[] trdCd = (JSPUtil.getParameter(request, prefix + "trd_cd", length));
            String[] rlaneCd = (JSPUtil.getParameter(request, prefix + "rlane_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] seaDys = (JSPUtil.getParameter(request, prefix + "sea_dys", length));
            String[] aplyVoyRto = (JSPUtil.getParameter(request, prefix + "aply_voy_rto", length));
            String[] clptSeq = (JSPUtil.getParameter(request, prefix + "clpt_seq", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] locCd = (JSPUtil.getParameter(request, prefix + "loc_cd", length));
            String[] vslDblCallSeq = (JSPUtil.getParameter(request, prefix + "vsl_dbl_call_seq", length));
            String[] slanCd = (JSPUtil.getParameter(request, prefix + "slan_cd", length));
            String[] ttlTzDys = (JSPUtil.getParameter(request, prefix + "ttl_tz_dys", length));
            String[] contiNm = (JSPUtil.getParameter(request, prefix + "conti_nm", length));
            String[] dirCd = (JSPUtil.getParameter(request, prefix + "dir_cd", length));
            String[] costYrwk = (JSPUtil.getParameter(request, prefix + "cost_yrwk", length));
            for (int i = 0; i < length; i++) {
                model = new SearchIntervalTransitTimeListVO();
                if (portDys[i] != null)
                    model.setPortDys(portDys[i]);
                if (iocCd[i] != null)
                    model.setIocCd(iocCd[i]);
                if (vslCd[i] != null)
                    model.setVslCd(vslCd[i]);
                if (vvdRmk[i] != null)
                    model.setVvdRmk(vvdRmk[i]);
                if (skdVoyNo[i] != null)
                    model.setSkdVoyNo(skdVoyNo[i]);
                if (trdCd[i] != null)
                    model.setTrdCd(trdCd[i]);
                if (rlaneCd[i] != null)
                    model.setRlaneCd(rlaneCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (seaDys[i] != null)
                    model.setSeaDys(seaDys[i]);
                if (aplyVoyRto[i] != null)
                    model.setAplyVoyRto(aplyVoyRto[i]);
                if (clptSeq[i] != null)
                    model.setClptSeq(clptSeq[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (locCd[i] != null)
                    model.setLocCd(locCd[i]);
                if (vslDblCallSeq[i] != null)
                    model.setVslDblCallSeq(vslDblCallSeq[i]);
                if (slanCd[i] != null)
                    model.setSlanCd(slanCd[i]);
                if (ttlTzDys[i] != null)
                    model.setTtlTzDys(ttlTzDys[i]);
                if (contiNm[i] != null)
                    model.setContiNm(contiNm[i]);
                if (dirCd[i] != null)
                    model.setDirCd(dirCd[i]);
                if (costYrwk[i] != null)
                    model.setCostYrwk(costYrwk[i]);
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getSearchIntervalTransitTimeListVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return SearchIntervalTransitTimeListVO[]
	 */
    public SearchIntervalTransitTimeListVO[] getSearchIntervalTransitTimeListVOs() {
        SearchIntervalTransitTimeListVO[] vos = (SearchIntervalTransitTimeListVO[]) models.toArray(new SearchIntervalTransitTimeListVO[models.size()]);
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
        this.portDys = this.portDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.iocCd = this.iocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCd = this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvdRmk = this.vvdRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.skdVoyNo = this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.trdCd = this.trdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.rlaneCd = this.rlaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.seaDys = this.seaDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aplyVoyRto = this.aplyVoyRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.clptSeq = this.clptSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locCd = this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslDblCallSeq = this.vslDblCallSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.slanCd = this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ttlTzDys = this.ttlTzDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.contiNm = this.contiNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.dirCd = this.dirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.costYrwk = this.costYrwk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pndlmRto = this.pndlmRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}

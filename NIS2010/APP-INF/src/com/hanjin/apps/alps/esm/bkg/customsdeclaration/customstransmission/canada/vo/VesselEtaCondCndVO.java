/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselEtaCondCndVO.java
*@FileTitle : VesselEtaCondCndCndVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.08  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김도완
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class VesselEtaCondCndVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<VesselEtaCondCndVO> models = new ArrayList<VesselEtaCondCndVO>();

    /* Column Info */
    private String vvd = null;

    /* Column Info */
    private String lastpol = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String sndDt = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String vpsPortCd = null;

    /* Column Info */
    private String lpolClptIndSeq = null;

    /* Column Info */
    private String hiddenVvd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public VesselEtaCondCndVO() {
    }

    public VesselEtaCondCndVO(String ibflag, String pagerows, String lastpol, String vvd, String sndDt, String vpsPortCd, String lpolClptIndSeq, String hiddenVvd) {
        this.vvd = vvd;
        this.lastpol = lastpol;
        this.ibflag = ibflag;
        this.sndDt = sndDt;
        this.pagerows = pagerows;
        this.vpsPortCd = vpsPortCd;
        this.lpolClptIndSeq = lpolClptIndSeq;
        this.hiddenVvd = hiddenVvd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("lastpol", getLastpol());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("snd_dt", getSndDt());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("vps_port_cd", getVpsPortCd());
        this.hashColumns.put("lpol_clpt_ind_seq", getLpolClptIndSeq());
        this.hashColumns.put("hidden_vvd", getHiddenVvd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("lastpol", "lastpol");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("snd_dt", "sndDt");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("vps_port_cd", "vpsPortCd");
        this.hashFields.put("lpol_clpt_ind_seq", "lpolClptIndSeq");
        this.hashFields.put("hidden_vvd", "hiddenVvd");
        return this.hashFields;
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
	 * @return lastpol
	 */
    public String getLastpol() {
        return this.lastpol;
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
	 * @return sndDt
	 */
    public String getSndDt() {
        return this.sndDt;
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
	 * @param vvd
	 */
    public void setVvd(String vvd) {
        this.vvd = vvd;
    }

    /**
	 * Column Info
	 * @param lastpol
	 */
    public void setLastpol(String lastpol) {
        this.lastpol = lastpol;
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
	 * @param sndDt
	 */
    public void setSndDt(String sndDt) {
        this.sndDt = sndDt;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setVpsPortCd(String vpsPortCd) {
        this.vpsPortCd = vpsPortCd;
    }

    public String getVpsPortCd() {
        return this.vpsPortCd;
    }

    public void setLpolClptIndSeq(String lpolClptIndSeq) {
        this.lpolClptIndSeq = lpolClptIndSeq;
    }

    public String getLpolClptIndSeq() {
        return this.lpolClptIndSeq;
    }

    public void setHiddenVvd(String hiddenVvd) {
        this.hiddenVvd = hiddenVvd;
    }

    public String getHiddenVvd() {
        return this.hiddenVvd;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        fromRequest(request, "");
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
        setLastpol(JSPUtil.getParameter(request, prefix + "lastpol", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setSndDt(JSPUtil.getParameter(request, prefix + "snd_dt", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
        setLpolClptIndSeq(JSPUtil.getParameter(request, prefix + "lpol_clpt_ind_seq", ""));
        setHiddenVvd(JSPUtil.getParameter(request, prefix + "hidden_vvd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VesselEtaCondCndVO[]
	 */
    public VesselEtaCondCndVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VesselEtaCondCndVO[]
	 */
    public VesselEtaCondCndVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        VesselEtaCondCndVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd", length));
            String[] lastpol = (JSPUtil.getParameter(request, prefix + "lastpol", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] sndDt = (JSPUtil.getParameter(request, prefix + "snd_dt", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] vpsPortCd = (JSPUtil.getParameter(request, prefix + "vps_port_cd", length));
	    	String[] lpolClptIndSeq = (JSPUtil.getParameter(request, prefix + "lpol_clpt_ind_seq", length));
	    	String[] hiddenVvd = (JSPUtil.getParameter(request, prefix + "hidden_vvd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new VesselEtaCondCndVO();
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (lastpol[i] != null)
                    model.setLastpol(lastpol[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (sndDt[i] != null)
                    model.setSndDt(sndDt[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (vpsPortCd[i] != null) 
		    		model.setVpsPortCd(vpsPortCd[i]);
				if (lpolClptIndSeq[i] != null) 
		    		model.setLpolClptIndSeq(lpolClptIndSeq[i]);
				if (hiddenVvd[i] != null) 
		    		model.setHiddenVvd(hiddenVvd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getVesselEtaCondCndVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return VesselEtaCondCndVO[]
	 */
    public VesselEtaCondCndVO[] getVesselEtaCondCndVOs() {
        VesselEtaCondCndVO[] vos = (VesselEtaCondCndVO[]) models.toArray(new VesselEtaCondCndVO[models.size()]);
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
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lastpol = this.lastpol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.sndDt = this.sndDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vpsPortCd = this.vpsPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.lpolClptIndSeq = this.lpolClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hiddenVvd = this.hiddenVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}

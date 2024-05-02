/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MalaysiaManifestVslInfoVO.java
*@FileTitle : MalaysiaManifestVslInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.09
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.09  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class MalaysiaManifestVslInfoVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<MalaysiaManifestVslInfoVO> models = new ArrayList<MalaysiaManifestVslInfoVO>();

    /* Column Info */
    private String port = null;

    /* Column Info */
    private String vvd = null;

    /* Column Info */
    private String eta = null;

    /* Column Info */
    private String vslFullname = null;

    /* Column Info */
    private String portNm = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String status = null;

    /* Column Info */
    private String etd = null;

    /* Column Info */
    private String vslNationCd = null;

    /* Column Info */
    private String eIInd = null;

    /* Column Info */
    private String vslAuthNo = null;

    /* Column Info */
    private String tsTpCd = null;

    /* Column Info */
    private String vslCallNo = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String vslId = null;

    /* Column Info */
    private String customsStationCd = null;

    /* Column Info */
    private String terminalOpCd = null;

    /* Column Info */
    private String preVvd = null;

    /* Column Info */
    private String prePolCd = null;

    /* Column Info */
    private String prePodCd = null;

    /* Column Info */
    private String nextVvd = null;

    /* Column Info */
    private String nextPolCd = null;

    /* Column Info */
    private String nextPodCd = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public MalaysiaManifestVslInfoVO() {
    }

    public MalaysiaManifestVslInfoVO(String ibflag, String pagerows, String eIInd, String tsTpCd, String status, String vvd, String vslFullname, String vslAuthNo, String vslNationCd, String port, String portNm, String eta, String etd, String vslCallNo, String vslId, String customsStationCd, String terminalOpCd, String preVvd, String prePolCd, String prePodCd, String nextVvd, String nextPolCd, String nextPodCd) {
        this.port = port;
        this.vvd = vvd;
        this.eta = eta;
        this.vslFullname = vslFullname;
        this.portNm = portNm;
        this.ibflag = ibflag;
        this.status = status;
        this.etd = etd;
        this.vslNationCd = vslNationCd;
        this.eIInd = eIInd;
        this.vslAuthNo = vslAuthNo;
        this.pagerows = pagerows;
        this.tsTpCd = tsTpCd;
        this.vslCallNo = vslCallNo;
        this.vslId = vslId;
        this.customsStationCd = customsStationCd;
        this.terminalOpCd = terminalOpCd;
        this.preVvd = preVvd;
        this.prePolCd = prePolCd;
        this.prePodCd = prePodCd;
        this.nextVvd = nextVvd;
        this.nextPolCd = nextPolCd;
        this.nextPodCd = nextPodCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("port", getPort());
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("eta", getEta());
        this.hashColumns.put("vsl_fullname", getVslFullname());
        this.hashColumns.put("port_nm", getPortNm());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("status", getStatus());
        this.hashColumns.put("etd", getEtd());
        this.hashColumns.put("vsl_nation_cd", getVslNationCd());
        this.hashColumns.put("e_i_ind", getEIInd());
        this.hashColumns.put("vsl_auth_no", getVslAuthNo());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("ts_tp_cd", getTsTpCd());
        this.hashColumns.put("vsl_call_no", getVslCallNo());
        this.hashColumns.put("vsl_id", getVslId());
        this.hashColumns.put("customs_station_cd", getCustomsStationCd());
        this.hashColumns.put("terminal_op_cd", getTerminalOpCd());
        this.hashColumns.put("pre_vvd", getPreVvd());
        this.hashColumns.put("pre_pol_cd", getPrePolCd());
        this.hashColumns.put("pre_pod_cd", getPrePodCd());
        this.hashColumns.put("next_vvd", getNextVvd());
        this.hashColumns.put("next_pol_cd", getNextPolCd());
        this.hashColumns.put("next_pod_cd", getNextPodCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("port", "port");
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("eta", "eta");
        this.hashFields.put("vsl_fullname", "vslFullname");
        this.hashFields.put("port_nm", "portNm");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("status", "status");
        this.hashFields.put("etd", "etd");
        this.hashFields.put("vsl_nation_cd", "vslNationCd");
        this.hashFields.put("e_i_ind", "eIInd");
        this.hashFields.put("vsl_auth_no", "vslAuthNo");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("ts_tp_cd", "tsTpCd");
        this.hashFields.put("vsl_call_no", "vslCallNo");
        this.hashFields.put("vsl_id", "vslId");
        this.hashFields.put("customs_station_cd", "customsStationCd");
        this.hashFields.put("terminal_op_cd", "terminalOpCd");
        this.hashFields.put("pre_vvd", "preVvd");
        this.hashFields.put("pre_pol_cd", "prePolCd");
        this.hashFields.put("pre_pod_cd", "prePodCd");
        this.hashFields.put("next_vvd", "nextVvd");
        this.hashFields.put("next_pol_cd", "nextPolCd");
        this.hashFields.put("next_pod_cd", "nextPodCd");
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
	 * @return vvd
	 */
    public String getVvd() {
        return this.vvd;
    }

    /**
	 * Column Info
	 * @return eta
	 */
    public String getEta() {
        return this.eta;
    }

    /**
	 * Column Info
	 * @return vslFullname
	 */
    public String getVslFullname() {
        return this.vslFullname;
    }

    /**
	 * Column Info
	 * @return portNm
	 */
    public String getPortNm() {
        return this.portNm;
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
	 * @return status
	 */
    public String getStatus() {
        return this.status;
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
	 * @return vslNationCd
	 */
    public String getVslNationCd() {
        return this.vslNationCd;
    }

    /**
	 * Column Info
	 * @return eIInd
	 */
    public String getEIInd() {
        return this.eIInd;
    }

    /**
	 * Column Info
	 * @return vslAuthNo
	 */
    public String getVslAuthNo() {
        return this.vslAuthNo;
    }

    /**
	 * Page Number
	 * @return pagerows
	 */
    public String getPagerows() {
        return this.pagerows;
    }

    /**
	 * Page Number
	 * @return tsTpCd
	 */
    public String getTsTpCd() {
        return this.tsTpCd;
    }

    /**
	 * Column Info
	 * @return vslCallNo
	 */
    public String getVslCallNo() {
        return this.vslCallNo;
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
	 * @param vvd
	 */
    public void setVvd(String vvd) {
        this.vvd = vvd;
    }

    /**
	 * Column Info
	 * @param eta
	 */
    public void setEta(String eta) {
        this.eta = eta;
    }

    /**
	 * Column Info
	 * @param vslFullname
	 */
    public void setVslFullname(String vslFullname) {
        this.vslFullname = vslFullname;
    }

    /**
	 * Column Info
	 * @param portNm
	 */
    public void setPortNm(String portNm) {
        this.portNm = portNm;
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
	 * @param status
	 */
    public void setStatus(String status) {
        this.status = status;
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
	 * @param vslNationCd
	 */
    public void setVslNationCd(String vslNationCd) {
        this.vslNationCd = vslNationCd;
    }

    /**
	 * Column Info
	 * @param eIInd
	 */
    public void setEIInd(String eIInd) {
        this.eIInd = eIInd;
    }

    /**
	 * Column Info
	 * @param vslAuthNo
	 */
    public void setVslAuthNo(String vslAuthNo) {
        this.vslAuthNo = vslAuthNo;
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
	 * @param tsTpCd
	 */
    public void setTsTpCd(String tsTpCd) {
        this.tsTpCd = tsTpCd;
    }

    /**
	 * Column Info
	 * @param vslCallNo
	 */
    public void setVslCallNo(String vslCallNo) {
        this.vslCallNo = vslCallNo;
    }

    public void setVslId(String vslId) {
        this.vslId = vslId;
    }

    public String getVslId() {
        return this.vslId;
    }

    public void setCustomsStationCd(String customsStationCd) {
        this.customsStationCd = customsStationCd;
    }

    public String getCustomsStationCd() {
        return this.customsStationCd;
    }

    public void setTerminalOpCd(String terminalOpCd) {
        this.terminalOpCd = terminalOpCd;
    }

    public String getTerminalOpCd() {
        return this.terminalOpCd;
    }

    public void setPreVvd(String preVvd) {
        this.preVvd = preVvd;
    }

    public String getPreVvd() {
        return this.preVvd;
    }

    public void setPrePolCd(String prePolCd) {
        this.prePolCd = prePolCd;
    }

    public String getPrePolCd() {
        return this.prePolCd;
    }

    public void setPrePodCd(String prePodCd) {
        this.prePodCd = prePodCd;
    }

    public String getPrePodCd() {
        return this.prePodCd;
    }

    public void setNextVvd(String nextVvd) {
        this.nextVvd = nextVvd;
    }

    public String getNextVvd() {
        return this.nextVvd;
    }

    public void setNextPolCd(String nextPolCd) {
        this.nextPolCd = nextPolCd;
    }

    public String getNextPolCd() {
        return this.nextPolCd;
    }

    public void setNextPodCd(String nextPodCd) {
        this.nextPodCd = nextPodCd;
    }

    public String getNextPodCd() {
        return this.nextPodCd;
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
        setPort(JSPUtil.getParameter(request, prefix + "port", ""));
        setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
        setEta(JSPUtil.getParameter(request, prefix + "eta", ""));
        setVslFullname(JSPUtil.getParameter(request, prefix + "vsl_fullname", ""));
        setPortNm(JSPUtil.getParameter(request, prefix + "port_nm", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
        setEtd(JSPUtil.getParameter(request, prefix + "etd", ""));
        setVslNationCd(JSPUtil.getParameter(request, prefix + "vsl_nation_cd", ""));
        setEIInd(JSPUtil.getParameter(request, prefix + "e_i_ind", ""));
        setVslAuthNo(JSPUtil.getParameter(request, prefix + "vsl_auth_no", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setTsTpCd(JSPUtil.getParameter(request, prefix + "ts_tp_cd", ""));
        setVslCallNo(JSPUtil.getParameter(request, prefix + "vsl_call_no", ""));
        setVslId(JSPUtil.getParameter(request, prefix + "vsl_id", ""));
        setCustomsStationCd(JSPUtil.getParameter(request, prefix + "customs_station_cd", ""));
        setTerminalOpCd(JSPUtil.getParameter(request, prefix + "terminal_op_cd", ""));
        setPreVvd(JSPUtil.getParameter(request, prefix + "pre_vvd", ""));
        setPrePolCd(JSPUtil.getParameter(request, prefix + "pre_pol_cd", ""));
        setPrePodCd(JSPUtil.getParameter(request, prefix + "pre_pod_cd", ""));
        setNextVvd(JSPUtil.getParameter(request, prefix + "next_vvd", ""));
        setNextPolCd(JSPUtil.getParameter(request, prefix + "next_pol_cd", ""));
        setNextPodCd(JSPUtil.getParameter(request, prefix + "next_pod_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MalaysiaManifestVslInfoVO[]
	 */
    public MalaysiaManifestVslInfoVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MalaysiaManifestVslInfoVO[]
	 */
    public MalaysiaManifestVslInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        MalaysiaManifestVslInfoVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] port = (JSPUtil.getParameter(request, prefix + "port", length));
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd", length));
            String[] eta = (JSPUtil.getParameter(request, prefix + "eta", length));
            String[] vslFullname = (JSPUtil.getParameter(request, prefix + "vsl_fullname", length));
            String[] portNm = (JSPUtil.getParameter(request, prefix + "port_nm", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] status = (JSPUtil.getParameter(request, prefix + "status", length));
            String[] etd = (JSPUtil.getParameter(request, prefix + "etd", length));
            String[] vslNationCd = (JSPUtil.getParameter(request, prefix + "vsl_nation_cd", length));
            String[] eIInd = (JSPUtil.getParameter(request, prefix + "e_i_ind", length));
            String[] vslAuthNo = (JSPUtil.getParameter(request, prefix + "vsl_auth_no", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] tsTpCd = (JSPUtil.getParameter(request, prefix + "ts_tp_cd", length));
            String[] vslCallNo = (JSPUtil.getParameter(request, prefix + "vsl_call_no", length));
            String[] vslId = (JSPUtil.getParameter(request, prefix + "vsl_id", length));
            String[] customsStationCd = (JSPUtil.getParameter(request, prefix + "customs_station_cd", length));
            String[] terminalOpCd = (JSPUtil.getParameter(request, prefix + "terminal_op_cd", length));
            String[] preVvd = (JSPUtil.getParameter(request, prefix + "pre_vvd", length));
	    	String[] prePolCd = (JSPUtil.getParameter(request, prefix + "pre_pol_cd", length));
	    	String[] prePodCd = (JSPUtil.getParameter(request, prefix + "pre_pod_cd", length));
	    	String[] nextVvd = (JSPUtil.getParameter(request, prefix + "next_vvd", length));
	    	String[] nextPolCd = (JSPUtil.getParameter(request, prefix + "next_pol_cd", length));
	    	String[] nextPodCd = (JSPUtil.getParameter(request, prefix + "next_pod_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new MalaysiaManifestVslInfoVO();
                if (port[i] != null)
                    model.setPort(port[i]);
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (eta[i] != null)
                    model.setEta(eta[i]);
                if (vslFullname[i] != null)
                    model.setVslFullname(vslFullname[i]);
                if (portNm[i] != null)
                    model.setPortNm(portNm[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (status[i] != null)
                    model.setStatus(status[i]);
                if (etd[i] != null)
                    model.setEtd(etd[i]);
                if (vslNationCd[i] != null)
                    model.setVslNationCd(vslNationCd[i]);
                if (eIInd[i] != null)
                    model.setEIInd(eIInd[i]);
                if (vslAuthNo[i] != null)
                    model.setVslAuthNo(vslAuthNo[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (tsTpCd[i] != null)
                    model.setTsTpCd(tsTpCd[i]);
                if (vslCallNo[i] != null)
                    model.setVslCallNo(vslCallNo[i]);
                if (vslId[i] != null)
                    model.setVslId(vslId[i]);
                if (customsStationCd[i] != null)
                    model.setCustomsStationCd(customsStationCd[i]);
                if (terminalOpCd[i] != null)
                    model.setTerminalOpCd(terminalOpCd[i]);
                if (preVvd[i] != null) 
		    		model.setPreVvd(preVvd[i]);
				if (prePolCd[i] != null) 
		    		model.setPrePolCd(prePolCd[i]);
				if (prePodCd[i] != null) 
		    		model.setPrePodCd(prePodCd[i]);
				if (nextVvd[i] != null) 
		    		model.setNextVvd(nextVvd[i]);
				if (nextPolCd[i] != null) 
		    		model.setNextPolCd(nextPolCd[i]);
				if (nextPodCd[i] != null) 
		    		model.setNextPodCd(nextPodCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getMalaysiaManifestVslInfoVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return MalaysiaManifestVslInfoVO[]
	 */
    public MalaysiaManifestVslInfoVO[] getMalaysiaManifestVslInfoVOs() {
        MalaysiaManifestVslInfoVO[] vos = (MalaysiaManifestVslInfoVO[]) models.toArray(new MalaysiaManifestVslInfoVO[models.size()]);
        return vos;
    }

    /**
	 * VO Class의 내용을 String으로 변환
	 */
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    /**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
    public void unDataFormat() {
        this.port = this.port.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvd = this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eta = this.eta.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslFullname = this.vslFullname.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.portNm = this.portNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.status = this.status.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.etd = this.etd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslNationCd = this.vslNationCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.eIInd = this.eIInd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslAuthNo = this.vslAuthNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.tsTpCd = this.tsTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslCallNo = this.vslCallNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vslId = this.vslId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.customsStationCd = this.customsStationCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.terminalOpCd = this.terminalOpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.preVvd = this.preVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prePolCd = this.prePolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.prePodCd = this.prePodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nextVvd = this.nextVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nextPolCd = this.nextPolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.nextPodCd = this.nextPodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}

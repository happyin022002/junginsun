/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BayPlanPolDetailVO.java
*@FileTitle : BayPlanPolDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.21  
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class BayPlanPolDetailVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<BayPlanPolDetailVO> models = new ArrayList<BayPlanPolDetailVO>();

    /* Column Info */
    private String fristCaPort = null;

    /* Column Info */
    private String fristCaEtaDt = null;

    /* Column Info */
    private String polActDepDt = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String polEstDepDt = null;

    /* Column Info */
    private String podEstArrDt = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String originTran = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    public BayPlanPolDetailVO() {
    }

    public BayPlanPolDetailVO(String ibflag, String pagerows, String polActDepDt, String polEstDepDt, String podEstArrDt, String fristCaPort, String fristCaEtaDt, String originTran) {
        this.fristCaPort = fristCaPort;
        this.fristCaEtaDt = fristCaEtaDt;
        this.polActDepDt = polActDepDt;
        this.ibflag = ibflag;
        this.polEstDepDt = polEstDepDt;
        this.podEstArrDt = podEstArrDt;
        this.pagerows = pagerows;
        this.originTran = originTran;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("frist_ca_port", getFristCaPort());
        this.hashColumns.put("frist_ca_eta_dt", getFristCaEtaDt());
        this.hashColumns.put("pol_act_dep_dt", getPolActDepDt());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pol_est_dep_dt", getPolEstDepDt());
        this.hashColumns.put("pod_est_arr_dt", getPodEstArrDt());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("origin_tran", getOriginTran());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("frist_ca_port", "fristCaPort");
        this.hashFields.put("frist_ca_eta_dt", "fristCaEtaDt");
        this.hashFields.put("pol_act_dep_dt", "polActDepDt");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pol_est_dep_dt", "polEstDepDt");
        this.hashFields.put("pod_est_arr_dt", "podEstArrDt");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("origin_tran", "originTran");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return fristCaPort
	 */
    public String getFristCaPort() {
        return this.fristCaPort;
    }

    /**
	 * Column Info
	 * @return fristCaEtaDt
	 */
    public String getFristCaEtaDt() {
        return this.fristCaEtaDt;
    }

    /**
	 * Column Info
	 * @return polActDepDt
	 */
    public String getPolActDepDt() {
        return this.polActDepDt;
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
	 * @return polEstDepDt
	 */
    public String getPolEstDepDt() {
        return this.polEstDepDt;
    }

    /**
	 * Column Info
	 * @return podEstArrDt
	 */
    public String getPodEstArrDt() {
        return this.podEstArrDt;
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
	 * @param fristCaPort
	 */
    public void setFristCaPort(String fristCaPort) {
        this.fristCaPort = fristCaPort;
    }

    /**
	 * Column Info
	 * @param fristCaEtaDt
	 */
    public void setFristCaEtaDt(String fristCaEtaDt) {
        this.fristCaEtaDt = fristCaEtaDt;
    }

    /**
	 * Column Info
	 * @param polActDepDt
	 */
    public void setPolActDepDt(String polActDepDt) {
        this.polActDepDt = polActDepDt;
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
	 * @param polEstDepDt
	 */
    public void setPolEstDepDt(String polEstDepDt) {
        this.polEstDepDt = polEstDepDt;
    }

    /**
	 * Column Info
	 * @param podEstArrDt
	 */
    public void setPodEstArrDt(String podEstArrDt) {
        this.podEstArrDt = podEstArrDt;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setOriginTran(String originTran) {
        this.originTran = originTran;
    }

    public String getOriginTran() {
        return this.originTran;
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
        setFristCaPort(JSPUtil.getParameter(request, prefix + "frist_ca_port", ""));
        setFristCaEtaDt(JSPUtil.getParameter(request, prefix + "frist_ca_eta_dt", ""));
        setPolActDepDt(JSPUtil.getParameter(request, prefix + "pol_act_dep_dt", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPolEstDepDt(JSPUtil.getParameter(request, prefix + "pol_est_dep_dt", ""));
        setPodEstArrDt(JSPUtil.getParameter(request, prefix + "pod_est_arr_dt", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setOriginTran(JSPUtil.getParameter(request, prefix + "origin_tran", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BayPlanPolDetailVO[]
	 */
    public BayPlanPolDetailVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BayPlanPolDetailVO[]
	 */
    public BayPlanPolDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        BayPlanPolDetailVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] fristCaPort = (JSPUtil.getParameter(request, prefix + "frist_ca_port", length));
            String[] fristCaEtaDt = (JSPUtil.getParameter(request, prefix + "frist_ca_eta_dt", length));
            String[] polActDepDt = (JSPUtil.getParameter(request, prefix + "pol_act_dep_dt", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] polEstDepDt = (JSPUtil.getParameter(request, prefix + "pol_est_dep_dt", length));
            String[] podEstArrDt = (JSPUtil.getParameter(request, prefix + "pod_est_arr_dt", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] originTran = (JSPUtil.getParameter(request, prefix + "origin_tran", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new BayPlanPolDetailVO();
                if (fristCaPort[i] != null)
                    model.setFristCaPort(fristCaPort[i]);
                if (fristCaEtaDt[i] != null)
                    model.setFristCaEtaDt(fristCaEtaDt[i]);
                if (polActDepDt[i] != null)
                    model.setPolActDepDt(polActDepDt[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (polEstDepDt[i] != null)
                    model.setPolEstDepDt(polEstDepDt[i]);
                if (podEstArrDt[i] != null)
                    model.setPodEstArrDt(podEstArrDt[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (originTran[i] != null) 
		    		model.setOriginTran(originTran[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getBayPlanPolDetailVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return BayPlanPolDetailVO[]
	 */
    public BayPlanPolDetailVO[] getBayPlanPolDetailVOs() {
        BayPlanPolDetailVO[] vos = (BayPlanPolDetailVO[]) models.toArray(new BayPlanPolDetailVO[models.size()]);
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
        this.fristCaPort = this.fristCaPort.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.fristCaEtaDt = this.fristCaEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polActDepDt = this.polActDepDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polEstDepDt = this.polEstDepDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podEstArrDt = this.podEstArrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.originTran = this.originTran.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}

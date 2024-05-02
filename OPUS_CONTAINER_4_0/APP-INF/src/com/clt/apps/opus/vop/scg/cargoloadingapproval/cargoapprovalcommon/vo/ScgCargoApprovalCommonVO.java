/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ScgPrnrAproRqstCgoVO.java
 *@FileTitle : ScgPrnrAproRqstCgoVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.01
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.12.01 dongsoo 
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.cargoapprovalcommon.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author dongsoo
 * @since J2EE 1.6
 * @see	..
 */
public class ScgCargoApprovalCommonVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<ScgCargoApprovalCommonVO> models = new ArrayList<ScgCargoApprovalCommonVO>();

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String aproRefNo = null;

    /* Column Info */
    private String polCd = null;

    /* Info */
    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

    /**	Constructor	*/
    public ScgCargoApprovalCommonVO() {
    }

    public ScgCargoApprovalCommonVO(String ibflag, String aproRefNo, String polCd) {
        this.ibflag = ibflag;
        this.aproRefNo = aproRefNo;
        this.polCd = polCd;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("apro_ref_no", getAproRefNo());
        this.hashColumns.put("pol_cd", getPolCd());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("apro_ref_no", "aproRefNo");
        this.hashFields.put("pol_cd", "polCd");
        return this.hashFields;
    }

    //	Getters	and	Setters
    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
    }

    /**
	 * Column Info
	 * @param  ibflag
 	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    public void setAproRefNo(String aproRefNo) {
        this.aproRefNo = aproRefNo;
    }

    public String getAproRefNo() {
        return this.aproRefNo;
    }

    public void setPolCd(String polCd) {
        this.polCd = polCd;
    }

    public String getPolCd() {
        return this.polCd;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request, String prefix) {
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setAproRefNo(JSPUtil.getParameter(request, prefix + "apro_ref_no", ""));
        setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgPrnrAproRqstCgoVO[]
	 */
    public ScgCargoApprovalCommonVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ScgPrnrAproRqstCgoVO[]
	 */
    public ScgCargoApprovalCommonVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ScgCargoApprovalCommonVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] aproRefNo = (JSPUtil.getParameter(request, prefix + "apro_ref_no", length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ScgCargoApprovalCommonVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (aproRefNo[i] != null)
                    model.setAproRefNo(aproRefNo[i]);
                if (polCd[i] != null) 
		    		model.setPolCd(polCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getScgCargoApprovalCommonVOs();
    }

    /**
	 *  VO 배열을 반환
	 * @return ScgPrnrAproRqstCgoVO[]
	 */
    public ScgCargoApprovalCommonVO[] getScgCargoApprovalCommonVOs() {
        ScgCargoApprovalCommonVO[] vos = (ScgCargoApprovalCommonVO[]) models.toArray(new ScgCargoApprovalCommonVO[models.size()]);
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
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.aproRefNo = this.aproRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}

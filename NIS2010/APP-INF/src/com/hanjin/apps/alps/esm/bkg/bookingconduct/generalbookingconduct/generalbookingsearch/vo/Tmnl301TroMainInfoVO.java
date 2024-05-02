/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Tmnl301DgInfoVO.java
*@FileTitle : Tmnl301DgInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.25
*@LastModifier : 
*@LastVersion : 1.0
* 2010.08.25  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo;

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
public class Tmnl301TroMainInfoVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<Tmnl301TroMainInfoVO> models = new ArrayList<Tmnl301TroMainInfoVO>();

    /* Column Info */
    private String bkgNo = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String troSeq = null;

    /* Column Info */
    private String troMainInfo = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public Tmnl301TroMainInfoVO() {
    }

    public Tmnl301TroMainInfoVO(String ibflag, String pagerows, String bkgNo, String troSeq, String troMainInfo) {
        this.bkgNo = bkgNo;
        this.ibflag = ibflag;
        this.pagerows = pagerows;
        this.troSeq = troSeq;
        this.troMainInfo = troMainInfo;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("tro_seq", getTroSeq());
        this.hashColumns.put("tro_main_info", getTroMainInfo());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("tro_seq", "troSeq");
        this.hashFields.put("tro_main_info", "troMainInfo");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return bkgNo
	 */
    public String getBkgNo() {
        return this.bkgNo;
    }

    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
    public String getIbflag() {
        return this.ibflag;
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
	 * @param bkgNo
	 */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setTroSeq(String troSeq) {
        this.troSeq = troSeq;
    }

    public String getTroSeq() {
        return this.troSeq;
    }

    public void setTroMainInfo(String troMainInfo) {
        this.troMainInfo = troMainInfo;
    }

    public String getTroMainInfo() {
        return this.troMainInfo;
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
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setTroSeq(JSPUtil.getParameter(request, prefix + "tro_seq", ""));
        setTroMainInfo(JSPUtil.getParameter(request, prefix + "tro_main_info", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Tmnl301TroMainInfoVO[]
	 */
    public Tmnl301TroMainInfoVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Tmnl301DgInfoVO[]
	 */
    public Tmnl301TroMainInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
    	Tmnl301TroMainInfoVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] troSeq = (JSPUtil.getParameter(request, prefix + "tro_seq", length));
	    	String[] troMainInfo = (JSPUtil.getParameter(request, prefix + "tro_main_info", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new Tmnl301TroMainInfoVO();
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (troSeq[i] != null) 
		    		model.setTroSeq(troSeq[i]);
				if (troMainInfo[i] != null) 
		    		model.setTroMainInfo(troMainInfo[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getTmnl301TroMainInfoVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return Tmnl301TroMainInfoVO[]
	 */
    public Tmnl301TroMainInfoVO[] getTmnl301TroMainInfoVOs() {
    	Tmnl301TroMainInfoVO[] vos = (Tmnl301TroMainInfoVO[]) models.toArray(new Tmnl301TroMainInfoVO[models.size()]);
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
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.troSeq = this.troSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.troMainInfo = this.troMainInfo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}

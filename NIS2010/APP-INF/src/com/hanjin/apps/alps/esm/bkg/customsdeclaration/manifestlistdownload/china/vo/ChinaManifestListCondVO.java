/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChinaManifestListCondVO.java
*@FileTitle : ChinaManifestListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.04
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.04  
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
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
public class ChinaManifestListCondVO extends ManifestListCondVO {

    private static final long serialVersionUID = 1L;

    private Collection<ChinaManifestListCondVO> models = new ArrayList<ChinaManifestListCondVO>();

    /* Column Info */
    private String vvd = null;

    /* Column Info */
    private String bkgNo = null;

    /* Column Info */
    private String transMode = null;

    /* Column Info */
    private String transType = null;

    /* Column Info */
    private String bkgCgoTpCd = null;

    /* Column Info */
    private String locCd = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String gubun = null;

    /* Column Info */
    private String usrId = null;

    /* Column Info */
    private String blNo = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String errDiv = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public ChinaManifestListCondVO() {
    }

    public ChinaManifestListCondVO(String ibflag, String pagerows, String vvd, String transType, String locCd, String bkgCgoTpCd, String transMode, String bkgNo, String blNo, String usrId, String gubun, String errDiv) {
        this.vvd = vvd;
        this.bkgNo = bkgNo;
        this.transMode = transMode;
        this.transType = transType;
        this.bkgCgoTpCd = bkgCgoTpCd;
        this.locCd = locCd;
        this.ibflag = ibflag;
        this.gubun = gubun;
        this.usrId = usrId;
        this.blNo = blNo;
        this.pagerows = pagerows;
        this.errDiv = errDiv;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("vvd", getVvd());
        this.hashColumns.put("bkg_no", getBkgNo());
        this.hashColumns.put("trans_mode", getTransMode());
        this.hashColumns.put("trans_type", getTransType());
        this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
        this.hashColumns.put("loc_cd", getLocCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("gubun", getGubun());
        this.hashColumns.put("usr_id", getUsrId());
        this.hashColumns.put("bl_no", getBlNo());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("err_div", getErrDiv());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("vvd", "vvd");
        this.hashFields.put("bkg_no", "bkgNo");
        this.hashFields.put("trans_mode", "transMode");
        this.hashFields.put("trans_type", "transType");
        this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
        this.hashFields.put("loc_cd", "locCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("gubun", "gubun");
        this.hashFields.put("usr_id", "usrId");
        this.hashFields.put("bl_no", "blNo");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("err_div", "errDiv");
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
	 * @return bkgNo
	 */
    public String getBkgNo() {
        return this.bkgNo;
    }

    /**
	 * Column Info
	 * @return transMode
	 */
    public String getTransMode() {
        return this.transMode;
    }

    /**
	 * Column Info
	 * @return transMode
	 */
    public String getTransType() {
        return this.transType;
    }

    /**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
    public String getBkgCgoTpCd() {
        return this.bkgCgoTpCd;
    }

    /**
	 * Column Info
	 * @return locCd
	 */
    public String getLocCd() {
        return this.locCd;
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
	 * @return gubun
	 */
    public String getGubun() {
        return this.gubun;
    }

    /**
	 * Column Info
	 * @return usrId
	 */
    public String getUsrId() {
        return this.usrId;
    }

    /**
	 * Column Info
	 * @return blNo
	 */
    public String getBlNo() {
        return this.blNo;
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
	 * @param bkgNo
	 */
    public void setBkgNo(String bkgNo) {
        this.bkgNo = bkgNo;
    }

    /**
	 * Column Info
	 * @param transMode
	 */
    public void setTransMode(String transMode) {
        this.transMode = transMode;
    }

    /**
	 * Column Info
	 * @param transMode
	 */
    public void setTransType(String transType) {
        this.transType = transType;
    }

    /**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
    public void setBkgCgoTpCd(String bkgCgoTpCd) {
        this.bkgCgoTpCd = bkgCgoTpCd;
    }

    /**
	 * Column Info
	 * @param locCd
	 */
    public void setLocCd(String locCd) {
        this.locCd = locCd;
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
	 * @param gubun
	 */
    public void setGubun(String gubun) {
        this.gubun = gubun;
    }

    /**
	 * Column Info
	 * @param usrId
	 */
    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    /**
	 * Column Info
	 * @param blNo
	 */
    public void setBlNo(String blNo) {
        this.blNo = blNo;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setErrDiv(String errDiv) {
        this.errDiv = errDiv;
    }

    public String getErrDiv() {
        return this.errDiv;
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
        setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
        setTransMode(JSPUtil.getParameter(request, prefix + "trans_mode", ""));
        setTransType(JSPUtil.getParameter(request, prefix + "trans_type", ""));
        setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
        setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setGubun(JSPUtil.getParameter(request, prefix + "gubun", ""));
        setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
        setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setErrDiv(JSPUtil.getParameter(request, prefix + "err_div", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChinaManifestListCondVO[]
	 */
    public ChinaManifestListCondVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChinaManifestListCondVO[]
	 */
    public ChinaManifestListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        ChinaManifestListCondVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] vvd = (JSPUtil.getParameter(request, prefix + "vvd", length));
            String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
            String[] transMode = (JSPUtil.getParameter(request, prefix + "trans_mode", length));
            String[] transType = (JSPUtil.getParameter(request, prefix + "trans_type", length));
            String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", length));
            String[] locCd = (JSPUtil.getParameter(request, prefix + "loc_cd", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] gubun = (JSPUtil.getParameter(request, prefix + "gubun", length));
            String[] usrId = (JSPUtil.getParameter(request, prefix + "usr_id", length));
            String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] errDiv = (JSPUtil.getParameter(request, prefix + "err_div", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new ChinaManifestListCondVO();
                if (vvd[i] != null)
                    model.setVvd(vvd[i]);
                if (bkgNo[i] != null)
                    model.setBkgNo(bkgNo[i]);
                if (transMode[i] != null)
                    model.setTransMode(transMode[i]);
                if (transType[i] != null)
                    model.setTransType(transType[i]);
                if (bkgCgoTpCd[i] != null)
                    model.setBkgCgoTpCd(bkgCgoTpCd[i]);
                if (locCd[i] != null)
                    model.setLocCd(locCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (gubun[i] != null)
                    model.setGubun(gubun[i]);
                if (usrId[i] != null)
                    model.setUsrId(usrId[i]);
                if (blNo[i] != null)
                    model.setBlNo(blNo[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (errDiv[i] != null) 
		    		model.setErrDiv(errDiv[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getChinaManifestListCondVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return ChinaManifestListCondVO[]
	 */
    public ChinaManifestListCondVO[] getChinaManifestListCondVOs() {
        ChinaManifestListCondVO[] vos = (ChinaManifestListCondVO[]) models.toArray(new ChinaManifestListCondVO[models.size()]);
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
        this.bkgNo = this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.transMode = this.transMode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.transType = this.transType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.bkgCgoTpCd = this.bkgCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.locCd = this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.gubun = this.gubun.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.usrId = this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.blNo = this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.errDiv = this.errDiv.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}

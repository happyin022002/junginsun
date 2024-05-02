/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CmInfoForFlatFileVO.java
*@FileTitle : CmInfoForFlatFileVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.07.17 김민정 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class CmInfoForFlatFileVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<CmInfoForFlatFileVO> models = new ArrayList<CmInfoForFlatFileVO>();

    /* Column Info */
    private String cmpkg = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String cmwgt = null;

    /* Column Info */
    private String cmdesc = null;

    /* Column Info */
    private String cmpkgu = null;

    /* Column Info */
    private String cmwgtu = null;

    /* Column Info */
    private String cmunno = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String cmcode = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public CmInfoForFlatFileVO() {
    }

    public CmInfoForFlatFileVO(String ibflag, String pagerows, String cmpkg, String cmpkgu, String cmwgt, String cmwgtu, String cmdesc, String cmunno, String cmcode) {
        this.cmpkg = cmpkg;
        this.ibflag = ibflag;
        this.cmwgt = cmwgt;
        this.cmdesc = cmdesc;
        this.cmpkgu = cmpkgu;
        this.cmwgtu = cmwgtu;
        this.cmunno = cmunno;
        this.pagerows = pagerows;
        this.cmcode = cmcode;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("cmpkg", getCmpkg());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("cmwgt", getCmwgt());
        this.hashColumns.put("cmdesc", getCmdesc());
        this.hashColumns.put("cmpkgu", getCmpkgu());
        this.hashColumns.put("cmwgtu", getCmwgtu());
        this.hashColumns.put("cmunno", getCmunno());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("cmcode", getCmcode());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("cmpkg", "cmpkg");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("cmwgt", "cmwgt");
        this.hashFields.put("cmdesc", "cmdesc");
        this.hashFields.put("cmpkgu", "cmpkgu");
        this.hashFields.put("cmwgtu", "cmwgtu");
        this.hashFields.put("cmunno", "cmunno");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("cmcode", "cmcode");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return cmpkg
	 */
    public String getCmpkg() {
        return this.cmpkg;
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
	 * @return cmwgt
	 */
    public String getCmwgt() {
        return this.cmwgt;
    }

    /**
	 * Column Info
	 * @return cmdesc
	 */
    public String getCmdesc() {
        return this.cmdesc;
    }

    /**
	 * Column Info
	 * @return cmpkgu
	 */
    public String getCmpkgu() {
        return this.cmpkgu;
    }

    /**
	 * Column Info
	 * @return cmwgtu
	 */
    public String getCmwgtu() {
        return this.cmwgtu;
    }

    /**
	 * Column Info
	 * @return cmunno
	 */
    public String getCmunno() {
        return this.cmunno;
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
	 * @param cmpkg
	 */
    public void setCmpkg(String cmpkg) {
        this.cmpkg = cmpkg;
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
	 * @param cmwgt
	 */
    public void setCmwgt(String cmwgt) {
        this.cmwgt = cmwgt;
    }

    /**
	 * Column Info
	 * @param cmdesc
	 */
    public void setCmdesc(String cmdesc) {
        this.cmdesc = cmdesc;
    }

    /**
	 * Column Info
	 * @param cmpkgu
	 */
    public void setCmpkgu(String cmpkgu) {
        this.cmpkgu = cmpkgu;
    }

    /**
	 * Column Info
	 * @param cmwgtu
	 */
    public void setCmwgtu(String cmwgtu) {
        this.cmwgtu = cmwgtu;
    }

    /**
	 * Column Info
	 * @param cmunno
	 */
    public void setCmunno(String cmunno) {
        this.cmunno = cmunno;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setCmcode(String cmcode) {
        this.cmcode = cmcode;
    }

    public String getCmcode() {
        return this.cmcode;
    }

    /**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
    public void fromRequest(HttpServletRequest request) {
        setCmpkg(JSPUtil.getParameter(request, "cmpkg", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setCmwgt(JSPUtil.getParameter(request, "cmwgt", ""));
        setCmdesc(JSPUtil.getParameter(request, "cmdesc", ""));
        setCmpkgu(JSPUtil.getParameter(request, "cmpkgu", ""));
        setCmwgtu(JSPUtil.getParameter(request, "cmwgtu", ""));
        setCmunno(JSPUtil.getParameter(request, "cmunno", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CmInfoForFlatFileVO[]
	 */
    public CmInfoForFlatFileVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CmInfoForFlatFileVO[]
	 */
    public CmInfoForFlatFileVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CmInfoForFlatFileVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] cmpkg = (JSPUtil.getParameter(request, prefix + "cmpkg", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] cmwgt = (JSPUtil.getParameter(request, prefix + "cmwgt", length));
            String[] cmdesc = (JSPUtil.getParameter(request, prefix + "cmdesc", length));
            String[] cmpkgu = (JSPUtil.getParameter(request, prefix + "cmpkgu", length));
            String[] cmwgtu = (JSPUtil.getParameter(request, prefix + "cmwgtu", length));
            String[] cmunno = (JSPUtil.getParameter(request, prefix + "cmunno", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] cmcode = (JSPUtil.getParameter(request, prefix + "cmcode", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CmInfoForFlatFileVO();
                if (cmpkg[i] != null)
                    model.setCmpkg(cmpkg[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (cmwgt[i] != null)
                    model.setCmwgt(cmwgt[i]);
                if (cmdesc[i] != null)
                    model.setCmdesc(cmdesc[i]);
                if (cmpkgu[i] != null)
                    model.setCmpkgu(cmpkgu[i]);
                if (cmwgtu[i] != null)
                    model.setCmwgtu(cmwgtu[i]);
                if (cmunno[i] != null)
                    model.setCmunno(cmunno[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (cmcode[i] != null) 
		    		model.setCmcode(cmcode[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCmInfoForFlatFileVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return CmInfoForFlatFileVO[]
	 */
    public CmInfoForFlatFileVO[] getCmInfoForFlatFileVOs() {
        CmInfoForFlatFileVO[] vos = (CmInfoForFlatFileVO[]) models.toArray(new CmInfoForFlatFileVO[models.size()]);
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
        this.cmpkg = this.cmpkg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmwgt = this.cmwgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmdesc = this.cmdesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmpkgu = this.cmpkgu.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmwgtu = this.cmwgtu.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmunno = this.cmunno.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.cmcode = this.cmcode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}

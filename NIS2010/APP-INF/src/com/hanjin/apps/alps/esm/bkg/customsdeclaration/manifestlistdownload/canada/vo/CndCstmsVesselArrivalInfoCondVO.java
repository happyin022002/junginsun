/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CndCstmsVesselArrivalInfoCondVO.java
*@FileTitle : CndCstmsVesselArrivalInfoCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.05.11 김민정 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalCondVO;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 김민정
 * @since J2EE 1.5
 * @see ..
 */
public class CndCstmsVesselArrivalInfoCondVO extends VesselArrivalCondVO {

    private static final long serialVersionUID = 1L;

    private Collection<CndCstmsVesselArrivalInfoCondVO> models = new ArrayList<CndCstmsVesselArrivalInfoCondVO>();

    /* Status */
    private String ibflag = null;

    /* Column Info */
    private String vvdCd = null;

    /* Column Info */
    private String podCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String polCd = null;

    /*	hashColumnInpo	*/
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	hashFildInpo	*/
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public CndCstmsVesselArrivalInfoCondVO() {
    }

    public CndCstmsVesselArrivalInfoCondVO(String ibflag, String pagerows, String vvdCd, String podCd, String polCd) {
        this.ibflag = ibflag;
        this.vvdCd = vvdCd;
        this.podCd = podCd;
        this.pagerows = pagerows;
        this.polCd = polCd;
    }

    /**
	 * hashColumnInpo
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("vvd_cd", getVvdCd());
        this.hashColumns.put("pod_cd", getPodCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("pol_cd", getPolCd());
        return this.hashColumns;
    }

    /**
	 * hashFildInpo
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("vvd_cd", "vvdCd");
        this.hashFields.put("pod_cd", "podCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("pol_cd", "polCd");
        return this.hashFields;
    }

    public String getIbflag() {
        return this.ibflag;
    }

    public String getVvdCd() {
        return this.vvdCd;
    }

    public String getPodCd() {
        return this.podCd;
    }

    public String getPagerows() {
        return this.pagerows;
    }

    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
    }

    public void setVvdCd(String vvdCd) {
        this.vvdCd = vvdCd;
    }

    public void setPodCd(String podCd) {
        this.podCd = podCd;
    }

    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setPolCd(String polCd) {
        this.polCd = polCd;
    }

    public String getPolCd() {
        return this.polCd;
    }

    public void fromRequest(HttpServletRequest request) {
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
        setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
        setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
    }

    public CndCstmsVesselArrivalInfoCondVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    public CndCstmsVesselArrivalInfoCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        CndCstmsVesselArrivalInfoCondVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag".trim(), length));
            String[] vvdCd = (JSPUtil.getParameter(request, prefix + "vvd_cd".trim(), length));
            String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd".trim(), length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows".trim(), length));
            String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new CndCstmsVesselArrivalInfoCondVO();
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (vvdCd[i] != null)
                    model.setVvdCd(vvdCd[i]);
                if (podCd[i] != null)
                    model.setPodCd(podCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (polCd[i] != null) 
		    		model.setPolCd(polCd[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getCndBlCondVOs();
    }

    public CndCstmsVesselArrivalInfoCondVO[] getCndBlCondVOs() {
        CndCstmsVesselArrivalInfoCondVO[] vos = (CndCstmsVesselArrivalInfoCondVO[]) models.toArray(new CndCstmsVesselArrivalInfoCondVO[models.size()]);
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
	 */
    private String[] getField(Field[] field, int i) {
        String[] arr = null;
        try {
            arr = (String[]) field[i].get(this);
        } catch (Exception ex) {
            arr = getFieldCatct(field, i, arr);
        }
        return arr;
    }

    /**
	 * getField 에서 catch문에 대한 로직
	 * @param field
	 * @param i
	 * @param arr
	 * @return arr
	 */
    private String[] getFieldCatct(Field[] field, int i, String[] arr) {
        try {
            arr = new String[1];
            arr[0] = String.valueOf(field[i].get(this));
        } catch (IllegalAccessException e) {
            return null;
        }
        return arr;
    }

    /**
	* DataFormat 설정
	*/
    public void onDataFormat() {
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.vvdCd = this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.podCd = this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.polCd = this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}

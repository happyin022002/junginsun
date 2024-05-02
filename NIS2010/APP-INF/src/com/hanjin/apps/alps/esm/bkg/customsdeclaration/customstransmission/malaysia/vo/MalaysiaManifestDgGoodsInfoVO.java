/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : MalaysiaManifestDgGoodsInfoVO.java
*@FileTitle : MalaysiaManifestDgGoodsInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.14
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.14  
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
public class MalaysiaManifestDgGoodsInfoVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;

    private Collection<MalaysiaManifestDgGoodsInfoVO> models = new ArrayList<MalaysiaManifestDgGoodsInfoVO>();

    /* Column Info */
    private String flashPoint = null;

    /* Column Info */
    private String undgNo = null;

    /* VO Data Value( C:Creation, U:Update, D:Delete ) */
    private String ibflag = null;

    /* Column Info */
    private String hazardCd = null;

    /* Page Number */
    private String pagerows = null;

    /* Column Info */
    private String imoClassNo = null;

    /* Column Info */
    private String packingGroup = null;

    /* Column Info */
    private String flashPointUnit = null;

    /*	테이블 컬럼의 값을 저장하는 Hashtable */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
    private HashMap<String, String> hashFields = new HashMap<String, String>();

    public MalaysiaManifestDgGoodsInfoVO() {
    }

    public MalaysiaManifestDgGoodsInfoVO(String ibflag, String pagerows, String hazardCd, String undgNo, String flashPoint, String imoClassNo, String packingGroup, String flashPointUnit) {
        this.flashPoint = flashPoint;
        this.undgNo = undgNo;
        this.ibflag = ibflag;
        this.hazardCd = hazardCd;
        this.pagerows = pagerows;
        this.imoClassNo = imoClassNo;
        this.packingGroup = packingGroup;
        this.flashPointUnit = flashPointUnit;
    }

    /**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
    public HashMap<String, String> getColumnValues() {
        this.hashColumns.put("flash_point", getFlashPoint());
        this.hashColumns.put("undg_no", getUndgNo());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("hazard_cd", getHazardCd());
        this.hashColumns.put("pagerows", getPagerows());
        this.hashColumns.put("imo_class_no", getImoClassNo());
        this.hashColumns.put("packing_group", getPackingGroup());
        this.hashColumns.put("flash_point_unit", getFlashPointUnit());
        return this.hashColumns;
    }

    /**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
    public HashMap<String, String> getFieldNames() {
        this.hashFields.put("flash_point", "flashPoint");
        this.hashFields.put("undg_no", "undgNo");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("hazard_cd", "hazardCd");
        this.hashFields.put("pagerows", "pagerows");
        this.hashFields.put("imo_class_no", "imoClassNo");
        this.hashFields.put("packing_group", "packingGroup");
        this.hashFields.put("flash_point_unit", "flashPointUnit");
        return this.hashFields;
    }

    /**
	 * Column Info
	 * @return flashPoint
	 */
    public String getFlashPoint() {
        return this.flashPoint;
    }

    /**
	 * Column Info
	 * @return undgNo
	 */
    public String getUndgNo() {
        return this.undgNo;
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
	 * @return hazardCd
	 */
    public String getHazardCd() {
        return this.hazardCd;
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
	 * @param flashPoint
	 */
    public void setFlashPoint(String flashPoint) {
        this.flashPoint = flashPoint;
    }

    /**
	 * Column Info
	 * @param undgNo
	 */
    public void setUndgNo(String undgNo) {
        this.undgNo = undgNo;
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
	 * @param hazardCd
	 */
    public void setHazardCd(String hazardCd) {
        this.hazardCd = hazardCd;
    }

    /**
	 * Page Number
	 * @param pagerows
	 */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
    }

    public void setImoClassNo(String imoClassNo) {
        this.imoClassNo = imoClassNo;
    }

    public String getImoClassNo() {
        return this.imoClassNo;
    }

    public void setPackingGroup(String packingGroup) {
        this.packingGroup = packingGroup;
    }

    public String getPackingGroup() {
        return this.packingGroup;
    }

    public void setFlashPointUnit(String flashPointUnit) {
        this.flashPointUnit = flashPointUnit;
    }

    public String getFlashPointUnit() {
        return this.flashPointUnit;
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
        setFlashPoint(JSPUtil.getParameter(request, prefix + "flash_point", ""));
        setUndgNo(JSPUtil.getParameter(request, prefix + "undg_no", ""));
        setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
        setHazardCd(JSPUtil.getParameter(request, prefix + "hazard_cd", ""));
        setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
        setImoClassNo(JSPUtil.getParameter(request, prefix + "imo_class_no", ""));
        setPackingGroup(JSPUtil.getParameter(request, prefix + "packing_group", ""));
        setFlashPointUnit(JSPUtil.getParameter(request, prefix + "flash_point_unit", ""));
    }

    /**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MalaysiaManifestDgGoodsInfoVO[]
	 */
    public MalaysiaManifestDgGoodsInfoVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MalaysiaManifestDgGoodsInfoVO[]
	 */
    public MalaysiaManifestDgGoodsInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        MalaysiaManifestDgGoodsInfoVO model = null;
        String[] tmp = request.getParameterValues(prefix + "ibflag");
        if (tmp == null)
            return null;
        int length = request.getParameterValues(prefix + "ibflag").length;
        try {
            String[] flashPoint = (JSPUtil.getParameter(request, prefix + "flash_point", length));
            String[] undgNo = (JSPUtil.getParameter(request, prefix + "undg_no", length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
            String[] hazardCd = (JSPUtil.getParameter(request, prefix + "hazard_cd", length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
            String[] imoClassNo = (JSPUtil.getParameter(request, prefix + "imo_class_no", length));
            String[] packingGroup = (JSPUtil.getParameter(request, prefix + "packing_group", length));
            String[] flashPointUnit = (JSPUtil.getParameter(request, prefix + "flash_point_unit", length));
	    	/* Add a field line, do not delete */
            for (int i = 0; i < length; i++) {
                model = new MalaysiaManifestDgGoodsInfoVO();
                if (flashPoint[i] != null)
                    model.setFlashPoint(flashPoint[i]);
                if (undgNo[i] != null)
                    model.setUndgNo(undgNo[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (hazardCd[i] != null)
                    model.setHazardCd(hazardCd[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                if (imoClassNo[i] != null)
                    model.setImoClassNo(imoClassNo[i]);
                if (packingGroup[i] != null)
                    model.setPackingGroup(packingGroup[i]);
                if (flashPointUnit[i] != null) 
		    		model.setFlashPointUnit(flashPointUnit[i]);
				/* Add a Method line, do not delete */
                models.add(model);
            }
        } catch (Exception e) {
            return null;
        }
        return getMalaysiaManifestDgGoodsInfoVOs();
    }

    /**
	 * VO 배열을 반환
	 * @return MalaysiaManifestDgGoodsInfoVO[]
	 */
    public MalaysiaManifestDgGoodsInfoVO[] getMalaysiaManifestDgGoodsInfoVOs() {
        MalaysiaManifestDgGoodsInfoVO[] vos = (MalaysiaManifestDgGoodsInfoVO[]) models.toArray(new MalaysiaManifestDgGoodsInfoVO[models.size()]);
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
        this.flashPoint = this.flashPoint.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.undgNo = this.undgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.hazardCd = this.hazardCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.imoClassNo = this.imoClassNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.packingGroup = this.packingGroup.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.flashPointUnit = this.flashPointUnit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}

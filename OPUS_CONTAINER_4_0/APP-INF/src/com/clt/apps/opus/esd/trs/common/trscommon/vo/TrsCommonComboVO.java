/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName       : TrsCommonComboVO.java
*@FileTitle      : BkgComboVO
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.11.24
*@LastModifier   : Hyungwook Choi
*@LastVersion    : 1.0
* 2014.11.24 Hyungwook Choi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.common.trscommon.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 김영출
 * @since J2EE 1.5
 */
public class TrsCommonComboVO extends AbstractValueObject {

    private static final long serialVersionUID = 1L;
    
    private Collection<TrsCommonComboVO> models = new ArrayList<TrsCommonComboVO>();
    
    /* Column Info */
    private String comboCd = null;
    /* Column Info */
    private String val = null;
    /* Column Info */
    private String name = null;
    /* Column Info */
    private String desc = null;
    /* Status */
    private String ibflag = null;
    /* Page Number */
    private String pagerows = null;

    /*    hashColumnInpo    */
    private HashMap<String, String> hashColumns = new HashMap<String, String>();

    /*    hashFildInpo    */
    private HashMap<String, String> hashFields = new HashMap<String, String>();
    
    /**
     * 생성자
     */
    public TrsCommonComboVO() {}

    /**
     * 생성자
     * 
     * @param ibflag
     * @param pagerows
     * @param val
     * @param name
     * @param desc
     * @param comboCd
     */
    public TrsCommonComboVO(String ibflag, String pagerows, String val, String name, String desc, String comboCd) {
        this.comboCd = comboCd;
        this.name = name;
        this.desc = desc;
        this.val = val;
        this.ibflag = ibflag;
        this.pagerows = pagerows;
    }
    
    /**
     * hashColumnInpo
     * @return HashMap
     */
    public HashMap<String, String> getColumnValues(){
        this.hashColumns.put("comboCd", getComboCd());
        this.hashColumns.put("ibflag", getIbflag());
        this.hashColumns.put("name", getName());
        this.hashColumns.put("desc", getDesc());
        this.hashColumns.put("val", getVal());
        this.hashColumns.put("pagerows", getPagerows());
        return this.hashColumns;
    }
    
    /**
     * hashFildInpo
     * @return
     */
    public HashMap<String, String> getFieldNames(){
        this.hashFields.put("comboCd", "comboCd");
        this.hashFields.put("ibflag", "ibflag");
        this.hashFields.put("name", "name");
        this.hashFields.put("desc", "desc");
        this.hashFields.put("val", "val");
        this.hashFields.put("pagerows", "pagerows");
        return this.hashFields;
    }
    
    /**
     * 
     * @return
     */
    public String getComboCd() {
        return this.comboCd;
    }
    /**
     * 
     * @return
     */
    public String getIbflag() {
        return this.ibflag;
    }
    /**
     * 
     * @return
     */
    public String getName() {
        return this.name;
    }
    /**
     * 
     * @return
     */
    public String getDesc() {
        return this.desc;
    }
    /**
     * 
     * @return
     */
    public String getVal() {
        return this.val;
    }
    /**
     * 
     * @return
     */
    public String getPagerows() {
        return this.pagerows;
    }
    
    
    /**
     * 
     * @param comboCd
     */
    public void setComboCd(String comboCd) {
        this.comboCd = comboCd;
        //this.comboCd=true;
    }
    /**
     * 
     * @param ibflag
     */
    public void setIbflag(String ibflag) {
        this.ibflag = ibflag;
        //this.ibflag=true;
    }
    /**
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
        //this.name=true;
    }
    /**
     * 
     * @param desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
        //this.desc=true;
    }
    /**
     * 
     * @param val
     */
    public void setVal(String val) {
        this.val = val;
        //this.val=true;
    }
    /**
     * 
     * @param pagerows
     */
    public void setPagerows(String pagerows) {
        this.pagerows = pagerows;
        //this.pagerows=true;
    }
    
    /**
     * 
     * @param request
     */
    public void fromRequest(HttpServletRequest request) {
        setComboCd(JSPUtil.getParameter(request, "comboCd", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setName(JSPUtil.getParameter(request, "name", ""));
        setDesc(JSPUtil.getParameter(request, "desc", ""));
        setVal(JSPUtil.getParameter(request, "val", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
    }

    /**
     * 
     * @param request
     * @return
     */
    public TrsCommonComboVO[] fromRequestGrid(HttpServletRequest request) {
        return fromRequestGrid(request, "");
    }

    /**
     * 
     * @param request
     * @param prefix
     * @return
     */
    public TrsCommonComboVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
        TrsCommonComboVO model = null;
        
        String[] tmp = request.getParameterValues(prefix + "ibflag");
          if(tmp == null)
               return null;

          int length = request.getParameterValues(prefix + "ibflag").length;
  
        try {
            String[] comboCd = (JSPUtil.getParameter(request, prefix    + "comboCd".trim(), length));
            String[] ibflag = (JSPUtil.getParameter(request, prefix    + "ibflag".trim(), length));
            String[] name = (JSPUtil.getParameter(request, prefix    + "name".trim(), length));
            String[] desc = (JSPUtil.getParameter(request, prefix    + "desc".trim(), length));
            String[] val = (JSPUtil.getParameter(request, prefix    + "val".trim(), length));
            String[] pagerows = (JSPUtil.getParameter(request, prefix    + "pagerows".trim(), length));
            
            for (int i = 0; i < length; i++) {
                model = new TrsCommonComboVO();
                if (comboCd[i] != null)
                    model.setComboCd(comboCd[i]);
                if (ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if (name[i] != null)
                    model.setName(name[i]);
                if (desc[i] != null)
                    model.setDesc(desc[i]);
                if (val[i] != null)
                    model.setVal(val[i]);
                if (pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                models.add(model);
            }

        } catch (Exception e) {}
        return getTrsCommonComboVOs();
    }

    /**
     * 
     * @return
     */
    public TrsCommonComboVO[] getTrsCommonComboVOs(){
        TrsCommonComboVO[] vos = (TrsCommonComboVO[])models.toArray(new TrsCommonComboVO[models.size()]);
        return vos;
    }
    
    /**
     * 
     */
    public String toString() {
        StringBuffer ret = new StringBuffer();
        Field[] field = this.getClass().getDeclaredFields();
        String space = "";
        try{
            for(int i = 0; i < field.length; i++){
                String[] arr = null;
                arr = getField(field, i);
                if(arr != null){
                    for(int j = 0; j < arr.length; j++) {
                        ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
                    }
                } else {
                    ret.append(field[i].getName() + " =  null \n");
                }
            }
        } catch (Exception ex) {}
        return ret.toString();
    }
    
    /**
     * 각 클래스 해당하는 필드 정보를 배열에 담는다 
     * @param field
     * @param i
     * @return String[]
     * @throws IllegalAccessException
     */
    private String[] getField(Field[] field, int i) throws IllegalAccessException {
        String[] arr;
        try{
            arr = (String[]) field[i].get(this);
        }catch(Exception ex){
            arr = new String[1];
            arr[0] = String.valueOf(field[i].get(this));
        }
        return arr;
    }
    
    /**
    * DataFormat 설정
    */
    public void onDataFormat()
    {
        this.comboCd = this.comboCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.name = this.name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.desc = this.desc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.val = this.val .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }
}

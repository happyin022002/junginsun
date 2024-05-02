/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TrsComboVO.java
*@FileTitle : TrsComboVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.26
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.09.30 민정호 
* 1.0 Creation
* 
* 2011.07.26 민정호 [CHM-201112196] Expense Summary Report에 Invoice 상태코드를 조회조건에 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.trscommon.vo;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;
import java.lang.reflect.Field;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

public class TrsComboVO extends AbstractValueObject
{

    public TrsComboVO()
    {
        models = new ArrayList();
        comboCd = null;
        val = null;
        name = null;
        desc = null;
        ibflag = null;
        pagerows = null;
        hashColumns = new HashMap();
        hashFields = new HashMap();
    }

    public TrsComboVO(String ibflag, String pagerows, String val, String name, String desc, String comboCd)
    {
        models = new ArrayList();
        this.comboCd = null;
        this.val = null;
        this.name = null;
        this.desc = null;
        this.ibflag = null;
        this.pagerows = null;
        hashColumns = new HashMap();
        hashFields = new HashMap();
        this.comboCd = comboCd;
        this.name = name;
        this.desc = desc;
        this.val = val;
        this.ibflag = ibflag;
        this.pagerows = pagerows;
    }

    public HashMap getColumnValues()
    {
        hashColumns.put("comboCd", getComboCd());
        hashColumns.put("ibflag", getIbflag());
        hashColumns.put("name", getName());
        hashColumns.put("desc", getDesc());
        hashColumns.put("val", getVal());
        hashColumns.put("pagerows", getPagerows());
        return hashColumns;
    }

    public HashMap getFieldNames()
    {
        hashFields.put("comboCd", "comboCd");
        hashFields.put("ibflag", "ibflag");
        hashFields.put("name", "name");
        hashFields.put("desc", "desc");
        hashFields.put("val", "val");
        hashFields.put("pagerows", "pagerows");
        return hashFields;
    }

    public String getComboCd()
    {
        return comboCd;
    }

    public String getIbflag()
    {
        return ibflag;
    }

    public String getName()
    {
        return name;
    }

    public String getDesc()
    {
        return desc;
    }

    public String getVal()
    {
        return val;
    }

    public String getPagerows()
    {
        return pagerows;
    }

    public void setComboCd(String comboCd)
    {
        this.comboCd = comboCd;
    }

    public void setIbflag(String ibflag)
    {
        this.ibflag = ibflag;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public void setVal(String val)
    {
        this.val = val;
    }

    public void setPagerows(String pagerows)
    {
        this.pagerows = pagerows;
    }

    public void fromRequest(HttpServletRequest request)
    {
        setComboCd(JSPUtil.getParameter(request, "comboCd", ""));
        setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
        setName(JSPUtil.getParameter(request, "name", ""));
        setDesc(JSPUtil.getParameter(request, "desc", ""));
        setVal(JSPUtil.getParameter(request, "val", ""));
        setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
    }

    public TrsComboVO[] fromRequestGrid(HttpServletRequest request)
    {
        return fromRequestGrid(request, "");
    }

    public TrsComboVO[] fromRequestGrid(HttpServletRequest request, String prefix)
    {
        TrsComboVO model = null;
        String tmp[] = request.getParameterValues((new StringBuilder(String.valueOf(prefix))).append("ibflag").toString());
        if(tmp == null)
            return null;
        int length = request.getParameterValues((new StringBuilder(String.valueOf(prefix))).append("ibflag").toString()).length;
        try
        {
            String comboCd[] = JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("comboCd".trim()).toString(), length);
            String ibflag[] = JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("ibflag".trim()).toString(), length);
            String name[] = JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("name".trim()).toString(), length);
            String desc[] = JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("desc".trim()).toString(), length);
            String val[] = JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("val".trim()).toString(), length);
            String pagerows[] = JSPUtil.getParameter(request, (new StringBuilder(String.valueOf(prefix))).append("pagerows".trim()).toString(), length);
            for(int i = 0; i < length; i++)
            {
                model = new TrsComboVO();
                if(comboCd[i] != null)
                    model.setComboCd(comboCd[i]);
                if(ibflag[i] != null)
                    model.setIbflag(ibflag[i]);
                if(name[i] != null)
                    model.setName(name[i]);
                if(desc[i] != null)
                    model.setDesc(desc[i]);
                if(val[i] != null)
                    model.setVal(val[i]);
                if(pagerows[i] != null)
                    model.setPagerows(pagerows[i]);
                models.add(model);
            }

        }
        catch(Exception exception) { }
        return getTrsComboVOs();
    }

    public TrsComboVO[] getTrsComboVOs()
    {
        TrsComboVO vos[] = (TrsComboVO[])models.toArray(new TrsComboVO[models.size()]);
        return vos;
    }

    public String toString()
    {
        StringBuffer ret = new StringBuffer();
        Field field[] = getClass().getDeclaredFields();
        String space = "";
        try
        {
            for(int i = 0; i < field.length; i++)
            {
                String arr[] = (String[])null;
                arr = getField(field, i);
                if(arr != null)
                {
                    for(int j = 0; j < arr.length; j++)
                        ret.append((new StringBuilder(String.valueOf(field[i].getName().concat(space).substring(0, 30).concat("= ")))).append(arr[j]).append("\n").toString());

                } else
                {
                    ret.append((new StringBuilder(String.valueOf(field[i].getName()))).append(" =  null \n").toString());
                }
            }

        }
        catch(Exception exception) { }
        return ret.toString();
    }

    private String[] getField(Field field[], int i)
        throws IllegalAccessException
    {
        String arr[];
        try
        {
            arr = (String[])field[i].get(this);
        }
        catch(Exception ex)
        {
            arr = new String[1];
            arr[0] = String.valueOf(field[i].get(this));
        }
        return arr;
    }

    public void onDataFormat()
    {
        comboCd = comboCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        ibflag = ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        name = name.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        desc = desc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        val = val.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
        pagerows = pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
    }

    private static final long serialVersionUID = 1L;
    private Collection models;
    private String comboCd;
    private String val;
    private String name;
    private String desc;
    private String ibflag;
    private String pagerows;
    private HashMap hashColumns;
    private HashMap hashFields;
}

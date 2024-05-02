/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ComboBoxTag.java
 *@FileTitle : Common
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-11
 *@LastModifier : 김원섭
 *@LastVersion : 1.0
 * 2006-10-11 김원섭
 * 1.0 최초 생성
 * 
 * 2008-10-28 임옥영 CSRNO=N200810240577
 * 단축키 설정 관련 combobox ENTER처리를위해 createMultiCombo() _OnKeyDown추가
 * 2011.07.12 Kim jong jun :[CHM-201111824] 소스 품질검토 결과 적용 .
 =========================================================*/
package com.hanjin.apps.alps.esm.spc.common.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import com.hanjin.framework.core.layer.event.EventException;

/**
 * 조회조건 ComboBox를 생성시킨다
 * 
 * @author 김원섭
 * @see 
 * @since J2EE 1.4
 */
public abstract class ComboBoxTag extends TagSupport {
	private transient Logger log;
	protected static final int SELECT = 1;

	protected static final int MULTICOMBO = 2;
	protected static final int SHEETCOMBO = 3;
	private String module = "";

	private String type = "";

	private String name = "";

	private String script = "";

	private String style = "";

	private String def = "";

	private String options = "";

	private String etc = "";

	private String del = "";
	
	private String width = "";

	private String className = "";
	private String multi = "false";
	private String multiCount = "1"; 
	private boolean editable = true;
	private String id = "";
	protected ComboBoxTag() {
        log = Logger.getLogger(getClass().getName());
	}
	/**
	 * 멤버변수의 setter method
	 * 
	 * @param type
	 */
	public void setDisplayType(String displayType) {
		this.type = displayType;
	}

	/**
	 * 멤버변수의 setter method
	 * 
	 * @param className
	 */
	public void setClass(String className) {
		this.className = className;
	}

	/**
	 * 멤버변수의 setter method
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 멤버변수의 setter method
	 * 
	 * @param del
	 */
	public void setDel(String del) {
		this.del = del.equalsIgnoreCase("TRUE")?"Y":"N";
	}

	/**
	 * 멤버변수의 setter method
	 * 
	 * @param options
	 */
	public void setOptions(String options) {
		this.options = options;
	}

	/**
	 * 멤버변수의 setter method
	 * 
	 * @param def
	 */
	public void setDef(String def) {
		this.def = def;
	}

	/**
	 * 멤버변수의 setter method
	 * 
	 * @param etc
	 */
	public void setEtc(String etc) {
		this.etc = etc;
	}

	/**
	 * 멤버변수의 setter method
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 멤버변수의 setter method
	 * 
	 * @param script
	 */
	public void setScript(String script) {
		this.script = script;
	}

	/**
	 * 멤버변수의 setter method
	 * 
	 * @param style
	 */
	public void setStyle(String style) {
		this.style = style;
	}

	/**
	 * 멤버변수의 setter method
	 * 
	 * @param style
	 */
	public void setMulti(String multi) {
		this.multi = multi;
	}

	/**
	 * 멤버변수의 setter method
	 * 
	 * @param style
	 */
	public void setMultiCount(String multiCount) {
		this.multiCount = multiCount;
	}

	/**
	 * 멤버변수의 setter method
	 * 
	 * @param width
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * CustomTag 실행 method
	 * 
	 * @return int
	 */
	public int doStartTag() throws JspException {
		try {
			module = pageContext.getPage().toString();
			int pos = module.lastIndexOf("esm");
			module = module.substring(pos + 4, pos + 7);
			JspWriter out = pageContext.getOut();
			String text = getDataListText();
			out.print(text);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new JspException(e);
		}
		return (SKIP_BODY);
	}
	
	/**
	 * combobox의 display 타입을 조회한다.
	 * 
	 * @return int
	 */
	public String getDataListText() throws EventException{
		int dType = getType();
		String text = "";
		switch (dType) {
		case SELECT:
			text = createSelect();
			break;
		case MULTICOMBO:
			text = createMultiCombo();
			break;
		case SHEETCOMBO:
			text = createSheetCombo();
			break;
		}
		return text;
	}
	
	/**
	 * Option 목록을 조회한다.
	 * @return
	 */
	private String[] getOptions(){
		String[] opt = new String[0];
		if (options != null) {
			opt = options.split("!!");
		}
		return opt;
	}

	protected String getModule() {
		return module;
	}
	protected String getDef() {
		return def;
	}
	protected String getDel() {
		return del;
	}
	/**
	 * Sheet의 Combo Data를 생성한다
	 * 
	 * @param out
	 */
	private String createSheetCombo() throws EventException {
		String[] opt = getOptions();
		int dataCnt = 0;
		StringBuffer buf = new StringBuffer();
		StringBuffer text = new StringBuffer();
		StringBuffer code = new StringBuffer();
		for (int i = 0; i < opt.length; i++) {
			String[] vals = opt[i].replace('/', ':').split(":");
			if (vals[0].equals("0")) {
				code.append("|").append(vals[1]);
				text.append("|").append(vals[2].replace('|', '\t'));
				dataCnt = dataCnt + 1;
			}
		}
		String[][] datas = getOptionList();
		for (int i = 0; i < datas.length; i++) {
			code.append("|").append(datas[i][0]);
			text.append("|").append(datas[i][1].replace('|', '\t'));
			dataCnt = dataCnt + 1;
		}
		for (int i = 0; i < opt.length; i++) {
			String[] vals = opt[i].replace('/', ':').split(":");
			if (vals[0].equals("9")) {
				code.append("|").append(vals[1]);
				text.append("|").append(vals[2].replace('|', '\t'));
				dataCnt = dataCnt + 1;
			}
		}
		if(code.charAt(1) != '|' || code.charAt(2) == '|'){
			code.deleteCharAt(0);
		}
		buf.append("<script language=\"JavaScript\">\n");
		buf.append("function getSheetCombo_"+name+"(){\n");
		buf.append("    var data = new Array();\n");
		if(!code.toString().equals("")){
			buf.append("    data[0] = \"").append(code.toString()).append("\";\n");
			buf.append("    data[1] = \"").append(text.toString().substring(1)).append("\";\n");
			buf.append("    return data\n");
		}
		else{
			buf.append("    return null\n");
		}
		buf.append("}\n");
		buf.append("function initSheetCombo_"+name+"(sheetObj, row, col){\n");
		buf.append("    var data = getSheetCombo_"+name+"();\n");
		buf.append("    if(data == null) return;\n");
		buf.append("    try{\n");
		buf.append("        sheetObj.InitDataCombo (row, col, data[1], data[0], \"\", \"\", \""+getShowCol()+"\");\n");
		buf.append("    }catch(e){log(e);}\n");
		buf.append("}\n");
		buf.append("</script>\n");
		return buf.toString();

	}
	/**
	 * ComboBox를 MultiCombo로 생성한다
	 * 
	 * @param out
	 */
	private String createMultiCombo() throws EventException {
		String[] opt = getOptions();
		StringBuffer buf = new StringBuffer();
		StringBuffer preOption = new StringBuffer();
		StringBuffer postOption = new StringBuffer();
		StringBuffer dataOption = new StringBuffer();
		for (int i = 0; i < opt.length; i++) {
			String[] vals = opt[i].replace('/', ':').split(":");
			if (vals[0].equals("0")) {
				preOption.append("        InsertItem(cnt++, \"" + vals[2] + "\", \"" + vals[1] + "\");\n");
			} else if (vals[0].equals("9")) {
				postOption.append("        InsertItem(cnt++, \"" + vals[2] + "\", \"" + vals[1] + "\");\n");
			}
		}
		String[][] datas = getOptionList();
		for (int i = 0; i < datas.length; i++) {
			dataOption.append("        InsertItem(cnt++, \"" + datas[i][1] + "\", \"" + datas[i][0] + "\");\n");
		}
		buf.append("<script language=\"JavaScript\">\n");
		buf.append("function initData_" + name + "(){\n");
		buf.append("    var sheetObj = document.getElementById(\"" + name + "\");\n");
		buf.append("    var cnt = 0;\n");
		buf.append("    with(sheetObj){\n");
		String str = getTitle();
		if (str != null) {
			buf.append("        SetTitle(\"" + str + "\");\n");
		}
		str = getColWidth();
		if (str != null) {
			buf.append("        SetColWidth(\"" + str + "\");\n");
		}
		str = getAlign();
		if (str != null) {
			buf.append("        SetColAlign(\"" + str + "\");\n");
		}
		int showCol = getShowCol();
		if(showCol >= 0){
			buf.append("        ShowCol = " + showCol + ";\n");
		}
		
		buf.append("        MultiSelect = " + multi + ";\n");
		buf.append("        MaxSelect = " + multiCount + ";\n");
		buf.append("        DropHeight = 190;\n");
		buf.append(preOption.toString());
		buf.append(dataOption.toString());
		buf.append(postOption.toString());
		String defVal = def.equals("") ? getDefault() : def;
		if (def != null && !def.equals("")) {
			buf.append("        Code = \"" + defVal + "\";\n");
		}
		if(!editable) {
			buf.append("        Enable = false;\n");
		}
		buf.append("    }\n");
		buf.append("}\n");
		buf.append("function initDataValue_" + name + "(){\n");
		buf.append("    var sheetObj = document.getElementById(\"" + name + "\");\n");
		buf.append("    with(sheetObj){\n");
		if (def != null && !def.equals("")) {
			buf.append("        Code2 = \"" + defVal + "\";\n");
		}
		else{
			buf.append("        Index2 = 0;\n");
		}
		buf.append("    }\n");
		buf.append("}\n");
		if(!multi.equals("true")) {
			buf.append("function "+name+"_OnBlur_t(comObj){\n");
			buf.append("    return;\n");
			buf.append("    log(\""+name+"_OnBlur\");\n");
			buf.append("    var finded = comObj.FindIndex(comObj.Text() , "+getShowCol()+");\n");
			buf.append("    log(\""+name+"_OnBlur finded : \"+finded);\n");
			buf.append("//    if(finded == comObj.Text()) return;\n");
			buf.append("    if(finded == \"-1\"){\n");
			buf.append("        comObj.Index = 0;\n");
			buf.append("    }\n");
			buf.append("    else{\n");
			buf.append("        comObj.Code = finded;\n");
			buf.append("    }\n");
			buf.append("}\n");
			
			buf.append(name+"_OnBlur = funcAdd(\""+name+"_OnBlur_t\", \""+name+"_OnBlur\");\n");
			//keyDown추가
			buf.append(name+"_OnKeyDown = funcAdd(\""+name+"_OnKeyDown_t\", \""+name+"_OnKeyDown\");\n");
		}
		buf.append("</script>");
		buf.append("<script language=\"JavaScript\">");
		buf.append("ComComboObject(\"" + name + "\", " + getCols() + ", " + getWidth() + ", " + (editable?0:1));
		if(className.equals("input1") ) {
			buf.append(", 1 ");
		}
		buf.append(");initData_" + name+"();");
		buf.append("</script>\n");
		return buf.toString();

	}

	/**
	 * ComboBox를 SelectBox로 생성한다
	 * 
	 * @param out
	 */
	private String createSelect() throws EventException {
		StringBuffer buf = new StringBuffer();
		buf.append("<select name=\"" + name + "\"");
		if (className != null && !"".equals(className)) {
			buf.append(" class=\"" + className + "\"");
		}
		if (id != null && !"".equals(id)) {
			buf.append(" id=\"" + id + "\"");
		}
		if (style != null && !"".equals(style)) {
			buf.append(" style=\"" + style + "\"");
		}
		if (script != null && !"".equals(script)) {
			buf.append(" " + script);
		}
		if (etc != null && !"".equals(etc)) {
			buf.append(" " + etc);
		}
		buf.append(">");
		String[] opt = getOptions();
		StringBuffer preOption = new StringBuffer();
		StringBuffer postOption = new StringBuffer();
		StringBuffer dataOption = new StringBuffer();
		for (int i = 0; i < opt.length; i++) {
			String[] vals = opt[i].replace('/', ':').split(":");
			if (vals[0].equals("0")) {
				preOption.append("<option value=\"" + vals[1] + "\"");
				if ((!def.equals("") && def.equals(vals[1]))) {
					preOption.append(" selected");
				}
				preOption.append(">" + vals[2] + "</option>");
			} else if (vals[0].equals("9")) {
				postOption.append("<option value=\"" + vals[1] + "\"");
				if ((!def.equals("") && def.equals(vals[1]))) {
					postOption.append(" selected");
				}
				postOption.append(">" + vals[2] + "</option>");
			}
		}
		String[][] datas = getOptionList();
		for (int i = 0; i < datas.length; i++) {
			dataOption.append("<option value=\"" + datas[i][0] + "\"");
			if ((def.equals(datas[i][0])) || (def.equals("") && datas[i][0].equals(getDefault()))) {
				dataOption.append(" selected");
			}
			dataOption.append(">" + datas[i][1] + "</option>");
		}
		buf.append(preOption.toString());
		buf.append(dataOption.toString());
		buf.append(postOption.toString());
		buf.append("</select>");
		return buf.toString();

	}

	/**
	 * 초기값을 조회하는 함수
	 * 
	 * @return String
	 */
	protected int getWidth() {
		int val = 0;
		if(width != null && !width.equals("") && width.matches("[0-9]*")) {
			val = Integer.parseInt(width);
		}
		else{
			val = getDefaultWidth();
		}
		return val;
	}

	/**
	 * List에 보여질 데이터를 조회하는 추상화 함수
	 * 
	 * @return String[][]
	 */
	protected abstract String[][] getOptionList() throws EventException;

	/**
	 * MultiCombo로 보여질지 SelectBox로 보여질지 선택하는 추상화 함수
	 * 
	 * @return int
	 */
	protected abstract int getType();

	/**
	 * Dispaly type을 선택
	 * 
	 * @param def default value
	 * @return int
	 */
	protected int getType(int def){
		if (type.equals("SELECT"))
			return ComboBoxTag.SELECT;
		if (type.equals("MULTICOMBO"))
			return ComboBoxTag.MULTICOMBO;
		if (type.equals("SHEETCOMBO"))
			return ComboBoxTag.SHEETCOMBO;
		return def;
	}

	/**
	 * 초기값을 조회하는 추상화 함수
	 * 
	 * @return String
	 */
	protected abstract String getDefault();

	/**
	 * 추상화 함수
	 * 
	 * @return int
	 */
	protected abstract int getDefaultWidth();

	/**
	 * 추상화 함수
	 * 
	 * @return int
	 */
	protected abstract int getCols();

	/**
	 * 추상화 함수
	 * 
	 * @return int
	 */
	protected abstract int getShowCol();

	/**
	 * 추상화 함수
	 * 
	 * @return String
	 */
	protected abstract String getAlign();

	/**
	 * 추상화 함수
	 * 
	 * @return String
	 */
	protected abstract String getTitle();

	/**
	 * 추상화 함수
	 * 
	 * @return String
	 */
	protected abstract String getColWidth();
	/**
	 * @param editable the editable to set
	 */
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
}
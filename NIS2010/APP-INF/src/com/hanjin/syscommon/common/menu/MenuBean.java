/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MenuBean.java
*@FileTitle : 메뉴 Value Object
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-22
*@LastModifier : SeongWook Kim
*@LastVersion : 1.0
* 2006-08-11 SeongWook Kim
* 1.0 최초 ?��?��
=========================================================*/
package com.hanjin.syscommon.common.menu;

/**
 * Menu Information Bean<br>
 * Menu Information?�� ?��?�� 객체<br>
 * 
 * @author SeongWook Kim
 * @see MenuProcessor,MenuEventResponse,MenuDBDAO 참조
 * @since J2EE 1.4
 */
public class MenuBean implements java.io.Serializable {

	/**
     * 메뉴?�� ?��벨정�? : 1 ~ 7?���?
	 */
    private String menuLevel;
    /**
     * 메뉴?�� 계층구조?��?�� ?��?��?�� �?�? ?��?���? �?�? ?��?�� ?��?��?�� 간의 출력 ?��?��
	 */
    private String menuOrder;
    /**
     * 메뉴 코드
	 */
    private String menuId;
    /**
     * 출력?�� 메뉴�?
	 */
    private String menuText;
    /**
     * ?��?�� 링크?�� ?��로그?���?
	 */
    private String programName;
    /**
     * ?��?�� 링크?�� ?��로그?�� 코드
	 */
    private String pid;
    /**
     * ?��?�� ?���?
	 */
    private String popup_yn;

    /**
     * ?��?��?��
	 */
    private String child_cnt;

    /**
     * ?��?�� 메뉴�? 최�?길이
	 */
    private String child_max_len;

    /**
     * 권한 ?��?�� ?���? Y or N
	 */
    private String authYn;
    /**
     * Bean ?��?��?��
     */
    public MenuBean() {}

    /**
     * Bean ?��?��?��
     * @param menuLevel 메뉴?���?
     * @param menuId 메뉴코드
     * @param menuText 메뉴�?
     * @param programName ?��로그?���?
     * @param pid ?��로그?��코드
     * @param popup_yn ?��?��?���?
     */
    public MenuBean(
        String menuLevel,
        String menuId,
        String menuText,
        String programName,
        String pid,
        String popup_yn) {
        this.menuLevel = menuLevel;
        this.menuId = menuId;
        this.menuText = menuText;
        this.programName = programName;
        this.pid = pid;
        this.popup_yn = popup_yn;
    }
    
    /**
     * Bean ?��?��?��
     * @param menuLevel 메뉴?���?
     * @param menuId 메뉴코드
     * @param menuText 메뉴�?
     * @param programName ?��로그?���?
     * @param pid ?��로그?��코드
     * @param popup_yn ?��?��?���?
     * @param menuOrder 메뉴?��?��
     */
    public MenuBean(
        String menuLevel,
        String menuId,
        String menuText,
        String programName,
        String pid,
        String popup_yn,
        String menuOrder,
        String childCnt,
        String childMaxLen,
        String authYn) {
        this.menuLevel = menuLevel;
        this.menuId = menuId;
        this.menuText = menuText;
        this.programName = programName;
        this.pid = pid;
        this.popup_yn = popup_yn;
        this.menuOrder = menuOrder;
        this.child_cnt = childCnt;
        this.child_max_len = childMaxLen;
        this.authYn = authYn;
    }

    /**
     * Bean ?��?��?��
     * @param menuLevel 메뉴?���?
     * @param menuId 메뉴코드
     * @param menuText 메뉴�?
     * @param programName ?��로그?���?
     * @param pid ?��로그?��코드
     * @param popup_yn ?��?��?���?
     * @param menuOrder 메뉴?��?��
     */
    public MenuBean(
        String menuLevel,
        String menuId,
        String menuText,
        String programName,
        String pid,
        String popup_yn,
        String menuOrder) {
        this.menuLevel = menuLevel;
        this.menuId = menuId;
        this.menuText = menuText;
        this.programName = programName;
        this.pid = pid;
        this.popup_yn = popup_yn;
        this.menuOrder = menuOrder;
    }

    /**
	 * @return  Returns the menuLevel.
	 */
    public String getMenuLevel() {
        return menuLevel;
    }

    /**
	 * @return  Returns the menuId.
	 */
    public String getMenuId() {
        return menuId;
    }

    /**
	 * @return  Returns the menuText.
	 */
    public String getMenuText() {
        return menuText;
    }

    /**
	 * @return  Returns the programName.
	 */
    public String getProgramName() {
        return programName;
    }

    /**
	 * @return  Returns the pid.
	 */
    public String getPid() {
        return pid;
    }

    /**
	 * @return  Returns the popup_yn.
	 */
    public String getPopup_yn() {
        return popup_yn;
    }

    /**
	 * @return  Returns the menuOrder.
	 */
	public String getMenuOrder() {
		return menuOrder;
	}

    /**
	 * @return  Returns the child_cnt.
	 */
	public String getChildCnt() {
		return child_cnt;
	}

    /**
	 * @return  Returns the child_max_len.
	 */
	public String getChildMaxLength() {
		return child_max_len;
	}

	/**
	 * top메뉴?��?�� ?��미�? 마우?��롤오�? ?��?�� ?��?��?��?�� ?��?��립트 ?��?��
	 * @param totalLayerCount 1?��벨의 메뉴 ?��?? ?���?
	 * @param showLayerIndex ?��면에?�� 마우?��?���?,마우?��?��?�� ?��벤트 발생?�� 보여�? ?��?��?��(메뉴)?�� ?��?��?��번호
	 * @return Show_Hide ?��바스?��립트 ?��?��
	 */
	public static String getShowHideScript(int totalLayerCount, int showLayerIndex){
		StringBuffer buf = new StringBuffer();

	    buf.append("Show_Hide(");
	    for(int i =1; i<=totalLayerCount; i++){
	      if(i>1) buf.append(",");
	      buf.append("'Layer"+i+"','',");
	      if(i==showLayerIndex){
	    	  buf.append("'show'");
	      }else{
	    	  buf.append("'hide'");
	      }
	    }
	    buf.append(");");
	    return buf.toString();
		
/*	    String val = "Show_Hide(";
	    for(int i =1; i<=totalLayerCount; i++){
	      if(i>1) val +=",";
	      val +="'Layer"+i+"','',";
	      if(i==showLayerIndex){
	        val +="'show'";
	      }else{
	        val +="'hide'";
	      }
	    }
	    val += ");";
	    return val;*/
		//Show_Hide('Layer1','','show','Layer2','','hide','Layer3','','hide','Layer4','','hide');
	}
	
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuffer strBuf = new StringBuffer();
        strBuf.append("{");
        strBuf.append("menuLevel = " + menuLevel).append(", ");
        strBuf.append("menuId = " + menuId).append(", ");
        strBuf.append("menuText = " + menuText).append(", ");
        strBuf.append("programName = " + programName).append(", ");
        strBuf.append("pid = " + pid).append(",");
        strBuf.append("popup_yn = " + popup_yn).append(",");
        strBuf.append("menuOrder = " + menuOrder).append("}");
        return strBuf.toString();
    }

	public void setAuthYn(String authYn) {
		this.authYn = authYn;
	}

	public String getAuthYn() {
		return authYn;
	}
}

/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MenuBean.java
*@FileTitle : ë©”ë‰´ Value Object
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-22
*@LastModifier : SeongWook Kim
*@LastVersion : 1.0
* 2006-08-11 SeongWook Kim
* 1.0 ìµœì´ˆ ?ƒ?„±
=========================================================*/
package com.hanjin.syscommon.common.menu;

/**
 * Menu Information Bean<br>
 * Menu Information?„ ?‹´?Š” ê°ì²´<br>
 * 
 * @author SeongWook Kim
 * @see MenuProcessor,MenuEventResponse,MenuDBDAO ì°¸ì¡°
 * @since J2EE 1.4
 */
public class MenuBean implements java.io.Serializable {

	/**
     * ë©”ë‰´?˜ ? ˆë²¨ì •ë³? : 1 ~ 7? ˆë²?
	 */
    private String menuLevel;
    /**
     * ë©”ë‰´?˜ ê³„ì¸µêµ¬ì¡°?—?„œ ?™?¼?•œ ë¶?ëª? ?…¸?“œë¥? ê°?ì§? ??‹ ?…¸?“œ?“¤ ê°„ì˜ ì¶œë ¥ ?ˆœ?„œ
	 */
    private String menuOrder;
    /**
     * ë©”ë‰´ ì½”ë“œ
	 */
    private String menuId;
    /**
     * ì¶œë ¥?  ë©”ë‰´ëª?
	 */
    private String menuText;
    /**
     * ?‹¤? œ ë§í¬?  ?”„ë¡œê·¸?¨ëª?
	 */
    private String programName;
    /**
     * ?‹¤? œ ë§í¬?  ?”„ë¡œê·¸?¨ ì½”ë“œ
	 */
    private String pid;
    /**
     * ?Œ?—… ?—¬ë¶?
	 */
    private String popup_yn;

    /**
     * ??‹?ˆ˜
	 */
    private String child_cnt;

    /**
     * ??‹ ë©”ë‰´ëª? ìµœë?ê¸¸ì´
	 */
    private String child_max_len;

    /**
     * ê¶Œí•œ ?†Œ?œ  ?—¬ë¶? Y or N
	 */
    private String authYn;
    /**
     * Bean ?ƒ?„±?
     */
    public MenuBean() {}

    /**
     * Bean ?ƒ?„±?
     * @param menuLevel ë©”ë‰´? ˆë²?
     * @param menuId ë©”ë‰´ì½”ë“œ
     * @param menuText ë©”ë‰´ëª?
     * @param programName ?”„ë¡œê·¸?¨ëª?
     * @param pid ?”„ë¡œê·¸?¨ì½”ë“œ
     * @param popup_yn ?Œ?—…?—¬ë¶?
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
     * Bean ?ƒ?„±?
     * @param menuLevel ë©”ë‰´? ˆë²?
     * @param menuId ë©”ë‰´ì½”ë“œ
     * @param menuText ë©”ë‰´ëª?
     * @param programName ?”„ë¡œê·¸?¨ëª?
     * @param pid ?”„ë¡œê·¸?¨ì½”ë“œ
     * @param popup_yn ?Œ?—…?—¬ë¶?
     * @param menuOrder ë©”ë‰´?ˆœ?„œ
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
     * Bean ?ƒ?„±?
     * @param menuLevel ë©”ë‰´? ˆë²?
     * @param menuId ë©”ë‰´ì½”ë“œ
     * @param menuText ë©”ë‰´ëª?
     * @param programName ?”„ë¡œê·¸?¨ëª?
     * @param pid ?”„ë¡œê·¸?¨ì½”ë“œ
     * @param popup_yn ?Œ?—…?—¬ë¶?
     * @param menuOrder ë©”ë‰´?ˆœ?„œ
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
	 * topë©”ë‰´?—?„œ ?´ë¯¸ì? ë§ˆìš°?Š¤ë¡¤ì˜¤ë²? ?“±?— ?‚¬?š©?•˜?Š” ?Š¤?¬ë¦½íŠ¸ ?ƒ?„±
	 * @param totalLayerCount 1? ˆë²¨ì˜ ë©”ë‰´ ?ˆ˜?? ?¼ì¹?
	 * @param showLayerIndex ?™”ë©´ì—?„œ ë§ˆìš°?Š¤?˜¤ë²?,ë§ˆìš°?Š¤?•„?›ƒ ?´ë²¤íŠ¸ ë°œìƒ?‹œ ë³´ì—¬ì¤? ? ˆ?´?–´(ë©”ë‰´)?˜ ?¸?±?Š¤ë²ˆí˜¸
	 * @return Show_Hide ?ë°”ìŠ¤?¬ë¦½íŠ¸ ?•¨?ˆ˜
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

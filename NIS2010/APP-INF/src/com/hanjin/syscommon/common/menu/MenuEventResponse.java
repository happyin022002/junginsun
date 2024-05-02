/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MenuEventResponse.java
*@FileTitle : ë©”ë‰´ë¦¬í„´ Value Object
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-22
*@LastModifier : SeongWook Kim
*@LastVersion : 1.0
* 2006-08-11 SeongWook Kim
* 1.0 ìµœì´ˆ ?ƒ?„±
=========================================================*/
package com.hanjin.syscommon.common.menu;

import java.util.ArrayList;
import java.util.Collection;

import com.hanjin.framework.support.layer.event.EventResponseSupport;

/**
 * Menu Creation Value Object EventResponse<br>
 * Menu Creation ?›„?— ê²°ê³¼ë¥? ?‹´?•„ ? „?‹¬?•˜?Š” ê°ì²´<br>
 * 
 * @author SeongWook Kim
 * @see MenuBean,MenuProcessor,MenuDBDAO ì°¸ì¡°
 * @since J2EE 1.4
 */
public class MenuEventResponse extends EventResponseSupport {
    /**
     * ?”„ë¡œê·¸?¨ ë¦¬ìŠ¤?Š¸
	 */
    private Collection programList = null;

    /**
     * ?´ë²¤íŠ¸ë¦¬ìŠ¤???Š¤ ?ƒ?„±?
     */
    public MenuEventResponse() {
    }

    /**
     * ?´ë²¤íŠ¸ë¦¬ìŠ¤???Š¤ ?ƒ?„±?
     * @param programList ?”„ë¡œê·¸?¨ ë¦¬ìŠ¤?Š¸
     */
    public MenuEventResponse(Collection programList) {
        this.programList = programList;
    }

    /**
     * @return Returns the programList.
     */
    public Collection getMenu() {
        return this.programList;
    }

    /**
     * totalList?—?„œ pidë¥? ë¶?ëª¨ë¡œ ?‘” level? ˆë²¨ì˜ ë©”ë‰´ë§? ë¦¬í„´
     * @param totalList
     * @param level
     * @param pid
     * @return Returns menu list
     */
    public ArrayList getMenuList(ArrayList totalList, String level, String pid) {
        MenuBean menuBean = null;
        ArrayList arrList = new ArrayList();
        if (pid == null || pid.equals("")) {
            for (int i = 0; i < totalList.size(); i++) {
                menuBean = (MenuBean) totalList.get(i);
            	log.info("MenuEventResponse : "+menuBean.getMenuId()+" : "+menuBean.getMenuLevel());
                if (level.equals(menuBean.getMenuLevel())) {
                	log.info("MenuEventResponse : OK");
                    arrList.add(menuBean);
                }
            }
        } else {
            for (int i = 0; i < totalList.size(); i++) {
                menuBean = (MenuBean) totalList.get(i);
                if (level.equals(menuBean.getMenuLevel()) && pid.equals(menuBean.getPid())) {
                    arrList.add(menuBean);
                }
            }
        }
        return arrList;
    }

    /**
     * totalList?—?„œ pid ë¦¬ìŠ¤?Š¸ë§? ë¦¬í„´
     * @param totalList
     * @return Returns pid list
     */
    public ArrayList getPidList(ArrayList totalList) {
        String pidStr = null;
        MenuBean menuBean = null;
        ArrayList arrList = new ArrayList();
        for (int i = 0; i < totalList.size(); i++) {
            menuBean = (MenuBean) totalList.get(i);
            pidStr = menuBean.getPid();

            if (pidStr != null && !pidStr.equals("") && !arrList.contains(pidStr)) {
                arrList.add(pidStr);
            }
        }
        return arrList;
    }

    /**
     * @param mainMenuList
     * @param pidStr
     * @return Returns pid list
     */
    public String getMainImageIndex(ArrayList mainMenuList, String pidStr) {
        String menuIdStr = null;
        MenuBean menuBean = null;
        String indexStr = "";
        for (int i = 0; i < mainMenuList.size(); i++) {
            menuBean = (MenuBean) mainMenuList.get(i);
            menuIdStr = menuBean.getMenuId();

            if (menuIdStr.equals(pidStr)) {
                indexStr = i + "";
            }
        }
        return indexStr;
    }

    /**
     * menuList?—?„œ programName?˜ ?”„ë¡œê·¸?¨ëª…ì„ ê°?ì§? MenuBean?„ ë¦¬í„´
     * @param menuList
     * @param programName
     * @return Return MenuBean
     */
    public MenuBean getMenuBean(ArrayList menuList, String programName) {
        MenuBean bean = null;
        for (int i = 0; i < menuList.size(); i++) {
            bean = (MenuBean) menuList.get(i);
            if (bean.getProgramName().equals(programName)) {
                return bean;
            }
        }
        return null;
    }

    /**
     * ?˜•? œ?…¸?“œ ì¤‘ì—?„œ?˜ ?¸?±?Š¤ë¥? ë¦¬í„´
     * @param menuList
     * @param bean
     * @return Return Menu Index
     */
    public int getMenuIdx(ArrayList menuList, MenuBean bean) {
        MenuBean tmpBean = null;
        int idx = -1;

        if (bean.getMenuLevel().equals("1")) {
            for (int i = 0; i < menuList.size(); i++) {
                tmpBean = (MenuBean) menuList.get(i);
                if (tmpBean.getMenuLevel().equals(bean.getMenuLevel())) {
                    idx++;
                }

                if (bean.getProgramName().equals(tmpBean.getProgramName())) {
                    return idx;
                }
            }
        } else {
            for (int i = 0; i < menuList.size(); i++) {
                tmpBean = (MenuBean) menuList.get(i);
                if (tmpBean.getPid().equals(bean.getPid())) {
                    idx++;
                }

                if (bean.getProgramName().equals(tmpBean.getProgramName())) {
                    return idx;
                }
            }

        }

        return -1;
    }

    /**
     * ?´ë²¤íŠ¸ëª? ë°˜í™˜
     */
    public String toString() {
        return "MenuEventResponse";
    }

    /**
     * ?´ë²¤íŠ¸ëª? ë°˜í™˜
     */
    public String getEventName() {
        return "MenuEventResponse";
    }

}

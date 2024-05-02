/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MenuEventResponse.java
*@FileTitle : 메뉴리턴 Value Object
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-22
*@LastModifier : SeongWook Kim
*@LastVersion : 1.0
* 2006-08-11 SeongWook Kim
* 1.0 최초 ?��?��
=========================================================*/
package com.hanjin.syscommon.common.menu;

import java.util.ArrayList;
import java.util.Collection;

import com.hanjin.framework.support.layer.event.EventResponseSupport;

/**
 * Menu Creation Value Object EventResponse<br>
 * Menu Creation ?��?�� 결과�? ?��?�� ?��?��?��?�� 객체<br>
 * 
 * @author SeongWook Kim
 * @see MenuBean,MenuProcessor,MenuDBDAO 참조
 * @since J2EE 1.4
 */
public class MenuEventResponse extends EventResponseSupport {
    /**
     * ?��로그?�� 리스?��
	 */
    private Collection programList = null;

    /**
     * ?��벤트리스???�� ?��?��?��
     */
    public MenuEventResponse() {
    }

    /**
     * ?��벤트리스???�� ?��?��?��
     * @param programList ?��로그?�� 리스?��
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
     * totalList?��?�� pid�? �?모로 ?�� level?��벨의 메뉴�? 리턴
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
     * totalList?��?�� pid 리스?���? 리턴
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
     * menuList?��?�� programName?�� ?��로그?��명을 �?�? MenuBean?�� 리턴
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
     * ?��?��?��?�� 중에?��?�� ?��?��?���? 리턴
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
     * ?��벤트�? 반환
     */
    public String toString() {
        return "MenuEventResponse";
    }

    /**
     * ?��벤트�? 반환
     */
    public String getEventName() {
        return "MenuEventResponse";
    }

}

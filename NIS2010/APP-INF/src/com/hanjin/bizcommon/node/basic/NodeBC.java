/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : NodeBC.java
*@FileTitle : Node 조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-17
*@LastModifier : Hyung Choon
*@LastVersion : 1.0
* 2006-08-17 Hyung Choon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.node.basic;

import java.util.List;

import com.hanjin.framework.core.layer.event.EventException;

/**
 * ENIS-BIZCOMMON Business Logic Command Interface<br>
 * - ENIS-BIZCOMMON에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Hyung Choon
 * @see ComEns061EventResponse 참조
 * @since J2EE 1.4
 */
public interface NodeBC  {
	
    /**
     * 조회 이벤트 처리<br>
     * Node화면에 대한 조회 이벤트 처리<br>
     * @param cntCd
     * @param locCd
     * @param ofcCd
     * @param nodeCd
     * @param nodeNm
     * @param mode
     * @param modeOnly
     * @param sccCd
     * @param iPage
     * @return List<SearchNodeListVO>
     * @throws EventException
     */
    public List<Object> searchNodeList(String cntCd, String locCd, String ofcCd, String nodeCd, String nodeNm, String mode, String modeOnly, String sccCd, int iPage) throws EventException;

}
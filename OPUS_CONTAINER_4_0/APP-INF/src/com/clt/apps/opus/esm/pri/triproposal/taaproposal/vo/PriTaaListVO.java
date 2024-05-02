/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RsltPropVO.java
 *@FileTitle : RsltPropVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.06
 *@LastModifier : 변영주
 *@LastVersion : 1.0
 * 2009.04.16 변영주 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.triproposal.taaproposal.vo;

import java.io.Serializable;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 변영주
 * @since J2EE 1.5
 */
public class PriTaaListVO implements Serializable {

    private static final long serialVersionUID = 1L;
    private RsltTaaMnVO rsltTaaMnVO = null;
    private RsltTaaMnVO[] rsltTaaMnVOs = null;
    private RsltTaaTriListVO[] rsltTaaTriListVOs = null;

    public RsltTaaMnVO getRsltTaaMnVO () {
        return rsltTaaMnVO;
    }

    public void setRsltTaaMnVO (RsltTaaMnVO rsltTaaMnVO) {
        this.rsltTaaMnVO = rsltTaaMnVO;
    }

    public RsltTaaMnVO[] getRsltTaaMnVOs () {
        return rsltTaaMnVOs;
    }

    public void setRsltTaaMnVOs (RsltTaaMnVO[] rsltTaaMnVOs) {
        this.rsltTaaMnVOs = rsltTaaMnVOs;
    }

    public RsltTaaTriListVO[] getRsltTaaTriListVOs () {
        return rsltTaaTriListVOs;
    }

    public void setRsltTaaTriListVOs (RsltTaaTriListVO[] rsltTaaTriListVOs) {
        this.rsltTaaTriListVOs = rsltTaaTriListVOs;
    }
}

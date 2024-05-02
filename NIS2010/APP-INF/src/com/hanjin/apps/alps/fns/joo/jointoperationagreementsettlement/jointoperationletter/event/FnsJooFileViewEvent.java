/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJooFIleViewEvent
*@FileTitle : Joo FIle View
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.10.22 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.event;

 
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationletter.vo.FileInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;
 
/**
 * JOO_FILE_VIEW.jsp 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  JOO_FILE_VIEW.jspHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jang kang cheol
 * @see FNS_JOO_FILEVIEWHTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJooFileViewEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private FileInfoVO fileInfo = null;
	
	/** Table Value Object Multi Data 처리 */
	private FileInfoVO[] fileInfos = null;

	public FnsJooFileViewEvent(){}

    /**
     * @return the fileInfo
     */
    public FileInfoVO getFileInfo() {
        return fileInfo;
    }

    /**
     * @return the fileInfos
     */
    public FileInfoVO[] getFileInfos() {
        FileInfoVO[] rtnVOs = null;
		if (this.fileInfos != null) {
			rtnVOs = new FileInfoVO[fileInfos.length];
			System.arraycopy(fileInfos, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;        
    }

    /**
     * @param fileInfo the fileInfo to set
     */
    public void setFileInfo(FileInfoVO fileInfo) {
        this.fileInfo = fileInfo;
    }

    /**
     * @param fileInfos the fileInfos to set
     */
    public void setFileInfos(FileInfoVO[] fileInfos) {
		if (fileInfos != null) {
			FileInfoVO[] tmpVOs = new FileInfoVO[fileInfos.length];
			System.arraycopy(fileInfos, 0, tmpVOs, 0, tmpVOs.length);
			this.fileInfos = tmpVOs;
		}        
    } 
}
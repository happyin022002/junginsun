/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0448Event.java
*@FileTitle : ESM_BKG-0448
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.04.21 임재택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsHistoryListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsRcvHistCondVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG-0448 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0448HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author LIM JAE TAEK
 * @see ESM_BKG-0448HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0448Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RocsRcvHistCondVO rocsRcvHistCondVO = null; 
	private RocsHistoryListCondVO rocsHistoryListCondVO = null;  
	 
	public EsmBkg0448Event(){}
	
	 public void setRocsRcvHistCondVO(RocsRcvHistCondVO rocsRcvHistCondVO){
			this. rocsRcvHistCondVO = rocsRcvHistCondVO;
		}
	 public void setRocsHistoryListCondVO(RocsHistoryListCondVO rocsHistoryListCondVO){
			this. rocsHistoryListCondVO = rocsHistoryListCondVO;
		}
	 
	public RocsRcvHistCondVO getRocsRcvHistCondVO(){
		return rocsRcvHistCondVO;
	} 
	
	public RocsHistoryListCondVO getRocsHistoryListCondVO(){
		return rocsHistoryListCondVO;
	} 
	 
}
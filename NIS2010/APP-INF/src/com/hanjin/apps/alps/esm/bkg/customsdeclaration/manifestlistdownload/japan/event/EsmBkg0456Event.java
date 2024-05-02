/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0456Event.java
*@FileTitle : ESM_BKG-0456
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.06.02 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.event;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListMfrCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.MfrCustModificationVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG-0456 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0456HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM SEUNG MIN
 * @see ESM_BKG-0456HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmBkg0456Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private JapanManifestListMfrCondVO japanManifestListMfrCondVO = null; 	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private MfrCustModificationVO mfrCustModificationVO = null;	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private String form1CustCntCd = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private String form1CustSeq = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	private String custType = null;	

	public EsmBkg0456Event(){} 
	
	public void setJapanManifestListMfrCondVO(JapanManifestListMfrCondVO japanManifestListMfrCondVO){
		this. japanManifestListMfrCondVO = japanManifestListMfrCondVO;
	}	
	 
	public JapanManifestListMfrCondVO getJapanManifestListMfrCondVO(){
		return japanManifestListMfrCondVO;
	}
	
	public void setJapanMfrCustModificationVO(MfrCustModificationVO mfrCustModificationVO){
		this. mfrCustModificationVO = mfrCustModificationVO;
	}	
	 
	public MfrCustModificationVO getJapanMfrCustModificationVO(){
		return mfrCustModificationVO;
	}	
	
	public void setForm1CustCntCd(String form1CustCntCd){
		this. form1CustCntCd = form1CustCntCd;
	}	
	 
	public String getForm1CustCntCd(){
		return form1CustCntCd;
	}	
	
	public void setForm1CustSeq(String form1CustSeq){
		this. form1CustSeq = form1CustSeq;
	}	
	 
	public String getForm1CustSeq(){
		return form1CustSeq;
	}	
	
	public void setCustType(String custType){
		this. custType = custType;
	}	
	 
	public String getCustType(){
		return custType;
	}	
}

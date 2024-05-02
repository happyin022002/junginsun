/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapanContainterVO.java
*@FileTitle : SEA-NACCS: Manifest Data Download _ B/L List 화면에서 계약정보를 담는 컨테이너 VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.05.18 김승민
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.syscommon.common.table.BkgCstmsJpBlMkVO;
import com.hanjin.syscommon.common.table.BkgCstmsJpBlVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see ManifestListDetailVO
 */
public class JapanContainerVO  extends ManifestListDetailVO{
	private static final long serialVersionUID = 1L;
	
	private List<JapanManifestListVslPortSkdVO> japanManifestListVslPortSkdVOs;
	private List<JapanManifestListBkgDetailVO> japanManifestListBkgDetailVOs;
	private List<JapanManifestListBkgDetail2VO> japanManifestListBkgDetail2VOs;
	private List<JapanManifestListCntrDetailVO> japanManifestListCntrDetailVOs;
	private List<JapanManifestListMfsDetailVO> japanManifestListMfsDetailVOs;
	private List<BkgCstmsJpBlMkVO> bkgCstmsJpBlMkVOs;
	private JapanManifestListEtcVO  japanManifestListEtcVO;
	private BkgCstmsJpBlVO  bkgCstmsJpBlVO;
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public JapanContainerVO() {}
	
	public List<JapanManifestListVslPortSkdVO> getJapanManifestListVslPortSkdVOs() {
		return japanManifestListVslPortSkdVOs;
	}
	
	public void setJapanManifestListVslPortSkdVOs(List<JapanManifestListVslPortSkdVO> japanManifestListVslPortSkdVOs) {
		this.japanManifestListVslPortSkdVOs = japanManifestListVslPortSkdVOs;
	}	
	
	public List<JapanManifestListBkgDetailVO> getJapanManifestListBkgDetailVOs() {
		return japanManifestListBkgDetailVOs;
	}
	
	public void setJapanManifestListBkgDetailVOs(List<JapanManifestListBkgDetailVO> japanManifestListBkgDetailVOs) {
		this.japanManifestListBkgDetailVOs = japanManifestListBkgDetailVOs;
	}
	
	public List<JapanManifestListBkgDetail2VO> getJapanManifestListBkgDetail2VOs() {
		return japanManifestListBkgDetail2VOs;
	}	
	
	public void setJapanManifestListBkgDetail2VOs(List<JapanManifestListBkgDetail2VO> japanManifestListBkgDetail2VOs) {
		this.japanManifestListBkgDetail2VOs = japanManifestListBkgDetail2VOs;
	}	
	
	public List<JapanManifestListCntrDetailVO> getJapanManifestListCntrDetailVOs() {
		return japanManifestListCntrDetailVOs;
	}
	
	public void setJapanManifestListCntrDetailVOs(List<JapanManifestListCntrDetailVO> japanManifestListCntrDetailVOs) {
		this.japanManifestListCntrDetailVOs = japanManifestListCntrDetailVOs;
	}	
	
	public List<JapanManifestListMfsDetailVO> getJapanManifestListMfsDetailVOs() {
		return japanManifestListMfsDetailVOs;
	}
	
	public void setJapanManifestListMfsDetailVOs(List<JapanManifestListMfsDetailVO> japanManifestListMfsDetailVOs) {
		this.japanManifestListMfsDetailVOs = japanManifestListMfsDetailVOs;
	}	
	
	public List<BkgCstmsJpBlMkVO> getBkgCstmsJpBlMkVOs() {
		return bkgCstmsJpBlMkVOs;
	}
	
	public void setBkgCstmsJpBlMkVOs(List<BkgCstmsJpBlMkVO> bkgCstmsJpBlMkVOs) {
		this.bkgCstmsJpBlMkVOs = bkgCstmsJpBlMkVOs;
	}	
	
	public JapanManifestListEtcVO getJapanManifestListEtcVO() {
		return japanManifestListEtcVO;
	}
	
	public void setJapanManifestListEtcVO(JapanManifestListEtcVO japanManifestListEtcVO) {
		this.japanManifestListEtcVO = japanManifestListEtcVO;
	}	
	
	public BkgCstmsJpBlVO getBkgCstmsJpBlVO() {
		return bkgCstmsJpBlVO;
	}
	
	public void setBkgCstmsJpBlVO(BkgCstmsJpBlVO bkgCstmsJpBlVO) {
		this.bkgCstmsJpBlVO = bkgCstmsJpBlVO;
	}	
}

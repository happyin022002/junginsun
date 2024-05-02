/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCllSumDetailVO.java
*@FileTitle : KorCllSumDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.07.28 김승민 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

import java.util.HashMap;
import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see KorCllSumDetailVO
 */
public class KorCllSumDetailVO extends AbstractValueObject{
		private static final long serialVersionUID = 1L;
		
		private List<CLLCDLManifestVslSkdInfoVO> cLLCDLManifestVslSkdInfoVOs;
		private List<CLLCDLManifestLoadSumByPodDetailVO> cLLCDLManifestLoadSumByPodDetailVOs;
		private List<CLLCDLManifestSpclCgoSumByPodDetailVO> cLLCDLManifestSpclCgoSumByPodDetailVOs;
		private List<CLLCDLManifestSpclStowRqstByPodDetailVO> cLLCDLManifestSpclStowRqstByPodDetailVOs;
		private List<KorCllLoadSumDetailVO> korCllLoadSumDetailVOs;
		private List<KorCllSpclCgoSumDetailVO> korCllSpclCgoSumDetailVOs;
		private List<KorCllSpclStowRqstDetailVO> korCllSpclStowRqstDetailVOs;	
		private List<KorCllSpclStowRqstDetail2VO> korCllSpclStowRqstDetail2VOs;	
		private List<KorCllSpclStowRqstDetail3VO> korCllSpclStowRqstDetail3VOs;	
		private List<CLLCDLManifestKorCllRemarkInfoVO> cLLCDLManifestKorCllRemarkInfoVOs;		
		
		/**
		 * 생성자
		 * @param
		 * @return 
		 */
		public KorCllSumDetailVO() {}
		
		public List<CLLCDLManifestVslSkdInfoVO> getCLLCDLManifestVslSkdInfoVOs() {
			return cLLCDLManifestVslSkdInfoVOs;
		}
		
		public void setCLLCDLManifestVslSkdInfoVOs(List<CLLCDLManifestVslSkdInfoVO> cLLCDLManifestVslSkdInfoVOs) {
			this.cLLCDLManifestVslSkdInfoVOs = cLLCDLManifestVslSkdInfoVOs;
		}	
		
		public List<CLLCDLManifestLoadSumByPodDetailVO> getCLLCDLManifestLoadSumByPodDetailVOs() {
			return cLLCDLManifestLoadSumByPodDetailVOs;
		}
		
		public void setCLLCDLManifestLoadSumByPodDetailVOs(List<CLLCDLManifestLoadSumByPodDetailVO> cLLCDLManifestLoadSumByPodDetailVOs) {
			this.cLLCDLManifestLoadSumByPodDetailVOs = cLLCDLManifestLoadSumByPodDetailVOs;
		}
		
		public List<CLLCDLManifestSpclCgoSumByPodDetailVO> getCLLCDLManifestSpclCgoSumByPodDetailVOs() {
			return cLLCDLManifestSpclCgoSumByPodDetailVOs;
		}
		
		public void setCLLCDLManifestSpclCgoSumByPodDetailVOs(List<CLLCDLManifestSpclCgoSumByPodDetailVO> cLLCDLManifestSpclCgoSumByPodDetailVOs) {
			this.cLLCDLManifestSpclCgoSumByPodDetailVOs = cLLCDLManifestSpclCgoSumByPodDetailVOs;
		}	
		
		public List<CLLCDLManifestSpclStowRqstByPodDetailVO> getCLLCDLManifestSpclStowRqstByPodDetailVOs() {
			return cLLCDLManifestSpclStowRqstByPodDetailVOs;
		}
		
		public void setCLLCDLManifestSpclStowRqstByPodDetailVOs(List<CLLCDLManifestSpclStowRqstByPodDetailVO> cLLCDLManifestSpclStowRqstByPodDetailVOs) {
			this.cLLCDLManifestSpclStowRqstByPodDetailVOs = cLLCDLManifestSpclStowRqstByPodDetailVOs;
		}	
		
		public List<KorCllLoadSumDetailVO> getKorCllLoadSumDetailVOs() {
			return korCllLoadSumDetailVOs;
		}
		
		public void setKorCllLoadSumDetailVOs(List<KorCllLoadSumDetailVO> korCllLoadSumDetailVOs) {
			this.korCllLoadSumDetailVOs = korCllLoadSumDetailVOs;
		}	
		
		public List<KorCllSpclCgoSumDetailVO> getKorCllSpclCgoSumDetailVOs() {
			return korCllSpclCgoSumDetailVOs;
		}
		
		public void setKorCllSpclCgoSumDetailVOs(List<KorCllSpclCgoSumDetailVO> korCllSpclCgoSumDetailVOs) {
			this.korCllSpclCgoSumDetailVOs = korCllSpclCgoSumDetailVOs;
		}	
		
		public List<KorCllSpclStowRqstDetailVO> getKorCllSpclStowRqstDetailVOs() {
			return korCllSpclStowRqstDetailVOs;
		}
		
		public void setKorCllSpclStowRqstDetailVOs(List<KorCllSpclStowRqstDetailVO> korCllSpclStowRqstDetailVOs) {
			this.korCllSpclStowRqstDetailVOs = korCllSpclStowRqstDetailVOs;
		}		
		
		public List<KorCllSpclStowRqstDetail2VO> getKorCllSpclStowRqstDetail2VOs() {
			return korCllSpclStowRqstDetail2VOs;
		}
		
		public void setKorCllSpclStowRqstDetail2VOs(List<KorCllSpclStowRqstDetail2VO> korCllSpclStowRqstDetail2VOs) {
			this.korCllSpclStowRqstDetail2VOs = korCllSpclStowRqstDetail2VOs;
		}	
		
		public List<KorCllSpclStowRqstDetail3VO> getKorCllSpclStowRqstDetail3VOs() {
			return korCllSpclStowRqstDetail3VOs;
		}
		
		public void setKorCllSpclStowRqstDetail3VOs(List<KorCllSpclStowRqstDetail3VO> korCllSpclStowRqstDetail3VOs) {
			this.korCllSpclStowRqstDetail3VOs = korCllSpclStowRqstDetail3VOs;
		}			
		
		public List<CLLCDLManifestKorCllRemarkInfoVO> getCLLCDLManifestKorCllRemarkInfoVOs() {
			return cLLCDLManifestKorCllRemarkInfoVOs;
		}
		
		public void setCLLCDLManifestKorCllRemarkInfoVOs(List<CLLCDLManifestKorCllRemarkInfoVO> cLLCDLManifestKorCllRemarkInfoVOs) {
			this.cLLCDLManifestKorCllRemarkInfoVOs = cLLCDLManifestKorCllRemarkInfoVOs;
		}			

		@Override
		public HashMap<String, String> getColumnValues() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public HashMap<String, String> getFieldNames() {
			// TODO Auto-generated method stub
			return null;
		}	
	}
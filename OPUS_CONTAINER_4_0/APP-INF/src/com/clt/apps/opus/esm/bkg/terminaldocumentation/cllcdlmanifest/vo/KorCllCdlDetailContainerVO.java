/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorCllCdlDetailContainerVO.java
*@FileTitle : KorCllCdlDetailContainerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier :
*@LastVersion : 1.0
* 2009.07.28
* 1.0 Creation
* 2012.10.30 [CHM-201220810][BKG][CLL/CDL] W/O Flag추가, Transmission MSG변경
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.vo;

import java.util.HashMap;
import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author
 * @since J2EE 1.6
 * @see KorCllCdlDetailContainerVO
 */
public class KorCllCdlDetailContainerVO extends AbstractValueObject{
		private static final long serialVersionUID = 1L;

		private List<CLLCDLManifestVslSkdInfoVO> cLLCDLManifestVslSkdInfoVOs;
		private List<KorCllCdlDetailVO> korCllCdlDetailVOs;
		private List<KorCllCdlDetailVO> lclKorCllCdlDetailVOs;
		private String returnMessage = "";

		/**
		 * 생성자
		 * @param
		 * @return
		 */
		public KorCllCdlDetailContainerVO() {}

		public List<CLLCDLManifestVslSkdInfoVO> getCLLCDLManifestVslSkdInfoVOs() {
			return cLLCDLManifestVslSkdInfoVOs;
		}

		public void setCLLCDLManifestVslSkdInfoVOs(List<CLLCDLManifestVslSkdInfoVO> cLLCDLManifestVslSkdInfoVOs) {
			this.cLLCDLManifestVslSkdInfoVOs = cLLCDLManifestVslSkdInfoVOs;
		}

		public List<KorCllCdlDetailVO> getKorCllCdlDetailVOs() {
			return korCllCdlDetailVOs;
		}

		public void setKorCllCdlDetailVO(List<KorCllCdlDetailVO> korCllCdlDetailVOs) {
			this.korCllCdlDetailVOs = korCllCdlDetailVOs;
		}


		public List<KorCllCdlDetailVO> getLclKorCllCdlDetailVOs() {
			return lclKorCllCdlDetailVOs;
		}
		public void setLclKorCllCdlDetailVO(List<KorCllCdlDetailVO> lclKorCllCdlDetailVOs) {
			this.lclKorCllCdlDetailVOs = lclKorCllCdlDetailVOs;
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

		/**
		 * @return the returnMessage
		 */
		public String getReturnMessage() {
			return returnMessage;
		}

		/**
		 * @param returnMessage the returnMessage to set
		 */
		public void setReturnMessage(String returnMessage) {
			this.returnMessage = returnMessage;
		}

	}
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0463Event.java
*@FileTitle : bookringreport
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.10 강동윤
* 1.0 Creation
* 2011.11.22 정선용 [CHM-201114286-01] DPCS-SI Turn Time레포트 및 Draft B/L전송후 Amendment S/I PIC변경관련 개발요구사항 송부
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event;

import java.util.Arrays;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.QueueStatusVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.QueueStatusDetailVO;


/**
 * ESM_BKG_0463 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0463HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kang dong yun
 * @see ESM_BKG_0463HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0463Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private QueueStatusVO queueStatusVO = null;
		
	/** Table Value Object Multi Data 처리 */
	private QueueStatusVO[] queueStatusVOs = null;
	
	/** Table Value Object Multi Data 처리 */
	private QueueStatusDetailVO[] queueStatusDetailVOs = null;

	public EsmBkg0463Event(){}
	
	public void setQueueStatusVO(QueueStatusVO queueStatusVO){
		this. queueStatusVO = queueStatusVO;
	}

	public QueueStatusVO getQueueStatusVO() {
		return queueStatusVO;
	}
	
	public void setQueueStatusVOS(QueueStatusVO[] queueStatusVOs){
		if(queueStatusVOs != null){
			QueueStatusVO[] tmpVOs = Arrays.copyOf(queueStatusVOs, queueStatusVOs.length);
			this.queueStatusVOs = tmpVOs;
		}
	}

	public void setQueueStatusDetailVOS(QueueStatusDetailVO[] queueStatusDetailVOs){
		if(queueStatusDetailVOs != null){
			QueueStatusDetailVO[] tmpVOs = Arrays.copyOf(queueStatusDetailVOs, queueStatusDetailVOs.length);
			this.queueStatusDetailVOs = tmpVOs;
		}
	}
	
	
}
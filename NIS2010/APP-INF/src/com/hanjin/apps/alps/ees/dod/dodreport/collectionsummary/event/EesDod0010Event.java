/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EesDod0010Event.java   
*@FileTitle : Collection Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2016-05-20
*@LastModifier : Won-Ki Eo
*@LastVersion : 1.0
* 2016-05-20 Won-Ki Eo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.event;

import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo.SumbyOfcDetailVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EesDod0010Event PDTO(Data Transfer Object including Parameters)<br>
 * @author Jeong-Min Park
 * @see EventSupport 참조
 * @since J2EE 1.4 
 */
public class EesDod0010Event extends EventSupport {

	private static final long serialVersionUID = -1909705464706058031L;
	
	private SumbyOfcDetailVO sumbyOfcDetailVO = null;

	public SumbyOfcDetailVO getSumbyOfcDetailVO() {
		return sumbyOfcDetailVO;
	}

	public void setSumbyOfcDetailVO(SumbyOfcDetailVO sumbyOfcDetailVO) {
		this.sumbyOfcDetailVO = sumbyOfcDetailVO;
	}

	

}

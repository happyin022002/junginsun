/*=========================================================
 *	Copyright(c) 2015 CyberLogitec
 *	@FileName 			: StccCodeRestrictionBC.java
 *	@FileTitle 			: 
 *	Open Issues			:
 *	Change history		:
 *	@LastModifyDate 	: 
 *	@LastModifier 		: 
 *	@LastVersion 		: 1.0
 *	1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.common.stcccoderestrictionpopup.basic;


import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * Business Logic Command Interface<br>
 * 
 * @author
 * @see EsdTrs0939Event 참조
 * @since J2EE 1.6
 */
public interface StccCodeRestrictionBC {

	/**
	 * 
	 * @param event
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchStccCodeRestriction(Event event) throws EventException;

}

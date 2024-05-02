/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdTes9090Event.java
*@FileTitle : User Password
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.10.06 yOng hO lEE
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.tes.codemanage.codemanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.tes.codemanage.codemanage.vo.TesCodeManageCommonVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.ComUserVO;


/**
 * ESD_TES_9090 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_TES_9090HTMLAction 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author yOng hO lEE
 * @see ESD_TES_9090HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsdTes9090Event extends EventSupport {

	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ComUserVO	 						comUserVO						= null;
	private TesCodeManageCommonVO 		tesCodeManageCommonVO	= null;
	
	/** Table Value Object Multi Data 처리 */
//	private ComUserVO[]							comUserVOs						= null;
	private TesCodeManageCommonVO[]		tesCodeManageCommonVOs	= null;

	public EsdTes9090Event(){}

	public ComUserVO getComUserVO() {
		return comUserVO;
	}

	public void setComUserVO(ComUserVO comUserVO) {
		this.comUserVO = comUserVO;
	}

	public TesCodeManageCommonVO getTesCodeManageCommonVO() {
		return tesCodeManageCommonVO;
	}

	public void setTesCodeManageCommonVO(TesCodeManageCommonVO tesCodeManageCommonVO) {
		this.tesCodeManageCommonVO = tesCodeManageCommonVO;
	}

//	public ComUserVO[] getComUserVOs() {
//		return comUserVOs;
//	}

//	public void setComUserVOs(ComUserVO[] comUserVOs) {
//		this.comUserVOs = comUserVOs;
//	}

	public TesCodeManageCommonVO[] getTesCodeManageCommonVOs() {
		TesCodeManageCommonVO[] tempVOs = null;
		
		if (this.tesCodeManageCommonVOs != null) {
			tempVOs = Arrays.copyOf(this.tesCodeManageCommonVOs, this.tesCodeManageCommonVOs.length);
		}
		return tempVOs;		
	}

	public void setTesCodeManageCommonVOs(TesCodeManageCommonVO[] tesCodeManageCommonVOs){
		if(tesCodeManageCommonVOs != null){
			TesCodeManageCommonVO[] tmpVOs = Arrays.copyOf(tesCodeManageCommonVOs, tesCodeManageCommonVOs.length);
			this.tesCodeManageCommonVOs = tmpVOs;
		}
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	
//	/** com_user Table  Value Object */
//	private COM_USER com_user = null;
//	private String lgs_cost_cd = null;
//	private String lgs_cost_opt_no = null;
//
//	/** com_users Multi Action을 위한 Collection */
//	private Collection com_users = null;
//
//	public EsdTes9090Event(){}
//
//	/**
//	 * ESD_TES_909Event.java's Construct
//	 * @param com_user	
//	 */		
//	public EsdTes9090Event(COM_USER com_user) {
//		this.com_user = com_user;
//    }
//
//	/**
//	 * ESD_TES_909Event.java's Construct
//	 * @param com_user
//	 * @param lgs_cost_cd
//	 * @param lgs_cost_opt_no
//	 */		
//	public EsdTes9090Event(COM_USER com_user, String lgs_cost_cd, String lgs_cost_opt_no) {
//		this.com_user = com_user;
//		this.lgs_cost_cd = lgs_cost_cd;
//		this.lgs_cost_opt_no = lgs_cost_opt_no;
//    }	
//
//	/**
//	 * ESD_TES_909Event.java's Construct
//	 * @param com_user
//	 * @param com_users
//	 */		
//	public EsdTes9090Event(COM_USER com_user, Collection com_users) {
//		this.com_user = com_user;
//		this.com_users = com_users;
//    }
//
//	/**
//	 * ESD_TES_909Event's getCOM_USER
//	 * @return com_user
//	 */	 	
//	public COM_USER getCOM_USER(){
//		return com_user;
//	}
//
//	/**
//	 * ESD_TES_909Event's getCOM_USERS
//	 * @return com_users
//	 */	 	
//	public Collection getCOM_USERS(){
//		return com_users;
//	}
//
//	/**
//	 * ESD_TES_909Event's getLgs_cost_cd
//	 * @return lgs_cost_cd
//	 */	 
//    public String getLgs_cost_cd(){
//        return lgs_cost_cd;
//    }
//
//	/**
//	 * ESD_TES_909Event's getLgs_cost_opt_no
//	 * @return lgs_cost_opt_no
//	 */	   
//    public String getLgs_cost_opt_no(){
//        return lgs_cost_opt_no;
//    }    
//
//	/**
//	 * ESD_TES_909Event's getEventName
//	 * @return
//	 */  	
//	public String getEventName() {
//		return "ESD_TES_909Event";
//	}    
//    
//	/**
//	 * ESD_TES_909Event's toString
//	 * @return
//	 */		
//	public String toString() {
//		return "ESD_TES_909Event";
//	}

}

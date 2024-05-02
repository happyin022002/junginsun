/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOEdi315SendVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.01
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.11.01 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOEdi315SendVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * for sending EDI Input Vo
	  * </pre>
	  */
	public Edi315SendDBDAOEdi315SendVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOEdi315SendVORSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT" ).append("\n"); 
		query.append("''rcv_dt             ," ).append("\n"); 
		query.append("''rcv_seq            ," ).append("\n"); 
		query.append("''edi_status         ," ).append("\n"); 
		query.append("''cust_status        ," ).append("\n"); 
		query.append("''mvmt_sts           ," ).append("\n"); 
		query.append("''cop_act_cd         ," ).append("\n"); 
		query.append("''bkg_no             ," ).append("\n"); 
		query.append("''bl_no              ," ).append("\n"); 
		query.append("''cntr_no            ," ).append("\n"); 
		query.append("''cop_no             ," ).append("\n"); 
		query.append("''cop_dtl_seq        ," ).append("\n"); 
		query.append("''curr_vvd           ," ).append("\n"); 
		query.append("''event_dt           ," ).append("\n"); 
		query.append("''event_yard         ," ).append("\n"); 
		query.append("''cre_dt             ," ).append("\n"); 
		query.append("''cre_id             ," ).append("\n"); 
		query.append("''call_from          ," ).append("\n"); 
		query.append("''man_flg            ," ).append("\n"); 
		query.append("''log_flg            ," ).append("\n"); 
		query.append("''edi_grp_cd         ," ).append("\n"); 
		query.append("''act_rcv_if_key_dt  ," ).append("\n"); 
		query.append("''act_rcv_if_key_no  ," ).append("\n"); 
		query.append("''cop_ind            ," ).append("\n"); 
		query.append("''cost_act_grp_seq   ," ).append("\n"); 
		query.append("''upd_id      		 ," ).append("\n"); 
		query.append("''upd_dt			 ," ).append("\n"); 
		query.append("''cntr_call_cnt 	 , -- AMS 발송시 BL/CNTR 별 발송 구분 할때 필요." ).append("\n"); 
		query.append("''vdl_by_cntr_attach , -- CNTR Attach시 Vessel Actual ATD 가 입력 된 경우 VDL Call." ).append("\n"); 
		query.append("''edi_if_key_dt      , -- 배치 발송 시 원본 EDI_RCV_DT" ).append("\n"); 
		query.append("''edi_if_key_seq     , -- 배치 발송 시 원본 EDI_RCV_SEQ" ).append("\n"); 
		query.append("''call_fm_src_id     ,  -- 예) mvmt, 322, vessel 등등 ..." ).append("\n"); 
		query.append("''fm_btch_flg	     ,	-- Edi315BatchSend 에서 call 되었는지 여부" ).append("\n"); 
		query.append("''if_rmk			    -- Edi315BatchSend 에서 현 var 에 , 로 구분된 edi_grp_cd 로만 전송" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}
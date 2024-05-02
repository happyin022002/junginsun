/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOUsaResultVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.09
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.11.09 김도완
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Do-Wan, Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOUsaResultVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 미세관응답메세지 수신 outVO : UsaResultVO
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOUsaResultVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOUsaResultVORSQL").append("\n"); 
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
		query.append("'' cus_loc," ).append("\n"); 
		query.append("'' it_itno," ).append("\n"); 
		query.append("'' it_ittype," ).append("\n"); 
		query.append("'' it_ipi_local," ).append("\n"); 
		query.append("'' it_qty, 				--bl package quantity총수량" ).append("\n"); 
		query.append("'' it_cusr_tqty,		--수신 받은 package총수량" ).append("\n"); 
		query.append("'' it_cstmcind,			--c-flag" ).append("\n"); 
		query.append("'' it_cgo_cind,			--c-flag" ).append("\n"); 
		query.append("'' it_cusj_tqty,		--1J받은 총량" ).append("\n"); 
		query.append("'' it_cusw_tqty,		--1W받은 총량" ).append("\n"); 
		query.append("-- C-Flag판별로직에 사용하는 변수" ).append("\n"); 
		query.append("'' hold_qty," ).append("\n"); 
		query.append("'' remv_qty,				-- Remove Qty" ).append("\n"); 
		query.append("'' y_ent_qty," ).append("\n"); 
		query.append("'' y_rls_qty," ).append("\n"); 
		query.append("'' w_qty" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}
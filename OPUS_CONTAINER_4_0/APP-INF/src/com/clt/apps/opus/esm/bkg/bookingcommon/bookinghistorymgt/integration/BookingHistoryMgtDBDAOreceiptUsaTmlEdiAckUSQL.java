/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BookingHistoryMgtDBDAOreceiptUsaTmlEdiAckUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.17
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2014.12.17 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingHistoryMgtDBDAOreceiptUsaTmlEdiAckUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * usa tml ack를 수신하여 저장한다.
	  * </pre>
	  */
	public BookingHistoryMgtDBDAOreceiptUsaTmlEdiAckUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_msg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rspn_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_rjct_rsn",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rspn_gdt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_rspn_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_edi_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.integration").append("\n"); 
		query.append("FileName : BookingHistoryMgtDBDAOreceiptUsaTmlEdiAckUSQL").append("\n"); 
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
		query.append("UPDATE BKG_TML_EDI_HIS" ).append("\n"); 
		query.append("   SET TML_RSPN_STS_CD  = @[tml_rspn_sts_cd]" ).append("\n"); 
		query.append("     , ERR_MSG          = @[err_msg]" ).append("\n"); 
		query.append("     , RSPN_DT          = TO_DATE(@[rspn_dt],'RRRRMMDDHH24MI')" ).append("\n"); 
		query.append("     , UPD_DT           = SYSDATE" ).append("\n"); 
		query.append("	 , MODI_DT		 	= SYSDATE" ).append("\n"); 
		query.append("     , UPD_USR_ID       = 'SYSTEM'" ).append("\n"); 
		query.append(" 	 , RSPN_GDT  		= TO_DATE(@[rspn_gdt],'RRRRMMDDHH24MI')" ).append("\n"); 
		query.append("     , MSG_RJCT_RSN  	= @[msg_rjct_rsn]" ).append("\n"); 
		query.append(" WHERE TML_EDI_RQST_NO = @[tml_edi_rqst_no]" ).append("\n"); 

	}
}
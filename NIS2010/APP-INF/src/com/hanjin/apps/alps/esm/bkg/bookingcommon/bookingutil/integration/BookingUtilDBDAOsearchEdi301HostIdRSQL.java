/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingUtilDBDAOsearchEdi301HostIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.30
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.04.30 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Daeyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOsearchEdi301HostIdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchEdi301HostId
	  * </pre>
	  */
	public BookingUtilDBDAOsearchEdi301HostIdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOsearchEdi301HostIdRSQL").append("\n"); 
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
		query.append("#if (${sndr_tp_cd} == 'CUST')" ).append("\n"); 
		query.append("SELECT mchn_trd_prnr_id HOST_TP_ID" ).append("\n"); 
		query.append("FROM bkg_edi_grp" ).append("\n"); 
		query.append("WHERE cust_trd_prnr_id  = @[rcv_id]" ).append("\n"); 
		query.append("AND esvc_grp_delt_flg = 'N'" ).append("\n"); 
		query.append("AND rownum            = 1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT SNDR_TRD_PRNR_ID HOST_TP_ID" ).append("\n"); 
		query.append("FROM BKG_EDI_TRD_PRNR_SUB_LNK EY" ).append("\n"); 
		query.append(", BKG_EDI_SUB_LNK_MSG MSG" ).append("\n"); 
		query.append("WHERE EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("AND EY.RCVR_TRD_PRNR_ID = @[rcv_id]" ).append("\n"); 
		query.append("AND EDI_MSG_TP_ID <> 'COPRAR'" ).append("\n"); 
		query.append("AND MSG_TP_DESC   = '1'" ).append("\n"); 
		query.append("AND rownum        = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
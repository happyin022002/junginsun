/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingUtilDBDAOsearchEdi301HostIdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
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
		params.put("edi_ref_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcv_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
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
		query.append("#if (${sndr_tp_cd} == 'CUST') " ).append("\n"); 
		query.append("    SELECT mchn_trd_prnr_id HOST_TP_ID" ).append("\n"); 
		query.append("      FROM bkg_edi_grp" ).append("\n"); 
		query.append("     WHERE cust_trd_prnr_id  = @[rcv_id]" ).append("\n"); 
		query.append("       AND esvc_grp_delt_flg = 'N'" ).append("\n"); 
		query.append("       AND rownum            = 1 " ).append("\n"); 
		query.append("#elseif (${sndr_tp_cd} == 'CUST_301')" ).append("\n"); 
		query.append("    SELECT BHCC.ATTR_CTNT4 AS HOST_TP_ID" ).append("\n"); 
		query.append("    FROM BKG_HRD_CDG_CTNT BHCC" ).append("\n"); 
		query.append("    WHERE BHCC.HRD_CDG_ID = 'CUSTOMER_301_EDI_ID'" ).append("\n"); 
		query.append("    AND BHCC.ATTR_CTNT3 = @[rcv_id]" ).append("\n"); 
		query.append("    AND ROWNUM =  1" ).append("\n"); 
		query.append("#elseif (${sndr_tp_cd} == 'APERAK') " ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("		HRD.ATTR_CTNT2 HOST_TP_ID" ).append("\n"); 
		query.append("    FROM BKG_HRD_CDG_CTNT HRD" ).append("\n"); 
		query.append("   	WHERE HRD_CDG_ID = 'XTER_ACK_RECEIVER'" ).append("\n"); 
		query.append("   	AND HRD.ATTR_CTNT1 = @[rcv_id]" ).append("\n"); 
		query.append("	AND ROWNUM = 1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${edi_ref_cd} != '') " ).append("\n"); 
		query.append("    SELECT SNDR_TRD_PRNR_ID HOST_TP_ID			" ).append("\n"); 
		query.append("      FROM BKG_EDI_TRD_PRNR_SUB_LNK EY			" ).append("\n"); 
		query.append("			, BKG_EDI_SUB_LNK_MSG MSG" ).append("\n"); 
		query.append("     WHERE EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ			" ).append("\n"); 
		query.append("       AND EY.RCVR_TRD_PRNR_ID = @[edi_rcv_id]" ).append("\n"); 
		query.append("       AND EY.PRNR_SUB_LNK_CD = @[edi_ref_cd]" ).append("\n"); 
		query.append("       AND MSG.EDI_MSG_TP_ID = '301'" ).append("\n"); 
		query.append("#if (${msg_cd} == '2')" ).append("\n"); 
		query.append("       AND MSG.EDI_MSG_IND_CD IN ('1','2')	" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("       AND MSG.EDI_MSG_IND_CD = @[msg_cd]	" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("       AND EDI_MSG_TP_ID <> 'COPRAR'			" ).append("\n"); 
		query.append("       AND MSG_TP_DESC   = '1'			" ).append("\n"); 
		query.append("       AND rownum        = 1         " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("    SELECT SNDR_TRD_PRNR_ID HOST_TP_ID" ).append("\n"); 
		query.append("      FROM BKG_EDI_TRD_PRNR_SUB_LNK EY" ).append("\n"); 
		query.append("			, BKG_EDI_SUB_LNK_MSG MSG" ).append("\n"); 
		query.append("     WHERE EY.TRD_PRNR_SUB_LNK_SEQ = MSG.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("       AND EY.RCVR_TRD_PRNR_ID = @[rcv_id]" ).append("\n"); 
		query.append("       AND EDI_MSG_TP_ID <> 'COPRAR'" ).append("\n"); 
		query.append("       AND MSG_TP_DESC   = '1'" ).append("\n"); 
		query.append("       AND rownum        = 1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
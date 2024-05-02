/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingMasterMgtDBDAOsearchBkgEdiSubLnkMsgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.10.06 이일민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ilmin Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOsearchBkgEdiSubLnkMsgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBkgEdiSubLnkMsg
	  * </pre>
	  */
	public BookingMasterMgtDBDAOsearchBkgEdiSubLnkMsgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_msg_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_prnr_sub_lnk_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_msg_ind_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration ").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOsearchBkgEdiSubLnkMsgRSQL").append("\n"); 
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
		query.append("SELECT TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append(", EDI_MSG_TP_ID" ).append("\n"); 
		query.append(", EDI_MSG_IND_CD" ).append("\n"); 
		query.append("FROM   BKG_EDI_SUB_LNK_MSG" ).append("\n"); 
		query.append("WHERE  TRD_PRNR_SUB_LNK_SEQ = @[trd_prnr_sub_lnk_seq]" ).append("\n"); 
		query.append("AND    EDI_MSG_TP_ID = @[edi_msg_tp_id]" ).append("\n"); 
		query.append("AND    EDI_MSG_IND_CD = @[edi_msg_ind_cd]" ).append("\n"); 

	}
}
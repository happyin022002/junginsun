/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterRqstMstSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.09
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.09 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchXterRqstMstSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterRqstMstSeq
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterRqstMstSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterRqstMstSeqRSQL").append("\n"); 
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
		query.append("#if (${xter_doc_tp_cd} == 'E')" ).append("\n"); 
		query.append("SELECT 	NVL(MAX(XTER_RQST_SEQ), 0) + 1 RQST_SEQ" ).append("\n"); 
		query.append("FROM 	BKG_XTER_XPT_LIC_NO" ).append("\n"); 
		query.append("WHERE 	XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND 	XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT 	NVL(MAX(XTER_RQST_SEQ), 0) + 1 RQST_SEQ" ).append("\n"); 
		query.append("FROM 	BKG_XTER_RQST_MST" ).append("\n"); 
		query.append("WHERE 	XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("AND 	XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND 	NVL(XTER_BL_TP_CD,' ') <> 'H'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
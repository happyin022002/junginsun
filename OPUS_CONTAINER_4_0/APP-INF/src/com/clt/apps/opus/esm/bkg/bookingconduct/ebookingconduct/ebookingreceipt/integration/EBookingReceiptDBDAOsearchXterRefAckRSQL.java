/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterRefAckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.18
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2014.12.18 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE, do hyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchXterRefAckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterRefAck
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterRefAckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterRefAckRSQL").append("\n"); 
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
		query.append("SELECT	'{ACK_REF_INFO' || CHR(10)" ).append("\n"); 
		query.append("         || 'IB_REF_TP_CD:'   || REF.REF_CD                                                     || CHR(10)" ).append("\n"); 
		query.append("         || 'IB_REF_NO:'      || REF.REF_NO                                                     || CHR(10)" ).append("\n"); 
		query.append("        || '}ACK_REF_INFO'		CNTR_REF_INFO" ).append("\n"); 
		query.append("  FROM bkg_xter_Rqst_mst mst, BKG_XTER_REF REF" ).append("\n"); 
		query.append(" where mst.xter_sndr_id     = @[sender_id]" ).append("\n"); 
		query.append("   and mst.xter_rqst_no     = @[rqst_no]" ).append("\n"); 
		query.append("   and mst.xter_rqst_seq    = @[rqst_seq]" ).append("\n"); 
		query.append("   and mst.xter_sndr_id     = REF.xter_sndr_id" ).append("\n"); 
		query.append("   and mst.xter_rqst_no     = REF.xter_rqst_no" ).append("\n"); 
		query.append("   and mst.xter_rqst_seq    = REF.xter_rqst_seq" ).append("\n"); 

	}
}
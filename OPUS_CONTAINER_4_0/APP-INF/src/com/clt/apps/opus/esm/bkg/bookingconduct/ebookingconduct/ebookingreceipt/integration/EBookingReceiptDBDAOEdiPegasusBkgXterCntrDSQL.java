/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOEdiPegasusBkgXterCntrDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.07
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2015.07.07 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOEdiPegasusBkgXterCntrDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EBookingReceiptDBDAOEdiPegasusBkgXterCntrDSQL
	  * </pre>
	  */
	public EBookingReceiptDBDAOEdiPegasusBkgXterCntrDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOEdiPegasusBkgXterCntrDSQL").append("\n"); 
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
		query.append("DELETE FROM BKG_XTER_CNTR BXC" ).append("\n"); 
		query.append("WHERE BXC.XTER_SNDR_ID = 'PEGASUS'" ).append("\n"); 
		query.append("AND BXC.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND BXC.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 
		query.append("AND BXC.CNTR_NO = 'No Data'" ).append("\n"); 
		query.append("AND NOT EXISTS (SELECT 'X' " ).append("\n"); 
		query.append("                FROM BKG_XTER_CNTR_SEAL_NO BXCS " ).append("\n"); 
		query.append("                WHERE BXCS.XTER_SNDR_ID = BXC.XTER_SNDR_ID" ).append("\n"); 
		query.append("                AND BXCS.XTER_RQST_NO = BXC.XTER_RQST_NO" ).append("\n"); 
		query.append("                AND BXCS.XTER_RQST_SEQ = BXC.XTER_RQST_SEQ)" ).append("\n"); 

	}
}
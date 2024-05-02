/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterHblSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.16
*@LastModifier : 김영철
*@LastVersion : 1.0
* 2009.12.16 김영철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim YC
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchXterHblSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterHblSeq
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterHblSeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_rqst_via_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("si_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterHblSeqRSQL").append("\n"); 
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
		query.append("SELECT DECODE(NVL(MAX(XTER_RQST_SEQ), 0),0,1,MAX(XTER_RQST_SEQ)) XTER_RQST_SEQ" ).append("\n"); 
		query.append("FROM   BKG_XTER_RQST_MST" ).append("\n"); 
		query.append("WHERE  (XTER_SNDR_ID, bkg_no, xter_rqst_via_cd) IN" ).append("\n"); 
		query.append("(SELECT XTER_SNDR_ID, bkg_no, xter_rqst_via_cd" ).append("\n"); 
		query.append("FROM BKG_XTER_RQST_MST" ).append("\n"); 
		query.append("WHERE XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("#if(${sender_id}=='PKEXM010' && ${xter_Doc_Tp_Cd}=='S')" ).append("\n"); 
		query.append("AND XTER_RQST_NO = @[si_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND XTER_RQST_VIA_CD = @[xter_rqst_via_cd]" ).append("\n"); 
		query.append("AND BKG_NO IS NOT NULL)" ).append("\n"); 
		query.append("AND   NVL(XTER_BL_TP_CD, ' ') <> 'H'" ).append("\n"); 

	}
}
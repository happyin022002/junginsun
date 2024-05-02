/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOEdiPegasusBkgXterTroDtlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.09
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2015.07.09 정인선
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

public class EBookingReceiptDBDAOEdiPegasusBkgXterTroDtlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EBookingReceiptDBDAOEdiPegasusBkgXterTroDtlUSQL
	  * </pre>
	  */
	public EBookingReceiptDBDAOEdiPegasusBkgXterTroDtlUSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOEdiPegasusBkgXterTroDtlUSQL").append("\n"); 
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
		query.append("UPDATE BKG_XTER_TRO_DTL BXTD" ).append("\n"); 
		query.append("SET BXTD.CNTR_TPSZ_CD = NVL((SELECT MCPS.CNTR_TPSZ_CD FROM MDM_CNTR_TP_SZ MCPS WHERE MCPS.MODI_CNTR_TPSZ_CD = BXTD.CNTR_TPSZ_CD AND MCPS.DELT_FLG = 'N'),BXTD.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("WHERE BXTD.XTER_SNDR_ID = 'PEGASUS'" ).append("\n"); 
		query.append("AND BXTD.XTER_RQST_NO = @[xter_rqst_no]" ).append("\n"); 
		query.append("AND BXTD.XTER_RQST_SEQ = @[xter_rqst_seq]" ).append("\n"); 

	}
}
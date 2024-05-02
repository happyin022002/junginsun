/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOModifyEurPkupRtnCyUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOModifyEurPkupRtnCyUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GeneralBookingReceiptDBDAOModifyEurPkupRtnCyUSQL.Qurey
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOModifyEurPkupRtnCyUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOModifyEurPkupRtnCyUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_BOOKING BK" ).append("\n"); 
		query.append(" USING (SELECT TRO.BKG_NO, " ).append("\n"); 
		query.append("               TRO.CNTR_PKUP_YD_CD, " ).append("\n"); 
		query.append("               TRO.CNTR_RTN_YD_CD" ).append("\n"); 
		query.append("          FROM BKG_EUR_TRO TRO" ).append("\n"); 
		query.append("             , BKG_EUR_TRO_DTL DTL" ).append("\n"); 
		query.append("         WHERE TRO.BKG_NO      = DTL.BKG_NO" ).append("\n"); 
		query.append("           AND TRO.IO_BND_CD   = DTL.IO_BND_CD   " ).append("\n"); 
		query.append("           AND TRO.TRO_SEQ     = DTL.TRO_SEQ" ).append("\n"); 
		query.append("           AND TRO.BKG_NO      = @[bkg_no]" ).append("\n"); 
		query.append("           AND TRO.CXL_FLG     = 'N'" ).append("\n"); 
		query.append("           AND TRO.CFM_FLG     = 'N'" ).append("\n"); 
		query.append("		   AND TRO.IO_BND_CD   = 'O'" ).append("\n"); 
		query.append("           AND ROWNUM = 1) TRO" ).append("\n"); 
		query.append("           ON (BK.BKG_NO = TRO.BKG_NO)" ).append("\n"); 
		query.append("  WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE " ).append("\n"); 
		query.append("   SET BK.MTY_PKUP_YD_CD = NVL(TRO.CNTR_PKUP_YD_CD, BK.MTY_PKUP_YD_CD)" ).append("\n"); 
		query.append("     , BK.FULL_RTN_YD_CD = TRO.CNTR_RTN_YD_CD" ).append("\n"); 

	}
}
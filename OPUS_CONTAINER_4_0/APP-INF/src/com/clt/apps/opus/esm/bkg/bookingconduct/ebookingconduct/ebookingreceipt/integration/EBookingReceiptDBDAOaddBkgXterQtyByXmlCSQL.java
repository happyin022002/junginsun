/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOaddBkgXterQtyByXmlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.01
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2015.10.01 정인선
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

public class EBookingReceiptDBDAOaddBkgXterQtyByXmlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EBookingReceiptDBDAOaddBkgXterQtyByXmlCSQL
	  * </pre>
	  */
	public EBookingReceiptDBDAOaddBkgXterQtyByXmlCSQL(){
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
		query.append("FileName : EBookingReceiptDBDAOaddBkgXterQtyByXmlCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_XTER_QTY BXQ (XTER_SNDR_ID, XTER_RQST_NO, XTER_RQST_SEQ, CNTR_TPSZ_CD, CNTR_QTY, SOC_QTY, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT)" ).append("\n"); 
		query.append("SELECT BXC.XTER_SNDR_ID" ).append("\n"); 
		query.append("     , BXC.XTER_RQST_NO, BXC.XTER_RQST_SEQ" ).append("\n"); 
		query.append("     , NVL(MCPS.CNTR_TPSZ_CD,BXC.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("     , COUNT(*)" ).append("\n"); 
		query.append("     , SUM(DECODE(BXC.SOC_FLG,'Y',1,0))" ).append("\n"); 
		query.append("     , 'SYSTEM'" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("     , 'SYSTEM'" ).append("\n"); 
		query.append("     , SYSDATE" ).append("\n"); 
		query.append("  FROM BKG_XTER_CNTR BXC" ).append("\n"); 
		query.append("     , MDM_CNTR_TP_SZ MCPS" ).append("\n"); 
		query.append(" WHERE BXC.XTER_SNDR_ID = @[sender_id]" ).append("\n"); 
		query.append("   	AND BXC.XTER_RQST_NO = @[rqst_no]" ).append("\n"); 
		query.append("   	AND BXC.XTER_RQST_SEQ = @[rqst_seq]" ).append("\n"); 
		query.append("   	AND DECODE(BXC.CNTR_TPSZ_CD,'40RF','40RQ',BXC.CNTR_TPSZ_CD) = MCPS.MODI_CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("	AND MCPS.DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("	AND MCPS.CNTR_TPSZ_CD(+) <> 'R8'" ).append("\n"); 
		query.append(" GROUP BY BXC.XTER_SNDR_ID, BXC.XTER_RQST_NO, BXC.XTER_RQST_SEQ, NVL(MCPS.CNTR_TPSZ_CD,BXC.CNTR_TPSZ_CD)" ).append("\n"); 

	}
}
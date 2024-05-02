/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiChgByTraxRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchDblEdiChgByTraxRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiChgByTraxRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_receive_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiChgByTraxRSQL").append("\n"); 
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
		query.append("SELECT N3RD_OFC" ).append("\n"); 
		query.append(",      CLT_OFC_CD" ).append("\n"); 
		query.append(",      PPD_RCV_OFC_CD" ).append("\n"); 
		query.append("FROM   (SELECT MAX(NVL(N3PTY_RCV_OFC_CD, ' ')) N3RD_OFC" ).append("\n"); 
		query.append("        FROM   BKG_CHG_RT" ).append("\n"); 
		query.append("        WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND ( (N3PTY_CUST_CNT_CD = 'CN'" ).append("\n"); 
		query.append("              AND N3PTY_CUST_SEQ = 44619" ).append("\n"); 
		query.append("              AND (N3PTY_RCV_OFC_CD = 'SHARC'" ).append("\n"); 
		query.append("                OR N3PTY_RCV_OFC_CD = 'SHAHQ'))" ).append("\n"); 
		query.append("             OR (N3PTY_CUST_CNT_CD = 'SG'" ).append("\n"); 
		query.append("             AND N3PTY_RCV_OFC_CD = 'SINSC'" ).append("\n"); 
		query.append("             AND (N3PTY_CUST_SEQ = DECODE(@[edi_receive_id],'TRAX.HPENTAPAC',16932,260)" ).append("\n"); 
		query.append("               OR N3PTY_CUST_SEQ IN (11029,17434))))" ).append("\n"); 
		query.append("           AND ROWNUM = 1) B1, " ).append("\n"); 
		query.append("       (SELECT MAX(CLT_OFC_CD) CLT_OFC_CD, MAX(PPD_RCV_OFC_CD) PPD_RCV_OFC_CD" ).append("\n"); 
		query.append("        FROM   BKG_RATE" ).append("\n"); 
		query.append("        WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("           AND ((CLT_PAYR_CUST_SEQ = 'CN' AND CLT_PAYR_CUST_SEQ = 44619)" ).append("\n"); 
		query.append("             OR (CLT_PAYR_CNT_CD = 'SG' AND CLT_PAYR_CUST_SEQ IN (DECODE(@[edi_receive_id],'TRAX.HPENTAPAC',16932,260), 11029,17434)" ).append("\n"); 
		query.append("             AND CLT_OFC_CD IN ('SHAHQ', 'SHARC', 'SINSC'))" ).append("\n"); 
		query.append("             OR (PPD_PAYR_CNT_CD = 'SG'" ).append("\n"); 
		query.append("             AND PPD_RCV_OFC_CD = 'SINSC'" ).append("\n"); 
		query.append("             AND PPD_PAYR_CUST_SEQ IN (DECODE(@[edi_receive_id],'TRAX.HPENTAPAC',16932,260), 11029,17434)))" ).append("\n"); 
		query.append("           AND ROWNUM = 1) B2" ).append("\n"); 

	}
}
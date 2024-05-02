/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingARCreationDBDAOsearchCheckCorrectionInvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.13 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOsearchCheckCorrectionInvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BookingARCreationDBDAOsearchCheckCorrectionInvoiceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOsearchCheckCorrectionInvoiceRSQL").append("\n"); 
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
		query.append("SELECT MAX(CHK_CORRECT) CHK_CORRECT_FLG" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("        SELECT 'Y' CHK_CORRECT" ).append("\n"); 
		query.append("        FROM   INV_AR_MN" ).append("\n"); 
		query.append("        WHERE  AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("        AND    BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("		AND    REV_TP_CD <> 'M'" ).append("\n"); 
		query.append("		AND    INV_DELT_DIV_CD <> 'Y'" ).append("\n"); 
		query.append("        AND    NVL(INV_SPLIT_CD,'N') IN ('M','S','C','X')" ).append("\n"); 
		query.append("        AND    ROWNUM = 1" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'Y' CHK_CORRECT" ).append("\n"); 
		query.append("        FROM   INV_AR_MN" ).append("\n"); 
		query.append("        WHERE  AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("        AND    BL_SRC_NO = @[bl_src_no]" ).append("\n"); 
		query.append("        AND    INV_NO IS NOT NULL" ).append("\n"); 
		query.append("        AND    INV_ISS_FLG = 'Y'" ).append("\n"); 
		query.append("        AND    ROWNUM = 1" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("        SELECT 'N' CHK_CORRECT FROM DUAL" ).append("\n"); 
		query.append("       )" ).append("\n"); 

	}
}
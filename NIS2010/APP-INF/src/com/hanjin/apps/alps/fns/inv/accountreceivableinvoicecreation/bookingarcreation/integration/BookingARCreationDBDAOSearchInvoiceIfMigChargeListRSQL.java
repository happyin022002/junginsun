/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingARCreationDBDAOSearchInvoiceIfMigChargeListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.01
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.06.01 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingARCreationDBDAOSearchInvoiceIfMigChargeListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BookingARCreationDBDAOSearchInvoiceIfMigChargeListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOSearchInvoiceIfMigChargeListRSQL").append("\n"); 
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
		query.append("SELECT CHG_CD," ).append("\n"); 
		query.append("       CURR_CD," ).append("\n"); 
		query.append("       PER_TP_CD," ).append("\n"); 
		query.append("       TRF_RT_AMT," ).append("\n"); 
		query.append("       RAT_AS_CNTR_QTY," ).append("\n"); 
		query.append("       SUM(CHG_AMT) CHG_AMT" ).append("\n"); 
		query.append("  FROM INV_BKG_IF_CHG" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BKG_SEQ = @[bkg_seq]" ).append("\n"); 
		query.append("   AND OFC_CD IN ( SELECT OFC_CD FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                       WHERE AR_OFC_CD = ( SELECT AR_OFC_CD " ).append("\n"); 
		query.append("                         					 FROM MDM_ORGANIZATION" ).append("\n"); 
		query.append("                        					WHERE OFC_CD = @[ofc_cd] ))" ).append("\n"); 
		query.append("   AND DECODE(CHG_CD,'WHF',DECODE(WHF_FLG,'Y',1,NVL(CHG_AMT,0)),NVL(CHG_AMT,0)) <> 0" ).append("\n"); 
		query.append("#if (${whf_chk} == 'Y')" ).append("\n"); 
		query.append("   AND CHG_CD <> 'WHF'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" group by CHG_CD, CURR_CD, PER_TP_CD, TRF_RT_AMT, RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append(" ORDER BY CHG_CD," ).append("\n"); 
		query.append("          CURR_CD," ).append("\n"); 
		query.append("          PER_TP_CD," ).append("\n"); 
		query.append("          TRF_RT_AMT," ).append("\n"); 
		query.append("		  RAT_AS_CNTR_QTY," ).append("\n"); 
		query.append("          CHG_AMT" ).append("\n"); 

	}
}
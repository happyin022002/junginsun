/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BookingARCreationDBDAOCompareBkgIFChargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.10
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.10 
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

public class BookingARCreationDBDAOCompareBkgIFChargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BookingARCreationDBDAOCompareBkgIFChargeRSQL(){
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
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOCompareBkgIFChargeRSQL").append("\n"); 
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
		query.append("CURR_CD," ).append("\n"); 
		query.append("PER_TP_CD," ).append("\n"); 
		query.append("TRF_RT_AMT," ).append("\n"); 
		query.append("RAT_AS_CNTR_QTY," ).append("\n"); 
		query.append("CHG_AMT FROM (" ).append("\n"); 
		query.append("SELECT CHG_CD," ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("PER_TP_CD," ).append("\n"); 
		query.append("TRF_RT_AMT," ).append("\n"); 
		query.append("RAT_AS_CNTR_QTY RAT_AS_CNTR_QTY," ).append("\n"); 
		query.append("CHG_AMT CHG_AMT" ).append("\n"); 
		query.append("FROM INV_BKG_IF_CHG" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BKG_SEQ = @[bkg_seq]" ).append("\n"); 
		query.append("AND AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("#if (${whf_chk} == 'Y')" ).append("\n"); 
		query.append("AND CHG_CD <> 'WHF'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND NVL(CHG_AMT,0) <> 0" ).append("\n"); 
		query.append("minus" ).append("\n"); 
		query.append("SELECT CHG_CD," ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("PER_TP_CD," ).append("\n"); 
		query.append("TRF_RT_AMT," ).append("\n"); 
		query.append("RAT_AS_CNTR_QTY," ).append("\n"); 
		query.append("CHG_AMT" ).append("\n"); 
		query.append("FROM INV_AR_CHG" ).append("\n"); 
		query.append("WHERE AR_IF_NO  IN ( SELECT  MAX(AR_IF_NO)" ).append("\n"); 
		query.append("FROM INV_AR_MN" ).append("\n"); 
		query.append("WHERE BKG_NO =  @[bkg_no]" ).append("\n"); 
		query.append("AND AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND NVL(INV_DELT_DIV_CD,'N')<> 'Y'" ).append("\n"); 
		query.append("AND REV_TP_CD<> 'M'" ).append("\n"); 
		query.append("AND NVL(INV_SPLIT_CD,'N') NOT IN ('S','X','C','E')" ).append("\n"); 
		query.append("GROUP BY AR_OFC_CD,BL_SRC_NO )" ).append("\n"); 
		query.append("#if (${whf_chk} == 'Y')" ).append("\n"); 
		query.append("AND CHG_CD <> 'WHF'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND CHG_CD <> 'IEV'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("union" ).append("\n"); 
		query.append("SELECT CHG_CD," ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("PER_TP_CD," ).append("\n"); 
		query.append("TRF_RT_AMT," ).append("\n"); 
		query.append("RAT_AS_CNTR_QTY," ).append("\n"); 
		query.append("CHG_AMT FROM(" ).append("\n"); 
		query.append("SELECT CHG_CD," ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("PER_TP_CD," ).append("\n"); 
		query.append("TRF_RT_AMT," ).append("\n"); 
		query.append("RAT_AS_CNTR_QTY," ).append("\n"); 
		query.append("CHG_AMT" ).append("\n"); 
		query.append("FROM INV_AR_CHG" ).append("\n"); 
		query.append("WHERE AR_IF_NO  IN ( SELECT  MAX(AR_IF_NO)" ).append("\n"); 
		query.append("FROM INV_AR_MN" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND AR_OFC_CD = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND NVL(INV_DELT_DIV_CD,'N')<> 'Y'" ).append("\n"); 
		query.append("AND REV_TP_CD<> 'M'" ).append("\n"); 
		query.append("AND NVL(INV_SPLIT_CD,'N') NOT IN ('S','X','C','E')" ).append("\n"); 
		query.append("GROUP BY AR_OFC_CD,BL_SRC_NO )" ).append("\n"); 
		query.append("#if (${whf_chk} == 'Y')" ).append("\n"); 
		query.append("AND CHG_CD <> 'WHF'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND CHG_CD <> 'IEV'" ).append("\n"); 
		query.append("minus" ).append("\n"); 
		query.append("SELECT CHG_CD," ).append("\n"); 
		query.append("CURR_CD," ).append("\n"); 
		query.append("PER_TP_CD," ).append("\n"); 
		query.append("TRF_RT_AMT," ).append("\n"); 
		query.append("RAT_AS_CNTR_QTY RAT_AS_CNTR_QTY," ).append("\n"); 
		query.append("CHG_AMT CHG_AMT" ).append("\n"); 
		query.append("FROM INV_BKG_IF_CHG" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BKG_SEQ = @[bkg_seq]" ).append("\n"); 
		query.append("AND AR_OFC_CD = @[ofc_cd]" ).append("\n"); 
		query.append("AND NVL(CHG_AMT,0) <> 0" ).append("\n"); 
		query.append("#if (${whf_chk} == 'Y')" ).append("\n"); 
		query.append("AND CHG_CD <> 'WHF'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
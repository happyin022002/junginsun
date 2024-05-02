/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DropOffCreationDBDAOSearchARInvoiceIFChgVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.27
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2016.01.27 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son, Jin-Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DropOffCreationDBDAOSearchARInvoiceIFChgVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AR 전송을 위한 Invoice Charge Data를 읽어온다.
	  * </pre>
	  */
	public DropOffCreationDBDAOSearchARInvoiceIFChgVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_src_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("drp_off_chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.integration").append("\n"); 
		query.append("FileName : DropOffCreationDBDAOSearchARInvoiceIFChgVORSQL").append("\n"); 
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
		query.append("SELECT '' AS SRC_IF_DT," ).append("\n"); 
		query.append("       '' AS SRC_IF_SEQ," ).append("\n"); 
		query.append("       DRP_OFF_CHG_SEQ AS CHG_SEQ," ).append("\n"); 
		query.append("       CURR_CD AS CURR_CD," ).append("\n"); 
		query.append("       'DOD' CHG_CD," ).append("\n"); 
		query.append("       CNTR_TPSZ_CD AS PER_TP_CD," ).append("\n"); 
		query.append("       TTL_AMT AS TRF_RT_AMT, -- temp" ).append("\n"); 
		query.append("       '1' AS RAT_AS_CNTR_QTY, -- temp" ).append("\n"); 
		query.append("	   TTL_AMT AS CHG_AMT," ).append("\n"); 
		query.append("       CNTR_NO AS TRF_NO," ).append("\n"); 
		query.append("       'N' TVA_FLG," ).append("\n"); 
		query.append("	   '' CHG_RMK," ).append("\n"); 
		query.append("       CRE_USR_ID," ).append("\n"); 
		query.append("       TO_CHAR(CRE_DT,'yyyymmdd') AS CRE_DT," ).append("\n"); 
		query.append("       UPD_USR_ID," ).append("\n"); 
		query.append("       TO_CHAR(UPD_DT,'yyyymmdd') AS UPD_DT" ).append("\n"); 
		query.append("  FROM DOD_DRP_OFF_CHG" ).append("\n"); 
		query.append(" WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("   AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${inv_src_no} != '') " ).append("\n"); 
		query.append("   AND INV_SRC_NO = @[inv_src_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${drp_off_chg_seq} != '') " ).append("\n"); 
		query.append("   AND DRP_OFF_CHG_SEQ = @[drp_off_chg_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
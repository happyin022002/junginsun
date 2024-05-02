/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BookingARCreationDBDAOsearchTvaFlgByChargeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.07.12
*@LastModifier : 
*@LastVersion : 1.0
* 2017.07.12 
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

public class BookingARCreationDBDAOsearchTvaFlgByChargeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * office 별 charge code tva flag 여부
	  * </pre>
	  */
	public BookingARCreationDBDAOsearchTvaFlgByChargeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration").append("\n"); 
		query.append("FileName : BookingARCreationDBDAOsearchTvaFlgByChargeRSQL").append("\n"); 
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
		query.append("SELECT MAX(TVA_FLG) AS TVA_FLG  FROM (" ).append("\n"); 
		query.append("SELECT DECODE(@[ofc_cd],'BOMSC', " ).append("\n"); 
		query.append("                        DECODE(@[io_bnd_cd],'O', DECODE(@[chg_cd],  'BCC','Y','BLR','Y','CMC','Y','CMS','Y','CSR','Y'," ).append("\n"); 
		query.append("                                                                    'CTS','Y','DAR','Y','DHF','Y','DDF','Y','DIV','Y'," ).append("\n"); 
		query.append("                                                                    'DMR','Y','DRC','Y','DTC','Y','DTS','Y','DVC','Y'," ).append("\n"); 
		query.append("                                                                    'EIS','Y','EMS','Y','ENS','Y','EPS','Y','ETC','Y'," ).append("\n"); 
		query.append("                                                                    'ICS','Y','IHC','Y','MCF','Y','MIS','Y','NFC','Y','NMS','Y','OAR','Y','OBS','Y','OTR','Y','OTS','Y'," ).append("\n"); 
		query.append("                                                                    'PCS','Y','SMC','Y','SOC','Y','TSC','Y','WHF','Y','OTH','Y','OIH','Y','CFR','Y','ITR','Y','CYR','Y'," ).append("\n"); 
		query.append("                                                                    'SLF','Y','INF','Y','DTH','Y','DIH','Y','CFD','Y','ITR','Y','CLN','Y','CLC','Y','PIF','Y','INF','Y'," ).append("\n"); 
		query.append("                                                                    'CMR','Y','OCH','Y','DCH','Y','CCL','Y','CMF','Y','NMC','Y','CHC','Y','CAM','Y','MDA','Y','LBP','Y'," ).append("\n"); 
		query.append("                                                                    'IDS','Y','TAD','Y','CIF','Y','MCF','Y','AFR','Y','OCR','Y','NST','Y','DHC','Y','APS','Y','GOH','Y'," ).append("\n"); 
		query.append("                                                                    'IFR','Y','N')," ).append("\n"); 
		query.append("                                                 DECODE(@[chg_cd],  'BCC','Y','BLR','Y','CMC','Y','CMS','Y','CSR','Y','CTS','Y','DAR','Y','DHF','Y','DDF','Y','DIV','Y',	" ).append("\n"); 
		query.append("                                                                    'DMR','Y','DRC','Y','DTC','Y','DTS','Y','DVC','Y','EIS','Y','EMS','Y','ENS','Y','EPS','Y','ETC','Y',	" ).append("\n"); 
		query.append("                                                                    'ICS','Y','IHC','Y','MCF','Y','MIS','Y','NFC','Y','NMS','Y','OAR','Y','OBS','Y','OTR','Y','OTS','Y',	" ).append("\n"); 
		query.append("                                                                    'PCS','Y','SMC','Y','SOC','Y','TSC','Y','WHF','Y','OTH','Y','OIH','Y','CFR','Y','ITR','Y','CYR','Y'," ).append("\n"); 
		query.append("                                                                    'SLF','Y','INF','Y','DTH','Y','DIH','Y','CFD','Y','ITR','Y','CLN','Y','CLC','Y','PIF','Y','INF','Y'," ).append("\n"); 
		query.append("                                                                    'CMR','Y','OCH','Y','DCH','Y','CCL','Y','CMF','Y','NMC','Y','CHC','Y','CAM','Y','MDA','Y','LBP','Y'," ).append("\n"); 
		query.append("                                                                    'IDS','Y','TAD','Y','CIF','Y','MCF','Y','AFR','Y','OCR','Y','NST','Y','DHC','Y','OFT','Y','BUC','Y'," ).append("\n"); 
		query.append("                                                                    'LSF','Y','CAF','Y','BAF','Y','WSC','Y','ACT','Y','FRC','Y','FRS','Y','PSC','Y','EFS','Y','FAF','Y'," ).append("\n"); 
		query.append("                                                                    'GRI','Y','TXS','Y','DIS','Y','CTO','Y','CDC','Y','N'))" ).append("\n"); 
		query.append("                      ,'N') AS TVA_FLG                " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 
		query.append("UNION ALL " ).append("\n"); 
		query.append("SELECT DECODE(@[ofc_cd],'BOMSC', DECODE(@[chg_cd],'MVC',DECODE(@[io_bnd_cd],'O','Y','N'),'N'),'N') AS TVA_FLG FROM DUAL WHERE TO_CHAR(SYSDATE,'YYYYMMDD') >='20160701'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT DECODE(@[ofc_cd],'BOMSC', DECODE(@[chg_cd],'MUC','Y','N'),'N') AS TVA_FLG FROM DUAL WHERE TO_CHAR(SYSDATE,'YYYYMMDD') >='20160711'" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DemDetTariffMgtDBDAOSearchApproSetupInfoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemDetTariffMgtDBDAOSearchApproSetupInfoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DemDetTariffMgtDBDAOSearchApproSetupInfoListRSQL
	  * </pre>
	  */
	public DemDetTariffMgtDBDAOSearchApproSetupInfoListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_expt_apro_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dmdt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_lvl",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration").append("\n"); 
		query.append("FileName : DemDetTariffMgtDBDAOSearchApproSetupInfoListRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("DMDT_EXPT_APRO_TP_CD" ).append("\n"); 
		query.append(",OFC_LVL" ).append("\n"); 
		query.append(",DMDT_OFC_CD" ).append("\n"); 
		query.append(",DMDT_SEQ" ).append("\n"); 
		query.append(",DECODE(CUST_CNT_CD,'AL','All',CUST_CNT_CD||CUST_SEQ) AS CUST_CD" ).append("\n"); 
		query.append(",FT_ADD_DYS" ).append("\n"); 
		query.append(",FT_TTL_DYS" ).append("\n"); 
		query.append(",DC_FLG" ).append("\n"); 
		query.append(",DC_RTO" ).append("\n"); 
		query.append(",DC_AMT" ).append("\n"); 
		query.append(",DMDT_BRNC_FLG" ).append("\n"); 
		query.append(",DMDT_BRNC_SUBST_ID" ).append("\n"); 
		query.append(",DMDT_RHQ_PIC_FLG" ).append("\n"); 
		query.append(",DMDT_RHQ_FLG" ).append("\n"); 
		query.append(",DMDT_RHQ_SUBST_ID" ).append("\n"); 
		query.append(",DMDT_HO_FLG" ).append("\n"); 
		query.append(",DMDT_HO_SUBST_ID" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append("FROM DMT_APRO_STUP" ).append("\n"); 
		query.append("WHERE DMDT_EXPT_APRO_TP_CD = CASE WHEN NVL(@[dmdt_expt_apro_tp_cd],DMDT_EXPT_APRO_TP_CD) = 'All' THEN DMDT_EXPT_APRO_TP_CD" ).append("\n"); 
		query.append("ELSE NVL(@[dmdt_expt_apro_tp_cd],DMDT_EXPT_APRO_TP_CD) END" ).append("\n"); 
		query.append("AND OFC_LVL = NVL(@[ofc_lvl],OFC_LVL)" ).append("\n"); 
		query.append("AND DMDT_OFC_CD = NVL(@[dmdt_ofc_cd],DMDT_OFC_CD )" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DemDetTariffMgtDBDAOSearchApproSetupValidationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemDetTariffMgtDBDAOSearchApproSetupValidationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DemDetTariffMgtDBDAOSearchApproSetupValidationRSQL
	  * </pre>
	  */
	public DemDetTariffMgtDBDAOSearchApproSetupValidationRSQL(){
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
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_lvl",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration ").append("\n"); 
		query.append("FileName : DemDetTariffMgtDBDAOSearchApproSetupValidationRSQL").append("\n"); 
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
		query.append("SELECT DECODE(COUNT(*),0,'N','Y') VAL_FLG" ).append("\n"); 
		query.append("FROM DMT_APRO_STUP" ).append("\n"); 
		query.append("WHERE DMDT_EXPT_APRO_TP_CD = @[dmdt_expt_apro_tp_cd]" ).append("\n"); 
		query.append("AND OFC_LVL              = @[ofc_lvl]" ).append("\n"); 
		query.append("AND DMDT_OFC_CD          = @[dmdt_ofc_cd]" ).append("\n"); 
		query.append("AND CUST_CNT_CD          = CASE WHEN TRIM(UPPER(@[cust_cd])) = 'ALL' THEN 'AL'" ).append("\n"); 
		query.append("ELSE SUBSTR(@[cust_cd],1,2) END" ).append("\n"); 
		query.append("AND CUST_SEQ             = CASE WHEN TRIM(UPPER(@[cust_cd])) = 'ALL' THEN 0" ).append("\n"); 
		query.append("ELSE TO_NUMBER(SUBSTR(@[cust_cd],3)) END" ).append("\n"); 

	}
}
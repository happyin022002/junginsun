/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOCopyPsoTariffCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOCopyPsoTariffCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CopyPsoTariff
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOCopyPsoTariffCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pso_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_pso_trf_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_chg_xpr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOCopyPsoTariffCSQL").append("\n"); 
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
		query.append("INSERT INTO  PSO_TARIFF" ).append("\n"); 
		query.append("   (    PORT_TRF_NO," ).append("\n"); 
		query.append("        PSO_TRF_TP_CD," ).append("\n"); 
		query.append("        FOML_NO," ).append("\n"); 
		query.append("        CONS_ALS_NM," ).append("\n"); 
		query.append("        FOML_SEQ," ).append("\n"); 
		query.append("        CHG_XPR_NO," ).append("\n"); 
		query.append("        CHG_XPR_SEQ," ).append("\n"); 
		query.append("        OBJ_LIST_NO," ).append("\n"); 
		query.append("        CURR_CD," ).append("\n"); 
		query.append("        PSO_RT_TP_CD," ).append("\n"); 
		query.append("        DP_NO," ).append("\n"); 
		query.append("        RT_COND_SYS_DESC," ).append("\n"); 
		query.append("        CRE_USR_ID," ).append("\n"); 
		query.append("        CRE_DT," ).append("\n"); 
		query.append("        UPD_USR_ID," ).append("\n"); 
		query.append("        UPD_DT  )" ).append("\n"); 
		query.append("    SELECT @[new_pso_trf_no]," ).append("\n"); 
		query.append("           PSO_TRF_TP_CD," ).append("\n"); 
		query.append("           FOML_NO," ).append("\n"); 
		query.append("           CONS_ALS_NM," ).append("\n"); 
		query.append("           FOML_SEQ," ).append("\n"); 
		query.append("           @[new_chg_xpr_no]," ).append("\n"); 
		query.append("           CHG_XPR_SEQ," ).append("\n"); 
		query.append("           OBJ_LIST_NO," ).append("\n"); 
		query.append("           CURR_CD," ).append("\n"); 
		query.append("           PSO_RT_TP_CD," ).append("\n"); 
		query.append("           DP_NO," ).append("\n"); 
		query.append("           RT_COND_SYS_DESC," ).append("\n"); 
		query.append("           @[cre_usr_id]," ).append("\n"); 
		query.append("           SYSDATE," ).append("\n"); 
		query.append("           @[cre_usr_id]," ).append("\n"); 
		query.append("           SYSDATE" ).append("\n"); 
		query.append("      FROM PSO_TARIFF" ).append("\n"); 
		query.append("     WHERE PORT_TRF_NO = @[pso_trf_no]" ).append("\n"); 

	}
}
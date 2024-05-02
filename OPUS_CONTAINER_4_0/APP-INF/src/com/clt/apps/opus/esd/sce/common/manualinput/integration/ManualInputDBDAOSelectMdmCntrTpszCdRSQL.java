/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ManualInputDBDAOSelectMdmCntrTpszCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.02
*@LastModifier : 이준근
*@LastVersion : 1.0
* 2012.05.02 이준근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.common.manualinput.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LeeJunKun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualInputDBDAOSelectMdmCntrTpszCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SelectMdmCntrTpszCd
	  * </pre>
	  */
	public ManualInputDBDAOSelectMdmCntrTpszCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frm_cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.common.manualinput.integration").append("\n"); 
		query.append("FileName : ManualInputDBDAOSelectMdmCntrTpszCdRSQL").append("\n"); 
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
		query.append("SELECT CNTR_TPSZ_CD, CNTR_SZ_CD, CNTR_TP_CD, CNTR_TPSZ_LODG_WGT, " ).append("\n"); 
		query.append("       CNTR_TPSZ_LODG_CAPA, CNTR_TPSZ_TARE_WGT, CNTR_TPSZ_DESC," ).append("\n"); 
		query.append("       CNTR_TPSZ_RMK, CNTR_TPSZ_PSA_CD, CNTR_TPSZ_ISO_CD, " ).append("\n"); 
		query.append("       MODI_CNTR_TPSZ_CD, EAI_EVNT_DT, CNTR_TPSZ_GRP_CD, " ).append("\n"); 
		query.append("       RPT_DP_SEQ, ACIAC_DIV_CD, EAI_IF_ID, DELT_FLG, " ).append("\n"); 
		query.append("       CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT" ).append("\n"); 
		query.append("FROM MDM_CNTR_TP_SZ " ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("#if (${frm_cntr_tpsz_cd} != '') " ).append("\n"); 
		query.append("  AND CNTR_TPSZ_CD = @[frm_cntr_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DMTCollectionOfficeMgtDBDAOConfirmYardExceptionCostUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.03
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2012.12.03 KIM HYUN HWA
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author ISD1
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCollectionOfficeMgtDBDAOConfirmYardExceptionCostUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * YardExceptionCost의 Comfirm 정보를 update
	  * </pre>
	  */
	public DMTCollectionOfficeMgtDBDAOConfirmYardExceptionCostUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_expt_cost_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cfm_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcollectionofficemgt.integration").append("\n"); 
		query.append("FileName : DMTCollectionOfficeMgtDBDAOConfirmYardExceptionCostUSQL").append("\n"); 
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
		query.append("#if ( ${cfm_cancel} == 'N' )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE DMT_YD_EXPT_COST " ).append("\n"); 
		query.append("SET CFM_FLG   = 'Y'," ).append("\n"); 
		query.append("    CFM_DT     = NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[upd_ofc_cd]),SYSDATE),             " ).append("\n"); 
		query.append("    CFM_USR_ID = @[cfm_usr_id],        " ).append("\n"); 
		query.append("    CFM_OFC_CD = @[cfm_ofc_cd]," ).append("\n"); 
		query.append("    UPD_USR_ID = @[upd_usr_id],           " ).append("\n"); 
		query.append("    UPD_DT     = NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[upd_ofc_cd]),SYSDATE),               " ).append("\n"); 
		query.append("    UPD_OFC_CD = @[upd_ofc_cd] " ).append("\n"); 
		query.append("WHERE YD_CD    = @[yd_cd]           " ).append("\n"); 
		query.append("AND   YD_EXPT_COST_SEQ  = @[yd_expt_cost_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UPDATE DMT_YD_EXPT_COST " ).append("\n"); 
		query.append("SET CFM_FLG   = 'N'," ).append("\n"); 
		query.append("    CFM_DT     = NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[upd_ofc_cd]),SYSDATE),             " ).append("\n"); 
		query.append("    CFM_USR_ID = '',        " ).append("\n"); 
		query.append("    CFM_OFC_CD = ''," ).append("\n"); 
		query.append("    UPD_USR_ID = @[upd_usr_id],           " ).append("\n"); 
		query.append("    UPD_DT     = NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[upd_ofc_cd]),SYSDATE),               " ).append("\n"); 
		query.append("    UPD_OFC_CD = @[upd_ofc_cd] " ).append("\n"); 
		query.append("WHERE YD_CD    = @[yd_cd]           " ).append("\n"); 
		query.append("AND   YD_EXPT_COST_SEQ  = @[yd_expt_cost_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
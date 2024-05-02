/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOSearchHOApprovalPathApprovalUserRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.12
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2015.08.12 김기태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kitae Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAExceptionTariffMgtDBDAOSearchHOApprovalPathApprovalUserRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFAExceptionTariffMgtDBDAOSearchHOApprovalPathApprovalUserRSQL
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOSearchHOApprovalPathApprovalUserRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_mapg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rfa_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rfa_expt_dar_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOSearchHOApprovalPathApprovalUserRSQL").append("\n"); 
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
		query.append("select  @[rfa_expt_dar_no]          as RFA_EXPT_DAR_NO" ).append("\n"); 
		query.append("	   ,@[rfa_expt_mapg_seq]  		as RFA_EXPT_MAPG_SEQ" ).append("\n"); 
		query.append("	   ,@[rfa_expt_ver_seq]  		as RFA_EXPT_VER_SEQ" ).append("\n"); 
		query.append("	   ,'HDO'               		as DMDT_EXPT_APRO_PATH_CD" ).append("\n"); 
		query.append("	   ,T2.USR_ID          			as APRO_USR_ID" ).append("\n"); 
		query.append("       ,T2.OFC_CD					as APRO_OFC_CD" ).append("\n"); 
		query.append("	   ,0							as DMDT_EXPT_APRO_AGN_ORD_NO" ).append("\n"); 
		query.append("	   ,'N'       	        		as DMDT_EXPT_APRO_AGN_FLG" ).append("\n"); 
		query.append("	   ,@[cre_usr_id]				as CRE_USR_ID" ).append("\n"); 
		query.append("	   ,@[upd_usr_id]				as UPD_USR_ID    " ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append("  from  MDM_ORGANIZATION  T1" ).append("\n"); 
		query.append("       ,COM_USER          T2" ).append("\n"); 
		query.append(" where  T1.OFC_TP_CD in ('HT')" ).append("\n"); 
		query.append("   and  T1.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   and  T1.OFC_CD in ('SELCMA', 'SELCMU', 'SELCMI', 'SELCMB', 'SELCMS')" ).append("\n"); 
		query.append("   and  T1.OFC_CD = T2.OFC_CD" ).append("\n"); 
		query.append("   and  T2.USE_FLG = 'Y'" ).append("\n"); 

	}
}
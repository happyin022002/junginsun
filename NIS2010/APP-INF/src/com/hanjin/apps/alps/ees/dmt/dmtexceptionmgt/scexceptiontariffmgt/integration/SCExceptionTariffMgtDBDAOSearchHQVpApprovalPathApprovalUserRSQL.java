/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SCExceptionTariffMgtDBDAOSearchHQVpApprovalPathApprovalUserRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.11
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2015.11.11 김기태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kitae Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCExceptionTariffMgtDBDAOSearchHQVpApprovalPathApprovalUserRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCExceptionTariffMgtDBDAOSearchHQVpApprovalPathApprovalUserRSQL
	  * </pre>
	  */
	public SCExceptionTariffMgtDBDAOSearchHQVpApprovalPathApprovalUserRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_expt_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : SCExceptionTariffMgtDBDAOSearchHQVpApprovalPathApprovalUserRSQL").append("\n"); 
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
		query.append("select  @[prop_no]          as PROP_NO" ).append("\n"); 
		query.append("	   ,@[sc_expt_ver_seq]  as SC_EXPT_VER_SEQ" ).append("\n"); 
		query.append("	   ,'V.P'               as DMDT_EXPT_APRO_PATH_CD" ).append("\n"); 
		query.append("	   ,T2.USR_ID           as APRO_USR_ID" ).append("\n"); 
		query.append("	   ,T2.OFC_CD			as APRO_OFC_CD" ).append("\n"); 
		query.append("	   ,0					as DMDT_EXPT_APRO_AGN_ORD_NO	   " ).append("\n"); 
		query.append("	   ,'N'       	        as DMDT_EXPT_APRO_AGN_FLG" ).append("\n"); 
		query.append("       ,@[cre_usr_id]		as CRE_USR_ID" ).append("\n"); 
		query.append("       ,@[upd_usr_id]		as UPD_USR_ID" ).append("\n"); 
		query.append("	   " ).append("\n"); 
		query.append("  from  (" ).append("\n"); 
		query.append("				select  OFC_N3RD_LVL_CD  as OFC_CD																						  " ).append("\n"); 
		query.append("				  from  DMT_OFC_LVL_V" ).append("\n"); 
		query.append("				 where  OFC_N8TH_LVL_CD = @[cre_ofc_cd]" ).append("\n"); 
		query.append("				   and  ROWNUM = 1" ).append("\n"); 
		query.append("		) T1" ).append("\n"); 
		query.append("	   ,(" ).append("\n"); 
		query.append("			select  OFC_CD" ).append("\n"); 
		query.append("				   ,USR_ID" ).append("\n"); 
		query.append("			  from  COM_USER" ).append("\n"); 
		query.append("			 where  PSN_ENG_NM = 'Managing Director(RHQ)'" ).append("\n"); 
		query.append("			   and  USE_FLG = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			union all" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			select  decode(OFC_CD, 'SELSC', 'SELIB', 'TYOSC', 'TYOIB', 'VVOBA', 'VVOIA', '') as OFC_CD" ).append("\n"); 
		query.append("				   ,USR_ID" ).append("\n"); 
		query.append("			  from  COM_USER" ).append("\n"); 
		query.append("			 where  PSN_ENG_NM in ('Branch MGR', 'Branch Manager')" ).append("\n"); 
		query.append("			   and  USE_FLG = 'Y'	 " ).append("\n"); 
		query.append("			   and  OFC_CD IN ('SELSC', 'TYOSC', 'VVOBA')" ).append("\n"); 
		query.append("		) T2" ).append("\n"); 
		query.append(" where  T1.OFC_CD = T2.OFC_CD" ).append("\n"); 
		query.append("   and  ROWNUM = 1" ).append("\n"); 

	}
}
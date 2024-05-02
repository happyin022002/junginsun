/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DemDetTariffMgtDBDAOSearchValidOfficeForAproPathRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.11
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2015.11.11 김기태
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kitae Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DemDetTariffMgtDBDAOSearchValidOfficeForAproPathRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DemDetTariffMgtDBDAOSearchValidOfficeForAproPathRSQL
	  * </pre>
	  */
	public DemDetTariffMgtDBDAOSearchValidOfficeForAproPathRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_apro_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srch_apro_path_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.integration").append("\n"); 
		query.append("FileName : DemDetTariffMgtDBDAOSearchValidOfficeForAproPathRSQL").append("\n"); 
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
		query.append("select  case " ).append("\n"); 
		query.append("			when @[srch_apro_path_cd] = 'HDO' then (" ).append("\n"); 
		query.append("                                        select  case when count(1) > 0 then 'Y' else 'N' end" ).append("\n"); 
		query.append("                                          from  MDM_ORGANIZATION" ).append("\n"); 
		query.append("                                         where  OFC_TP_CD in ('HT')" ).append("\n"); 
		query.append("                                           and  DELT_FLG = 'N'" ).append("\n"); 
		query.append("                                           and  OFC_CD = @[srch_apro_ofc_cd]" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("			when @[srch_apro_path_cd] = 'V.P' then (" ).append("\n"); 
		query.append("                                        select  case when count(1) > 0 then 'Y' else 'N' end" ).append("\n"); 
		query.append("                                          from  (" ).append("\n"); 
		query.append("                                                    select  OFC_CD" ).append("\n"); 
		query.append("                                                      from  COM_USER" ).append("\n"); 
		query.append("                                                     where  PSN_ENG_NM = 'Managing Director(RHQ)'" ).append("\n"); 
		query.append("                                                       and  USE_FLG ='Y'" ).append("\n"); 
		query.append("                                                    " ).append("\n"); 
		query.append("                                                    union all" ).append("\n"); 
		query.append("                                                    " ).append("\n"); 
		query.append("                                                    select  decode(OFC_CD,'SELSC','SELIB','TYOSC','TYOIB','VVOBA','VVOIA','') as OFC_CD" ).append("\n"); 
		query.append("                                                      from  COM_USER" ).append("\n"); 
		query.append("                                                     where  PSN_ENG_NM IN ('Branch Manager','Branch MGR')" ).append("\n"); 
		query.append("                                                       and  USE_FLG ='Y'  " ).append("\n"); 
		query.append("                                                       and  OFC_CD IN ('SELSC', 'TYOSC', 'VVOBA')                                                       " ).append("\n"); 
		query.append("                                                )" ).append("\n"); 
		query.append("                                         where  OFC_CD = @[srch_apro_ofc_cd]" ).append("\n"); 
		query.append("                                    )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			when @[srch_apro_path_cd] = 'BBG' then (" ).append("\n"); 
		query.append("										select  case when count(1) > 0 then 'Y' else 'N' end" ).append("\n"); 
		query.append("										  from  (  " ).append("\n"); 
		query.append("													select  OFC_CD " ).append("\n"); 
		query.append("													  from  COM_USER " ).append("\n"); 
		query.append("													 where  PSN_ENG_NM = 'Country Manager' " ).append("\n"); 
		query.append("													   and  substr(OFC_CD, 4, 2) = 'BB' " ).append("\n"); 
		query.append("													   and  USE_FLG = 'Y' " ).append("\n"); 
		query.append("															" ).append("\n"); 
		query.append("													union all" ).append("\n"); 
		query.append("														 " ).append("\n"); 
		query.append("													select  OFC_CD " ).append("\n"); 
		query.append("													  from  COM_USER " ).append("\n"); 
		query.append("													 where  PSN_ENG_NM = 'Branch MGR' " ).append("\n"); 
		query.append("													   and  USE_FLG = 'Y'			 " ).append("\n"); 
		query.append("													   and  ( " ).append("\n"); 
		query.append("																OFC_CD in ('SELSC','TYOSC','VVOIA')  " ).append("\n"); 
		query.append("															 or OFC_CD in  " ).append("\n"); 
		query.append("																( " ).append("\n"); 
		query.append("																	select  OFC_CD " ).append("\n"); 
		query.append("																	  from  MDM_ORGANIZATION  " ).append("\n"); 
		query.append("																	 where  REP_CUST_CNT_CD IN ('CN','US')   " ).append("\n"); 
		query.append("																	   and  OFC_TP_CD = 'BB' " ).append("\n"); 
		query.append("                                                                       and  DELT_FLG = 'N'" ).append("\n"); 
		query.append("																) " ).append("\n"); 
		query.append("															) 										  " ).append("\n"); 
		query.append("												)" ).append("\n"); 
		query.append("										 where  OFC_CD = @[srch_apro_ofc_cd]" ).append("\n"); 
		query.append("									)" ).append("\n"); 
		query.append("		else 'N'" ).append("\n"); 
		query.append("		end		" ).append("\n"); 
		query.append("  from  dual" ).append("\n"); 

	}
}
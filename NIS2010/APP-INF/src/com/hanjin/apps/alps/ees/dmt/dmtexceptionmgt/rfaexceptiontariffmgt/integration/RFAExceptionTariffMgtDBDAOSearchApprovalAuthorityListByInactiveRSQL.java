/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOSearchApprovalAuthorityListByInactiveRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.11
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2015.11.11 김기태
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

public class RFAExceptionTariffMgtDBDAOSearchApprovalAuthorityListByInactiveRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RFAExceptionTariffMgtDBDAOSearchApprovalAuthorityListByInactiveRSQL
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOSearchApprovalAuthorityListByInactiveRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOSearchApprovalAuthorityListByInactiveRSQL").append("\n"); 
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
		query.append("select  APVL_PATH_CD" ).append("\n"); 
		query.append("       ,APVL_PATH_LVL" ).append("\n"); 
		query.append("	   ,OFC_CD" ).append("\n"); 
		query.append("	   ,USR_ID" ).append("\n"); 
		query.append("	   ,USR_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  from  (" ).append("\n"); 
		query.append("			--// BBG(지점장) 조회" ).append("\n"); 
		query.append("			select  'BBG' 					as APVL_PATH_CD" ).append("\n"); 
		query.append("                   ,1                       as APVL_PATH_LVL" ).append("\n"); 
		query.append("				   ,T4.OFC_CD" ).append("\n"); 
		query.append("				   ,T4.USR_ID" ).append("\n"); 
		query.append("				   ,T4.USR_NM" ).append("\n"); 
		query.append("				   " ).append("\n"); 
		query.append("			  from  DMT_CHG_DELT_PATH_STUP  T1" ).append("\n"); 
		query.append("				   ,DMT_CHG_DELT_OFC_STUP   T2" ).append("\n"); 
		query.append("				   ,DMT_OFC_LVL_V			T3" ).append("\n"); 
		query.append("				   ,(" ).append("\n"); 
		query.append("						select  USR_ID" ).append("\n"); 
		query.append("							   ,USR_NM" ).append("\n"); 
		query.append("							   ,OFC_CD" ).append("\n"); 
		query.append("						  from  COM_USER" ).append("\n"); 
		query.append("						 where  PSN_ENG_NM           = 'Country Manager'" ).append("\n"); 
		query.append("						   and  substr(OFC_CD, 4, 2) = 'BB'" ).append("\n"); 
		query.append("						   and  USE_FLG              = 'Y'" ).append("\n"); 
		query.append("						   " ).append("\n"); 
		query.append("						union all" ).append("\n"); 
		query.append("						" ).append("\n"); 
		query.append("						select  USR_ID" ).append("\n"); 
		query.append("							   ,USR_NM" ).append("\n"); 
		query.append("							   ,OFC_CD" ).append("\n"); 
		query.append("						  from  COM_USER  SUB1" ).append("\n"); 
		query.append("						 where  PSN_ENG_NM = 'Branch MGR'" ).append("\n"); 
		query.append("						   and  (" ).append("\n"); 
		query.append("									OFC_CD in ('SELSC', 'TYOSC')" ).append("\n"); 
		query.append("								 or exists" ).append("\n"); 
		query.append("									(" ).append("\n"); 
		query.append("										select  1" ).append("\n"); 
		query.append("										  from  MDM_ORGANIZATION    " ).append("\n"); 
		query.append("										 where  REP_CUST_CNT_CD IN ('CN','US')     " ).append("\n"); 
		query.append("										   and  OFC_TP_CD = 'BB'   " ).append("\n"); 
		query.append("										   and  DELT_FLG  = 'N'" ).append("\n"); 
		query.append("										   and  OFC_CD    = SUB1.OFC_CD" ).append("\n"); 
		query.append("									)" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("						   and  USE_FLG    = 'Y'" ).append("\n"); 
		query.append("					)						T4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			 where  T1.EFF_DT <= sysdate and (T1.EXP_DT is null or T1.EXP_DT >= sysdate)" ).append("\n"); 
		query.append("			   and  T1.CHG_DELT_PATH_STUP_SEQ = T2.CHG_DELT_PATH_STUP_SEQ" ).append("\n"); 
		query.append("			   and  T1.DMDT_BRNC_FLG          = 'Y'" ).append("\n"); 
		query.append("               #if (${ofc_cd_list} != '')" ).append("\n"); 
		query.append("               and  T2.CHG_DELT_OFC_CD        in" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("						#foreach( $ofc_cd in ${ofc_cd_list} )" ).append("\n"); 
		query.append("							#if($velocityCount < $ofc_cd_list.size()) '$ofc_cd', #else '$ofc_cd' #end" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("  			   and  T2.CHG_DELT_OFC_CD        = T3.OFC_N8TH_LVL_CD" ).append("\n"); 
		query.append("			   and  T3.OFC_N4TH_LVL_CD		  = T4.OFC_CD(+)" ).append("\n"); 
		query.append("               #if (${ofc_cd} != '') " ).append("\n"); 
		query.append("			   and  T4.OFC_CD                 = @[ofc_cd]" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("			   #if (${usr_nm} != '') " ).append("\n"); 
		query.append("			   and  upper(T4.USR_NM) like '%'||UPPER(@[usr_nm])||'%'" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("			   " ).append("\n"); 
		query.append("			union all" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			--// RHQ(지역본부장) 조회" ).append("\n"); 
		query.append("			select  'RHQ' 					as APVL_PATH_CD" ).append("\n"); 
		query.append("                   ,2                       as APVL_PATH_LVL" ).append("\n"); 
		query.append("				   ,T4.OFC_CD" ).append("\n"); 
		query.append("				   ,T4.USR_ID" ).append("\n"); 
		query.append("				   ,T4.USR_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			  from  DMT_CHG_DELT_PATH_STUP  T1" ).append("\n"); 
		query.append("				   ,DMT_CHG_DELT_OFC_STUP   T2" ).append("\n"); 
		query.append("				   ,DMT_OFC_LVL_V			T3	" ).append("\n"); 
		query.append("				   ,(" ).append("\n"); 
		query.append("						select  USR_ID" ).append("\n"); 
		query.append("							   ,USR_NM" ).append("\n"); 
		query.append("							   ,OFC_CD" ).append("\n"); 
		query.append("						  from  COM_USER                       " ).append("\n"); 
		query.append("						 where  PSN_ENG_NM = 'Managing Director(RHQ)'                       " ).append("\n"); 
		query.append("						   and  USE_FLG = 'Y'  " ).append("\n"); 
		query.append("						   " ).append("\n"); 
		query.append("						union all" ).append("\n"); 
		query.append("						" ).append("\n"); 
		query.append("						select  USR_ID" ).append("\n"); 
		query.append("							   ,USR_NM" ).append("\n"); 
		query.append("							   ,decode(OFC_CD, 'SELSC', 'SELIB', 'TYOSC', 'TYOIB', 'VVOBA', 'VVOIA', OFC_CD)" ).append("\n"); 
		query.append("						 from  COM_USER                       " ).append("\n"); 
		query.append("						where  PSN_ENG_NM in ('Branch MGR', 'Branch Manager')                       " ).append("\n"); 
		query.append("						  and  USE_FLG = 'Y'                        " ).append("\n"); 
		query.append("						  and  OFC_CD in ('SELSC', 'TYOSC', 'VVOBA')" ).append("\n"); 
		query.append("					)						T4" ).append("\n"); 
		query.append("			 where  T1.EFF_DT <= sysdate and (T1.EXP_DT is null or T1.EXP_DT >= sysdate)" ).append("\n"); 
		query.append("			   and  T1.CHG_DELT_PATH_STUP_SEQ = T2.CHG_DELT_PATH_STUP_SEQ" ).append("\n"); 
		query.append("			   and  (" ).append("\n"); 
		query.append("						T1.DMDT_RHQ_FLG       = 'Y' " ).append("\n"); 
		query.append("					 or T1.DMDT_HO_FLG        = 'N'" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("			   #if (${ofc_cd_list} != '')" ).append("\n"); 
		query.append("               and  T2.CHG_DELT_OFC_CD        in" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("						#foreach( $ofc_cd in ${ofc_cd_list} )" ).append("\n"); 
		query.append("							#if($velocityCount < $ofc_cd_list.size()) '$ofc_cd', #else '$ofc_cd' #end" ).append("\n"); 
		query.append("						#end" ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("               #end" ).append("\n"); 
		query.append("               and  T2.CHG_DELT_OFC_CD        = T3.OFC_N8TH_LVL_CD" ).append("\n"); 
		query.append("			   and  T3.OFC_N3RD_LVL_CD		  = T4.OFC_CD(+)" ).append("\n"); 
		query.append("               #if (${ofc_cd} != '') " ).append("\n"); 
		query.append("			   and  T4.OFC_CD                 = @[ofc_cd]" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("			   #if (${usr_nm} != '') " ).append("\n"); 
		query.append("			   and  upper(T4.USR_NM) like '%'||UPPER(@[usr_nm])||'%'" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("			   " ).append("\n"); 
		query.append("			union all" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			--// DMT02 권한사용자 조회 (RHQ 권한 = RHQ(지역본부장) or DMT02 권한사용자)" ).append("\n"); 
		query.append("			select  'RHQ'					as APVL_PATH_CD" ).append("\n"); 
		query.append("                   ,2                       as APVL_PATH_LVL" ).append("\n"); 
		query.append("			       ,SUB2.OFC_CD" ).append("\n"); 
		query.append("			       ,SUB2.USR_ID" ).append("\n"); 
		query.append("				   ,SUB2.USR_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			  from  DMT_USR_ROLE_MTCH  SUB1" ).append("\n"); 
		query.append("				   ,COM_USER           SUB2" ).append("\n"); 
		query.append("			 where  SUB1.USR_ROLE_CD = 'DMT02'" ).append("\n"); 
		query.append("			   and  SUB1.USR_ID      = SUB2.USR_ID" ).append("\n"); 
		query.append("			   and  SUB2.USE_FLG     = 'Y'   " ).append("\n"); 
		query.append("               #if (${ofc_cd} != '') " ).append("\n"); 
		query.append("			   and  SUB2.OFC_CD                 = @[ofc_cd]" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("			   #if (${usr_nm} != '') " ).append("\n"); 
		query.append("			   and  upper(SUB2.USR_NM) like '%' || upper(@[usr_nm]) || '%'" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("			   and  exists" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("						select  1" ).append("\n"); 
		query.append("						  from  DMT_CHG_DELT_PATH_STUP  T1" ).append("\n"); 
		query.append("				               ,DMT_CHG_DELT_OFC_STUP   T2" ).append("\n"); 
		query.append("						 where  T1.EFF_DT <= sysdate and (T1.EXP_DT is null or T1.EXP_DT >= sysdate)" ).append("\n"); 
		query.append("						   and  T1.CHG_DELT_PATH_STUP_SEQ = T2.CHG_DELT_PATH_STUP_SEQ" ).append("\n"); 
		query.append("						   and  (" ).append("\n"); 
		query.append("									T1.DMDT_RHQ_FLG       = 'Y' " ).append("\n"); 
		query.append("								 or T1.DMDT_HO_FLG        = 'N'" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("						   #if (${ofc_cd_list} != '')" ).append("\n"); 
		query.append("						   and  T2.CHG_DELT_OFC_CD        in" ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									#foreach( $ofc_cd in ${ofc_cd_list} )" ).append("\n"); 
		query.append("										#if($velocityCount < $ofc_cd_list.size()) '$ofc_cd', #else '$ofc_cd' #end" ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("						   #end" ).append("\n"); 
		query.append("					)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			union all" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			--// DMT01 권한사용자 조회 (HO 권한 = DMT01 권한사용자)" ).append("\n"); 
		query.append("			select  'HO'					as APVL_PATH_CD" ).append("\n"); 
		query.append("                   ,3                       as APVL_PATH_LVL" ).append("\n"); 
		query.append("			       ,SUB2.OFC_CD" ).append("\n"); 
		query.append("			       ,SUB2.USR_ID" ).append("\n"); 
		query.append("				   ,SUB2.USR_NM" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			  from  DMT_USR_ROLE_MTCH  SUB1" ).append("\n"); 
		query.append("				   ,COM_USER           SUB2" ).append("\n"); 
		query.append("			 where  SUB1.USR_ROLE_CD = 'DMT01'" ).append("\n"); 
		query.append("			   and  SUB1.USR_ID      = SUB2.USR_ID" ).append("\n"); 
		query.append("			   and  SUB2.USE_FLG     = 'Y'" ).append("\n"); 
		query.append("               #if (${ofc_cd} != '') " ).append("\n"); 
		query.append("			   and  SUB2.OFC_CD                 = @[ofc_cd]" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("			   #if (${usr_nm} != '') " ).append("\n"); 
		query.append("			   and  upper(SUB2.USR_NM) like '%' || upper(@[usr_nm]) || '%'" ).append("\n"); 
		query.append("			   #end" ).append("\n"); 
		query.append("			   and  exists" ).append("\n"); 
		query.append("                    (" ).append("\n"); 
		query.append("						select  1" ).append("\n"); 
		query.append("						  from  DMT_CHG_DELT_PATH_STUP  T1" ).append("\n"); 
		query.append("				               ,DMT_CHG_DELT_OFC_STUP   T2" ).append("\n"); 
		query.append("						 where  T1.EFF_DT <= sysdate and (T1.EXP_DT is null or T1.EXP_DT >= sysdate)" ).append("\n"); 
		query.append("						   and  T1.CHG_DELT_PATH_STUP_SEQ = T2.CHG_DELT_PATH_STUP_SEQ" ).append("\n"); 
		query.append("						   #if (${ofc_cd_list} != '')" ).append("\n"); 
		query.append("						   and  T2.CHG_DELT_OFC_CD        in" ).append("\n"); 
		query.append("								(" ).append("\n"); 
		query.append("									#foreach( $ofc_cd in ${ofc_cd_list} )" ).append("\n"); 
		query.append("										#if($velocityCount < $ofc_cd_list.size()) '$ofc_cd', #else '$ofc_cd' #end" ).append("\n"); 
		query.append("									#end" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("						   #end" ).append("\n"); 
		query.append("					)			   " ).append("\n"); 
		query.append("		)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("group by APVL_PATH_CD" ).append("\n"); 
		query.append("        ,APVL_PATH_LVL" ).append("\n"); 
		query.append("	    ,OFC_CD" ).append("\n"); 
		query.append("	    ,USR_ID" ).append("\n"); 
		query.append("	    ,USR_NM" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("order by APVL_PATH_LVL" ).append("\n"); 

	}
}
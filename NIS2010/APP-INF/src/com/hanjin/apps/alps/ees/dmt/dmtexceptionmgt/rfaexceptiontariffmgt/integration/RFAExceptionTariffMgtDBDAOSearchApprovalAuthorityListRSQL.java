/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOSearchApprovalAuthorityListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RFAExceptionTariffMgtDBDAOSearchApprovalAuthorityListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 승인권한자 List 를 조회하는 화면
	  * </pre>
	  */
	public RFAExceptionTariffMgtDBDAOSearchApprovalAuthorityListRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_hd_qtr_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
		query.append("FileName : RFAExceptionTariffMgtDBDAOSearchApprovalAuthorityListRSQL").append("\n"); 
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
		query.append("select  distinct T1.USR_ID 		as USR_ID" ).append("\n"); 
		query.append("	   ,T4.AR_HD_QTR_OFC_CD 	as AR_HD_QTR_OFC_CD" ).append("\n"); 
		query.append("       ,T1.OFC_CD 				as OFC_CD" ).append("\n"); 
		query.append("       ,T1.USR_NM               as USR_NM" ).append("\n"); 
		query.append("#if (${cond_type} != 'before')" ).append("\n"); 
		query.append("       ,T2.USR_ROLE_CD" ).append("\n"); 
		query.append("	#if (${cond_type} == 'after')" ).append("\n"); 
		query.append("       ,decode(T2.USR_ROLE_CD, 'DMT01', 'HO PIC', 'DMT10', 'HO Team MGR', 'DMT02', 'RHQ PIC', 'DMT20' , 'RHQ O.MGR', 'DMT03', 'SSZ/BAG', 'DMT30', 'SCO/BAO PIC', 'DMT50', 'CONTRACT OFC SSZ', 'ERROR') as APVL_PATH_CD       " ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("       ,decode(T2.USR_ROLE_CD, 'DMT01', 'HO', 'DMT02', 'RHQ', 'DMT06', 'SSZ/BAG') as APVL_PATH_CD" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  from  COM_USER            T1 " ).append("\n"); 
		query.append("       ,DMT_USR_ROLE_MTCH   T2" ).append("\n"); 
		query.append("       ,COM_OFC_PGM_MTCH    T3" ).append("\n"); 
		query.append("       ,MDM_ORGANIZATION    T4" ).append("\n"); 
		query.append(" where  T1.USR_ID       =   T2.USR_ID" ).append("\n"); 
		query.append("   and  T1.OFC_CD       =   T3.OFC_CD" ).append("\n"); 
		query.append("   and  T1.OFC_CD       =   T4.OFC_CD" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("   #if (${cond_type} == 'before')" ).append("\n"); 
		query.append("   ##--- BEFORE BOOKING 승인권자 ---" ).append("\n"); 
		query.append("   and  T2.USR_ROLE_CD  = 'DMT05'" ).append("\n"); 
		query.append("   and  T3.PGM_NO       = 'EES_DMT_2005'" ).append("\n"); 
		query.append("   #elseif (${cond_type} == 'after')" ).append("\n"); 
		query.append("   ##--- AFTER BOOKING 승인권자 ---" ).append("\n"); 
		query.append("   and  T2.USR_ROLE_CD  in ('DMT01', 'DMT02', 'DMT03','DMT10', 'DMT20', 'DMT30', 'DMT50')" ).append("\n"); 
		query.append("   and  T3.PGM_NO       = 'EES_DMT_2005'" ).append("\n"); 
		query.append("   #elseif (${cond_type} == 'inactive')" ).append("\n"); 
		query.append("   ##--- CHARGE INACTIVATION 승인권자 ---" ).append("\n"); 
		query.append("   and  T2.USR_ROLE_CD  in ('DMT02', 'DMT06')" ).append("\n"); 
		query.append("   and  T3.PGM_NO       = 'EES_DMT_3014'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("   #if (${ar_hd_qtr_ofc_cd} != '') " ).append("\n"); 
		query.append("   and  T4.AR_HD_QTR_OFC_CD = @[ar_hd_qtr_ofc_cd]" ).append("\n"); 
		query.append("   #end  " ).append("\n"); 
		query.append("   #if (${ofc_cd} != '') " ).append("\n"); 
		query.append("   and  T1.OFC_CD       =   @[ofc_cd]" ).append("\n"); 
		query.append("   #end " ).append("\n"); 
		query.append("   #if (${usr_nm} != '') " ).append("\n"); 
		query.append("   and  upper(T1.USR_NM) like '%' || upper(@[usr_nm]) || '%'" ).append("\n"); 
		query.append("   #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("order by T4.AR_HD_QTR_OFC_CD	" ).append("\n"); 
		query.append("	    #if (${cond_type} == 'inactive' || ${cond_type} == 'after')" ).append("\n"); 
		query.append("        ,T2.USR_ROLE_CD desc" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("		,T1.OFC_CD" ).append("\n"); 
		query.append("		,T1.USR_NM" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RFAExceptionTariffMgtDBDAOSearchApprovalAuthorityListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.02
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

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
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.integration").append("\n"); 
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
		query.append("SELECT  DISTINCT CU.USR_ID AS USR_ID," ).append("\n"); 
		query.append("	    MO.AR_HD_QTR_OFC_CD AS AR_HD_QTR_OFC_CD," ).append("\n"); 
		query.append("        CU.OFC_CD AS OFC_CD,        " ).append("\n"); 
		query.append("        CU.USR_NM AS USR_NM" ).append("\n"); 
		query.append("FROM    COM_USER            CU," ).append("\n"); 
		query.append("        COM_USR_ROLE_MTCH   CURM," ).append("\n"); 
		query.append("        COM_OFC_PGM_MTCH    COPM," ).append("\n"); 
		query.append("        MDM_ORGANIZATION    MO" ).append("\n"); 
		query.append("WHERE   CU.OFC_CD       =   COPM.OFC_CD" ).append("\n"); 
		query.append("AND     CU.USR_ID       =   CURM.USR_ID" ).append("\n"); 
		query.append("AND     CU.OFC_CD       =   MO.OFC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${cond_type} == 'before') " ).append("\n"); 
		query.append("##BEFORE BOOKING 승인권자" ).append("\n"); 
		query.append("AND     COPM.PGM_NO     =   'EES_DMT_2005'" ).append("\n"); 
		query.append("AND     CURM.USR_ROLE_CD IN ('DMT01', 'DMT02', 'DMT03')" ).append("\n"); 
		query.append("#elseif (${cond_type} == 'after') " ).append("\n"); 
		query.append("## AFTER BOOKING 승인권자 " ).append("\n"); 
		query.append("AND     COPM.PGM_NO     =   'EES_DMT_2009'" ).append("\n"); 
		query.append("AND     CURM.USR_ROLE_CD IN ('DMT01', 'DMT02', 'DMT03')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ar_hd_qtr_ofc_cd} != '') " ).append("\n"); 
		query.append("AND     MO.AR_HD_QTR_OFC_CD = @[ar_hd_qtr_ofc_cd]" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ofc_cd} != '') " ).append("\n"); 
		query.append("AND     CU.OFC_CD       =   @[ofc_cd]" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${usr_nm} != '') " ).append("\n"); 
		query.append("AND     UPPER(CU.USR_NM)       LIKE   '%'||UPPER(@[usr_nm])||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY MO.AR_HD_QTR_OFC_CD	" ).append("\n"); 
		query.append("		,CU.OFC_CD" ).append("\n"); 
		query.append("		,CU.USR_NM" ).append("\n"); 

	}
}
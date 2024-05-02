/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OfficeGeneralInfoMgtDBDAOsearchColleagueTreeListDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.10.28 권영법
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 권영법
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OfficeGeneralInfoMgtDBDAOsearchColleagueTreeListDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public OfficeGeneralInfoMgtDBDAOsearchColleagueTreeListDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.integration").append("\n"); 
		query.append("FileName : OfficeGeneralInfoMgtDBDAOsearchColleagueTreeListDataRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("C.AR_HD_QTR_OFC_CD," ).append("\n"); 
		query.append("A.OFC_CD OFC_CD," ).append("\n"); 
		query.append("A.MNR_GRP_TP_CD," ).append("\n"); 
		query.append("A.CNTC_USR_ID," ).append("\n"); 
		query.append("A.MNR_CNTC_RMK," ).append("\n"); 
		query.append("B.USR_NM," ).append("\n"); 
		query.append("B.USR_EML," ).append("\n"); 
		query.append("A.OFC_CD ORG_OFC_CD," ).append("\n"); 
		query.append("A.MNR_GRP_TP_CD ORG_MNR_GRP_TP_CD," ).append("\n"); 
		query.append("A.CNTC_USR_ID  ORG_CNTC_USR_ID" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("MDM_ORGANIZATION C," ).append("\n"); 
		query.append("MNR_OFC_CNTC_PSON A," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("OFC_CD," ).append("\n"); 
		query.append("USR_ID," ).append("\n"); 
		query.append("USR_NM," ).append("\n"); 
		query.append("USR_EML" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT ROW_NUMBER() OVER (ORDER BY CU.USR_ID ASC) NO," ).append("\n"); 
		query.append("CU.OFC_CD," ).append("\n"); 
		query.append("CU.USR_ID," ).append("\n"); 
		query.append("CU.USR_NM," ).append("\n"); 
		query.append("CU.USR_EML" ).append("\n"); 
		query.append("FROM COM_USER  CU" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND NVL(CU.USE_FLG, 'Y') <> 'N'" ).append("\n"); 
		query.append("AND CU.OFC_CD LIKE '%'|| @[ofc_cd] ||'%'" ).append("\n"); 
		query.append(")) B" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND A.CNTC_USR_ID = B.USR_ID" ).append("\n"); 
		query.append("AND A.OFC_CD = B.OFC_CD" ).append("\n"); 
		query.append("AND A.OFC_CD = C.OFC_CD" ).append("\n"); 
		query.append("AND C.AR_HD_QTR_OFC_CD = @[ar_hd_qtr_ofc_cd]" ).append("\n"); 

	}
}
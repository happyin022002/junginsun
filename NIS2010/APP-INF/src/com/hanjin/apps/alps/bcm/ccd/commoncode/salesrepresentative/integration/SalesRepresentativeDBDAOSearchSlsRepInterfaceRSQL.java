/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : SalesRepresentativeDBDAOSearchSlsRepInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SalesRepresentativeDBDAOSearchSlsRepInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Sales Rep interface
	  * </pre>
	  */
	public SalesRepresentativeDBDAOSearchSlsRepInterfaceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("srep_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.integration ").append("\n"); 
		query.append("FileName : SalesRepresentativeDBDAOSearchSlsRepInterfaceRSQL").append("\n"); 
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
		query.append("SELECT Srep_Cd    " ).append("\n"); 
		query.append("      ,Ofc_Cd Mst_Ofc_Id  " ).append("\n"); 
		query.append("      ,Ofc_Cd     " ).append("\n"); 
		query.append("      ,Srep_Nm    " ).append("\n"); 
		query.append("      ,'' Ofc_Mst_Tm_Id" ).append("\n"); 
		query.append("      ,Ofc_Team_Cd " ).append("\n"); 
		query.append("      ,SEX_CD Sx_Cd      " ).append("\n"); 
		query.append("      ,Srep_Abbr_Nm" ).append("\n"); 
		query.append("      ,Ib_Srep_Flg " ).append("\n"); 
		query.append("      ,Ob_Srep_Flg " ).append("\n"); 
		query.append("      ,Empe_Cd    " ).append("\n"); 
		query.append("      ,Srep_Eml   " ).append("\n"); 
		query.append("      ,Intl_Mphn_No" ).append("\n"); 
		query.append("      ,Mphn_No    " ).append("\n"); 
		query.append("      ,Cre_Usr_Id  " ).append("\n"); 
		query.append("      ,TO_CHAR(Cre_Dt,'YYYYMMDDHH24MISS') Cre_Dt" ).append("\n"); 
		query.append("      ,Upd_Usr_Id  " ).append("\n"); 
		query.append("      ,TO_CHAR(Upd_Dt,'YYYYMMDDHH24MISS') Upd_Dt" ).append("\n"); 
		query.append("      ,MSR.SREP_STS_CD Sts_Cd     " ).append("\n"); 
		query.append("      ,'' O_Mst_Ofc_Id " ).append("\n"); 
		query.append("      ,'' O_Ofc_Cd   " ).append("\n"); 
		query.append("  FROM MDM_SLS_REP MSR" ).append("\n"); 
		query.append(" WHERE SREP_CD = @[srep_cd]" ).append("\n"); 
		query.append(" " ).append("\n"); 

	}
}
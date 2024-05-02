/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OfficeGeneralInfoMgtDBDAOremoveColleagueTreeDataDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 정영훈
*@LastVersion : 1.0
* 2009.06.19 정영훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author chung young hun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OfficeGeneralInfoMgtDBDAOremoveColleagueTreeDataDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * delete
	  * </pre>
	  */
	public OfficeGeneralInfoMgtDBDAOremoveColleagueTreeDataDSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_cntc_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_mnr_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("DELETE FROM MNR_OFC_CNTC_PSON" ).append("\n"); 
		query.append("WHERE OFC_CD = @[org_ofc_cd]" ).append("\n"); 
		query.append("AND   MNR_GRP_TP_CD = @[org_mnr_grp_tp_cd]" ).append("\n"); 
		query.append("AND   CNTC_USR_ID = @[org_cntc_usr_id]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.integration").append("\n"); 
		query.append("FileName : OfficeGeneralInfoMgtDBDAOremoveColleagueTreeDataDSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}
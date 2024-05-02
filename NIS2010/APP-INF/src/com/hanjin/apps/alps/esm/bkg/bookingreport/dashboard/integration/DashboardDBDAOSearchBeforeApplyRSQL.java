/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DashboardDBDAOSearchBeforeApplyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DashboardDBDAOSearchBeforeApplyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 어플라이를 하기전 해당 레포트가 저장되어있는 레포트인지 확인한다
	  * </pre>
	  */
	public DashboardDBDAOSearchBeforeApplyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpt_fom_nm",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.integration").append("\n"); 
		query.append("FileName : DashboardDBDAOSearchBeforeApplyRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    RPT_FOM_NO" ).append("\n"); 
		query.append("    ,   DP_NM RPT_FOM_NM" ).append("\n"); 
		query.append("    ,   DBD_IRR_TP_CD RPT_FOM_DESC" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("    BKG_DBD_RPT_FOM_DTL D" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("    CRE_USR_ID =@[usr_id] " ).append("\n"); 
		query.append("AND" ).append("\n"); 
		query.append("    RPT_FOM_NO =(SELECT RPT_FOM_NO FROM BKG_DBD_RPT_FOM F WHERE RPT_FOM_NM=@[rpt_fom_nm] AND F.CRE_USR_ID = D.CRE_USR_ID)" ).append("\n"); 

	}
}
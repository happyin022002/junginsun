/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CustGroupDBDAOSearchCustPerfInterfaceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2018.03.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custgroup.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustGroupDBDAOSearchCustPerfInterfaceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Group customer interface
	  * </pre>
	  */
	public CustGroupDBDAOSearchCustPerfInterfaceRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.bcm.cms.custmanage.custgroup.integration ").append("\n"); 
		query.append("FileName : CustGroupDBDAOSearchCustPerfInterfaceRSQL").append("\n"); 
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
		query.append("select MCPG.CUST_GRP_ID Cust_Grp_Cd        " ).append("\n"); 
		query.append("      ,Cust_Grp_Nm        " ).append("\n"); 
		query.append("      ,Ofc_Cd            " ).append("\n"); 
		query.append("      ,Ofc_Cd Mst_Ofc_Id         " ).append("\n"); 
		query.append("      ,Srep_Cd           " ).append("\n"); 
		query.append("      ,MCPG.VBS_CLSS_CD Val_Bse_Segm_Clss_Cd " ).append("\n"); 
		query.append("      ,MCPG.NBS_CLSS_CD1 Nds_Bse_Segm_Clss_Cd1" ).append("\n"); 
		query.append("      ,MCPG.NBS_CLSS_CD2 Nds_Bse_Segm_Clss_Cd2" ).append("\n"); 
		query.append("      ,MCPG.NBS_CLSS_CD3 Nds_Bse_Segm_Clss_Cd3" ).append("\n"); 
		query.append("      ,Cre_Usr_Id         " ).append("\n"); 
		query.append("      ,Cre_Dt            " ).append("\n"); 
		query.append("      ,Upd_Usr_Id         " ).append("\n"); 
		query.append("      ,Upd_Dt            " ).append("\n"); 
		query.append("      ,Delt_Flg          " ).append("\n"); 
		query.append("      ,New_Key_Acct_Flg    " ).append("\n"); 
		query.append("      ,Rgn_Acct_Flg       " ).append("\n"); 
		query.append("      ,Rhq_Cd            " ).append("\n"); 
		query.append("      ,Ofc_Team_Cd" ).append("\n"); 
		query.append("FROM MDM_CUST_PERF_GRP MCPG" ).append("\n"); 
		query.append("WHERE CUST_GRP_ID = @[cust_grp_id]" ).append("\n"); 

	}
}
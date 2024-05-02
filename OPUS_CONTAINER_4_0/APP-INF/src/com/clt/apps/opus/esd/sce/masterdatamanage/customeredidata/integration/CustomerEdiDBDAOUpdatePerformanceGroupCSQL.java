/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CustomerEdiDBDAOUpdatePerformanceGroupCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.05
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2015.03.05 박광석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author PARK KWANG SEOK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CustomerEdiDBDAOUpdatePerformanceGroupCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdatePerformanceGroup
	  * </pre>
	  */
	public CustomerEdiDBDAOUpdatePerformanceGroupCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_grp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_grp_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_cgo_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tp_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.integration").append("\n"); 
		query.append("FileName : CustomerEdiDBDAOUpdatePerformanceGroupCSQL").append("\n"); 
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
		query.append("insert into edi_usr_cust" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    CRE_USR_ID" ).append("\n"); 
		query.append(",   EDI_GRP_CD" ).append("\n"); 
		query.append(",   EDI_STS_SEQ" ).append("\n"); 
		query.append(",   CUST_TRD_PRNR_ID" ).append("\n"); 
		query.append(",   EDI_GRP_DESC" ).append("\n"); 
		query.append(",   EDI_CGO_RMK" ).append("\n"); 
		query.append(",   CRE_DT" ).append("\n"); 
		query.append(",   UPD_USR_ID" ).append("\n"); 
		query.append(",   UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("values(@[user_id]," ).append("\n"); 
		query.append("	@[edi_grp_id]," ).append("\n"); 
		query.append("	2," ).append("\n"); 
		query.append("	@[tp_id]," ).append("\n"); 
		query.append("	@[edi_grp_desc]," ).append("\n"); 
		query.append("	@[edi_cgo_rmk]," ).append("\n"); 
		query.append("	sysdate," ).append("\n"); 
		query.append("	@[user_id]," ).append("\n"); 
		query.append("	sysdate)" ).append("\n"); 

	}
}
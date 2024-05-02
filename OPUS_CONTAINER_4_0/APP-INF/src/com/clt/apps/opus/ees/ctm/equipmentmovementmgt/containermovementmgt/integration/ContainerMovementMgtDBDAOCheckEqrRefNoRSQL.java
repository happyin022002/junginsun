/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOCheckEqrRefNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.13
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOCheckEqrRefNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckEqrRefNo
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOCheckEqrRefNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_pln_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mty_repo_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOCheckEqrRefNoRSQL").append("\n"); 
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
		query.append("SELECT 1 AS EXIST" ).append("\n"); 
		query.append("FROM (SELECT REF_ID" ).append("\n"); 
		query.append("    FROM EQR_VSL_LODG_DCHG_EXE_PLN" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT REF_ID" ).append("\n"); 
		query.append("    FROM EQR_INLND_TRSP_EXE_PLN" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT REF_ID" ).append("\n"); 
		query.append("    FROM EQR_ECC_INTER_EXE_PLN" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT REF_ID" ).append("\n"); 
		query.append("    FROM EQR_ONF_HIR_EXE_PLN)" ).append("\n"); 
		query.append("WHERE REF_ID = NVL(@[mty_pln_no], @[mty_repo_no])" ).append("\n"); 

	}
}
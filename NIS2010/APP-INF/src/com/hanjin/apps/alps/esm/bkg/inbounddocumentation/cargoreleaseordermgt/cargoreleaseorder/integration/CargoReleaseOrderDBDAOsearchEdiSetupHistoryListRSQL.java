/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchEdiSetupHistoryListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOsearchEdiSetupHistoryListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI Setup History
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchEdiSetupHistoryListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchEdiSetupHistoryListRSQL").append("\n"); 
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
		query.append("SELECT YD_CD,PORT_CD,EDI_RCV_ID,EDI_SND_ID,SLAN_CD1,SLAN_CD2,SLAN_CD3,SLAN_CD4,SLAN_CD5,SLAN_CD6,SLAN_CD7,SLAN_CD8,SLAN_CD9,SLAN_CD10,CRE_USR_ID,UPD_USR_ID" ).append("\n"); 
		query.append("    ,CASE FULL_RLSE_EDI_CD WHEN '1' THEN 'FO' WHEN '2' THEN 'FOC'  END FULL_RLSE_EDI_CD" ).append("\n"); 
		query.append("	,TO_CHAR(CRE_DT,'YYYY-MM-DD HH24:MI') CRE_DT" ).append("\n"); 
		query.append("	,TO_CHAR(UPD_DT,'YYYY-MM-DD HH24:MI') UPD_DT " ).append("\n"); 
		query.append("FROM BKG_EDI_YD_HIS" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND YD_CD LIKE @[yd_cd]||'%'" ).append("\n"); 
		query.append("ORDER BY UPD_DT DESC" ).append("\n"); 

	}
}
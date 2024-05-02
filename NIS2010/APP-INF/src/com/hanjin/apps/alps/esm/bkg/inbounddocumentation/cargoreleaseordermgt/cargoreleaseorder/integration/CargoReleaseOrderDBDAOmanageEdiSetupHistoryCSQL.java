/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOmanageEdiSetupHistoryCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.24 
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

public class CargoReleaseOrderDBDAOmanageEdiSetupHistoryCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI Setup History 저장
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOmanageEdiSetupHistoryCSQL(){
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
		query.append("FileName : CargoReleaseOrderDBDAOmanageEdiSetupHistoryCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_EDI_YD_HIS (" ).append("\n"); 
		query.append("	YD_CD" ).append("\n"); 
		query.append("	,EDI_YD_HIS_SEQ" ).append("\n"); 
		query.append("	,PORT_CD" ).append("\n"); 
		query.append("	,EDI_RCV_ID" ).append("\n"); 
		query.append("	,SLAN_CD1" ).append("\n"); 
		query.append("	,SLAN_CD2" ).append("\n"); 
		query.append("	,SLAN_CD3" ).append("\n"); 
		query.append("	,SLAN_CD4" ).append("\n"); 
		query.append("	,SLAN_CD5" ).append("\n"); 
		query.append("	,SLAN_CD6" ).append("\n"); 
		query.append("	,SLAN_CD7" ).append("\n"); 
		query.append("	,SLAN_CD8" ).append("\n"); 
		query.append("	,SLAN_CD9 " ).append("\n"); 
		query.append("	,SLAN_CD10" ).append("\n"); 
		query.append("	,EDI_SND_ID" ).append("\n"); 
		query.append("	,FULL_RLSE_EDI_CD" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT )" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	YD_CD" ).append("\n"); 
		query.append("    ,LTRIM(TO_CHAR(BKG_EDI_YD_HIS_SEQ.NEXTVAL,'009'))  " ).append("\n"); 
		query.append("	,PORT_CD" ).append("\n"); 
		query.append("	,EDI_RCV_ID" ).append("\n"); 
		query.append("	,SLAN_CD1" ).append("\n"); 
		query.append("	,SLAN_CD2" ).append("\n"); 
		query.append("	,SLAN_CD3" ).append("\n"); 
		query.append("	,SLAN_CD4" ).append("\n"); 
		query.append("	,SLAN_CD5" ).append("\n"); 
		query.append("	,SLAN_CD6" ).append("\n"); 
		query.append("	,SLAN_CD7" ).append("\n"); 
		query.append("	,SLAN_CD8" ).append("\n"); 
		query.append("	,SLAN_CD9" ).append("\n"); 
		query.append("	,SLAN_CD10" ).append("\n"); 
		query.append("	,EDI_SND_ID" ).append("\n"); 
		query.append("	,FULL_RLSE_EDI_CD" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT " ).append("\n"); 
		query.append("FROM BKG_EDI_YD" ).append("\n"); 
		query.append("WHERE YD_CD = @[yd_cd]" ).append("\n"); 

	}
}
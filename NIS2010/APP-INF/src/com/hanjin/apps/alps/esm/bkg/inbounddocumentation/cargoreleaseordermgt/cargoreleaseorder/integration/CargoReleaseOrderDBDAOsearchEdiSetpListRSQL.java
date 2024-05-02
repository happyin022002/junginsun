/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchEdiSetpListRSQL.java
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

public class CargoReleaseOrderDBDAOsearchEdiSetpListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI Setup 조회
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchEdiSetpListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcv_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_rlse_edi_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchEdiSetpListRSQL").append("\n"); 
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
		query.append("	YD_CD" ).append("\n"); 
		query.append("    ,PORT_CD" ).append("\n"); 
		query.append("	,SUBSTR(YD_CD,6,2) POD_YD_NO" ).append("\n"); 
		query.append("	,SUBSTR(YD_CD,0,5) POD_CD " ).append("\n"); 
		query.append("	,PORT_CD POD_CD_CPY" ).append("\n"); 
		query.append("	,EDI_RCV_ID" ).append("\n"); 
		query.append("	,EDI_SND_ID" ).append("\n"); 
		query.append("	,CASE WHEN FULL_RLSE_EDI_CD IN (1,2) THEN FULL_RLSE_EDI_CD ELSE '' END FULL_RLSE_EDI_CD" ).append("\n"); 
		query.append("	,(SELECT YD_NM FROM MDM_YARD WHERE YD_CD = A.YD_CD ) YD_DESC" ).append("\n"); 
		query.append("	,( SELECT LOC_NM FROM MDM_LOCATION WHERE LOC_CD = A.PORT_CD ) POD_DESC" ).append("\n"); 
		query.append("	,NVL(SLAN_CD1,'') SLAN_CD1" ).append("\n"); 
		query.append("	,NVL(SLAN_CD2,'') SLAN_CD2" ).append("\n"); 
		query.append("	,NVL(SLAN_CD3,'') SLAN_CD3" ).append("\n"); 
		query.append("	,NVL(SLAN_CD4,'') SLAN_CD4" ).append("\n"); 
		query.append("	,NVL(SLAN_CD5,'') SLAN_CD5" ).append("\n"); 
		query.append("	,NVL(SLAN_CD6,'') SLAN_CD6" ).append("\n"); 
		query.append("	,NVL(SLAN_CD7,'') SLAN_CD7" ).append("\n"); 
		query.append("	,NVL(SLAN_CD8,'') SLAN_CD8" ).append("\n"); 
		query.append("	,NVL(SLAN_CD9,'') SLAN_CD9" ).append("\n"); 
		query.append("	,NVL(SLAN_CD10,'') SLAN_CD10" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,TO_CHAR(CRE_DT,'YYYY-MM-DD HH24:MI') CRE_DT" ).append("\n"); 
		query.append("	,TO_CHAR(UPD_DT,'YYYY-MM-DD HH24:MI') UPD_DT" ).append("\n"); 
		query.append("FROM BKG_EDI_YD A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${yd_cd} != '') " ).append("\n"); 
		query.append("AND YD_CD LIKE @[yd_cd]||'%'" ).append("\n"); 
		query.append("#end     " ).append("\n"); 
		query.append("#if (${port_cd} != '') " ).append("\n"); 
		query.append("AND PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${edi_rcv_id} != '') " ).append("\n"); 
		query.append("AND EDI_RCV_ID = @[edi_rcv_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${edi_snd_id} != '') " ).append("\n"); 
		query.append("AND EDI_SND_ID = @[edi_snd_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${full_rlse_edi_cd} != '') " ).append("\n"); 
		query.append("	#if (${full_rlse_edi_cd} == '1' || ${full_rlse_edi_cd} == '2') " ).append("\n"); 
		query.append("		AND FULL_RLSE_EDI_CD = @[full_rlse_edi_cd]" ).append("\n"); 
		query.append("    #elseif (${full_rlse_edi_cd} == '0') " ).append("\n"); 
		query.append("		AND FULL_RLSE_EDI_CD NOT IN (1,2)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY YD_CD" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOmanageEdiSetupCSQL.java
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

public class CargoReleaseOrderDBDAOmanageEdiSetupCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI Setup 수정
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOmanageEdiSetupCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("slan_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd6",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_rlse_edi_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd5",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("slan_cd10",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOmanageEdiSetupCSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_EDI_YD A " ).append("\n"); 
		query.append("USING ( SELECT  @[pod_cd]||@[pod_yd_no] AS YD_CD" ).append("\n"); 
		query.append("               ,@[pod_cd] AS PORT_CD" ).append("\n"); 
		query.append("               ,@[edi_rcv_id] AS EDI_RCV_ID" ).append("\n"); 
		query.append("               ,@[edi_snd_id] AS EDI_SND_ID" ).append("\n"); 
		query.append("               ,@[full_rlse_edi_cd] AS FULL_RLSE_EDI_CD" ).append("\n"); 
		query.append("               ,@[cre_usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append("               ,@[slan_cd1] AS SLAN_CD1" ).append("\n"); 
		query.append("               ,@[slan_cd2] AS SLAN_CD2" ).append("\n"); 
		query.append("               ,@[slan_cd3] AS SLAN_CD3" ).append("\n"); 
		query.append("               ,@[slan_cd4] AS SLAN_CD4" ).append("\n"); 
		query.append("               ,@[slan_cd5] AS SLAN_CD5" ).append("\n"); 
		query.append("               ,@[slan_cd6] AS SLAN_CD6" ).append("\n"); 
		query.append("               ,@[slan_cd7] AS SLAN_CD7" ).append("\n"); 
		query.append("               ,@[slan_cd8] AS SLAN_CD8" ).append("\n"); 
		query.append("               ,@[slan_cd9] AS SLAN_CD9" ).append("\n"); 
		query.append("               ,@[slan_cd10] AS SLAN_CD10" ).append("\n"); 
		query.append("       FROM DUAL" ).append("\n"); 
		query.append("      ) B" ).append("\n"); 
		query.append("ON (A.YD_CD = B.YD_CD)  " ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE  SET   PORT_CD		    = B.PORT_CD" ).append("\n"); 
		query.append("             ,EDI_RCV_ID 	    = B.EDI_RCV_ID" ).append("\n"); 
		query.append("             ,EDI_SND_ID 		= B.EDI_SND_ID" ).append("\n"); 
		query.append("             ,FULL_RLSE_EDI_CD 	= B.FULL_RLSE_EDI_CD" ).append("\n"); 
		query.append("             ,UPD_USR_ID 	    = B.CRE_USR_ID           " ).append("\n"); 
		query.append("             ,UPD_DT 	        = SYSDATE                        " ).append("\n"); 
		query.append("             ,SLAN_CD1 	        = B.SLAN_CD1" ).append("\n"); 
		query.append("             ,SLAN_CD2 	        = B.SLAN_CD2" ).append("\n"); 
		query.append("             ,SLAN_CD3 	        = B.SLAN_CD3" ).append("\n"); 
		query.append("             ,SLAN_CD4 	        = B.SLAN_CD4" ).append("\n"); 
		query.append("             ,SLAN_CD5 	        = B.SLAN_CD5" ).append("\n"); 
		query.append("             ,SLAN_CD6 	        = B.SLAN_CD6" ).append("\n"); 
		query.append("             ,SLAN_CD7 	        = B.SLAN_CD7" ).append("\n"); 
		query.append("             ,SLAN_CD8 	        = B.SLAN_CD8" ).append("\n"); 
		query.append("             ,SLAN_CD9 	        = B.SLAN_CD9" ).append("\n"); 
		query.append("             ,SLAN_CD10	        = B.SLAN_CD10" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT (YD_CD,PORT_CD,EDI_RCV_ID,EDI_SND_ID,FULL_RLSE_EDI_CD,SLAN_CD1,SLAN_CD2,SLAN_CD3,SLAN_CD4,SLAN_CD5,SLAN_CD6,SLAN_CD7,SLAN_CD8,SLAN_CD9,SLAN_CD10,CRE_USR_ID,CRE_DT,UPD_USR_ID,UPD_DT)" ).append("\n"); 
		query.append("VALUES ( B.YD_CD" ).append("\n"); 
		query.append("        ,B.PORT_CD" ).append("\n"); 
		query.append("        ,B.EDI_RCV_ID" ).append("\n"); 
		query.append("        ,B.EDI_SND_ID" ).append("\n"); 
		query.append("        ,B.FULL_RLSE_EDI_CD" ).append("\n"); 
		query.append("        ,B.SLAN_CD1 " ).append("\n"); 
		query.append("        ,B.SLAN_CD2 " ).append("\n"); 
		query.append("        ,B.SLAN_CD3 " ).append("\n"); 
		query.append("        ,B.SLAN_CD4 " ).append("\n"); 
		query.append("        ,B.SLAN_CD5 " ).append("\n"); 
		query.append("        ,B.SLAN_CD6 " ).append("\n"); 
		query.append("        ,B.SLAN_CD7 " ).append("\n"); 
		query.append("        ,B.SLAN_CD8 " ).append("\n"); 
		query.append("        ,B.SLAN_CD9 " ).append("\n"); 
		query.append("        ,B.SLAN_CD10" ).append("\n"); 
		query.append("        ,B.CRE_USR_ID        " ).append("\n"); 
		query.append("        ,SYSDATE            " ).append("\n"); 
		query.append("        ,B.CRE_USR_ID        " ).append("\n"); 
		query.append("        ,SYSDATE " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
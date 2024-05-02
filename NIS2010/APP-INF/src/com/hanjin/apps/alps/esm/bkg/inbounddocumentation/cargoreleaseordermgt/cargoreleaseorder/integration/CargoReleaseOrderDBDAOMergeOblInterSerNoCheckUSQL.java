/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOMergeOblInterSerNoCheckUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.16 
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

public class CargoReleaseOrderDBDAOMergeOblInterSerNoCheckUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WEB B/L Printed : Serial Number 관련하여 체크한 사용자 등록
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOMergeOblInterSerNoCheckUSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOMergeOblInterSerNoCheckUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_DO_REF REF " ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("    SELECT @[bkg_no] AS BKG_NO" ).append("\n"); 
		query.append("			,@[usr_id] AS UPD_USR_ID     " ).append("\n"); 
		query.append("			,@[usr_id] AS CRE_USR_ID     " ).append("\n"); 
		query.append("			,@[usr_id] AS OBL_INTER_SER_NO_CHK_USR_ID" ).append("\n"); 
		query.append("    FROM DUAL" ).append("\n"); 
		query.append(") T " ).append("\n"); 
		query.append("ON (REF.BKG_NO = T.BKG_NO)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE " ).append("\n"); 
		query.append("    SET  OBL_INTER_SER_NO_CHK_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("        ,OBL_INTER_SER_NO_CHK_DT = SYSDATE" ).append("\n"); 
		query.append("    WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN " ).append("\n"); 
		query.append("    INSERT (" ).append("\n"); 
		query.append("     BKG_NO" ).append("\n"); 
		query.append("    ,CRE_USR_ID" ).append("\n"); 
		query.append("    ,CRE_DT" ).append("\n"); 
		query.append("    ,UPD_USR_ID" ).append("\n"); 
		query.append("    ,UPD_DT" ).append("\n"); 
		query.append("    ,OBL_INTER_SER_NO_CHK_USR_ID" ).append("\n"); 
		query.append("    ,OBL_INTER_SER_NO_CHK_DT" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("    VALUES( " ).append("\n"); 
		query.append("     T.BKG_NO                 " ).append("\n"); 
		query.append("    ,T.CRE_USR_ID" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append("    ,T.UPD_USR_ID" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append("    ,T.OBL_INTER_SER_NO_CHK_USR_ID" ).append("\n"); 
		query.append("    ,SYSDATE" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}
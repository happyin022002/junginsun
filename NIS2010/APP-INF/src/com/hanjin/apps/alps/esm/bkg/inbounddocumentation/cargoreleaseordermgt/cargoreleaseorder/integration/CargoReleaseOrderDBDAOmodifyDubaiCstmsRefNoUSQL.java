/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOmodifyDubaiCstmsRefNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.10 
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

public class CargoReleaseOrderDBDAOmodifyDubaiCstmsRefNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 두바이
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOmodifyDubaiCstmsRefNoUSQL(){
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_ref_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOmodifyDubaiCstmsRefNoUSQL").append("\n"); 
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
		query.append("MERGE INTO BKG_DO_REF A" ).append("\n"); 
		query.append("USING (SELECT  (SELECT BKG_NO FROM BKG_BOOKING WHERE bl_no=@[bl_no] )  AS BKG_NO                " ).append("\n"); 
		query.append("              ,'CSTMS REF NO'            AS CSTMS_REF_NM          " ).append("\n"); 
		query.append("              ,@[cstms_ref_ctnt]         AS CSTMS_REF_CTNT       " ).append("\n"); 
		query.append("              ,'N'                       AS DO_HLD_FLG" ).append("\n"); 
		query.append("              ,'N'                       AS DO_SPLIT_FLG" ).append("\n"); 
		query.append("              ,'N'                       AS INFO_CGO_FLG" ).append("\n"); 
		query.append("              ,@[usr_id]                 AS CRE_USR_ID " ).append("\n"); 
		query.append("              ,SYSDATE                   AS CRE_DT           " ).append("\n"); 
		query.append("              ,@[usr_id]                 AS UPD_USR_ID " ).append("\n"); 
		query.append("     ,SYSDATE                   AS UPD_DT            " ).append("\n"); 
		query.append("       FROM DUAL" ).append("\n"); 
		query.append("      ) B" ).append("\n"); 
		query.append("ON (A.BKG_NO = B.BKG_NO )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE " ).append("\n"); 
		query.append("    SET CSTMS_REF_NM    = B.CSTMS_REF_NM  " ).append("\n"); 
		query.append("      , CSTMS_REF_CTNT  = B.CSTMS_REF_CTNT" ).append("\n"); 
		query.append("      , DO_HLD_FLG      = B.DO_HLD_FLG" ).append("\n"); 
		query.append("      , DO_SPLIT_FLG    = B.DO_SPLIT_FLG" ).append("\n"); 
		query.append("      , INFO_CGO_FLG    = B.INFO_CGO_FLG" ).append("\n"); 
		query.append("      , UPD_USR_ID      = B.UPD_USR_ID" ).append("\n"); 
		query.append("      , UPD_DT          = B.UPD_DT    " ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (bkg_no" ).append("\n"); 
		query.append("    ,cstms_ref_nm" ).append("\n"); 
		query.append("    ,cstms_ref_ctnt" ).append("\n"); 
		query.append("    ,do_hld_flg" ).append("\n"); 
		query.append("    ,do_split_flg" ).append("\n"); 
		query.append("    ,info_cgo_flg" ).append("\n"); 
		query.append("    ,cre_usr_id" ).append("\n"); 
		query.append("    ,cre_dt" ).append("\n"); 
		query.append("    ,upd_usr_id" ).append("\n"); 
		query.append("    ,upd_dt)" ).append("\n"); 
		query.append("    VALUES( B.BKG_NO                  " ).append("\n"); 
		query.append("                 , B.CSTMS_REF_NM            " ).append("\n"); 
		query.append("                 , B.CSTMS_REF_CTNT         " ).append("\n"); 
		query.append("                 , B.DO_HLD_FLG" ).append("\n"); 
		query.append("                 , B.DO_SPLIT_FLG" ).append("\n"); 
		query.append("                 , B.INFO_CGO_FLG" ).append("\n"); 
		query.append("                 , B.CRE_USR_ID              " ).append("\n"); 
		query.append("                 , B.CRE_DT               " ).append("\n"); 
		query.append("                 , B.UPD_USR_ID" ).append("\n"); 
		query.append("                 , B.UPD_DT" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}
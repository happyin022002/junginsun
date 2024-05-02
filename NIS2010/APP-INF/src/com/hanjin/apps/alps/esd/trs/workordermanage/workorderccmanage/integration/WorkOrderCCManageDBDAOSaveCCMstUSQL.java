/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : WorkOrderCCManageDBDAOSaveCCMstUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.09
*@LastModifier : 조풍연
*@LastVersion : 1.0
* 2010.04.09 조풍연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderccmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author POONG-YEON CHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WorkOrderCCManageDBDAOSaveCCMstUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * WorkOrderCC 정보를 저장한다.
	  * </pre>
	  */
	public WorkOrderCCManageDBDAOSaveCCMstUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wo_cc_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.workordermanage.workorderccmanage.integration").append("\n"); 
		query.append("FileName : WorkOrderCCManageDBDAOSaveCCMstUSQL").append("\n"); 
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
		query.append("MERGE" ).append("\n"); 
		query.append("INTO TRS_TRSP_WRK_ORD_CC X" ).append("\n"); 
		query.append("USING DUAL ON (" ).append("\n"); 
		query.append("X.VNDR_SEQ = @[vndr_seq]            -- /* VNDR_SEQ */" ).append("\n"); 
		query.append("--                AND X.HJL_NO IS NULL                -- /* 2008.04.29 ETS OPEN */" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("WO_CC_OFC_CD," ).append("\n"); 
		query.append("VNDR_LOC_CD," ).append("\n"); 
		query.append("CRE_OFC_CD," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[vndr_seq],                                -- /* VNDR_SEQ      */" ).append("\n"); 
		query.append("@[wo_cc_ofc_cd],                            -- /* WO_CC_OFC_CD  */" ).append("\n"); 
		query.append("@[vndr_loc_cd],                             -- /* VNDR_LOC_CD   */" ).append("\n"); 
		query.append("@[cre_ofc_cd],                              -- /* CRE_OFC_CD    */" ).append("\n"); 
		query.append("@[cre_usr_id],                              -- /* CRE_USR_ID    */" ).append("\n"); 
		query.append("SYSDATE,  									-- /* CRE_DT        */" ).append("\n"); 
		query.append("@[upd_usr_id],                              -- /* UPD_USR_ID    */" ).append("\n"); 
		query.append("SYSDATE   									-- /* UPD_DT        */" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("X.WO_CC_OFC_CD  = @[wo_cc_ofc_cd]," ).append("\n"); 
		query.append("X.VNDR_LOC_CD   = @[vndr_loc_cd]," ).append("\n"); 
		query.append("X.UPD_USR_ID    = @[upd_usr_id]," ).append("\n"); 
		query.append("X.UPD_DT    	= SYSDATE" ).append("\n"); 

	}
}
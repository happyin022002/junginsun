/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VesselScheduleMasterDataDBDAOModifyVskCanalVendorUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.06
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.06 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class VesselScheduleMasterDataDBDAOModifyVskCanalVendorUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyVskCanalVendor
	  * </pre>
	  */
	public VesselScheduleMasterDataDBDAOModifyVskCanalVendorUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnl_agn_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.integration ").append("\n"); 
		query.append("FileName : VesselScheduleMasterDataDBDAOModifyVskCanalVendorUSQL").append("\n"); 
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
		query.append("MERGE INTO   VSK_CNL_VNDR T" ).append("\n"); 
		query.append("USING        (" ).append("\n"); 
		query.append("             SELECT     @[vsl_slan_cd]      AS VSL_SLAN_CD" ).append("\n"); 
		query.append("                      , @[cnl_agn_vndr_seq] AS CNL_AGN_VNDR_SEQ   " ).append("\n"); 
		query.append("                      , @[cre_usr_id]       AS CRE_USR_ID    " ).append("\n"); 
		query.append("                      , SYSDATE             AS CRE_DT        " ).append("\n"); 
		query.append("                      , @[upd_usr_id]       AS UPD_USR_ID    " ).append("\n"); 
		query.append("                      , SYSDATE             AS UPD_DT                   " ).append("\n"); 
		query.append("                FROM    DUAL " ).append("\n"); 
		query.append("              ) X          " ).append("\n"); 
		query.append("ON            (" ).append("\n"); 
		query.append("              T.VSL_SLAN_CD = X.VSL_SLAN_CD" ).append("\n"); 
		query.append("     AND      T.CNL_AGN_VNDR_SEQ = X.CNL_AGN_VNDR_SEQ         " ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("WHEN MATCHED THEN      " ).append("\n"); 
		query.append("              UPDATE SET " ).append("\n"); 
		query.append("                           T.UPD_USR_ID     = X.UPD_USR_ID" ).append("\n"); 
		query.append("                         , T.UPD_DT         = X.UPD_DT" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("              INSERT   (" ).append("\n"); 
		query.append("                          T.VSL_SLAN_CD   " ).append("\n"); 
		query.append("                        , T.CNL_AGN_VNDR_SEQ     " ).append("\n"); 
		query.append("                        , T.CRE_USR_ID      " ).append("\n"); 
		query.append("                        , T.CRE_DT          " ).append("\n"); 
		query.append("                        , T.UPD_USR_ID      " ).append("\n"); 
		query.append("                        , T.UPD_DT" ).append("\n"); 
		query.append("                       )            " ).append("\n"); 
		query.append("              VALUES   (  X.VSL_SLAN_CD           " ).append("\n"); 
		query.append("                        , X.CNL_AGN_VNDR_SEQ   " ).append("\n"); 
		query.append("                        , X.CRE_USR_ID        " ).append("\n"); 
		query.append("                        , X.CRE_DT           " ).append("\n"); 
		query.append("                        , X.UPD_USR_ID     " ).append("\n"); 
		query.append("                        , X.UPD_DT           " ).append("\n"); 
		query.append("                        )" ).append("\n"); 

	}
}
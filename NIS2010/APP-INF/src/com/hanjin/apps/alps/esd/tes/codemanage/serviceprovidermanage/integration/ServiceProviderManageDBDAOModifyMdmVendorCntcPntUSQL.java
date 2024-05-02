/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ServiceProviderManageDBDAOModifyMdmVendorCntcPntUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.10.30
*@LastModifier : 
*@LastVersion : 1.0
* 2017.10.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.codemanage.serviceprovidermanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ServiceProviderManageDBDAOModifyMdmVendorCntcPntUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyMdmVendorCntcPnt
	  * </pre>
	  */
	public ServiceProviderManageDBDAOModifyMdmVendorCntcPntUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ida_vndr_eml",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.codemanage.serviceprovidermanage.integration").append("\n"); 
		query.append("FileName : ServiceProviderManageDBDAOModifyMdmVendorCntcPntUSQL").append("\n"); 
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
		query.append("MERGE INTO MDM_VNDR_CNTC_PNT MVA" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("        SELECT COUNT(VNDR_SEQ) CNT" ).append("\n"); 
		query.append("        FROM MDM_VNDR_CNTC_PNT" ).append("\n"); 
		query.append("        WHERE VNDR_SEQ = @[ida_vndr_seq]" ).append("\n"); 
		query.append("        AND CNTC_DIV_CD = 'IDA'" ).append("\n"); 
		query.append("       ) MVB" ).append("\n"); 
		query.append("ON ( MVB.CNT > 0 )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE SET MVA.VNDR_EML = @[ida_vndr_eml], MVA.UPD_USR_ID = @[upd_usr_id], MVA.UPD_DT = SYSDATE" ).append("\n"); 
		query.append("    WHERE VNDR_SEQ = @[ida_vndr_seq]" ).append("\n"); 
		query.append("    AND CNTC_DIV_CD = 'IDA'" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (" ).append("\n"); 
		query.append("			VNDR_SEQ, " ).append("\n"); 
		query.append("			VNDR_CNTC_PNT_SEQ, " ).append("\n"); 
		query.append("			VNDR_EML, " ).append("\n"); 
		query.append("			DELT_FLG, " ).append("\n"); 
		query.append("			CRE_USR_ID, " ).append("\n"); 
		query.append("			CRE_DT, " ).append("\n"); 
		query.append("			UPD_USR_ID, " ).append("\n"); 
		query.append("			UPD_DT, " ).append("\n"); 
		query.append("			CNTC_DIV_CD" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("    VALUES (" ).append("\n"); 
		query.append("			@[ida_vndr_seq], " ).append("\n"); 
		query.append("			( SELECT NVL(MAX(VNDR_CNTC_PNT_SEQ)+1,1) FROM MDM_VNDR_CNTC_PNT WHERE VNDR_SEQ = @[ida_vndr_seq] )," ).append("\n"); 
		query.append("            @[ida_vndr_eml]," ).append("\n"); 
		query.append("			'N'," ).append("\n"); 
		query.append("			@[upd_usr_id]," ).append("\n"); 
		query.append("			SYSDATE," ).append("\n"); 
		query.append("			@[upd_usr_id]," ).append("\n"); 
		query.append("			SYSDATE," ).append("\n"); 
		query.append("			'IDA'" ).append("\n"); 
		query.append("			)" ).append("\n"); 

	}
}
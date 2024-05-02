/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : USA404EDIStatusInquiryDBDAOUpdateTrsTrspRailBilVndrSetAplUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.31
*@LastModifier : 김성욱
*@LastVersion : 1.0
* 2015.08.31 김성욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Sung-Wook Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USA404EDIStatusInquiryDBDAOUpdateTrsTrspRailBilVndrSetAplUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * USA RAIL BILLING Vendor Set Applicable을 수정
	  * </pre>
	  */
	public USA404EDIStatusInquiryDBDAOUpdateTrsTrspRailBilVndrSetAplUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_rail_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_scg_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_rail_scg_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_scg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_agmt_scg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sUsrId",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("appl_rt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.integration").append("\n"); 
		query.append("FileName : USA404EDIStatusInquiryDBDAOUpdateTrsTrspRailBilVndrSetAplUSQL").append("\n"); 
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
		query.append("MERGE INTO TRS_RAIL_BIL_VNDR_SET_APLY" ).append("\n"); 
		query.append("USING DUAL" ).append("\n"); 
		query.append("   ON ( TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd] AND" ).append("\n"); 
		query.append("        TRSP_SO_SEQ        = @[trsp_so_seq] AND" ).append("\n"); 
		query.append("        SUB_RAIL_SEQ       = @[sub_rail_seq] AND" ).append("\n"); 
		query.append("        TRSP_AGMT_SCG_SEQ  = @[trsp_agmt_scg_seq]" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("  UPDATE" ).append("\n"); 
		query.append("     SET TRSP_RAIL_SCG_CD = @[trsp_rail_scg_cd]," ).append("\n"); 
		query.append("         SCG_APLY_AMT     = @[appl_rt]," ).append("\n"); 
		query.append("         COM_SCG_KND_CD   = @[com_scg_knd_cd]," ).append("\n"); 
		query.append("         COM_SCG_SEQ      = @[com_scg_seq]," ).append("\n"); 
		query.append("         CRE_DT           = SYSDATE," ).append("\n"); 
		query.append("         UPD_USR_ID       = @[sUsrId]," ).append("\n"); 
		query.append("         UPD_DT           = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("  INSERT (" ).append("\n"); 
		query.append("            TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("            TRSP_SO_SEQ," ).append("\n"); 
		query.append("            SUB_RAIL_SEQ," ).append("\n"); 
		query.append("            TRSP_AGMT_SCG_SEQ," ).append("\n"); 
		query.append("            TRSP_RAIL_SCG_CD," ).append("\n"); 
		query.append("            COM_SCG_KND_CD," ).append("\n"); 
		query.append("            COM_SCG_SEQ," ).append("\n"); 
		query.append("            SCG_APLY_AMT," ).append("\n"); 
		query.append("            CRE_USR_ID," ).append("\n"); 
		query.append("            CRE_DT," ).append("\n"); 
		query.append("            UPD_USR_ID," ).append("\n"); 
		query.append("            UPD_DT" ).append("\n"); 
		query.append("         ) VALUES (" ).append("\n"); 
		query.append("            @[trsp_so_ofc_cty_cd]," ).append("\n"); 
		query.append("            @[trsp_so_seq]," ).append("\n"); 
		query.append("            @[sub_rail_seq]," ).append("\n"); 
		query.append("            @[trsp_agmt_scg_seq]," ).append("\n"); 
		query.append("            @[trsp_rail_scg_cd]," ).append("\n"); 
		query.append("		    @[com_scg_knd_cd]," ).append("\n"); 
		query.append("            @[com_scg_seq]," ).append("\n"); 
		query.append("            @[appl_rt]," ).append("\n"); 
		query.append("            @[sUsrId]," ).append("\n"); 
		query.append("            SYSDATE," ).append("\n"); 
		query.append("            @[sUsrId]," ).append("\n"); 
		query.append("            SYSDATE" ).append("\n"); 
		query.append("         )" ).append("\n"); 

	}
}
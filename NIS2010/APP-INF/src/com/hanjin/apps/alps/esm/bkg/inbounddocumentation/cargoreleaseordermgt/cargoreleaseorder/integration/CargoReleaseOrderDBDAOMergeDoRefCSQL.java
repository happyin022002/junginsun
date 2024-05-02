/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOMergeDoRefCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.05 
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

public class CargoReleaseOrderDBDAOMergeDoRefCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Korea D/O Release Reference 정보를 수정한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOMergeDoRefCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inter_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_asgn_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_ref_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("info_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ida_cstms_asgn_line_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("do_split_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cy_op_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ida_imp_gen_mf_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ida_cgor_ord_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("do_hld_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_asgn_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_ref_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOMergeDoRefCSQL").append("\n"); 
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
		query.append("USING (SELECT  @[bkg_no]                 AS BKG_NO                " ).append("\n"); 
		query.append("              ,@[cstms_ref_nm]           AS CSTMS_REF_NM          " ).append("\n"); 
		query.append("              ,@[cstms_ref_ctnt]         AS CSTMS_REF_CTNT        " ).append("\n"); 
		query.append("              ,@[cstms_asgn_nm]          AS CSTMS_ASGN_NM         " ).append("\n"); 
		query.append("              ,@[cstms_asgn_ctnt]        AS CSTMS_ASGN_CTNT       " ).append("\n"); 
		query.append("              ,@[ida_imp_gen_mf_no]      AS IDA_IMP_GEN_MF_NO     " ).append("\n"); 
		query.append("              ,@[ida_cgor_ord_yr]        AS IDA_CGOR_ORD_YR       " ).append("\n"); 
		query.append("              ,@[ida_cstms_asgn_line_no] AS IDA_CSTMS_ASGN_LINE_NO " ).append("\n"); 
		query.append("              ,@[inter_rmk]              AS INTER_RMK             " ).append("\n"); 
		query.append("              ,@[do_hld_flg]             AS DO_HLD_FLG            " ).append("\n"); 
		query.append("              ,@[do_split_flg]           AS DO_SPLIT_FLG          " ).append("\n"); 
		query.append("              ,@[cy_op_cd]               AS CY_OP_CD              " ).append("\n"); 
		query.append("              ,@[info_cgo_flg]           AS INFO_CGO_FLG   " ).append("\n"); 
		query.append("              ,@[cre_usr_id]             AS CRE_USR_ID  " ).append("\n"); 
		query.append("              ,SYSDATE                   AS CRE_DT           " ).append("\n"); 
		query.append("              ,@[upd_usr_id]             AS UPD_USR_ID " ).append("\n"); 
		query.append("			  ,SYSDATE                   AS UPD_DT     " ).append("\n"); 
		query.append("              ,NULL                      AS IDA_DO_YD_CD " ).append("\n"); 
		query.append("              ,NULL						 AS DO_VTY_DT      " ).append("\n"); 
		query.append("       FROM DUAL" ).append("\n"); 
		query.append("      ) B " ).append("\n"); 
		query.append("ON (A.BKG_NO = B.BKG_NO )" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    UPDATE " ).append("\n"); 
		query.append("    SET INTER_RMK  = B.INTER_RMK" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("      #if (${cstms_ref_nm} != '')" ).append("\n"); 
		query.append("      , CSTMS_REF_NM    = B.CSTMS_REF_NM " ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      #if (${cstms_ref_ctnt} != '')" ).append("\n"); 
		query.append("      , CSTMS_REF_CTNT  = B.CSTMS_REF_CTNT" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      #if (${cstms_asgn_nm} != '')" ).append("\n"); 
		query.append("      , CSTMS_ASGN_NM   = B.CSTMS_ASGN_NM" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      #if (${cstms_asgn_ctnt} != '')" ).append("\n"); 
		query.append("      , CSTMS_ASGN_CTNT = B.CSTMS_ASGN_CTNT" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      #if (${ida_imp_gen_mf_no} != '')" ).append("\n"); 
		query.append("      , IDA_IMP_GEN_MF_NO = B.IDA_IMP_GEN_MF_NO" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      #if (${ida_cgor_ord_yr} != '')" ).append("\n"); 
		query.append("      , IDA_CGOR_ORD_YR = B.IDA_CGOR_ORD_YR" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append("      #if (${ida_cstms_asgn_line_no} != '')" ).append("\n"); 
		query.append("      , IDA_CSTMS_ASGN_LINE_NO = B.IDA_CSTMS_ASGN_LINE_NO" ).append("\n"); 
		query.append("      #end " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      #if (${do_hld_flg} != '')" ).append("\n"); 
		query.append("      , DO_HLD_FLG = B.DO_HLD_FLG" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      #if (${do_split_flg} != '')" ).append("\n"); 
		query.append("      , DO_SPLIT_FLG = B.DO_SPLIT_FLG" ).append("\n"); 
		query.append("      #end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      #if (${cy_op_cd} != '')" ).append("\n"); 
		query.append("      , CY_OP_CD = B.CY_OP_CD" ).append("\n"); 
		query.append("      #end    " ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      #if (${info_cgo_flg} != '')" ).append("\n"); 
		query.append("      , INFO_CGO_FLG = B.INFO_CGO_FLG" ).append("\n"); 
		query.append("      #end  " ).append("\n"); 
		query.append("                                 " ).append("\n"); 
		query.append("    ,	UPD_USR_ID   = B.UPD_USR_ID" ).append("\n"); 
		query.append("    ,	UPD_DT       = B.UPD_DT    " ).append("\n"); 
		query.append("    ,   IDA_DO_YD_CD = B.IDA_DO_YD_CD  " ).append("\n"); 
		query.append("	,   DO_VTY_DT    = B.DO_VTY_DT" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    INSERT" ).append("\n"); 
		query.append("     (" ).append("\n"); 
		query.append("        BKG_NO," ).append("\n"); 
		query.append("        CSTMS_REF_NM," ).append("\n"); 
		query.append("        CSTMS_REF_CTNT," ).append("\n"); 
		query.append("        CSTMS_ASGN_NM," ).append("\n"); 
		query.append("        CSTMS_ASGN_CTNT," ).append("\n"); 
		query.append("        IDA_IMP_GEN_MF_NO," ).append("\n"); 
		query.append("        IDA_CGOR_ORD_YR," ).append("\n"); 
		query.append("        IDA_CSTMS_ASGN_LINE_NO," ).append("\n"); 
		query.append("        INTER_RMK," ).append("\n"); 
		query.append("        DO_HLD_FLG," ).append("\n"); 
		query.append("        DO_SPLIT_FLG," ).append("\n"); 
		query.append("        CY_OP_CD," ).append("\n"); 
		query.append("        INFO_CGO_FLG," ).append("\n"); 
		query.append("        CRE_USR_ID," ).append("\n"); 
		query.append("        CRE_DT," ).append("\n"); 
		query.append("        UPD_USR_ID," ).append("\n"); 
		query.append("        UPD_DT," ).append("\n"); 
		query.append("        IDA_DO_YD_CD," ).append("\n"); 
		query.append("        DO_VTY_DT" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("       VALUES( B.BKG_NO                  " ).append("\n"); 
		query.append("                 , B.CSTMS_REF_NM            " ).append("\n"); 
		query.append("                 , B.CSTMS_REF_CTNT          " ).append("\n"); 
		query.append("                 , B.CSTMS_ASGN_NM           " ).append("\n"); 
		query.append("                 , B.CSTMS_ASGN_CTNT         " ).append("\n"); 
		query.append("                 , B.IDA_IMP_GEN_MF_NO       " ).append("\n"); 
		query.append("                 , B.IDA_CGOR_ORD_YR         " ).append("\n"); 
		query.append("                 , B.IDA_CSTMS_ASGN_LINE_NO  " ).append("\n"); 
		query.append("                 , B.INTER_RMK               " ).append("\n"); 
		query.append("                 , NVL(B.DO_HLD_FLG, 'N')" ).append("\n"); 
		query.append("                 , NVL(B.DO_SPLIT_FLG, 'N')" ).append("\n"); 
		query.append("                 , B.CY_OP_CD" ).append("\n"); 
		query.append("                 , NVL(B.INFO_CGO_FLG, 'N')" ).append("\n"); 
		query.append("                 , B.CRE_USR_ID              " ).append("\n"); 
		query.append("                 , B.CRE_DT               " ).append("\n"); 
		query.append("                 , B.UPD_USR_ID" ).append("\n"); 
		query.append("                 , B.UPD_DT" ).append("\n"); 
		query.append("                 , B.IDA_DO_YD_CD" ).append("\n"); 
		query.append("                 , B.DO_VTY_DT" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}
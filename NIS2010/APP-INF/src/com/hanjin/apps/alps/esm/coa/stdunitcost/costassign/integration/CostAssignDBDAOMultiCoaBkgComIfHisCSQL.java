/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CostAssignDBDAOMultiCoaBkgComIfHisCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.05
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.costassign.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CostAssignDBDAOMultiCoaBkgComIfHisCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG History를 입력한다.
	  * </pre>
	  */
	public CostAssignDBDAOMultiCoaBkgComIfHisCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cost_src_sys_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.coa.stdunitcost.costassign.integration").append("\n"); 
		query.append("FileName : CostAssignDBDAOMultiCoaBkgComIfHisCSQL").append("\n"); 
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
		query.append("MERGE INTO COA_BKG_COM_IF_HIS C1" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("       SELECT B2.BKG_NO" ).append("\n"); 
		query.append("             ,B2.COST_SRC_SYS_CD" ).append("\n"); 
		query.append("             ,B2.IF_DT" ).append("\n"); 
		query.append("             ,B2.IF_RMK" ).append("\n"); 
		query.append("             ,B1.COST_WK" ).append("\n"); 
		query.append("             ,B1.COST_YRMON" ).append("\n"); 
		query.append("             ,B1.SLS_YRMON" ).append("\n"); 
		query.append("             ,'M_'||@[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("             ,SYSDATE CRE_DT" ).append("\n"); 
		query.append("             ,'M_'||@[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("             ,SYSDATE UPD_DT             " ).append("\n"); 
		query.append("         FROM (" ).append("\n"); 
		query.append("               SELECT A1.COST_YRMON" ).append("\n"); 
		query.append("                     ,A1.SLS_YRMON" ).append("\n"); 
		query.append("                     ,A1.COST_WK" ).append("\n"); 
		query.append("                     ,A2.BKG_NO" ).append("\n"); 
		query.append("                 FROM COA_MON_VVD A1" ).append("\n"); 
		query.append("                     ,COA_RGST_BKG A2" ).append("\n"); 
		query.append("                WHERE A1.TRD_CD        = A2.TRD_CD" ).append("\n"); 
		query.append("                  AND A1.RLANE_CD      = A2.RLANE_CD" ).append("\n"); 
		query.append("                  AND A1.IOC_CD        = A2.IOC_CD" ).append("\n"); 
		query.append("                  AND A1.VSL_CD        = A2.VSL_CD" ).append("\n"); 
		query.append("                  AND A1.SKD_VOY_NO    = A2.SKD_VOY_NO" ).append("\n"); 
		query.append("                  AND A1.DIR_CD        = A2.DIR_CD" ).append("\n"); 
		query.append("                  AND A1.DELT_FLG      = 'N'" ).append("\n"); 
		query.append("                  AND A2.BKG_STS_CD    IN ('F','S','W')" ).append("\n"); 
		query.append("                  AND A2.BKG_CGO_TP_CD <> 'P'" ).append("\n"); 
		query.append("                  AND A2.BL_NO_TP      IN ('M','0')" ).append("\n"); 
		query.append("                  AND A2.BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("              )  B1" ).append("\n"); 
		query.append("             ,(" ).append("\n"); 
		query.append("               SELECT @[bkg_no] BKG_NO" ).append("\n"); 
		query.append("                     ,@[cost_src_sys_cd] COST_SRC_SYS_CD" ).append("\n"); 
		query.append("                     ,SYSDATE IF_DT" ).append("\n"); 
		query.append("                     ,@[if_rmk] IF_RMK" ).append("\n"); 
		query.append("                FROM DUAL" ).append("\n"); 
		query.append("#if(${if_rmk} == 'COP MT Change' && ${cost_src_sys_cd} == 'SCE')" ).append("\n"); 
		query.append("               where exists (select 'X'" ).append("\n"); 
		query.append("                               from bkg_booking a, sce_cop_hdr b, sce_cop_dtl c" ).append("\n"); 
		query.append("                              where a.bkg_no = b.bkg_no" ).append("\n"); 
		query.append("                                and b.cop_no = c.cop_no" ).append("\n"); 
		query.append("                                and a.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("                                and c.act_cd in ('MOTYDO', 'MITYAD')" ).append("\n"); 
		query.append("                                and decode(c.act_cd, 'MOTYDO', a.mty_pkup_yd_cd, a.mty_rtn_yd_cd) <> c.nod_cd)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("              ) B2" ).append("\n"); 
		query.append("        WHERE B2.BKG_NO = B1.BKG_NO(+)" ).append("\n"); 
		query.append("              " ).append("\n"); 
		query.append("      ) C2" ).append("\n"); 
		query.append("ON (   C1.BKG_NO          = C2.BKG_NO " ).append("\n"); 
		query.append("   AND C1.COST_SRC_SYS_CD = C2.COST_SRC_SYS_CD" ).append("\n"); 
		query.append("   AND C1.IF_DT           = C2.IF_DT" ).append("\n"); 
		query.append("   )" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("	UPDATE " ).append("\n"); 
		query.append("	   SET C1.IF_RMK     = C2.IF_RMK" ).append("\n"); 
		query.append("	      ,C1.COST_YRMON = C2.COST_YRMON" ).append("\n"); 
		query.append("	      ,C1.SLS_YRMON  = C2.SLS_YRMON" ).append("\n"); 
		query.append("	      ,C1.COST_WK    = C2.COST_WK" ).append("\n"); 
		query.append("    	  ,C1.UPD_USR_ID = C2.UPD_USR_ID" ).append("\n"); 
		query.append("    	  ,C1.UPD_DT     = C2.UPD_DT" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("	INSERT(" ).append("\n"); 
		query.append("           C1.BKG_NO" ).append("\n"); 
		query.append("          ,C1.COST_SRC_SYS_CD" ).append("\n"); 
		query.append("          ,C1.IF_DT" ).append("\n"); 
		query.append("          ,C1.IF_RMK" ).append("\n"); 
		query.append("          ,C1.COST_YRMON" ).append("\n"); 
		query.append("          ,C1.SLS_YRMON" ).append("\n"); 
		query.append("          ,C1.COST_WK" ).append("\n"); 
		query.append("          ,C1.CRE_USR_ID" ).append("\n"); 
		query.append("          ,C1.CRE_DT" ).append("\n"); 
		query.append("          ,C1.UPD_USR_ID" ).append("\n"); 
		query.append("          ,C1.UPD_DT " ).append("\n"); 
		query.append("	) VALUES( " ).append("\n"); 
		query.append("           C2.BKG_NO" ).append("\n"); 
		query.append("          ,C2.COST_SRC_SYS_CD" ).append("\n"); 
		query.append("          ,C2.IF_DT" ).append("\n"); 
		query.append("          ,C2.IF_RMK" ).append("\n"); 
		query.append("          ,C2.COST_YRMON" ).append("\n"); 
		query.append("          ,C2.SLS_YRMON" ).append("\n"); 
		query.append("          ,C2.COST_WK" ).append("\n"); 
		query.append("          ,C2.CRE_USR_ID" ).append("\n"); 
		query.append("          ,C2.CRE_DT" ).append("\n"); 
		query.append("          ,C2.UPD_USR_ID" ).append("\n"); 
		query.append("          ,C2.UPD_DT " ).append("\n"); 
		query.append("	)" ).append("\n"); 

	}
}
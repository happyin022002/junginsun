/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CostAssignDBDAOModifyCoaCommonInterfaceCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.12.04
*@LastModifier : 
*@LastVersion : 1.0
* 2013.12.04 
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

public class CostAssignDBDAOModifyCoaCommonInterfaceCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    COA_BKG_COM_IF테이블에 데이터를 INSERT/UPDATE
	  * </pre>
	  */
	public CostAssignDBDAOModifyCoaCommonInterfaceCSQL(){
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
		query.append("FileName : CostAssignDBDAOModifyCoaCommonInterfaceCSQL").append("\n"); 
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
		query.append("MERGE INTO COA_BKG_COM_IF A1" ).append("\n"); 
		query.append("USING (" ).append("\n"); 
		query.append("       SELECT @[bkg_no] BKG_NO" ).append("\n"); 
		query.append("             ,@[cost_src_sys_cd] COST_SRC_SYS_CD" ).append("\n"); 
		query.append("             ,SYSDATE IF_DT " ).append("\n"); 
		query.append("             ,@[if_rmk]IF_RMK " ).append("\n"); 
		query.append("             ,'M_'||@[cre_usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("             ,SYSDATE CRE_DT" ).append("\n"); 
		query.append("             ,'M_'||@[upd_usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("             ,SYSDATE UPD_DT" ).append("\n"); 
		query.append("        FROM DUAL" ).append("\n"); 
		query.append("#if(${if_rmk} == 'COP MT Change' && ${cost_src_sys_cd} == 'SCE')" ).append("\n"); 
		query.append("       where exists (select 'X'" ).append("\n"); 
		query.append("                       from bkg_booking a, sce_cop_hdr b, sce_cop_dtl c" ).append("\n"); 
		query.append("                      where a.bkg_no = b.bkg_no" ).append("\n"); 
		query.append("                        and b.cop_no = c.cop_no" ).append("\n"); 
		query.append("                        and a.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("                        and c.act_cd in ('MOTYDO', 'MITYAD')" ).append("\n"); 
		query.append("                        and decode(c.act_cd, 'MOTYDO', a.mty_pkup_yd_cd, a.mty_rtn_yd_cd) <> c.nod_cd)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("      ) A2" ).append("\n"); 
		query.append("ON (A1.BKG_NO = A2.BKG_NO AND A1.COST_SRC_SYS_CD = A2.COST_SRC_SYS_CD)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("	UPDATE SET " ).append("\n"); 
		query.append("		A1.IF_DT = A2.IF_DT" ).append("\n"); 
		query.append("	,	A1.IF_RMK = A2.IF_RMK" ).append("\n"); 
		query.append("	,	A1.UPD_USR_ID = A2.UPD_USR_ID" ).append("\n"); 
		query.append("	,	A1.UPD_DT = A2.UPD_DT" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("	INSERT(" ).append("\n"); 
		query.append("		A1.BKG_NO" ).append("\n"); 
		query.append("	,	A1.COST_SRC_SYS_CD" ).append("\n"); 
		query.append("	,	A1.IF_DT" ).append("\n"); 
		query.append("	,	A1.IF_RMK" ).append("\n"); 
		query.append("	,	A1.CRE_USR_ID" ).append("\n"); 
		query.append("	,	A1.CRE_DT" ).append("\n"); 
		query.append("	,	A1.UPD_USR_ID" ).append("\n"); 
		query.append("	,	A1.UPD_DT" ).append("\n"); 
		query.append("	) VALUES( " ).append("\n"); 
		query.append("		A2.BKG_NO" ).append("\n"); 
		query.append("	,	A2.COST_SRC_SYS_CD" ).append("\n"); 
		query.append("	,	A2.IF_DT" ).append("\n"); 
		query.append("	,	A2.IF_RMK" ).append("\n"); 
		query.append("	,	A2.CRE_USR_ID" ).append("\n"); 
		query.append("	,	A2.CRE_DT" ).append("\n"); 
		query.append("	,	A2.UPD_USR_ID" ).append("\n"); 
		query.append("	,	A2.UPD_DT)" ).append("\n"); 

	}
}
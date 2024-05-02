/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReplanManageDBDAOAddSoListByCopCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.05
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.07.05 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReplanManageDBDAOAddSoListByCopCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * cop 단위로 SCE_PLN_SO_LIST 를 생성한다. 기존 S/O 의 status 등의 재 정리작업은 본 query 에서 하지 않고 java 단에서 처리.
	  * </pre>
	  */
	public ReplanManageDBDAOAddSoListByCopCSQL(){
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
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.replanmanage.replanmanage.integration").append("\n"); 
		query.append("FileName : ReplanManageDBDAOAddSoListByCopCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_PLN_SO_LIST" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("COP_NO," ).append("\n"); 
		query.append("COST_ACT_GRP_SEQ," ).append("\n"); 
		query.append("COST_ACT_GRP_CD," ).append("\n"); 
		query.append("CTRL_OFC_CD," ).append("\n"); 
		query.append("N1ST_NOD_PLN_DT," ).append("\n"); 
		query.append("N1ST_NOD_CD," ).append("\n"); 
		query.append("N2ND_NOD_CD," ).append("\n"); 
		query.append("N3RD_NOD_CD," ).append("\n"); 
		query.append("N4TH_NOD_CD," ).append("\n"); 
		query.append("PCTL_IO_BND_CD," ).append("\n"); 
		query.append("PCTL_COST_MOD_CD," ).append("\n"); 
		query.append("N1ST_VNDR_SEQ," ).append("\n"); 
		query.append("TRSP_SO_STS_CD," ).append("\n"); 
		query.append("TRSP_MOD_CD," ).append("\n"); 
		query.append("INLND_ROUT_INV_BIL_PATT_CD," ).append("\n"); 
		query.append("INV_BIL_PATT_DIV_FLG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("DOR_ARR_DT," ).append("\n"); 
		query.append("LST_NOD_PLN_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT COP_NO," ).append("\n"); 
		query.append("COST_ACT_GRP_SEQ," ).append("\n"); 
		query.append("COST_ACT_GRP_CD," ).append("\n"); 
		query.append("CTRL_OFC_CD," ).append("\n"); 
		query.append("N1ST_NOD_PLN_DT," ).append("\n"); 
		query.append("N1ST_NOD_CD," ).append("\n"); 
		query.append("N2ND_NOD_CD," ).append("\n"); 
		query.append("N3RD_NOD_CD," ).append("\n"); 
		query.append("N4TH_NOD_CD," ).append("\n"); 
		query.append("PCTL_IO_BND_CD," ).append("\n"); 
		query.append("PCTL_COST_MOD_CD," ).append("\n"); 
		query.append("N1ST_VNDR_SEQ," ).append("\n"); 
		query.append("TRSP_SO_STS_CD," ).append("\n"); 
		query.append("TRSP_MOD_CD," ).append("\n"); 
		query.append("INLND_ROUT_INV_BIL_PATT_CD," ).append("\n"); 
		query.append("INV_BIL_PATT_DIV_FLG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("DOR_ARR_DT," ).append("\n"); 
		query.append("LST_NOD_PLN_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT a.cop_no COP_NO ," ).append("\n"); 
		query.append("b.cost_act_grp_seq COST_ACT_GRP_SEQ ," ).append("\n"); 
		query.append("MAX(b.cost_act_grp_cd ) COST_ACT_GRP_CD ," ).append("\n"); 
		query.append("MAX(b.ctrl_ofc_cd ) CTRL_OFC_CD ," ).append("\n"); 
		query.append("MAX(b.n1st_nod_pln_dt ) N1ST_NOD_PLN_DT ," ).append("\n"); 
		query.append("MAX(b.n1st_nod_cd ) N1ST_NOD_CD ," ).append("\n"); 
		query.append("MAX(b.n2nd_nod_cd ) N2ND_NOD_CD ," ).append("\n"); 
		query.append("MAX(b.n3rd_nod_cd ) N3RD_NOD_CD ," ).append("\n"); 
		query.append("MAX(b.n4th_nod_cd ) N4TH_NOD_CD ," ).append("\n"); 
		query.append("MAX(b.pctl_io_bnd_cd ) PCTL_IO_BND_CD ," ).append("\n"); 
		query.append("MAX(b.pctl_cost_mod_cd ) PCTL_COST_MOD_CD ," ).append("\n"); 
		query.append("MAX(b.n1st_vndr_seq ) N1ST_VNDR_SEQ ," ).append("\n"); 
		query.append("MAX(b.trsp_so_sts_cd ) TRSP_SO_STS_CD ," ).append("\n"); 
		query.append("MAX(b.trsp_mod_cd ) TRSP_MOD_CD ," ).append("\n"); 
		query.append("MAX(b.inlnd_rout_inv_bil_patt_cd) INLND_ROUT_INV_BIL_PATT_CD ," ).append("\n"); 
		query.append("max(b.INV_BIL_PATT_DIV_FLG ) INV_BIL_PATT_DIV_FLG," ).append("\n"); 
		query.append("'SYSTEM' CRE_USR_ID ," ).append("\n"); 
		query.append("SYSDATE CRE_DT ," ).append("\n"); 
		query.append("'SYSTEM' UPD_USR_ID ," ).append("\n"); 
		query.append("SYSDATE UPD_DT ," ).append("\n"); 
		query.append("max(b.DOR_ARR_DT ) DOR_ARR_DT ," ).append("\n"); 
		query.append("max(b.LST_NOD_ARR_DT ) LST_NOD_PLN_DT" ).append("\n"); 
		query.append("FROM sce_cop_hdr a ," ).append("\n"); 
		query.append("prd_prod_ctl_act_grp_dtl b ," ).append("\n"); 
		query.append("prd_prod_ctl_rout_dtl d" ).append("\n"); 
		query.append("WHERE a.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("AND A.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND b.pctl_no = a.pctl_no" ).append("\n"); 
		query.append("AND d.pctl_no(+) = b.pctl_no -- Outer Join으로 변경" ).append("\n"); 
		query.append("AND b.pctl_no = @[pctl_no]" ).append("\n"); 
		query.append("GROUP BY a.cop_no , b.cost_act_grp_seq" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ((" ).append("\n"); 
		query.append("SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT a.cop_no COP_NO ," ).append("\n"); 
		query.append("b.cost_act_grp_seq COST_ACT_GRP_SEQ ," ).append("\n"); 
		query.append("MAX(b.cost_act_grp_cd ) COST_ACT_GRP_CD ," ).append("\n"); 
		query.append("MAX(b.ctrl_ofc_cd ) CTRL_OFC_CD ," ).append("\n"); 
		query.append("MAX(b.n1st_nod_pln_dt ) N1ST_NOD_PLN_DT ," ).append("\n"); 
		query.append("MAX(b.n1st_nod_cd ) N1ST_NOD_CD ," ).append("\n"); 
		query.append("MAX(b.n2nd_nod_cd ) N2ND_NOD_CD ," ).append("\n"); 
		query.append("MAX(b.n3rd_nod_cd ) N3RD_NOD_CD ," ).append("\n"); 
		query.append("MAX(b.n4th_nod_cd ) N4TH_NOD_CD ," ).append("\n"); 
		query.append("MAX(b.pctl_io_bnd_cd ) PCTL_IO_BND_CD ," ).append("\n"); 
		query.append("MAX(b.pctl_cost_mod_cd ) PCTL_COST_MOD_CD ," ).append("\n"); 
		query.append("MAX(b.n1st_vndr_seq ) N1ST_VNDR_SEQ ," ).append("\n"); 
		query.append("MAX(b.trsp_so_sts_cd ) TRSP_SO_STS_CD ," ).append("\n"); 
		query.append("MAX(b.trsp_mod_cd ) TRSP_MOD_CD ," ).append("\n"); 
		query.append("MAX(b.inlnd_rout_inv_bil_patt_cd) INLND_ROUT_INV_BIL_PATT_CD ," ).append("\n"); 
		query.append("max(b.INV_BIL_PATT_DIV_FLG ) INV_BIL_PATT_DIV_FLG," ).append("\n"); 
		query.append("'SYSTEM' CRE_USR_ID ," ).append("\n"); 
		query.append("SYSDATE CRE_DT ," ).append("\n"); 
		query.append("'SYSTEM' UPD_USR_ID ," ).append("\n"); 
		query.append("SYSDATE UPD_DT ," ).append("\n"); 
		query.append("max(b.DOR_ARR_DT ) DOR_ARR_DT ," ).append("\n"); 
		query.append("max(b.LST_NOD_ARR_DT ) LST_NOD_PLN_DT" ).append("\n"); 
		query.append("FROM sce_cop_hdr a ," ).append("\n"); 
		query.append("prd_prod_ctl_act_grp_dtl b ," ).append("\n"); 
		query.append("prd_prod_ctl_rout_dtl d" ).append("\n"); 
		query.append("WHERE a.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("AND A.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND b.pctl_no = a.pctl_no" ).append("\n"); 
		query.append("AND d.pctl_no(+) = b.pctl_no -- Outer Join으로 변경" ).append("\n"); 
		query.append("AND b.pctl_no = @[pctl_no]" ).append("\n"); 
		query.append("GROUP BY a.cop_no , b.cost_act_grp_seq" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE NVL(TRSP_SO_STS_CD, 'U') != 'U') > 0" ).append("\n"); 
		query.append("AND NVL(TRSP_SO_STS_CD, 'U') != 'U')" ).append("\n"); 
		query.append("OR ((" ).append("\n"); 
		query.append("SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT a.cop_no COP_NO ," ).append("\n"); 
		query.append("b.cost_act_grp_seq COST_ACT_GRP_SEQ ," ).append("\n"); 
		query.append("MAX(b.cost_act_grp_cd ) COST_ACT_GRP_CD ," ).append("\n"); 
		query.append("MAX(b.ctrl_ofc_cd ) CTRL_OFC_CD ," ).append("\n"); 
		query.append("MAX(b.n1st_nod_pln_dt ) N1ST_NOD_PLN_DT ," ).append("\n"); 
		query.append("MAX(b.n1st_nod_cd ) N1ST_NOD_CD ," ).append("\n"); 
		query.append("MAX(b.n2nd_nod_cd ) N2ND_NOD_CD ," ).append("\n"); 
		query.append("MAX(b.n3rd_nod_cd ) N3RD_NOD_CD ," ).append("\n"); 
		query.append("MAX(b.n4th_nod_cd ) N4TH_NOD_CD ," ).append("\n"); 
		query.append("MAX(b.pctl_io_bnd_cd ) PCTL_IO_BND_CD ," ).append("\n"); 
		query.append("MAX(b.pctl_cost_mod_cd ) PCTL_COST_MOD_CD ," ).append("\n"); 
		query.append("MAX(b.n1st_vndr_seq ) N1ST_VNDR_SEQ ," ).append("\n"); 
		query.append("MAX(b.trsp_so_sts_cd ) TRSP_SO_STS_CD ," ).append("\n"); 
		query.append("MAX(b.trsp_mod_cd ) TRSP_MOD_CD ," ).append("\n"); 
		query.append("MAX(b.inlnd_rout_inv_bil_patt_cd) INLND_ROUT_INV_BIL_PATT_CD ," ).append("\n"); 
		query.append("max(b.INV_BIL_PATT_DIV_FLG ) INV_BIL_PATT_DIV_FLG," ).append("\n"); 
		query.append("'SYSTEM' CRE_USR_ID ," ).append("\n"); 
		query.append("SYSDATE CRE_DT ," ).append("\n"); 
		query.append("'SYSTEM' UPD_USR_ID ," ).append("\n"); 
		query.append("SYSDATE UPD_DT ," ).append("\n"); 
		query.append("max(b.DOR_ARR_DT ) DOR_ARR_DT ," ).append("\n"); 
		query.append("max(b.LST_NOD_ARR_DT ) LST_NOD_PLN_DT" ).append("\n"); 
		query.append("FROM sce_cop_hdr a ," ).append("\n"); 
		query.append("prd_prod_ctl_act_grp_dtl b ," ).append("\n"); 
		query.append("prd_prod_ctl_rout_dtl d" ).append("\n"); 
		query.append("WHERE a.bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("AND A.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND b.pctl_no = a.pctl_no" ).append("\n"); 
		query.append("AND d.pctl_no(+) = b.pctl_no -- Outer Join으로 변경" ).append("\n"); 
		query.append("AND b.pctl_no = @[pctl_no]" ).append("\n"); 
		query.append("GROUP BY a.cop_no , b.cost_act_grp_seq" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE NVL(TRSP_SO_STS_CD, 'U') != 'U') = 0" ).append("\n"); 
		query.append("AND COST_ACT_GRP_SEQ = 990)" ).append("\n"); 
		query.append("ORDER BY COP_NO, COST_ACT_GRP_SEQ" ).append("\n"); 

	}
}
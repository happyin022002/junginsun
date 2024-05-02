/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FillInEquipmentNoDBDAOsearchFillInEquipmentNoListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.08
*@LastModifier : Park Yeon-Jin
*@LastVersion : 1.0
* 2012.11.08 Park Yeon-Jin
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Yeon-Jin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class FillInEquipmentNoDBDAOsearchFillInEquipmentNoListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Fill In Equipment No List 조회 한다.
	  * </pre>
	  */
	public FillInEquipmentNoDBDAOsearchFillInEquipmentNoListRSQL(){
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
		params.put("trsp_wo_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_wo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.workorder.integration").append("\n"); 
		query.append("FileName : FillInEquipmentNoDBDAOsearchFillInEquipmentNoListRSQL").append("\n"); 
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
		query.append("select DISTINCT x1.CNTR_NO," ).append("\n"); 
		query.append("x1.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("x1.EQ_TPSZ_NM," ).append("\n"); 
		query.append("x1.BKG_NO," ).append("\n"); 
		query.append("x1.BKG_STATUS_CD ," ).append("\n"); 
		query.append("DECODE(x2.cntr_no, NULL, X1.BKG_STATUS_NM, 'N') BKG_STATUS_NM ," ).append("\n"); 
		query.append("x1.BL_NO," ).append("\n"); 
		query.append("x1.ORG_BKG_NO," ).append("\n"); 
		query.append("DECODE((SELECT DISTINCT EQ_NO" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("WHERE (ORG_BKG_NO = x1.ORG_BKG_NO OR BKG_NO = x1.BKG_NO)" ).append("\n"); 
		query.append("AND TRSP_BND_CD = 'O'" ).append("\n"); 
		query.append("AND TRSP_COST_DTL_MOD_CD = 'DR'" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND x1.CNTR_NO =EQ_NO(+) ), null, 'Y', 'N') AS SO_EQ_Flg," ).append("\n"); 
		query.append("DECODE((SELECT DISTINCT EQ_NO" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("WHERE (ORG_BKG_NO = x1.ORG_BKG_NO OR BKG_NO = x1.BKG_NO)" ).append("\n"); 
		query.append("AND TRSP_BND_CD = 'O'" ).append("\n"); 
		query.append("AND TRSP_COST_DTL_MOD_CD = 'DR'" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND x1.CNTR_NO =EQ_NO(+) ), null, 'Y', 'N') AS SO_EQ_Flg," ).append("\n"); 
		query.append("DECODE((SELECT VNDR_SEQ" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BKG_NO = X1.BKG_NO" ).append("\n"); 
		query.append("AND CNTR_NO = X1.CNTR_NO" ).append("\n"); 
		query.append("AND MVMT_STS_CD = 'OC'" ).append("\n"); 
		query.append("AND ROWNUM = 1), '','Y', DECODE((SELECT USA_EDI_CD" ).append("\n"); 
		query.append("FROM MDM_VENDOR" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND VNDR_SEQ = (SELECT VNDR_SEQ" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND BKG_NO = X1.BKG_NO" ).append("\n"); 
		query.append("AND CNTR_NO = X1.CNTR_NO" ).append("\n"); 
		query.append("AND MVMT_STS_CD = 'OC'" ).append("\n"); 
		query.append("AND ROWNUM = 1)),( SELECT USA_EDI_CD" ).append("\n"); 
		query.append("FROM MDM_VENDOR" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND VNDR_SEQ = @[vndr_seq]) ,'Y', 'N')) CTM_SCAC_CHK_FLG" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("SELECT DISTINCT BC.CNTR_NO," ).append("\n"); 
		query.append("BC.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT CNTR_TPSZ_RMK" ).append("\n"); 
		query.append("FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("WHERE CNTR_TPSZ_CD = BC.CNTR_TPSZ_CD) AS EQ_TPSZ_NM," ).append("\n"); 
		query.append("BK.BKG_NO," ).append("\n"); 
		query.append("BK.BKG_STS_CD BKG_STATUS_CD," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD00769'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = BK.BKG_STS_CD) BKG_STATUS_NM," ).append("\n"); 
		query.append("BK.BL_NO bl_no ," ).append("\n"); 
		query.append("SO.ORG_BKG_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT S.TRSP_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("S.TRSP_SO_SEQ," ).append("\n"); 
		query.append("S.TRSP_WO_OFC_CTY_CD," ).append("\n"); 
		query.append("S.TRSP_WO_SEQ," ).append("\n"); 
		query.append("S.TRSP_COST_DTL_MOD_CD," ).append("\n"); 
		query.append("S.BKG_NO," ).append("\n"); 
		query.append("S.EQ_NO," ).append("\n"); 
		query.append("S.EQ_TPSZ_CD," ).append("\n"); 
		query.append("S.ORG_BKG_NO" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD S" ).append("\n"); 
		query.append("WHERE S.TRSP_WO_OFC_CTY_CD IS NOT NULL" ).append("\n"); 
		query.append("AND S.TRSP_WO_SEQ IS NOT NULL ) SO," ).append("\n"); 
		query.append("TRS_TRSP_WRK_ORD WO," ).append("\n"); 
		query.append("BKG_BOOKING BK ," ).append("\n"); 
		query.append("BKG_CONTAINER BC" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND WO.TRSP_WO_OFC_CTY_CD = SO.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND WO.TRSP_WO_SEQ = SO.TRSP_WO_SEQ" ).append("\n"); 
		query.append("AND WO.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND SO.TRSP_COST_DTL_MOD_CD = 'DR'" ).append("\n"); 
		query.append("AND ( DECODE(bc.cntr_tpsz_cd, so.EQ_TPSZ_CD, 'Y', (" ).append("\n"); 
		query.append("SELECT DECODE(count(prov_cntr_tpsz_cd), 0, 'N', 'Y')" ).append("\n"); 
		query.append("FROM SCE_COP_CNTR_REPO_RULE" ).append("\n"); 
		query.append("WHERE ACT_FLG = 'Y'" ).append("\n"); 
		query.append("AND CNTR_TPSZ_CD = so.EQ_TPSZ_CD) ) ) = 'Y'" ).append("\n"); 
		query.append("AND (SO.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("OR SO.ORG_BKG_NO = BC.BKG_NO)" ).append("\n"); 
		query.append("AND BC.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("AND BK.BKG_STS_CD != 'X'" ).append("\n"); 
		query.append("AND wo.wo_vndr_seq IN (" ).append("\n"); 
		query.append("SELECT vndr_seq" ).append("\n"); 
		query.append("FROM mdm_vendor" ).append("\n"); 
		query.append("WHERE prnt_vndr_seq = (" ).append("\n"); 
		query.append("SELECT prnt_vndr_seq" ).append("\n"); 
		query.append("FROM mdm_vendor" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND vndr_seq = @[vndr_seq] ) )" ).append("\n"); 
		query.append("AND (wo.trsp_wo_ofc_cty_cd," ).append("\n"); 
		query.append("wo.trsp_wo_seq) = ((@[trsp_wo_ofc_cty_cd]," ).append("\n"); 
		query.append("@[trsp_wo_seq])) ) x1," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT CNTR_NO," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("eq_tpsz_nm," ).append("\n"); 
		query.append("bkg_no," ).append("\n"); 
		query.append("BKG_STATUS_CD," ).append("\n"); 
		query.append("BKG_STATUS_NM," ).append("\n"); 
		query.append("BL_NO," ).append("\n"); 
		query.append("org_bkg_no" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT so.eq_NO CNTR_NO," ).append("\n"); 
		query.append("so.eq_TPSZ_CD CNTR_TPSZ_CD," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT cntr_tpsz_rmk" ).append("\n"); 
		query.append("FROM mdm_cntr_tp_sz" ).append("\n"); 
		query.append("WHERE cntr_tpsz_cd = so.eq_TPSZ_CD) AS eq_tpsz_nm," ).append("\n"); 
		query.append("so.bkg_no," ).append("\n"); 
		query.append("BK.BKG_STS_CD BKG_STATUS_CD," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT INTG_CD_VAL_DP_DESC" ).append("\n"); 
		query.append("FROM COM_INTG_CD_DTL" ).append("\n"); 
		query.append("WHERE INTG_CD_ID = 'CD00769'" ).append("\n"); 
		query.append("AND INTG_CD_VAL_CTNT = BK.BKG_STS_CD) BKG_STATUS_NM," ).append("\n"); 
		query.append("BK.BL_NO bl_no," ).append("\n"); 
		query.append("so.org_bkg_no" ).append("\n"); 
		query.append("FROM BKG_BOOKING BK," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select wo.TRSP_WO_OFC_CTY_CD," ).append("\n"); 
		query.append("wo.TRSP_WO_SEQ," ).append("\n"); 
		query.append("EQ_NO," ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("so.org_bkg_no," ).append("\n"); 
		query.append("so.EQ_TPSZ_CD" ).append("\n"); 
		query.append("from TRS_TRSP_SVC_ORD so," ).append("\n"); 
		query.append("TRS_TRSP_WRK_ORD wo" ).append("\n"); 
		query.append("where 1=1" ).append("\n"); 
		query.append("AND wo.trsp_wo_ofc_cty_cd = so.trsp_wo_ofc_cty_cd" ).append("\n"); 
		query.append("AND wo.trsp_wo_seq = so.trsp_wo_seq" ).append("\n"); 
		query.append("AND WO.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND (so.bkg_no ) IN (" ).append("\n"); 
		query.append("SELECT bkg_no" ).append("\n"); 
		query.append("FROM trs_trsp_svc_ord" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND trsp_wo_ofc_cty_cd = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("AND trsp_wo_seq = @[trsp_wo_seq]" ).append("\n"); 
		query.append("union all" ).append("\n"); 
		query.append("SELECT org_bkg_no" ).append("\n"); 
		query.append("FROM trs_trsp_svc_ord" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND trsp_wo_ofc_cty_cd = @[trsp_wo_ofc_cty_cd]" ).append("\n"); 
		query.append("AND trsp_wo_seq = @[trsp_wo_seq] )" ).append("\n"); 
		query.append("AND (wo.trsp_wo_ofc_cty_cd," ).append("\n"); 
		query.append("wo.trsp_wo_seq) = ((@[trsp_wo_ofc_cty_cd]," ).append("\n"); 
		query.append("@[trsp_wo_seq]))" ).append("\n"); 
		query.append("AND so.trsp_cost_dtl_mod_cd = 'DR'" ).append("\n"); 
		query.append("AND wo.wo_vndr_seq IN (" ).append("\n"); 
		query.append("SELECT vndr_seq" ).append("\n"); 
		query.append("FROM mdm_vendor" ).append("\n"); 
		query.append("WHERE prnt_vndr_seq = (" ).append("\n"); 
		query.append("SELECT prnt_vndr_seq" ).append("\n"); 
		query.append("FROM mdm_vendor" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND vndr_seq = @[vndr_seq] ) ) ) so" ).append("\n"); 
		query.append("where 1=1" ).append("\n"); 
		query.append("and so.bkg_no = bk.bkg_no" ).append("\n"); 
		query.append("AND bk.bkg_sts_cd != 'X'" ).append("\n"); 
		query.append("and so.eq_NO is not null )) x2" ).append("\n"); 
		query.append("where x1.cntr_no = x2.cntr_no(+)" ).append("\n"); 

	}
}
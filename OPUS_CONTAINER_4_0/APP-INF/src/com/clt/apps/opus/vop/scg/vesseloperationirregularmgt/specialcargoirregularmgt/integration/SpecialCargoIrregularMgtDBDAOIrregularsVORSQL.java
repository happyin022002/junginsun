/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SpecialCargoIrregularMgtDBDAOIrregularsVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.23
*@LastModifier : 
*@LastVersion : 1.0
* 2012.11.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoIrregularMgtDBDAOIrregularsVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SPCL CGO Irregular List 조회   
	  * </pre>
	  */
	public SpecialCargoIrregularMgtDBDAOIrregularsVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_spcl_cgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("irr_occr_from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("irr_spcl_cgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("irr_occr_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_opr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_irr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_comp_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.integration").append("\n"); 
		query.append("FileName : SpecialCargoIrregularMgtDBDAOIrregularsVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("	SIR.VSL_CD||SIR.SKD_VOY_NO||SIR.SKD_DIR_CD VVD_CD" ).append("\n"); 
		query.append(",	SIR.VSL_CD" ).append("\n"); 
		query.append(",	SIR.SKD_VOY_NO" ).append("\n"); 
		query.append(",	SIR.SKD_DIR_CD" ).append("\n"); 
		query.append(",	SIR.SPCL_CGO_IRR_SEQ" ).append("\n"); 
		query.append(",   (" ).append("\n"); 
		query.append("	SELECT MVS.VSL_SLAN_CD" ).append("\n"); 
		query.append("      FROM VSK_VSL_SKD VVS" ).append("\n"); 
		query.append("         , MDM_VSL_SVC_LANE MVS" ).append("\n"); 
		query.append("     WHERE VVS.VSL_CD = SIR.VSL_CD" ).append("\n"); 
		query.append("       AND VVS.SKD_VOY_NO = SIR.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND VVS.SKD_DIR_CD = SIR.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND VVS.VSL_SLAN_CD = MVS.VSL_SLAN_CD" ).append("\n"); 
		query.append("    ) VSL_SLAN_CD" ).append("\n"); 
		query.append(",	SIR.VSL_CRR_CD VSL_OPR_TP_CD" ).append("\n"); 
		query.append(",	TO_CHAR(SIR.IRR_OCCR_DT,'YYYY-MM-DD') IRR_OCCR_DT" ).append("\n"); 
		query.append(",	SIR.SPCL_CGO_IRR_TP_CD" ).append("\n"); 
		query.append(",   (" ).append("\n"); 
		query.append("	SELECT SIT.SPCL_CGO_IRR_TP_NM" ).append("\n"); 
		query.append("      FROM SCG_IRR_TP_CD SIT" ).append("\n"); 
		query.append("     WHERE SIT.SPCL_CGO_IRR_TP_CD = SIR.SPCL_CGO_IRR_TP_CD" ).append("\n"); 
		query.append("    ) SPCL_CGO_IRR_TP_NM" ).append("\n"); 
		query.append(",	DECODE(SIR.CGO_OPR_CD,COM_ConstantMgr_PKG.COM_getCompanyCode_FNC(),SIC.BKG_NO,SIC.BKG_REF_NO) BKG_NO" ).append("\n"); 
		query.append(",	DECODE(SIR.CGO_OPR_CD,COM_ConstantMgr_PKG.COM_getCompanyCode_FNC(),SIC.CNTR_NO,SIC.CNTR_REF_NO) CNTR_NO" ).append("\n"); 
		query.append(",	SIR.CGO_OPR_CD" ).append("\n"); 
		query.append(",	SIC.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(",	SIC.CGO_SEQ" ).append("\n"); 
		query.append(",	NVL(SIC.SPCL_CGO_CATE_CD,SIR.SPCL_CGO_CATE_CD) SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append(",	SIC.IMDG_UN_NO" ).append("\n"); 
		query.append(",	SIC.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append(",	SIC.IMDG_CLSS_CD" ).append("\n"); 
		query.append(",	DECODE(SIR.SPCL_CGO_CATE_CD,'DG',(" ).append("\n"); 
		query.append("	                                   SELECT BDC.GRS_WGT" ).append("\n"); 
		query.append("                                         FROM BKG_DG_CGO BDC" ).append("\n"); 
		query.append("                                        WHERE BDC.BKG_NO       = SIC.BKG_NO" ).append("\n"); 
		query.append("                                          AND BDC.CNTR_NO      = SIC.CNTR_NO" ).append("\n"); 
		query.append("                                          AND BDC.CNTR_CGO_SEQ = SIC.CGO_SEQ" ).append("\n"); 
		query.append("                                     ),SIC.AWK_CGO_GRS_WGT) AWK_CGO_GRS_WGT" ).append("\n"); 
		query.append(",	DECODE(SIR.SPCL_CGO_CATE_CD,'DG',(" ).append("\n"); 
		query.append("	                                   SELECT BDC.NET_WGT" ).append("\n"); 
		query.append("                                         FROM BKG_DG_CGO BDC" ).append("\n"); 
		query.append("                                        WHERE BDC.BKG_NO       = SIC.BKG_NO" ).append("\n"); 
		query.append("                                          AND BDC.CNTR_NO      = SIC.CNTR_NO" ).append("\n"); 
		query.append("                                          AND BDC.CNTR_CGO_SEQ = SIC.CGO_SEQ" ).append("\n"); 
		query.append("                                     ),SIC.AWK_CGO_NET_WGT) AWK_CGO_NET_WGT" ).append("\n"); 
		query.append(",	SIC.DIM_LEN" ).append("\n"); 
		query.append(",	SIC.DIM_WDT" ).append("\n"); 
		query.append(",	SIC.DIM_HGT" ).append("\n"); 
		query.append(",   (" ).append("\n"); 
		query.append("	SELECT BB1.POR_CD" ).append("\n"); 
		query.append("      FROM BKG_BOOKING BB1" ).append("\n"); 
		query.append("     WHERE BB1.BKG_NO         = SIC.BKG_NO" ).append("\n"); 
		query.append("    ) POR_CD" ).append("\n"); 
		query.append(",   (" ).append("\n"); 
		query.append("	SELECT BB2.POL_CD" ).append("\n"); 
		query.append("      FROM BKG_BOOKING BB2" ).append("\n"); 
		query.append("     WHERE BB2.BKG_NO         = SIC.BKG_NO" ).append("\n"); 
		query.append("    ) POL_CD" ).append("\n"); 
		query.append(",   (" ).append("\n"); 
		query.append("	SELECT BB3.POD_CD" ).append("\n"); 
		query.append("      FROM BKG_BOOKING BB3" ).append("\n"); 
		query.append("     WHERE BB3.BKG_NO         = SIC.BKG_NO" ).append("\n"); 
		query.append("    ) POD_CD" ).append("\n"); 
		query.append(",   (" ).append("\n"); 
		query.append("	SELECT BB4.DEL_CD" ).append("\n"); 
		query.append("      FROM BKG_BOOKING BB4" ).append("\n"); 
		query.append("     WHERE BB4.BKG_NO         = SIC.BKG_NO" ).append("\n"); 
		query.append("    ) DEL_CD" ).append("\n"); 
		query.append(",   (" ).append("\n"); 
		query.append("	SELECT BS1.CUST_NM" ).append("\n"); 
		query.append("      FROM BKG_CUSTOMER BS1" ).append("\n"); 
		query.append("     WHERE BS1.BKG_NO         = SIC.BKG_NO" ).append("\n"); 
		query.append("       AND BS1.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("    ) S_CUST_NM" ).append("\n"); 
		query.append(",   (" ).append("\n"); 
		query.append("	SELECT BS2.CUST_NM" ).append("\n"); 
		query.append("      FROM BKG_CUSTOMER BS2" ).append("\n"); 
		query.append("     WHERE BS2.BKG_NO         = SIC.BKG_NO" ).append("\n"); 
		query.append("       AND BS2.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("    ) C_CUST_NM" ).append("\n"); 
		query.append(",	SIR.CRE_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(SIR.CRE_DT,'YYYYMMDD') CRE_DT" ).append("\n"); 
		query.append(",	SIR.UPD_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(SIR.UPD_DT,'YYYYMMDD') UPD_DT" ).append("\n"); 
		query.append(",   (" ).append("\n"); 
		query.append("    SELECT USR.OFC_CD" ).append("\n"); 
		query.append("      FROM COM_USER USR" ).append("\n"); 
		query.append("     WHERE USR.USR_ID = SIR.CRE_USR_ID" ).append("\n"); 
		query.append("    ) OFC_CD" ).append("\n"); 
		query.append(",   '' IRR_OCCR_FROM_DT" ).append("\n"); 
		query.append(",   '' IRR_OCCR_TO_DT" ).append("\n"); 
		query.append(",   '' IRR_SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append(",   '' CNT_SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("FROM SCG_IRREGULAR SIR" ).append("\n"); 
		query.append("   , SCG_IRR_CNTR  SIC" ).append("\n"); 
		query.append("WHERE SIR.VSL_CD = SIC.VSL_CD" ).append("\n"); 
		query.append(" AND SIR.SKD_VOY_NO = SIC.SKD_VOY_NO" ).append("\n"); 
		query.append(" AND SIR.SKD_DIR_CD = SIC.SKD_DIR_CD" ).append("\n"); 
		query.append(" AND SIR.SPCL_CGO_IRR_SEQ = SIC.SPCL_CGO_IRR_SEQ " ).append("\n"); 
		query.append(" AND SIR.IRR_OCCR_DT BETWEEN TO_DATE(@[irr_occr_from_dt],'YYYYMMDD') AND TO_DATE(@[irr_occr_to_dt],'YYYYMMDD')+0.99999" ).append("\n"); 
		query.append("#if (${irr_spcl_cgo_cate_cd} != '') " ).append("\n"); 
		query.append(" AND SIR.SPCL_CGO_CATE_CD = @[irr_spcl_cgo_cate_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_slan_cd} != '') " ).append("\n"); 
		query.append(" AND EXISTS (" ).append("\n"); 
		query.append("    SELECT 'A'" ).append("\n"); 
		query.append("      FROM VSK_VSL_SKD CVV" ).append("\n"); 
		query.append("     WHERE CVV.VSL_CD = SIR.VSL_CD" ).append("\n"); 
		query.append("       AND CVV.SKD_VOY_NO = SIR.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND CVV.SKD_DIR_CD = SIR.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND CVV.VSL_SLAN_CD = @[vsl_slan_cd]" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '') " ).append("\n"); 
		query.append(" AND SIR.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_opr_tp_cd} != '') " ).append("\n"); 
		query.append(" AND EXISTS (" ).append("\n"); 
		query.append("    SELECT 'A'" ).append("\n"); 
		query.append("      FROM VSK_VSL_SKD VVS" ).append("\n"); 
		query.append("         , MDM_VSL_CNTR MVC" ).append("\n"); 
		query.append("         , MDM_CARRIER VCR" ).append("\n"); 
		query.append("     WHERE VVS.VSL_CD = SIR.VSL_CD" ).append("\n"); 
		query.append("       AND VVS.SKD_VOY_NO = SIR.SKD_VOY_NO" ).append("\n"); 
		query.append("       AND VVS.SKD_DIR_CD = SIR.SKD_DIR_CD" ).append("\n"); 
		query.append("       AND VVS.VSL_CD = MVC.VSL_CD" ).append("\n"); 
		query.append("	   AND MVC.CRR_CD = VCR.CRR_CD" ).append("\n"); 
		query.append("       AND VCR.CRR_CD = @[vsl_opr_tp_cd]" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cgo_opr_cd} != '') " ).append("\n"); 
		query.append(" AND SIR.CGO_OPR_CD = @[cgo_opr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${spcl_cgo_irr_tp_cd} != '') " ).append("\n"); 
		query.append(" AND SIR.SPCL_CGO_IRR_TP_CD = @[spcl_cgo_irr_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_un_no} != '' || ${imdg_clss_cd} != '' || ${imdg_comp_grp_cd} != '') " ).append("\n"); 
		query.append("AND (" ).append("\n"); 
		query.append("     (   SIR.CGO_OPR_CD = COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("     AND   (" ).append("\n"); 
		query.append("        SIC.CNTR_NO IN (" ).append("\n"); 
		query.append("        SELECT A.CNTR_NO" ).append("\n"); 
		query.append("        FROM SCG_IRR_CNTR A" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("#if (${imdg_clss_cd} != '') " ).append("\n"); 
		query.append("                       AND A.IMDG_CLSS_CD = @[imdg_clss_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_un_no} != '') " ).append("\n"); 
		query.append("                       AND A.IMDG_UN_No = @[imdg_un_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_comp_grp_cd} != '') " ).append("\n"); 
		query.append("                       AND A.IMDG_COMP_GRP_CD = @[imdg_comp_grp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("     OR" ).append("\n"); 
		query.append("     (   SIR.CGO_OPR_CD <> COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("     AND   (" ).append("\n"); 
		query.append("        SIC.CNTR_REF_NO IN (" ).append("\n"); 
		query.append("        SELECT A.CNTR_REF_NO" ).append("\n"); 
		query.append("        FROM SCG_IRR_CNTR A" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("#if (${imdg_clss_cd} != '') " ).append("\n"); 
		query.append("                       AND A.IMDG_CLSS_CD = @[imdg_clss_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_un_no} != '') " ).append("\n"); 
		query.append("                       AND A.IMDG_UN_No = @[imdg_un_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${imdg_comp_grp_cd} != '') " ).append("\n"); 
		query.append("                       AND A.IMDG_COMP_GRP_CD = @[imdg_comp_grp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("     )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cnt_spcl_cgo_cate_cd} != '') " ).append("\n"); 
		query.append(" AND SIC.SPCL_CGO_CATE_CD = @[cnt_spcl_cgo_cate_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${por_cd} != '') " ).append("\n"); 
		query.append(" AND EXISTS (" ).append("\n"); 
		query.append("	SELECT 'A'" ).append("\n"); 
		query.append("      FROM BKG_BOOKING CB1" ).append("\n"); 
		query.append("     WHERE CB1.BKG_NO         = SIC.BKG_NO" ).append("\n"); 
		query.append("       AND CB1.POR_CD         = @[por_cd]" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append(" AND EXISTS (" ).append("\n"); 
		query.append("	SELECT 'A'" ).append("\n"); 
		query.append("      FROM BKG_BOOKING CB2" ).append("\n"); 
		query.append("     WHERE CB2.BKG_NO         = SIC.BKG_NO" ).append("\n"); 
		query.append("       AND CB2.POL_CD         = @[pol_cd]" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '') " ).append("\n"); 
		query.append(" AND EXISTS (" ).append("\n"); 
		query.append("	SELECT 'A'" ).append("\n"); 
		query.append("      FROM BKG_BOOKING CB3" ).append("\n"); 
		query.append("     WHERE CB3.BKG_NO         = SIC.BKG_NO" ).append("\n"); 
		query.append("       AND CB3.POD_CD         = @[pod_cd]" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '') " ).append("\n"); 
		query.append(" AND EXISTS (" ).append("\n"); 
		query.append("	SELECT 'A'" ).append("\n"); 
		query.append("      FROM BKG_BOOKING CB4" ).append("\n"); 
		query.append("     WHERE CB4.BKG_NO         = SIC.BKG_NO" ).append("\n"); 
		query.append("       AND CB4.DEL_CD         = @[del_cd]" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${s_cust_nm} != '') " ).append("\n"); 
		query.append(" AND EXISTS (" ).append("\n"); 
		query.append("	SELECT 'A'" ).append("\n"); 
		query.append("      FROM BKG_CUSTOMER CC1" ).append("\n"); 
		query.append("     WHERE CC1.BKG_NO         = SIC.BKG_NO" ).append("\n"); 
		query.append("       AND CC1.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("       AND UPPER(CC1.CUST_NM) LIKE '%'||UPPER(@[s_cust_nm])||'%'" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${c_cust_nm} != '') " ).append("\n"); 
		query.append(" AND EXISTS (" ).append("\n"); 
		query.append("	SELECT 'A'" ).append("\n"); 
		query.append("      FROM BKG_CUSTOMER CC2" ).append("\n"); 
		query.append("     WHERE CC2.BKG_NO         = SIC.BKG_NO" ).append("\n"); 
		query.append("       AND CC2.BKG_CUST_TP_CD = 'C'" ).append("\n"); 
		query.append("       AND UPPER(CC2.CUST_NM) LIKE '%'||UPPER(@[c_cust_nm])||'%'" ).append("\n"); 
		query.append("    ) " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY" ).append("\n"); 
		query.append("    SIR.IRR_OCCR_DT DESC" ).append("\n"); 
		query.append(",	SIR.VSL_CD" ).append("\n"); 
		query.append(",	SIR.SKD_VOY_NO" ).append("\n"); 
		query.append(",	SIR.SKD_DIR_CD" ).append("\n"); 
		query.append(",   SIR.SPCL_CGO_IRR_TP_CD" ).append("\n"); 
		query.append(",   DECODE(SIR.CGO_OPR_CD,COM_ConstantMgr_PKG.COM_getCompanyCode_FNC(),SIC.BKG_NO,SIC.BKG_REF_NO)" ).append("\n"); 
		query.append(",	SIR.CGO_OPR_CD" ).append("\n"); 
		query.append(",	SIC.CNTR_NO" ).append("\n"); 
		query.append(",	SIC.CGO_SEQ" ).append("\n"); 

	}
}
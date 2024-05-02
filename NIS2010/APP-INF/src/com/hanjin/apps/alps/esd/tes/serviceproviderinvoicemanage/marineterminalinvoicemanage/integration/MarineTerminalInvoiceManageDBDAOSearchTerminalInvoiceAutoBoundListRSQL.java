/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceAutoBoundListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.10.19 박재흥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceAutoBoundListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTerminalInvoiceAutoBoundList
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceAutoBoundListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_skd_voy_no2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOSearchTerminalInvoiceAutoBoundListRSQL").append("\n"); 
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
		query.append("SELECT  F.TML_SO_OFC_CTY_CD, F.TML_SO_SEQ, F.TML_SO_DTL_SEQ," ).append("\n"); 
		query.append("F.VSL_CD, F.SKD_VOY_NO, F.SKD_DIR_CD, F.IO_BND_CD," ).append("\n"); 
		query.append("F.VVD, F.LGS_COST_CD, F.INV_AMT, F.VVD_TYPE, F.CNTR_QTY_SUM, F.TOT_CNT," ).append("\n"); 
		query.append("F.CNTR_QTY_SUM ALLOCATED_VOLUMN," ).append("\n"); 
		query.append("0 CALC_AMT," ).append("\n"); 
		query.append("TO_CHAR(F.ATB_DT,'YYYY-MM-DD') ATB_DT, F.CNTR_TPSZ_CD, F.FM_TR_VOL_VAL, F.TO_TR_VOL_VAL," ).append("\n"); 
		query.append("F.DCGO_IND_CD, F.VOL_TR_UT_CD, F.INV_XCH_RT, '1' CHOICE" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT T.TML_SO_OFC_CTY_CD, T.TML_SO_SEQ, T.TML_SO_DTL_SEQ," ).append("\n"); 
		query.append("T.VSL_CD, T.SKD_VOY_NO, T.SKD_DIR_CD, T.IO_BND_CD," ).append("\n"); 
		query.append("T.VVD, T.LGS_COST_CD, T.INV_AMT, T.VVD_TYPE, T.CNTR_QTY_SUM," ).append("\n"); 
		query.append("SUM(T.CNTR_QTY_SUM) OVER (PARTITION BY T.TML_SO_OFC_CTY_CD, T.TML_SO_SEQ, T.TML_SO_DTL_SEQ) TOT_CNT," ).append("\n"); 
		query.append("T.ATB_DT, T.CNTR_TPSZ_CD, T.FM_TR_VOL_VAL, T.TO_TR_VOL_VAL," ).append("\n"); 
		query.append("T.DCGO_IND_CD, T.VOL_TR_UT_CD, T.INV_XCH_RT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT O.TML_SO_OFC_CTY_CD, O.TML_SO_SEQ, O.TML_SO_DTL_SEQ," ).append("\n"); 
		query.append("O.VSL_CD, O.SKD_VOY_NO, O.SKD_DIR_CD, O.IO_BND_CD," ).append("\n"); 
		query.append("O.VVD, O.LGS_COST_CD, O.INV_AMT, O.VVD_TYPE," ).append("\n"); 
		query.append("0 CNTR_QTY_SUM," ).append("\n"); 
		query.append("O.ATB_DT, O.CNTR_TPSZ_CD, O.FM_TR_VOL_VAL, O.TO_TR_VOL_VAL," ).append("\n"); 
		query.append("O.DCGO_IND_CD, O.VOL_TR_UT_CD, O.INV_XCH_RT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT A.TML_SO_OFC_CTY_CD, A.TML_SO_SEQ, A.TML_SO_DTL_SEQ," ).append("\n"); 
		query.append("A.VSL_CD, A.SKD_VOY_NO, A.SKD_DIR_CD, A.IO_BND_CD," ).append("\n"); 
		query.append("A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD," ).append("\n"); 
		query.append("A.LGS_COST_CD, A.INV_AMT, 'Input' VVD_TYPE," ).append("\n"); 
		query.append("A.ATB_DT, A.CNTR_TPSZ_CD, A.FM_TR_VOL_VAL, A.TO_TR_VOL_VAL," ).append("\n"); 
		query.append("A.DCGO_IND_CD, A.VOL_TR_UT_CD, A.INV_XCH_RT" ).append("\n"); 
		query.append("FROM TES_TML_SO_DTL A, TES_TML_SO_COST B" ).append("\n"); 
		query.append("WHERE A.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND A.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("AND A.CALC_COST_GRP_CD = 'TM'" ).append("\n"); 
		query.append("AND A.CALC_TP_CD = 'M'" ).append("\n"); 
		query.append("AND A.LGS_COST_CD IN ('SVALFL','SVOSOT','SVTLLS')" ).append("\n"); 
		query.append("AND A.VSL_CD = @[vvd_vsl_cd]" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = @[vvd_skd_voy_no]" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = @[vvd_skd_dir_cd]" ).append("\n"); 
		query.append("AND A.LGS_COST_CD = B.LGS_COST_CD" ).append("\n"); 
		query.append("AND B.MRN_TML_FLG = 'Y'" ).append("\n"); 
		query.append("AND B.COST_CALC_MZD_CD = 'M'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT A.TML_SO_OFC_CTY_CD, A.TML_SO_SEQ, A.TML_SO_DTL_SEQ, A.VSL_CD," ).append("\n"); 
		query.append("-- vessel port에서 가져온 항차가 Null이 아니면 ( 그럴일은 없겠지만 예방차원에서 로직 추가 )" ).append("\n"); 
		query.append("#if (${vvd_skd_voy_no2} != '')" ).append("\n"); 
		query.append("@[vvd_skd_voy_no2]," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("A.SKD_VOY_NO," ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("DECODE(A.SKD_DIR_CD,'E','W','W','E','S','N','N','S') SKD_DIR_CD," ).append("\n"); 
		query.append("DECODE(A.IO_BND_CD,'I','O','O','I') IO_BND_CD," ).append("\n"); 
		query.append("A.VSL_CD||" ).append("\n"); 
		query.append("-- vessel port에서 가져온 항차가 Null이 아니면 ( 그럴일은 없겠지만 예방차원에서 로직 추가 )" ).append("\n"); 
		query.append("#if (${vvd_skd_voy_no2} != '')" ).append("\n"); 
		query.append("@[vvd_skd_voy_no2]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("A.SKD_VOY_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("||DECODE(A.SKD_DIR_CD,'E','W','W','E','S','N','N','S') VVD," ).append("\n"); 
		query.append("A.LGS_COST_CD, A.INV_AMT, 'Allocate' VVD_TYPE," ).append("\n"); 
		query.append("A.ATB_DT, A.CNTR_TPSZ_CD, A.FM_TR_VOL_VAL, A.TO_TR_VOL_VAL," ).append("\n"); 
		query.append("A.DCGO_IND_CD, A.VOL_TR_UT_CD, A.INV_XCH_RT" ).append("\n"); 
		query.append("FROM TES_TML_SO_DTL A, TES_TML_SO_COST B" ).append("\n"); 
		query.append("WHERE A.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND A.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("AND A.CALC_COST_GRP_CD = 'TM'" ).append("\n"); 
		query.append("AND A.CALC_TP_CD = 'M'" ).append("\n"); 
		query.append("AND A.LGS_COST_CD IN ('SVALFL','SVOSOT','SVTLLS')" ).append("\n"); 
		query.append("AND A.VSL_CD = @[vvd_vsl_cd]" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = @[vvd_skd_voy_no]" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = @[vvd_skd_dir_cd]" ).append("\n"); 
		query.append("AND A.LGS_COST_CD = B.LGS_COST_CD" ).append("\n"); 
		query.append("AND B.MRN_TML_FLG = 'Y'" ).append("\n"); 
		query.append("AND B.COST_CALC_MZD_CD = 'M'  ) O" ).append("\n"); 
		query.append("GROUP BY O.TML_SO_OFC_CTY_CD, O.TML_SO_SEQ, O.TML_SO_DTL_SEQ," ).append("\n"); 
		query.append("O.VSL_CD, O.SKD_VOY_NO, O.SKD_DIR_CD, O.IO_BND_CD," ).append("\n"); 
		query.append("O.VVD, O.LGS_COST_CD, O.INV_AMT, O.VVD_TYPE," ).append("\n"); 
		query.append("O.ATB_DT, O.CNTR_TPSZ_CD, O.FM_TR_VOL_VAL, O.TO_TR_VOL_VAL," ).append("\n"); 
		query.append("O.DCGO_IND_CD, O.VOL_TR_UT_CD, O.INV_XCH_RT ) T ) F" ).append("\n"); 
		query.append("ORDER BY F.TML_SO_OFC_CTY_CD, F.TML_SO_SEQ, F.TML_SO_DTL_SEQ , VVD_TYPE DESC" ).append("\n"); 

	}
}
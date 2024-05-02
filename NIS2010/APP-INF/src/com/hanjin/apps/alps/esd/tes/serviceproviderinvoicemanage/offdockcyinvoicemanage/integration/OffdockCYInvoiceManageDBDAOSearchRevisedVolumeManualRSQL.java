/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : OffdockCYInvoiceManageDBDAOSearchRevisedVolumeManualRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.07
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OffdockCYInvoiceManageDBDAOSearchRevisedVolumeManualRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchRevisedVolumeManual
	  * 
	  * * 2011.08.08 윤태승 [CHM-201111118-1] MR Invoice Creation & Correction 의 Manual input 보완
	  * </pre>
	  */
	public OffdockCYInvoiceManageDBDAOSearchRevisedVolumeManualRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("param_lgs_cost_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration").append("\n"); 
		query.append("FileName : OffdockCYInvoiceManageDBDAOSearchRevisedVolumeManualRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	R.TML_SO_OFC_CTY_CD,                                           " ).append("\n"); 
		query.append("	R.TML_SO_SEQ,                                                  " ).append("\n"); 
		query.append("	R.TML_SO_DTL_SEQ,                                              " ).append("\n"); 
		query.append("	R.TML_SO_RVIS_LIST_SEQ,                                        " ).append("\n"); 
		query.append("	R.TML_INV_TP_CD,                                               " ).append("\n"); 
		query.append("	R.CALC_COST_GRP_CD,                                            " ).append("\n"); 
		query.append("	R.TML_RVIS_TP_CD,                                              " ).append("\n"); 
		query.append("	R.LGS_COST_CD,                                                 " ).append("\n"); 
		query.append("	DECODE(R.RVIS_IND_FLG,'Y',1,0) TML_RVIS_IND_FLG,               " ).append("\n"); 
		query.append("	R.CNTR_NO,                                                     " ).append("\n"); 
		query.append("	R.CNTR_TPSZ_CD,                                                " ).append("\n"); 
		query.append("	R.CNTR_STY_CD,                                                 " ).append("\n"); 
		query.append("	R.RVIS_RMK CNTR_RMK," ).append("\n"); 
		query.append("	R.BKG_NO," ).append("\n"); 
		query.append("	D.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("	TO_CHAR(R.PLG_IN_DT,'YYYYMMDD HH24MI') PLUG_IN," ).append("\n"); 
		query.append("	TO_CHAR(R.PLG_OUT_DT,'YYYYMMDD HH24MI') PLUG_OUT," ).append("\n"); 
		query.append("	R.PLG_TERM_DYS PLUG_TERM," ).append("\n"); 
		query.append("	R.OTR_CRR_FLG" ).append("\n"); 
		query.append("FROM TES_TML_SO_HDR H, TES_TML_SO_DTL D, TES_TML_SO_RVIS_LIST R  " ).append("\n"); 
		query.append("WHERE 1=1                                                        " ).append("\n"); 
		query.append("AND H.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD                    " ).append("\n"); 
		query.append("AND H.TML_SO_SEQ        = D.TML_SO_SEQ                           " ).append("\n"); 
		query.append("AND D.TML_SO_OFC_CTY_CD = R.TML_SO_OFC_CTY_CD(+)                 " ).append("\n"); 
		query.append("AND D.TML_SO_SEQ        = R.TML_SO_SEQ(+)                        " ).append("\n"); 
		query.append("AND D.TML_SO_DTL_SEQ 	= R.TML_SO_DTL_SEQ(+)                      " ).append("\n"); 
		query.append("AND H.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]                               " ).append("\n"); 
		query.append("AND H.TML_SO_SEQ 	= @[tml_so_seq]" ).append("\n"); 
		query.append("AND D.TML_SO_DTL_SEQ 	= @[tml_so_dtl_seq]" ).append("\n"); 
		query.append("AND R.LGS_COST_CD 	= @[param_lgs_cost_cd]" ).append("\n"); 
		query.append("ORDER BY LGS_COST_CD ASC, CNTR_NO ASC" ).append("\n"); 

	}
}
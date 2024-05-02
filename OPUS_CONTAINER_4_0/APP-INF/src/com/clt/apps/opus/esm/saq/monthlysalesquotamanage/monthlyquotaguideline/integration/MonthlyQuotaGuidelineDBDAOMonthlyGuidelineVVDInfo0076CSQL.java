/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MonthlyQuotaGuidelineDBDAOMonthlyGuidelineVVDInfo0076CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 주선영
*@LastVersion : 1.0
* 2010.02.24 주선영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaguideline.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ju Sun Young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MonthlyQuotaGuidelineDBDAOMonthlyGuidelineVVDInfo0076CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SAQ_MON_TGT_VVD_ADJ Insert
	  * </pre>
	  */
	public MonthlyQuotaGuidelineDBDAOMonthlyGuidelineVVDInfo0076CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("year",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("target_grp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("version",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaguideline.integration").append("\n"); 
		query.append("FileName : MonthlyQuotaGuidelineDBDAOMonthlyGuidelineVVDInfo0076CSQL").append("\n"); 
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
		query.append("INSERT INTO SAQ_MON_TGT_VVD_ADJ (" ).append("\n"); 
		query.append("            BSE_YR              ,          " ).append("\n"); 
		query.append("            BSE_QTR_CD          ,          " ).append("\n"); 
		query.append("            GLINE_VER_NO        ,          " ).append("\n"); 
		query.append("            TRD_CD              ,          " ).append("\n"); 
		query.append("            RLANE_CD            ,          " ).append("\n"); 
		query.append("            DIR_CD              ,          " ).append("\n"); 
		query.append("            VSL_CD              ,          " ).append("\n"); 
		query.append("            SKD_VOY_NO          ,          " ).append("\n"); 
		query.append("            SKD_DIR_CD          ,          " ).append("\n"); 
		query.append("            SPRT_GRP_CD         ,          " ).append("\n"); 
		query.append("            BSA_GRP_CD          ,          " ).append("\n"); 
		query.append("            BSE_MON             ,          " ).append("\n"); 
		query.append("            BSE_WK              ,          " ).append("\n"); 
		query.append("            SUB_TRD_CD          ,          " ).append("\n"); 
		query.append("            IOC_CD              ,          " ).append("\n"); 
		query.append("            VVD_SEQ             ,          " ).append("\n"); 
		query.append("            FNL_BSA_CAPA        ,          " ).append("\n"); 
		query.append("            LST_LODG_PORT_ETD_DT,          " ).append("\n"); 
		query.append("            UPD_RMK             ,          " ).append("\n"); 
		query.append("            CRE_USR_ID          ,          " ).append("\n"); 
		query.append("            CRE_DT              ,          " ).append("\n"); 
		query.append("            UPD_USR_ID          ,          " ).append("\n"); 
		query.append("            UPD_DT              )          " ).append("\n"); 
		query.append("SELECT                           		" ).append("\n"); 
		query.append("            VVD.BSE_YR              ,          	" ).append("\n"); 
		query.append("            VVD.BSE_QTR_CD          ,          	" ).append("\n"); 
		query.append("            @[version] gline_ver_no ,          	" ).append("\n"); 
		query.append("            VVD.TRD_CD              ,          	" ).append("\n"); 
		query.append("            VVD.RLANE_CD            ,          	" ).append("\n"); 
		query.append("            NVL(DIR.CONV_DIR_CD, VVD.DIR_CD),  	" ).append("\n"); 
		query.append("            VVD.VSL_CD              ,          	" ).append("\n"); 
		query.append("            VVD.SKD_VOY_NO          ,          	" ).append("\n"); 
		query.append("            VVD.SKD_DIR_CD          ,          	" ).append("\n"); 
		query.append("            VVD.SPRT_GRP_CD         ,          	" ).append("\n"); 
		query.append("            VVD.BSA_GRP_CD          ,          	" ).append("\n"); 
		query.append("            VVD.BSE_MON             ,          	" ).append("\n"); 
		query.append("            VVD.BSE_WK              ,          	" ).append("\n"); 
		query.append("            VVD.SUB_TRD_CD          ,          	" ).append("\n"); 
		query.append("            VVD.IOC_CD              ,          	" ).append("\n"); 
		query.append("            VVD.VVD_SEQ             ,          	" ).append("\n"); 
		query.append("            VVD.FNL_BSA_CAPA        ,          	" ).append("\n"); 
		query.append("            VVD.LST_LODG_PORT_ETD_DT,          	" ).append("\n"); 
		query.append("            VVD.UPD_RMK             ,          	" ).append("\n"); 
		query.append("            @[user_id]              ,          	" ).append("\n"); 
		query.append("            SYSDATE                 ,          	" ).append("\n"); 
		query.append("            @[user_id]              ,          	" ).append("\n"); 
		query.append("            SYSDATE                           	" ).append("\n"); 
		query.append("FROM        SAQ_MON_TGT_VVD  VVD,          	" ).append("\n"); 
		query.append("            SAQ_MON_DIR_CONV DIR           	" ).append("\n"); 
		query.append("WHERE       VVD.BSE_YR      = @[year]          " ).append("\n"); 
		query.append("AND         VVD.BSE_QTR_CD  = @[bse_qtr_cd]    " ).append("\n"); 
		query.append("AND         VVD.BSE_YR      = DIR.BSE_YR(+)    " ).append("\n"); 
		query.append("AND         VVD.BSE_QTR_CD  = DIR.BSE_QTR_CD(+)" ).append("\n"); 
		query.append("AND         VVD.TRD_CD      = DIR.TRD_CD(+)    " ).append("\n"); 
		query.append("AND         VVD.RLANE_CD    = DIR.RLANE_CD(+)  " ).append("\n"); 
		query.append("AND         VVD.DIR_CD      = DIR.DIR_CD(+)    " ).append("\n"); 
		query.append("AND         VVD.DELT_FLG    = 'N'              " ).append("\n"); 
		query.append("AND         VVD.TRD_CD      IN ( SELECT TRD_CD              	" ).append("\n"); 
		query.append("                                  FROM  SAQ_TGT_GRP_TRD_V     	" ).append("\n"); 
		query.append("                                  WHERE SAQ_TGT_GRP_CD = @[target_grp] )" ).append("\n"); 

	}
}
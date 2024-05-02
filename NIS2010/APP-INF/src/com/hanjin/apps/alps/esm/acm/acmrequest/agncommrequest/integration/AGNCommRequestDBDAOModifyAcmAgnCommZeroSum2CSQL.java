/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AGNCommRequestDBDAOModifyAcmAgnCommZeroSum2CSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AGNCommRequestDBDAOModifyAcmAgnCommZeroSum2CSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ACM_AGN_COMM 테이블에서 Agreement 대상이 아닌 데이터를 업데이트한다.
	  * </pre>
	  */
	public AGNCommRequestDBDAOModifyAcmAgnCommZeroSum2CSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ac_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration").append("\n"); 
		query.append("FileName : AGNCommRequestDBDAOModifyAcmAgnCommZeroSum2CSQL").append("\n"); 
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
		query.append("INSERT INTO ACM_AGN_COMM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("  BKG_NO" ).append("\n"); 
		query.append(", AGN_CD" ).append("\n"); 
		query.append(", IO_BND_CD" ).append("\n"); 
		query.append(", AC_TP_CD" ).append("\n"); 
		query.append(", AC_SEQ" ).append("\n"); 
		query.append(", BDR_FLG" ).append("\n"); 
		query.append(", AC_STS_CD" ).append("\n"); 
		query.append(", PPD_AMT" ).append("\n"); 
		query.append(", CRNT_AMT" ).append("\n"); 
		query.append(", IF_AMT" ).append("\n"); 
		query.append(", CRNT_REV_AMT" ).append("\n"); 
		query.append(", DDCT_CHG_AMT" ).append("\n"); 
		query.append(", DDCT_TRSP_AMT" ).append("\n"); 
		query.append(", DDCT_SPCL_CMPN_AMT" ).append("\n"); 
		query.append(", DDCT_VIP_AMT" ).append("\n"); 
		query.append(", COMM_FX_AMT" ).append("\n"); 
		query.append(", REV_DIV_CD" ).append("\n"); 
		query.append(", COMM_RT" ).append("\n"); 
		query.append(", AGN_AGMT_NO" ).append("\n"); 
		query.append(", AGN_AGMT_SEQ" ).append("\n"); 
		query.append(", LOC_DIV_CD" ).append("\n"); 
		query.append(", LOC_CD" ).append("\n"); 
		query.append(", AR_OFC_CD" ).append("\n"); 
		query.append(", AP_OFC_CD" ).append("\n"); 
		query.append(", AP_CTR_CD" ).append("\n"); 
		query.append(", COMM_STND_COST_CD" ).append("\n"); 
		query.append(", SAIL_ARR_DT" ).append("\n"); 
		query.append(", AC_OCCR_INFO_CD" ).append("\n"); 
		query.append(", AC_SLAN_CD" ).append("\n"); 
		query.append(", AC_RLANE_CD" ).append("\n"); 
		query.append(", AC_VSL_CD" ).append("\n"); 
		query.append(", AC_SKD_VOY_NO" ).append("\n"); 
		query.append(", AC_SKD_DIR_CD" ).append("\n"); 
		query.append(", AC_REV_DIR_CD" ).append("\n"); 
		query.append(", CURR_CD" ).append("\n"); 
		query.append(", XCH_RT_APLY_LVL" ).append("\n"); 
		query.append(", PAY_XCH_RT" ).append("\n"); 
		query.append(", PAY_PPD_AMT" ).append("\n"); 
		query.append(", PAY_CRNT_AMT" ).append("\n"); 
		query.append(", PAY_IF_AMT" ).append("\n"); 
		query.append(", OFC_CHR_CD" ).append("\n"); 
		query.append(", VNDR_CNT_CD" ).append("\n"); 
		query.append(", VNDR_SEQ" ).append("\n"); 
		query.append(", ACCL_FLG" ).append("\n"); 
		query.append(", AC_PROC_DESC" ).append("\n"); 
		query.append(", PPD_OFRT_AMT" ).append("\n"); 
		query.append(", PPD_CHG_AMT" ).append("\n"); 
		query.append(", CLT_OFRT_AMT" ).append("\n"); 
		query.append(", CLT_CHG_AMT" ).append("\n"); 
		query.append(", AGN_INFO_SEQ" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append(" CRNT.BKG_NO" ).append("\n"); 
		query.append(",CRNT.AGN_CD" ).append("\n"); 
		query.append(",CRNT.IO_BND_CD" ).append("\n"); 
		query.append(",CRNT.AC_TP_CD" ).append("\n"); 
		query.append(",NEXT_AC_SEQ    AS AC_SEQ" ).append("\n"); 
		query.append(",CRNT.BDR_FLG" ).append("\n"); 
		query.append(",'CS'           AS AC_STS_CD" ).append("\n"); 
		query.append(",CANCEL_AMT     AS PPD_AMT" ).append("\n"); 
		query.append(",0              AS CRNT_AMT" ).append("\n"); 
		query.append(",0 - CANCEL_AMT AS IF_AMT" ).append("\n"); 
		query.append(",CRNT.CRNT_REV_AMT" ).append("\n"); 
		query.append(",CRNT.DDCT_CHG_AMT" ).append("\n"); 
		query.append(",CRNT.DDCT_TRSP_AMT" ).append("\n"); 
		query.append(",CRNT.DDCT_SPCL_CMPN_AMT" ).append("\n"); 
		query.append(",CRNT.DDCT_VIP_AMT" ).append("\n"); 
		query.append(",CRNT.COMM_FX_AMT" ).append("\n"); 
		query.append(",CRNT.REV_DIV_CD" ).append("\n"); 
		query.append(",CRNT.COMM_RT" ).append("\n"); 
		query.append(",CRNT.AGN_AGMT_NO" ).append("\n"); 
		query.append(",CRNT.AGN_AGMT_SEQ" ).append("\n"); 
		query.append(",CRNT.LOC_DIV_CD" ).append("\n"); 
		query.append(",CRNT.LOC_CD" ).append("\n"); 
		query.append(",CRNT.AR_OFC_CD" ).append("\n"); 
		query.append(",CRNT.AP_OFC_CD" ).append("\n"); 
		query.append(",CRNT.AP_CTR_CD" ).append("\n"); 
		query.append(",CRNT.COMM_STND_COST_CD" ).append("\n"); 
		query.append(",CRNT.SAIL_ARR_DT" ).append("\n"); 
		query.append(",CRNT.AC_OCCR_INFO_CD" ).append("\n"); 
		query.append(",CRNT.AC_SLAN_CD" ).append("\n"); 
		query.append(",CRNT.AC_RLANE_CD" ).append("\n"); 
		query.append(",CRNT.AC_VSL_CD" ).append("\n"); 
		query.append(",CRNT.AC_SKD_VOY_NO" ).append("\n"); 
		query.append(",CRNT.AC_SKD_DIR_CD" ).append("\n"); 
		query.append(",CRNT.AC_REV_DIR_CD" ).append("\n"); 
		query.append(",CRNT.CURR_CD" ).append("\n"); 
		query.append(",CRNT.XCH_RT_APLY_LVL" ).append("\n"); 
		query.append(",CRNT.PAY_XCH_RT" ).append("\n"); 
		query.append(",CANCEL_PAY_AMT       AS PAY_PPD_AMT" ).append("\n"); 
		query.append(",0                    AS PAY_CRNT_AMT" ).append("\n"); 
		query.append(",0 - CANCEL_PAY_AMT   AS PAY_IF_AMT" ).append("\n"); 
		query.append(",CRNT.OFC_CHR_CD" ).append("\n"); 
		query.append(",CRNT.VNDR_CNT_CD" ).append("\n"); 
		query.append(",CRNT.VNDR_SEQ" ).append("\n"); 
		query.append(",CRNT.ACCL_FLG" ).append("\n"); 
		query.append(",CRNT.AC_PROC_DESC" ).append("\n"); 
		query.append(",CRNT.PPD_OFRT_AMT" ).append("\n"); 
		query.append(",CRNT.PPD_CHG_AMT" ).append("\n"); 
		query.append(",CRNT.CLT_OFRT_AMT" ).append("\n"); 
		query.append(",CRNT.CLT_CHG_AMT" ).append("\n"); 
		query.append(",CRNT.AGN_INFO_SEQ" ).append("\n"); 
		query.append(",@[usr_id] AS CRE_USR_ID" ).append("\n"); 
		query.append(",SYSDATE AS CRE_DT" ).append("\n"); 
		query.append(",@[usr_id] AS UPD_USR_ID" ).append("\n"); 
		query.append(",SYSDATE AS UPD_DT" ).append("\n"); 
		query.append("FROM ACM_AGN_COMM CRNT,(" ).append("\n"); 
		query.append("    SELECT" ).append("\n"); 
		query.append("        BKG_NO,AGN_CD,IO_BND_CD,AC_TP_CD," ).append("\n"); 
		query.append("        NVL (MAX (C.AC_SEQ), 0) + 1  AS NEXT_AC_SEQ ," ).append("\n"); 
		query.append("        SUM (C.IF_AMT) AS CANCEL_AMT, SUM (C.PAY_IF_AMT) AS CANCEL_PAY_AMT" ).append("\n"); 
		query.append("    FROM ACM_AGN_COMM C" ).append("\n"); 
		query.append("    WHERE C.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	  AND C.AGN_CD = @[agn_cd]" ).append("\n"); 
		query.append("	  AND C.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("	  AND C.AC_TP_CD = @[ac_tp_cd]" ).append("\n"); 
		query.append("      AND C.AC_STS_CD IN ( 'RS','AS','PS','IF' ) " ).append("\n"); 
		query.append("    GROUP BY C.BKG_NO, C.AGN_CD, C.IO_BND_CD, C.AC_TP_CD " ).append("\n"); 
		query.append("    HAVING 0 <> SUM (C.IF_AMT) " ).append("\n"); 
		query.append(")PPD" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND CRNT.BKG_NO    = PPD.BKG_NO " ).append("\n"); 
		query.append("AND CRNT.AGN_CD    = PPD.AGN_CD " ).append("\n"); 
		query.append("AND CRNT.IO_BND_CD = PPD.IO_BND_CD " ).append("\n"); 
		query.append("AND CRNT.AC_TP_CD  = PPD.AC_TP_CD " ).append("\n"); 
		query.append("AND CRNT.AC_SEQ    = PPD.NEXT_AC_SEQ - 1 " ).append("\n"); 
		query.append("AND CRNT.AC_STS_CD IN ( 'RS','AS','PS','IF' )" ).append("\n"); 

	}
}
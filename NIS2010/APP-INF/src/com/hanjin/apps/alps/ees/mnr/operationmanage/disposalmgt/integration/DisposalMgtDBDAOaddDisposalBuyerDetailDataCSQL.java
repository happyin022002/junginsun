/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DisposalMgtDBDAOaddDisposalBuyerDetailDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.10
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.01.10 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOaddDisposalBuyerDetailDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addDisposalBuyerDetailData
	  * </pre>
	  */
	public DisposalMgtDBDAOaddDisposalBuyerDetailDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_cfm_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_disp_dtl_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_disp_cfm_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_prnr_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mnr_disp_cfm_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("part_ut_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vndr_bid_tms",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOaddDisposalBuyerDetailDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_DISP_BUYR_DTL_PART(" ).append("\n"); 
		query.append("         DISP_NO" ).append("\n"); 
		query.append("        ,DISP_DTL_SEQ" ).append("\n"); 
		query.append("        ,MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("        ,MNR_PRNR_SEQ" ).append("\n"); 
		query.append("		,EQ_TPSZ_CD" ).append("\n"); 
		query.append("        ,DISP_QTY" ).append("\n"); 
		query.append("        ,DISP_CFM_QTY" ).append("\n"); 
		query.append("        ,PART_UT_AMT" ).append("\n"); 
		query.append("        ,MNR_DISP_CFM_STS_CD" ).append("\n"); 
		query.append("        ,MNR_DISP_CFM_DT" ).append("\n"); 
		query.append("        ,MNR_DISP_CFM_USR_ID" ).append("\n"); 
		query.append("        ,MNR_DISP_DTL_RMK" ).append("\n"); 
		query.append("        ,VNDR_BID_TMS" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("        ,UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("            @[disp_no]" ).append("\n"); 
		query.append("           ,@[disp_dtl_seq]" ).append("\n"); 
		query.append("           ,@[mnr_prnr_cnt_cd]" ).append("\n"); 
		query.append("           ,TO_NUMBER(@[mnr_prnr_seq])" ).append("\n"); 
		query.append("		   ,@[eq_tpsz_cd]" ).append("\n"); 
		query.append("           ,@[disp_qty]" ).append("\n"); 
		query.append("           ,@[disp_cfm_qty]" ).append("\n"); 
		query.append("           ,@[part_ut_amt]" ).append("\n"); 
		query.append("           ,DECODE(@[mnr_disp_cfm_sts_cd],'1','C','N')" ).append("\n"); 
		query.append("           ,sysdate" ).append("\n"); 
		query.append("           ,@[mnr_disp_cfm_usr_id]" ).append("\n"); 
		query.append("           ,@[mnr_disp_dtl_rmk]" ).append("\n"); 
		query.append("           ,TO_TIMESTAMP(SUBSTR(@[vndr_bid_tms], 1, 14)||'.'||SUBSTR(@[vndr_bid_tms], -3),'YYYY-MM-DD HH24:MI:SS FF3')" ).append("\n"); 
		query.append("           ,@[cre_usr_id]" ).append("\n"); 
		query.append("           ,sysdate" ).append("\n"); 
		query.append("           ,@[upd_usr_id]" ).append("\n"); 
		query.append("           ,sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
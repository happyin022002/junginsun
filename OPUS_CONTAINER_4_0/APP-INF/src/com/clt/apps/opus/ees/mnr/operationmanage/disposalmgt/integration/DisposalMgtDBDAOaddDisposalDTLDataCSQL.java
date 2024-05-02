/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DisposalMgtDBDAOaddDisposalDTLDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.12
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOaddDisposalDTLDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addDisposalDTLData
	  * </pre>
	  */
	public DisposalMgtDBDAOaddDisposalDTLDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_trkr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_ut_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_trf_ut_prc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("disp_rlse_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_sold_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("disp_vrfy_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_ut_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inv_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("file_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rcv_inv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOaddDisposalDTLDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_DISP_DTL(" ).append("\n"); 
		query.append("         DISP_NO" ).append("\n"); 
		query.append("        ,DISP_DTL_SEQ" ).append("\n"); 
		query.append("        ,DISP_UT_TP_CD" ).append("\n"); 
		query.append("        ,EQ_NO" ).append("\n"); 
		query.append("        ,EQ_TPSZ_CD" ).append("\n"); 
		query.append("        ,DISP_YD_CD" ).append("\n"); 
		query.append("        ,DISP_QTY" ).append("\n"); 
		query.append("        ,DISP_SOLD_DT" ).append("\n"); 
		query.append("        ,DISP_TRKR_NM" ).append("\n"); 
		query.append("        ,DISP_RLSE_NO" ).append("\n"); 
		query.append("        ,DISP_UT_PRC" ).append("\n"); 
		query.append("        ,DISP_RSN_CD" ).append("\n"); 
		query.append("        ,PART_AMT" ).append("\n"); 
		query.append("        ,INV_AMT" ).append("\n"); 
		query.append("        ,FILE_SEQ" ).append("\n"); 
		query.append("        ,RCV_INV_SEQ" ).append("\n"); 
		query.append("        ,MNR_DISP_DTL_RMK" ).append("\n"); 
		query.append("        ,MNR_PRNR_CNT_CD" ).append("\n"); 
		query.append("        ,MNR_PRNR_SEQ" ).append("\n"); 
		query.append("		,DISP_TRF_UT_PRC" ).append("\n"); 
		query.append("		,DISP_VRFY_TP_CD" ).append("\n"); 
		query.append("        ,CRE_USR_ID" ).append("\n"); 
		query.append("        ,CRE_DT" ).append("\n"); 
		query.append("        ,UPD_USR_ID" ).append("\n"); 
		query.append("        ,UPD_DT" ).append("\n"); 
		query.append("        ,CHG_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("            @[disp_no]" ).append("\n"); 
		query.append("           ,@[disp_dtl_seq]" ).append("\n"); 
		query.append("           ,@[disp_ut_tp_cd]" ).append("\n"); 
		query.append("           ,@[eq_no]" ).append("\n"); 
		query.append("           ,@[eq_tpsz_cd]" ).append("\n"); 
		query.append("           ,@[disp_yd_cd]" ).append("\n"); 
		query.append("           ,@[disp_qty]" ).append("\n"); 
		query.append("           ,TO_DATE(@[disp_sold_dt], 'yyyy-mm-dd')" ).append("\n"); 
		query.append("           ,@[disp_trkr_nm]" ).append("\n"); 
		query.append("           ,@[disp_rlse_no]" ).append("\n"); 
		query.append("           ,@[disp_ut_prc]" ).append("\n"); 
		query.append("           ,@[disp_rsn_cd]" ).append("\n"); 
		query.append("           ,@[disp_qty] * @[disp_ut_prc]" ).append("\n"); 
		query.append("           ,@[inv_amt]" ).append("\n"); 
		query.append("           ,@[file_seq]" ).append("\n"); 
		query.append("           ,@[rcv_inv_seq]" ).append("\n"); 
		query.append("           ,@[mnr_disp_dtl_rmk]" ).append("\n"); 
		query.append("           ,@[mnr_prnr_cnt_cd]" ).append("\n"); 
		query.append("           ,TO_NUMBER(@[mnr_prnr_seq])" ).append("\n"); 
		query.append("		   ,@[disp_trf_ut_prc] " ).append("\n"); 
		query.append("		   ,@[disp_vrfy_tp_cd]" ).append("\n"); 
		query.append("           ,@[cre_usr_id]" ).append("\n"); 
		query.append("           ,sysdate" ).append("\n"); 
		query.append("           ,@[upd_usr_id]" ).append("\n"); 
		query.append("           ,sysdate" ).append("\n"); 
		query.append("           ,(SELECT CASE WHEN (SELECT EQ_TYPE FROM MNR_EQ_STS_V WHERE EQ_NO = @[eq_no]) <> 'U' THEN 'EQS' " ).append("\n"); 
		query.append("                        WHEN (SELECT LSTM_CD FROM MNR_EQ_STS_V WHERE EQ_NO = @[eq_no]) <> 'OW' THEN 'EQD'" ).append("\n"); 
		query.append("                        WHEN (SELECT DISTINCT 'X' FROM MNR_TTL_LSS_RQST_HDR A, MNR_TTL_LSS_RQST_DTL B" ).append("\n"); 
		query.append("                               WHERE A.TTL_LSS_NO = B.TTL_LSS_NO" ).append("\n"); 
		query.append("                                 AND B.RQST_EQ_NO = @[eq_no]" ).append("\n"); 
		query.append("                                 AND A.TTL_LSS_STS_CD IN ('HA', 'HC', 'HE')) = 'X' THEN 'EQD'" ).append("\n"); 
		query.append("                        WHEN INSTR(MST_COMMON_PKG.MST_RU_TP_GET_FNC(@[eq_no]), 'ASSET') > 0 AND (SELECT RSTR_USG_TP_LBL_NM8 FROM MST_CONTAINER WHERE CNTR_NO = @[eq_no]) IN ('FA', 'PSD') THEN 'EQS'" ).append("\n"); 
		query.append("                        WHEN INSTR(MST_COMMON_PKG.MST_RU_TP_GET_FNC(@[eq_no]), 'ASSET') > 0 AND (SELECT RSTR_USG_TP_LBL_NM8 FROM MST_CONTAINER WHERE CNTR_NO = @[eq_no]) = 'CA' THEN 'EQC'" ).append("\n"); 
		query.append("                      ELSE 'ERR' END " ).append("\n"); 
		query.append("               FROM DUAL)" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
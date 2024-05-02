/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationBLDBDAOBkgBlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.24
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.24 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOBkgBlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update
	  * </pre>
	  */
	public BLDocumentationBLDBDAOBkgBlUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_wgt_prn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_meas_prn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_pck_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cmdt_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_pay_ofc_prn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mf_desc_prn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_qty_prn_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_cmdt_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_wgt_prn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mk_desc_prn_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOBkgBlUSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("UPDATE BKG_BL_DOC_HIS" ).append("\n"); 
		query.append("SET    TTL_PCK_DESC      = @[ttl_pck_desc]" ).append("\n"); 
		query.append(",      CSTMS_DESC        = @[cstms_desc]" ).append("\n"); 
		query.append(",      PCK_CMDT_DESC     = @[pck_cmdt_desc]" ).append("\n"); 
		query.append(",      CNTR_CMDT_DESC    = @[cntr_cmdt_desc]" ).append("\n"); 
		query.append(",      PCK_QTY           = @[pck_qty]" ).append("\n"); 
		query.append(",      PCK_TP_CD         = @[pck_tp_cd]" ).append("\n"); 
		query.append(",      MEAS_QTY          = @[meas_qty]" ).append("\n"); 
		query.append(",      MEAS_UT_CD        = @[meas_ut_cd]" ).append("\n"); 
		query.append(",      ACT_WGT           = @[act_wgt]" ).append("\n"); 
		query.append(",      WGT_UT_CD         = @[wgt_ut_cd]" ).append("\n"); 
		query.append(",      ACT_WGT_PRN_FLG   = DECODE (NVL(@[act_wgt_prn_flg],'Y'), 'N', 'N', 'Y')" ).append("\n"); 
		query.append(",	   MEAS_QTY_PRN_FLG  = DECODE (NVL(@[meas_qty_prn_flg],'Y'), 'N', 'N', 'Y')" ).append("\n"); 
		query.append(",      CNTR_WGT_PRN_FLG  = DECODE (NVL(@[cntr_wgt_prn_flg],'Y'), 'N', 'N', 'Y')" ).append("\n"); 
		query.append(",	   CNTR_MEAS_PRN_FLG = DECODE (NVL(@[cntr_meas_prn_flg],'Y'), 'N', 'N', 'Y')" ).append("\n"); 
		query.append(",	   FRT_PAY_OFC_PRN_FLG = CASE WHEN @[frt_pay_ofc_prn_flg] IS NULL THEN FRT_PAY_OFC_PRN_FLG" ).append("\n"); 
		query.append("                                  ELSE @[frt_pay_ofc_prn_flg] END" ).append("\n"); 
		query.append(",	   MK_DESC_PRN_FLG = CASE WHEN @[mk_desc_prn_flg] IS NULL THEN MK_DESC_PRN_FLG " ).append("\n"); 
		query.append("							  ELSE @[mk_desc_prn_flg] END" ).append("\n"); 
		query.append(",	   MF_DESC_PRN_FLG = CASE WHEN @[mf_desc_prn_flg] IS NULL THEN MF_DESC_PRN_FLG " ).append("\n"); 
		query.append("							  ELSE @[mf_desc_prn_flg] END" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    CORR_NO='TMP0000001'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("UPDATE BKG_BL_DOC" ).append("\n"); 
		query.append("SET    TTL_PCK_DESC      = @[ttl_pck_desc]" ).append("\n"); 
		query.append(",      CSTMS_DESC        = @[cstms_desc]" ).append("\n"); 
		query.append(",      PCK_CMDT_DESC     = @[pck_cmdt_desc]" ).append("\n"); 
		query.append(",      CNTR_CMDT_DESC    = @[cntr_cmdt_desc]" ).append("\n"); 
		query.append(",      PCK_QTY           = @[pck_qty]" ).append("\n"); 
		query.append(",      PCK_TP_CD         = @[pck_tp_cd]" ).append("\n"); 
		query.append(",      MEAS_QTY          = @[meas_qty]" ).append("\n"); 
		query.append(",      MEAS_UT_CD        = @[meas_ut_cd]" ).append("\n"); 
		query.append(",      ACT_WGT           = @[act_wgt]" ).append("\n"); 
		query.append(",      WGT_UT_CD         = @[wgt_ut_cd]" ).append("\n"); 
		query.append(",      ACT_WGT_PRN_FLG   = DECODE (NVL(@[act_wgt_prn_flg],'Y'), 'N', 'N', 'Y')" ).append("\n"); 
		query.append(",	   MEAS_QTY_PRN_FLG  = DECODE (NVL(@[meas_qty_prn_flg],'Y'), 'N', 'N', 'Y')" ).append("\n"); 
		query.append(",      CNTR_WGT_PRN_FLG  = DECODE (NVL(@[cntr_wgt_prn_flg],'Y'), 'N', 'N', 'Y')" ).append("\n"); 
		query.append(",	   CNTR_MEAS_PRN_FLG = DECODE (NVL(@[cntr_meas_prn_flg],'Y'), 'N', 'N', 'Y')" ).append("\n"); 
		query.append(",	   FRT_PAY_OFC_PRN_FLG = CASE WHEN @[frt_pay_ofc_prn_flg] IS NULL THEN FRT_PAY_OFC_PRN_FLG" ).append("\n"); 
		query.append("                                  ELSE @[frt_pay_ofc_prn_flg] END" ).append("\n"); 
		query.append(",	   MK_DESC_PRN_FLG = CASE WHEN @[mk_desc_prn_flg] IS NULL THEN MK_DESC_PRN_FLG " ).append("\n"); 
		query.append("							  ELSE @[mk_desc_prn_flg] END" ).append("\n"); 
		query.append(",	   MF_DESC_PRN_FLG = CASE WHEN @[mf_desc_prn_flg] IS NULL THEN MF_DESC_PRN_FLG " ).append("\n"); 
		query.append("							  ELSE @[mf_desc_prn_flg] END" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
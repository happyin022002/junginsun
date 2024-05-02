/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOCmVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.08
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOCmVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    insert
	  * </pre>
	  */
	public BLDocumentationCMDBDAOCmVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hamo_trf_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("dcgo_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hs_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hngr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mf_gds_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pck_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ncm_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wpm_trt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mf_mk_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mf_wgt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("meas_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cntr_mf_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOCmVOCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CNTR_MF_DESC_HIS (" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append(",   CORR_NO" ).append("\n"); 
		query.append(",	CNTR_MF_SEQ" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	CMDT_HS_CD" ).append("\n"); 
		query.append(",	PCK_QTY" ).append("\n"); 
		query.append(",	PCK_TP_CD" ).append("\n"); 
		query.append(",	CNTR_MF_WGT" ).append("\n"); 
		query.append(",	WGT_UT_CD" ).append("\n"); 
		query.append(",	MEAS_QTY" ).append("\n"); 
		query.append(",	MEAS_UT_CD" ).append("\n"); 
		query.append(",	DCGO_FLG" ).append("\n"); 
		query.append(",	BB_CGO_FLG" ).append("\n"); 
		query.append(",	AWK_CGO_FLG" ).append("\n"); 
		query.append(",	RC_FLG" ).append("\n"); 
		query.append(",	RD_CGO_FLG" ).append("\n"); 
		query.append(",	HNGR_FLG" ).append("\n"); 
		query.append(",	CNTR_MF_MK_DESC" ).append("\n"); 
		query.append(",	CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append(",	HBL_SEQ" ).append("\n"); 
		query.append(",	HAMO_TRF_CD" ).append("\n"); 
		query.append(",	NCM_NO" ).append("\n"); 
		query.append(",	PO_NO" ).append("\n"); 
		query.append(",	CNTR_MF_NO" ).append("\n"); 
		query.append(",	CSTMS_DECL_NO" ).append("\n"); 
		query.append(",	DCGO_SEQ" ).append("\n"); 
		query.append(",   WPM_TRT_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES( @[bkg_no]" ).append("\n"); 
		query.append(",   'TMP0000001'" ).append("\n"); 
		query.append(",	(NVL((SELECT max(CNTR_MF_SEQ) FROM BKG_CNTR_MF_DESC_HIS WHERE BKG_NO=@[bkg_no] AND CNTR_NO=@[cntr_no]),0)+1)" ).append("\n"); 
		query.append(",	@[cntr_no]" ).append("\n"); 
		query.append(",	@[cmdt_hs_cd]" ).append("\n"); 
		query.append(",	@[pck_qty]" ).append("\n"); 
		query.append(",	@[pck_tp_cd]" ).append("\n"); 
		query.append(",	@[cntr_mf_wgt]" ).append("\n"); 
		query.append(",	NVL(@[wgt_ut_cd],(" ).append("\n"); 
		query.append("        SELECT WGT_UT_CD" ).append("\n"); 
		query.append("        FROM   BKG_CONTAINER" ).append("\n"); 
		query.append("        WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND    CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("    ))" ).append("\n"); 
		query.append(",	@[meas_qty]" ).append("\n"); 
		query.append(",	NVL(@[meas_ut_cd],(" ).append("\n"); 
		query.append("        SELECT MEAS_UT_CD" ).append("\n"); 
		query.append("        FROM   BKG_CONTAINER" ).append("\n"); 
		query.append("        WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND    CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("    ))" ).append("\n"); 
		query.append(",	DECODE(@[dcgo_flg], '1', 'Y', 'N')" ).append("\n"); 
		query.append(",	NVL((SELECT BB_CGO_FLG FROM BKG_CNTR_HIS WHERE BKG_NO = @[bkg_no] AND CNTR_NO = @[cntr_no] AND CORR_NO = 'TMP0000001'), 'N')" ).append("\n"); 
		query.append(",	DECODE(@[awk_cgo_flg], '1', 'Y', 'N')" ).append("\n"); 
		query.append(",	NVL((SELECT RC_FLG 	   FROM BKG_CNTR_HIS WHERE BKG_NO = @[bkg_no] AND CNTR_NO = @[cntr_no] AND CORR_NO = 'TMP0000001'), 'N')" ).append("\n"); 
		query.append(",	NVL((SELECT RD_CGO_FLG FROM BKG_CNTR_HIS WHERE BKG_NO = @[bkg_no] AND CNTR_NO = @[cntr_no] AND CORR_NO = 'TMP0000001'), 'N')" ).append("\n"); 
		query.append(",	DECODE(@[hngr_flg], '1', 'Y', 'N')" ).append("\n"); 
		query.append(",   REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(@[cntr_mf_mk_desc], chr(13)||chr(10), '▤') , chr(10),''), chr(13), '▤'), chr(9), ' '), '▤' ,chr(13)||chr(10))" ).append("\n"); 
		query.append(",	REGEXP_REPLACE(REGEXP_REPLACE(@[cntr_mf_gds_desc], '[[:space:]]', ' '), '( ){2,}', ' ')" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	@[hamo_trf_cd]" ).append("\n"); 
		query.append(",	@[ncm_no]" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	@[cntr_mf_no]" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	@[dcgo_seq]" ).append("\n"); 
		query.append(",   DECODE(@[wpm_trt_cd],'N/A','A',@[wpm_trt_cd])" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("INSERT INTO BKG_CNTR_MF_DESC (" ).append("\n"); 
		query.append("	BKG_NO" ).append("\n"); 
		query.append(",	CNTR_MF_SEQ" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	CMDT_HS_CD" ).append("\n"); 
		query.append(",	PCK_QTY" ).append("\n"); 
		query.append(",	PCK_TP_CD" ).append("\n"); 
		query.append(",	CNTR_MF_WGT" ).append("\n"); 
		query.append(",	WGT_UT_CD" ).append("\n"); 
		query.append(",	MEAS_QTY" ).append("\n"); 
		query.append(",	MEAS_UT_CD" ).append("\n"); 
		query.append(",	DCGO_FLG" ).append("\n"); 
		query.append(",	BB_CGO_FLG" ).append("\n"); 
		query.append(",	AWK_CGO_FLG" ).append("\n"); 
		query.append(",	RC_FLG" ).append("\n"); 
		query.append(",	RD_CGO_FLG" ).append("\n"); 
		query.append(",	HNGR_FLG" ).append("\n"); 
		query.append(",	CNTR_MF_MK_DESC" ).append("\n"); 
		query.append(",	CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append(",	HBL_SEQ" ).append("\n"); 
		query.append(",	HAMO_TRF_CD" ).append("\n"); 
		query.append(",	NCM_NO" ).append("\n"); 
		query.append(",	PO_NO" ).append("\n"); 
		query.append(",	CNTR_MF_NO" ).append("\n"); 
		query.append(",	CSTMS_DECL_NO" ).append("\n"); 
		query.append(",	DCGO_SEQ" ).append("\n"); 
		query.append(",   WPM_TRT_CD" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES( @[bkg_no]" ).append("\n"); 
		query.append(",	(NVL((SELECT max(CNTR_MF_SEQ) FROM BKG_CNTR_MF_DESC WHERE BKG_NO=@[bkg_no] AND CNTR_NO=@[cntr_no]),0)+1)" ).append("\n"); 
		query.append(",	@[cntr_no]" ).append("\n"); 
		query.append(",	@[cmdt_hs_cd]" ).append("\n"); 
		query.append(",	@[pck_qty]" ).append("\n"); 
		query.append(",	@[pck_tp_cd]" ).append("\n"); 
		query.append(",	@[cntr_mf_wgt]" ).append("\n"); 
		query.append(",	NVL(@[wgt_ut_cd],(" ).append("\n"); 
		query.append("        SELECT WGT_UT_CD" ).append("\n"); 
		query.append("        FROM   BKG_CONTAINER" ).append("\n"); 
		query.append("        WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND    CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("    ))" ).append("\n"); 
		query.append(",	@[meas_qty]" ).append("\n"); 
		query.append(",	NVL(@[meas_ut_cd],(" ).append("\n"); 
		query.append("        SELECT MEAS_UT_CD" ).append("\n"); 
		query.append("        FROM   BKG_CONTAINER" ).append("\n"); 
		query.append("        WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND    CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("    ))" ).append("\n"); 
		query.append(",	DECODE(@[dcgo_flg], '1', 'Y', 'N')" ).append("\n"); 
		query.append(",	NVL((SELECT BB_CGO_FLG FROM BKG_CONTAINER WHERE BKG_NO = @[bkg_no] AND CNTR_NO = @[cntr_no]), 'N')" ).append("\n"); 
		query.append(",	DECODE(@[awk_cgo_flg], '1', 'Y', 'N')" ).append("\n"); 
		query.append(",	NVL((SELECT RC_FLG 	   FROM BKG_CONTAINER WHERE BKG_NO = @[bkg_no] AND CNTR_NO = @[cntr_no]), 'N')" ).append("\n"); 
		query.append(",	NVL((SELECT RD_CGO_FLG FROM BKG_CONTAINER WHERE BKG_NO = @[bkg_no] AND CNTR_NO = @[cntr_no]), 'N')" ).append("\n"); 
		query.append(",	DECODE(@[hngr_flg], '1', 'Y', 'N')" ).append("\n"); 
		query.append(",   REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(@[cntr_mf_mk_desc], chr(13)||chr(10), '▤') , chr(10),''), chr(13), '▤'), chr(9), ' '), '▤' ,chr(13)||chr(10))" ).append("\n"); 
		query.append(",	REGEXP_REPLACE(REGEXP_REPLACE(@[cntr_mf_gds_desc], '[[:space:]]', ' '), '( ){2,}', ' ')" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	@[hamo_trf_cd]" ).append("\n"); 
		query.append(",	@[ncm_no]" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	@[cntr_mf_no]" ).append("\n"); 
		query.append(",	''" ).append("\n"); 
		query.append(",	@[dcgo_seq]" ).append("\n"); 
		query.append(",   @[wpm_trt_cd]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLDocumentationCMDBDAOCmVOByXterUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.16
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.02.16 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOCmVOByXterUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update
	  * </pre>
	  */
	public BLDocumentationCMDBDAOCmVOByXterUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cntr_mf_gds_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mf_dtl_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("meas_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_mf_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration ").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOCmVOByXterUSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("UPDATE BKG_CNTR_MF_DESC_HIS" ).append("\n"); 
		query.append("SET    PCK_QTY          = @[pck_qty]" ).append("\n"); 
		query.append(",	PCK_TP_CD        = @[pck_tp_cd]" ).append("\n"); 
		query.append(",	CNTR_MF_WGT      = @[cntr_mf_wgt]" ).append("\n"); 
		query.append(",   WGT_UT_CD        = (SELECT WGT_UT_CD   FROM BKG_CONTAINER WHERE BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001' AND CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append(",	MEAS_QTY         = @[meas_qty]" ).append("\n"); 
		query.append(",   MEAS_UT_CD		 = (SELECT MEAS_UT_CD  FROM BKG_CONTAINER WHERE BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001' AND CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append(",	MEAS_QTY         = @[meas_qty]" ).append("\n"); 
		query.append(",	DCGO_FLG         = (SELECT DCGO_FLG    FROM BKG_CONTAINER WHERE BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001' AND CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append(",	RC_FLG           = (SELECT RC_FLG      FROM BKG_CONTAINER WHERE BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001' AND CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append(",	AWK_CGO_FLG      = (SELECT AWK_CGO_FLG FROM BKG_CONTAINER WHERE BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001' AND CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append(",	BB_CGO_FLG       = (SELECT BB_CGO_FLG  FROM BKG_CONTAINER WHERE BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001' AND CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append(",	HNGR_FLG         = (SELECT HNGR_FLG    FROM BKG_CONTAINER WHERE BKG_NO = @[bkg_no] AND CORR_NO = 'TMP0000001' AND CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append(",	CNTR_MF_MK_DESC  = @[cntr_mf_mk_desc]" ).append("\n"); 
		query.append(",	CNTR_MF_GDS_DESC = @[cntr_mf_gds_desc]||DECODE(NVL(@[cntr_mf_gds_desc],'X'), 'X', '', CHR(13))||@[cntr_mf_dtl_desc]" ).append("\n"); 
		query.append("#if (${hamo_trf_cd} != '')" ).append("\n"); 
		query.append(",	HAMO_TRF_CD      = @[hamo_trf_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ncm_no} != '')" ).append("\n"); 
		query.append(",	NCM_NO           = @[ncm_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	UPD_USR_ID       = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT           = sysdate" ).append("\n"); 
		query.append("WHERE	BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("AND CORR_NO          = 'TMP0000001'" ).append("\n"); 
		query.append("and CNTR_NO			 = @[cntr_no]" ).append("\n"); 
		query.append("AND	CNTR_MF_SEQ      = @[cntr_mf_seq]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_CNTR_MF_DESC SET" ).append("\n"); 
		query.append("PCK_QTY          = @[pck_qty]" ).append("\n"); 
		query.append(",	PCK_TP_CD        = @[pck_tp_cd]" ).append("\n"); 
		query.append(",	CNTR_MF_WGT      = @[cntr_mf_wgt]" ).append("\n"); 
		query.append(",   WGT_UT_CD        = (SELECT WGT_UT_CD   FROM BKG_CONTAINER WHERE BKG_NO = @[bkg_no] AND CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append(",	MEAS_QTY         = @[meas_qty]" ).append("\n"); 
		query.append(",	DCGO_FLG         = (SELECT DCGO_FLG    FROM BKG_CONTAINER WHERE BKG_NO = @[bkg_no] AND CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append(",	RC_FLG           = (SELECT RC_FLG      FROM BKG_CONTAINER WHERE BKG_NO = @[bkg_no] AND CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append(",	AWK_CGO_FLG      = (SELECT AWK_CGO_FLG FROM BKG_CONTAINER WHERE BKG_NO = @[bkg_no] AND CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append(",	BB_CGO_FLG       = (SELECT BB_CGO_FLG  FROM BKG_CONTAINER WHERE BKG_NO = @[bkg_no] AND CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append(",	HNGR_FLG         = (SELECT HNGR_FLG    FROM BKG_CONTAINER WHERE BKG_NO = @[bkg_no] AND CNTR_NO = @[cntr_no])" ).append("\n"); 
		query.append(",	CNTR_MF_MK_DESC  = @[cntr_mf_mk_desc]" ).append("\n"); 
		query.append(",	CNTR_MF_GDS_DESC = @[cntr_mf_gds_desc]||DECODE(NVL(@[cntr_mf_gds_desc],'X'), 'X', '', CHR(13))||@[cntr_mf_dtl_desc]" ).append("\n"); 
		query.append("#if (${hamo_trf_cd} != '')" ).append("\n"); 
		query.append(",	HAMO_TRF_CD      = @[hamo_trf_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ncm_no} != '')" ).append("\n"); 
		query.append(",	NCM_NO           = @[ncm_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",	UPD_USR_ID       = @[upd_usr_id]" ).append("\n"); 
		query.append(",	UPD_DT           = sysdate" ).append("\n"); 
		query.append("WHERE	BKG_NO       = @[bkg_no]" ).append("\n"); 
		query.append("and CNTR_NO			 = @[cntr_no]" ).append("\n"); 
		query.append("AND	CNTR_MF_SEQ      = @[cntr_mf_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
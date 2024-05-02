/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOCopyCmByCntrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.07 
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

public class BLDocumentationCMDBDAOCopyCmByCntrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert
	  * </pre>
	  */
	public BLDocumentationCMDBDAOCopyCmByCntrCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tgt_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("src_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOCopyCmByCntrCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("            (BKG_NO" ).append("\n"); 
		query.append(",            CNTR_MF_SEQ" ).append("\n"); 
		query.append(",            CNTR_NO" ).append("\n"); 
		query.append(",            CMDT_HS_CD" ).append("\n"); 
		query.append(",            PCK_QTY" ).append("\n"); 
		query.append(",            PCK_TP_CD" ).append("\n"); 
		query.append(",            CNTR_MF_WGT" ).append("\n"); 
		query.append(",            WGT_UT_CD" ).append("\n"); 
		query.append(",            MEAS_QTY" ).append("\n"); 
		query.append(",            MEAS_UT_CD" ).append("\n"); 
		query.append(",            DCGO_FLG" ).append("\n"); 
		query.append(",            BB_CGO_FLG" ).append("\n"); 
		query.append(",            AWK_CGO_FLG" ).append("\n"); 
		query.append(",            RC_FLG" ).append("\n"); 
		query.append(",            RD_CGO_FLG" ).append("\n"); 
		query.append(",            HNGR_FLG" ).append("\n"); 
		query.append(",            CNTR_MF_MK_DESC" ).append("\n"); 
		query.append(",            CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append(",            HBL_SEQ" ).append("\n"); 
		query.append(",            HAMO_TRF_CD" ).append("\n"); 
		query.append(",            NCM_NO" ).append("\n"); 
		query.append(",            PO_NO" ).append("\n"); 
		query.append(",            CNTR_MF_NO" ).append("\n"); 
		query.append(",            CSTMS_DECL_NO" ).append("\n"); 
		query.append(",            WPM_TRT_CD" ).append("\n"); 
		query.append(",            CRE_USR_ID" ).append("\n"); 
		query.append(",            CRE_DT" ).append("\n"); 
		query.append(",            UPD_USR_ID" ).append("\n"); 
		query.append(",            UPD_DT)" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("SELECT @[tgt_bkg_no] BKG_NO " ).append("\n"); 
		query.append(",      ((SELECT NVL(SUM(CNTR_MF_SEQ), 0)" ).append("\n"); 
		query.append("         FROM   BKG_CNTR_MF_DESC_HIS" ).append("\n"); 
		query.append("         WHERE  BKG_NO = @[tgt_bkg_no] AND CNTR_NO=@[cntr_no]) + ROW_NUMBER() OVER(PARTITION BY BKG_NO, CNTR_NO ORDER BY CNTR_MF_SEQ))" ).append("\n"); 
		query.append(",      CNTR_NO" ).append("\n"); 
		query.append(",      CMDT_HS_CD" ).append("\n"); 
		query.append(",      PCK_QTY" ).append("\n"); 
		query.append(",      PCK_TP_CD" ).append("\n"); 
		query.append(",      CNTR_MF_WGT" ).append("\n"); 
		query.append(",      WGT_UT_CD" ).append("\n"); 
		query.append(",      MEAS_QTY" ).append("\n"); 
		query.append(",      MEAS_UT_CD" ).append("\n"); 
		query.append(",      DCGO_FLG" ).append("\n"); 
		query.append(",      BB_CGO_FLG" ).append("\n"); 
		query.append(",      AWK_CGO_FLG" ).append("\n"); 
		query.append(",      RC_FLG" ).append("\n"); 
		query.append(",      RD_CGO_FLG" ).append("\n"); 
		query.append(",      HNGR_FLG" ).append("\n"); 
		query.append(",      CNTR_MF_MK_DESC" ).append("\n"); 
		query.append(",      CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append(",      HBL_SEQ" ).append("\n"); 
		query.append(",      HAMO_TRF_CD" ).append("\n"); 
		query.append(",      NCM_NO" ).append("\n"); 
		query.append(",      PO_NO" ).append("\n"); 
		query.append(",      '' CNTR_MF_NO" ).append("\n"); 
		query.append(",      CSTMS_DECL_NO" ).append("\n"); 
		query.append(",      WPM_TRT_CD" ).append("\n"); 
		query.append(",      @[cre_usr_id]" ).append("\n"); 
		query.append(",      SYSDATE" ).append("\n"); 
		query.append(",      @[cre_usr_id]" ).append("\n"); 
		query.append(",      SYSDATE" ).append("\n"); 
		query.append("FROM   BKG_CNTR_MF_DESC_HIS" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[src_bkg_no]" ).append("\n"); 
		query.append("AND    CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND    CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("SELECT @[tgt_bkg_no] BKG_NO " ).append("\n"); 
		query.append(",      ((SELECT NVL(SUM(CNTR_MF_SEQ), 0)" ).append("\n"); 
		query.append("         FROM   BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("         WHERE  BKG_NO=@[tgt_bkg_no] AND CNTR_NO=@[cntr_no]) + ROW_NUMBER() OVER(PARTITION BY BKG_NO, CNTR_NO ORDER BY CNTR_MF_SEQ))" ).append("\n"); 
		query.append(",      CNTR_NO" ).append("\n"); 
		query.append(",      CMDT_HS_CD" ).append("\n"); 
		query.append(",      PCK_QTY" ).append("\n"); 
		query.append(",      PCK_TP_CD" ).append("\n"); 
		query.append(",      CNTR_MF_WGT" ).append("\n"); 
		query.append(",      WGT_UT_CD" ).append("\n"); 
		query.append(",      MEAS_QTY" ).append("\n"); 
		query.append(",      MEAS_UT_CD" ).append("\n"); 
		query.append(",      DCGO_FLG" ).append("\n"); 
		query.append(",      BB_CGO_FLG" ).append("\n"); 
		query.append(",      AWK_CGO_FLG" ).append("\n"); 
		query.append(",      RC_FLG" ).append("\n"); 
		query.append(",      RD_CGO_FLG" ).append("\n"); 
		query.append(",      HNGR_FLG" ).append("\n"); 
		query.append(",      CNTR_MF_MK_DESC" ).append("\n"); 
		query.append(",      CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append(",      HBL_SEQ" ).append("\n"); 
		query.append(",      HAMO_TRF_CD" ).append("\n"); 
		query.append(",      NCM_NO" ).append("\n"); 
		query.append(",      PO_NO" ).append("\n"); 
		query.append(",      '' CNTR_MF_NO" ).append("\n"); 
		query.append(",      CSTMS_DECL_NO" ).append("\n"); 
		query.append(",      WPM_TRT_CD" ).append("\n"); 
		query.append(",      @[cre_usr_id]" ).append("\n"); 
		query.append(",      SYSDATE" ).append("\n"); 
		query.append(",      @[cre_usr_id]" ).append("\n"); 
		query.append(",      SYSDATE" ).append("\n"); 
		query.append("FROM   BKG_CNTR_MF_DESC" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[src_bkg_no]" ).append("\n"); 
		query.append("AND    CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}
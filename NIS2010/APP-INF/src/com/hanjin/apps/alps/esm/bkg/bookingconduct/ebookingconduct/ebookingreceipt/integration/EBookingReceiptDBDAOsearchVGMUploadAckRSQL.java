/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchVGMUploadAckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2018.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchVGMUploadAckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchVGMUploadAckRSQL
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchVGMUploadAckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("xter_vgm_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_vgm_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchVGMUploadAckRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("'IVC_NO:' || rqst.XTER_VGM_RQST_NO" ).append("\n"); 
		query.append("||CHR(10)||'IVC_FUNCCD:' || NVL(RQST.VGM_EDI_TP_CD, '4')" ).append("\n"); 
		query.append("||CHR(10)||'IVC_DATE:' || to_char(sysdate,'CCYYMMDDHHMM')" ).append("\n"); 
		query.append("||CHR(10)||'IVC_BKGNO:' || rqst.BKG_NO" ).append("\n"); 
		query.append("||CHR(10)||'IVC_CNTRNO:' || rqst.CNTR_NO" ).append("\n"); 
		query.append("||CHR(10)||'IVC_RES_CD:' || DECODE(rqst.VGM_UPLD_STS_CD,'F','AP','R','RE','')" ).append("\n"); 
		query.append("||CHR(10)||'IVC_RESPONSE:' || rqst.RJCT_RSN_RMK" ).append("\n"); 
		query.append("||CHR(10)||'IVC_BKG_REFNO:' || rqst.XTER_BKG_RQST_REF_NO" ).append("\n"); 
		query.append("||CHR(10)||'IVC_SI_REFNO:' || rqst.XTER_SI_REF_NO" ).append("\n"); 
		query.append("||CHR(10)||'{IVC_CNTR_CUST'" ).append("\n"); 
		query.append("||CHR(10)||'IVCC_CD:' || pty.VGM_PTY_TP_CD" ).append("\n"); 
		query.append("||CHR(10)||'IVCC_NM:' || pty.VGM_PTY_ID" ).append("\n"); 
		query.append("||CHR(10)||'IVCC_ADDR:' || pty.VGM_PTY_ADDR" ).append("\n"); 
		query.append("||CHR(10)||'IVCC_PERSON_NM:' || pty.AUTH_PSON_NM" ).append("\n"); 
		query.append("||CHR(10)||'IVCC_TEL:' || pty.VGM_PTY_CNTC_PHN_NO" ).append("\n"); 
		query.append("||CHR(10)||'IVCC_EML:' || pty.VGM_PTY_EML" ).append("\n"); 
		query.append("||CHR(10)||'IVCC_FAX:' || pty.VGM_PTY_FAX_NO" ).append("\n"); 
		query.append("||CHR(10)||'}IVC_CNTR_CUST' as FLAT_FILE" ).append("\n"); 
		query.append("FROM BKG_XTER_VRFD_WGT_RQST RQST," ).append("\n"); 
		query.append("	 BKG_XTER_VRFD_WGT_PTY PTY" ).append("\n"); 
		query.append("WHERE RQST.XTER_SNDR_ID = PTY.XTER_SNDR_ID" ).append("\n"); 
		query.append("  AND RQST.XTER_VGM_RQST_NO = PTY.XTER_VGM_RQST_NO" ).append("\n"); 
		query.append("  AND RQST.XTER_VGM_SEQ = PTY.XTER_VGM_SEQ" ).append("\n"); 
		query.append("  AND RQST.CNTR_NO = PTY.CNTR_NO" ).append("\n"); 
		query.append("  AND RQST.XTER_SNDR_ID = @[xter_sndr_id]" ).append("\n"); 
		query.append("  AND RQST.XTER_VGM_RQST_NO = @[xter_vgm_rqst_no]" ).append("\n"); 
		query.append("  AND RQST.XTER_VGM_SEQ = @[xter_vgm_seq]" ).append("\n"); 
		query.append("  AND RQST.CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SPCLCmpnApprovalDBDAOModifySPCLCmpnApprovalDtlListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.26 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SPCLCmpnApprovalDBDAOModifySPCLCmpnApprovalDtlListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ACM_SPCL_CMPN_DTL 에 exchange rate 변경에 따른 값 수정
	  * </pre>
	  */
	public SPCLCmpnApprovalDBDAOModifySPCLCmpnApprovalDtlListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cmpn_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.acm.acmapproval.spclcmpnapproval.integration").append("\n"); 
		query.append("FileName : SPCLCmpnApprovalDBDAOModifySPCLCmpnApprovalDtlListUSQL").append("\n"); 
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
		query.append("MERGE INTO ACM_SPCL_CMPN_DTL K" ).append("\n"); 
		query.append("      USING" ).append("\n"); 
		query.append("      (SELECT B.BKG_NO, B.SPCL_OFC_CD, B.SPCL_CMPN_SEQ, B.CNTR_TPSZ_CD, B.IF_DTRB_AMT, A.PAY_XCH_RT" ).append("\n"); 
		query.append("         FROM ACM_SPCL_CMPN A" ).append("\n"); 
		query.append("            , ACM_SPCL_CMPN_DTL B" ).append("\n"); 
		query.append("        WHERE 1=1" ).append("\n"); 
		query.append("          AND A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("          AND A.SPCL_OFC_CD = @[spcl_ofc_cd]" ).append("\n"); 
		query.append("          AND A.SPCL_CMPN_SEQ = @[spcl_cmpn_seq]" ).append("\n"); 
		query.append("          AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("          AND A.SPCL_OFC_CD = B.SPCL_OFC_CD" ).append("\n"); 
		query.append("          AND A.SPCL_CMPN_SEQ = B.SPCL_CMPN_SEQ " ).append("\n"); 
		query.append("          AND A.SPCL_CMPN_STS_CD = 'CS'" ).append("\n"); 
		query.append("          AND NVL(A.PAY_CHK_FLG,'N') = 'Y'" ).append("\n"); 
		query.append("        ) INFO" ).append("\n"); 
		query.append("    ON (K.BKG_NO        = INFO.BKG_NO" ).append("\n"); 
		query.append("    AND K.SPCL_OFC_CD   = INFO.SPCL_OFC_CD" ).append("\n"); 
		query.append("    AND K.SPCL_CMPN_SEQ = INFO.SPCL_CMPN_SEQ " ).append("\n"); 
		query.append("    AND K.CNTR_TPSZ_CD  = INFO.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE" ).append("\n"); 
		query.append("   SET " ).append("\n"); 
		query.append("        K.PAY_IF_DTRB_AMT = K.IF_DTRB_AMT * INFO.PAY_XCH_RT" ).append("\n"); 
		query.append("      , K.UPD_USR_ID      = @[usr_id]" ).append("\n"); 
		query.append("      , K.UPD_DT          = SYSDATE" ).append("\n"); 

	}
}
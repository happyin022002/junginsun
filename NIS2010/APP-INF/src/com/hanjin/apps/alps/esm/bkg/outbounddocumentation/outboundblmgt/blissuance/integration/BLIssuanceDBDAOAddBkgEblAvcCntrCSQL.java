/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BLIssuanceDBDAOAddBkgEblAvcCntrCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.26
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2011.04.26 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOAddBkgEblAvcCntrCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BLIssuanceDBDAOAddBkgEblAvcCntrCSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ebl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOAddBkgEblAvcCntrCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_EBL_AVC_CNTR" ).append("\n"); 
		query.append("	(BKG_NO" ).append("\n"); 
		query.append("	,BL_NO" ).append("\n"); 
		query.append("	,BKG_EBL_SEQ" ).append("\n"); 
		query.append("	,CNTR_SEQ" ).append("\n"); 
		query.append("	,DOC_PARA_NO1" ).append("\n"); 
		query.append("	,DOC_PARA_NO2" ).append("\n"); 
		query.append("	,CNTR_NO" ).append("\n"); 
		query.append("	,CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	,CNTR_PRT_FLG" ).append("\n"); 
		query.append("	,CNTR_WGT" ).append("\n"); 
		query.append("	,CNTR_OP_CAPA" ).append("\n"); 
		query.append("	,CNTR_VOL_QTY" ).append("\n"); 
		query.append("	,CNTR_SEAL_NO" ).append("\n"); 
		query.append("	,IF_FLG" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT" ).append("\n"); 
		query.append("	,CGO_DESC" ).append("\n"); 
		query.append("	,PCK_TP_CD" ).append("\n"); 
		query.append("	,WGT_UT_CD" ).append("\n"); 
		query.append("	,MEAS_UT_CD)" ).append("\n"); 
		query.append("SELECT	C.BKG_NO BKG_NO      " ).append("\n"); 
		query.append("	,B.BL_NO BL_NO       " ).append("\n"); 
		query.append("	,@[bkg_ebl_seq] BKG_EBL_SEQ" ).append("\n"); 
		query.append("	,ROWNUM CNTR_SEQ" ).append("\n"); 
		query.append("	,C.BKG_NO||LTRIM(TO_CHAR(@[bkg_ebl_seq], '0000')) DOC_PARA_NO1" ).append("\n"); 
		query.append("	,C.BKG_NO||LTRIM(TO_CHAR(@[bkg_ebl_seq], '0000'))||LTRIM(TO_CHAR(ROWNUM, '0000')) DOC_PARA_NO2" ).append("\n"); 
		query.append("	,C.CNTR_NO CNTR_NO     " ).append("\n"); 
		query.append("	,C.CNTR_TPSZ_CD CNTR_TPSZ_CD" ).append("\n"); 
		query.append("	,C.CNTR_PRT_FLG CNTR_PRT_FLG" ).append("\n"); 
		query.append("	,C.CNTR_WGT CNTR_WGT    " ).append("\n"); 
		query.append("	,C.MEAS_QTY CNTR_OP_CAPA" ).append("\n"); 
		query.append("	,C.PCK_QTY CNTR_VOL_QTY" ).append("\n"); 
		query.append("	,'S/'||S.CNTR_SEAL_NO CNTR_SEAL_NO" ).append("\n"); 
		query.append("	,'N' IF_FLG      " ).append("\n"); 
		query.append("	,@[usr_id] CRE_USR_ID  " ).append("\n"); 
		query.append("	,SYSDATE CRE_DT      " ).append("\n"); 
		query.append("	,@[usr_id] UPD_USR_ID  " ).append("\n"); 
		query.append("	,SYSDATE UPD_DT" ).append("\n"); 
		query.append("	,DECODE(NVL(C.RCV_TERM_CD,' '),'Y','CY','H','CY',' ',' ',C.RCV_TERM_CD)||'/'||DECODE(NVL(C.DE_TERM_CD,' '),'Y','CY','H','CY',' ',' ',C.DE_TERM_CD) CGO_DESC" ).append("\n"); 
		query.append("	,C.PCK_TP_CD" ).append("\n"); 
		query.append("	,C.WGT_UT_CD" ).append("\n"); 
		query.append("	,C.MEAS_UT_CD" ).append("\n"); 
		query.append("  FROM	BKG_CONTAINER C," ).append("\n"); 
		query.append("        BKG_BOOKING B," ).append("\n"); 
		query.append("		BKG_CNTR_SEAL_NO S" ).append("\n"); 
		query.append(" WHERE 	C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("   AND  C.BKG_NO = S.BKG_NO(+)" ).append("\n"); 
		query.append("   AND  C.CNTR_NO = S.CNTR_NO(+)" ).append("\n"); 
		query.append("   AND  S.CNTR_SEAL_SEQ(+) = 1" ).append("\n"); 
		query.append("   AND  C.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}
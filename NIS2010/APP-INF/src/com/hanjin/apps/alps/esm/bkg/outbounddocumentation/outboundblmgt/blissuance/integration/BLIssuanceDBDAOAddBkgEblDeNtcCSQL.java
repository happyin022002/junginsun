/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BLIssuanceDBDAOAddBkgEblDeNtcCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.24
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2011.04.24 김태경
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

public class BLIssuanceDBDAOAddBkgEblDeNtcCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLIssuanceDBDAOAddBkgEblDeNtcCSQL
	  * </pre>
	  */
	public BLIssuanceDBDAOAddBkgEblDeNtcCSQL(){
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
		query.append("FileName : BLIssuanceDBDAOAddBkgEblDeNtcCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_EBL_DE_NTC" ).append("\n"); 
		query.append("    (BKG_NO" ).append("\n"); 
		query.append("	,BKG_EBL_SEQ" ).append("\n"); 
		query.append("	,CNTR_SEQ" ).append("\n"); 
		query.append("	,DOC_PARA_NO1" ).append("\n"); 
		query.append("	,DOC_PARA_NO2" ).append("\n"); 
		query.append("	,DOC_RMK" ).append("\n"); 
		query.append("	,DOC_NO_AND_CLSS_NM" ).append("\n"); 
		query.append("	,OBJ_FUNC_EVNT_CD1" ).append("\n"); 
		query.append("	,OBJ_FUNC_EVNT_CD2" ).append("\n"); 
		query.append("	,OBJ_FUNC_EVNT_CD3" ).append("\n"); 
		query.append("	,OBJ_FUNC_EVNT_CD4" ).append("\n"); 
		query.append("	,DE_DT" ).append("\n"); 
		query.append("	,REF_NO" ).append("\n"); 
		query.append("	,BKG_CUST_NM" ).append("\n"); 
		query.append("	,BL_CUST_NM" ).append("\n"); 
		query.append("	,CUST_PHN_NO" ).append("\n"); 
		query.append("	,BL_NO" ).append("\n"); 
		query.append("	,IF_FLG" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("    ,UPD_USR_ID" ).append("\n"); 
		query.append("    ,UPD_DT)" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("     BK.BKG_NO" ).append("\n"); 
		query.append("    ,@[bkg_ebl_seq] BKG_EBL_SEQ" ).append("\n"); 
		query.append("    ,ROWNUM CNTR_SEQ" ).append("\n"); 
		query.append("    ,BKG_NO||LTRIM(TO_CHAR(@[bkg_ebl_seq], '0000')) DOC_PARA_NO1" ).append("\n"); 
		query.append("	,BKG_NO||LTRIM(TO_CHAR(@[bkg_ebl_seq], '0000'))||LTRIM(TO_CHAR(ROWNUM, '0000')) DOC_PARA_NO2" ).append("\n"); 
		query.append("	,'BLDeliveryNotice' DOC_RMK" ).append("\n"); 
		query.append("	,BKG_NO||LTRIM(TO_CHAR(@[bkg_ebl_seq], '0000'))||LTRIM(TO_CHAR(ROWNUM, '0000')) DOC_NO_AND_CLSS_NM" ).append("\n"); 
		query.append("	,'1' OBJ_FUNC_EVNT_CD1" ).append("\n"); 
		query.append("	,'NA' OBJ_FUNC_EVNT_CD2" ).append("\n"); 
		query.append("	,'1.0' OBJ_FUNC_EVNT_CD3" ).append("\n"); 
		query.append("	,'1' OBJ_FUNC_EVNT_CD4" ).append("\n"); 
		query.append("	,'' DE_DT" ).append("\n"); 
		query.append("	,'' REF_NO" ).append("\n"); 
		query.append("	,(SELECT SUBSTR(CUST_NM,1,35) FROM BKG_CUSTOMER C" ).append("\n"); 
		query.append("				 WHERE C.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("				   AND C.BKG_CUST_TP_CD ='C') BKG_CUST_NM" ).append("\n"); 
		query.append("    ,(SELECT SUBSTR(CUST_NM,1,35) FROM BKG_CUSTOMER C" ).append("\n"); 
		query.append("				 WHERE C.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("				   AND C.BKG_CUST_TP_CD ='C') BL_CUST_NM" ).append("\n"); 
		query.append("    ,'' CUST_PHN_NO" ).append("\n"); 
		query.append("    ,BK.BL_NO BL_NO" ).append("\n"); 
		query.append("    ,'N' IF_FLG" ).append("\n"); 
		query.append("	,@[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("	,SYSDATE CRE_DT" ).append("\n"); 
		query.append("	,@[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("	,SYSDATE UPD_DT	" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("   WHERE 	BK.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}
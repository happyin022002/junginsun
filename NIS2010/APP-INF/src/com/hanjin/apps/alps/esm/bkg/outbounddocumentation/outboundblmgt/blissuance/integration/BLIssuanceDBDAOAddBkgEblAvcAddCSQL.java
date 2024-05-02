/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BLIssuanceDBDAOAddBkgEblAvcAddCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.15
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2011.04.15 김태경
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

public class BLIssuanceDBDAOAddBkgEblAvcAddCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BLIssuanceDBDAOAddBkgEblAvcAddCSQL(){
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
		query.append("FileName : BLIssuanceDBDAOAddBkgEblAvcAddCSQL").append("\n"); 
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
		query.append("INSERT	INTO BKG_EBL_AVC_ADD" ).append("\n"); 
		query.append("	(BKG_NO" ).append("\n"); 
		query.append("	,BL_NO	" ).append("\n"); 
		query.append("	,BKG_EBL_SEQ" ).append("\n"); 
		query.append("	,CNTR_SEQ" ).append("\n"); 
		query.append("	,DOC_PARA_NO1" ).append("\n"); 
		query.append("	,DOC_PARA_NO2" ).append("\n"); 
		query.append("	,JB_TIT_CTNT" ).append("\n"); 
		query.append("	,CUST_REF_RMK1" ).append("\n"); 
		query.append("	,CUST_REF_RMK2" ).append("\n"); 
		query.append("	,IF_FLG" ).append("\n"); 
		query.append("	,CRE_USR_ID" ).append("\n"); 
		query.append("	,CRE_DT" ).append("\n"); 
		query.append("	,UPD_USR_ID" ).append("\n"); 
		query.append("	,UPD_DT)" ).append("\n"); 
		query.append("SELECT	BK.BKG_NO BKG_NO" ).append("\n"); 
		query.append("	,BK.BL_NO BL_NO" ).append("\n"); 
		query.append("	,@[bkg_ebl_seq] BKG_EBL_SEQ" ).append("\n"); 
		query.append("	,ROWNUM CNTR_SEQ" ).append("\n"); 
		query.append("	,BK.BKG_NO||LTRIM(TO_CHAR(@[bkg_ebl_seq], '0000')) DOC_PARA_NO1" ).append("\n"); 
		query.append("	,BK.BKG_NO||LTRIM(TO_CHAR(@[bkg_ebl_seq], '0000'))||LTRIM(TO_CHAR(ROWNUM, '0000')) DOC_PARA_NO2" ).append("\n"); 
		query.append("	,ADD_INFO.TITLE JB_TIT_CTNT" ).append("\n"); 
		query.append("	,'' CUST_REF_RMK1" ).append("\n"); 
		query.append("	,CASE WHEN ADD_INFO.TITLE ='EQ' THEN '(EQ SUB : '||ADD_INFO.DES||')'" ).append("\n"); 
		query.append("	 ELSE ADD_INFO.DES" ).append("\n"); 
		query.append("	 END CUST_REF_RMK2" ).append("\n"); 
		query.append("	,'N' IF_FLG" ).append("\n"); 
		query.append("	,@[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append("	,SYSDATE CRE_DT" ).append("\n"); 
		query.append("	,@[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("	,SYSDATE UPD_DT	" ).append("\n"); 
		query.append("  FROM	BKG_BOOKING BK, " ).append("\n"); 
		query.append("		(SELECT BKG_NO,'EQ' AS TITLE,BKG_JOIN_FNC(CURSOR(  " ).append("\n"); 
		query.append("                            SELECT CNTR_TPSZ_CD||'X'||EQ_SUBST_CGO_QTY AS A  " ).append("\n"); 
		query.append("                              FROM BKG_QUANTITY  " ).append("\n"); 
		query.append("                             WHERE BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("                               AND EQ_SUBST_CNTR_TPSZ_CD IS NOT NULL  " ).append("\n"); 
		query.append("                               AND EQ_SUBST_CGO_QTY <> 0 ),',') DES" ).append("\n"); 
		query.append("		  FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("          WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("         UNION ALL " ).append("\n"); 
		query.append("         SELECT BKG_NO, 'FMC',DECODE(RTRIM(RF.CUST_REF_NO_CTNT),'',NULL,'FMC'||SUBSTR(RF.CUST_REF_NO_CTNT,1,6)) FMC_NO" ).append("\n"); 
		query.append("         FROM BKG_REFERENCE RF WHERE BKG_NO =  @[bkg_no] AND BKG_REF_TP_CD  = 'FMCN' AND ROWNUM =1" ).append("\n"); 
		query.append("         UNION ALL " ).append("\n"); 
		query.append("         SELECT BKG_NO, 'CA',DECODE(BL.BDR_CNG_FLG, 'N', NULL ,'C/A') AS CA_no  FROM BKG_BL_DOC BL" ).append("\n"); 
		query.append("         WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("         ) ADD_INFO" ).append("\n"); 
		query.append("							" ).append("\n"); 
		query.append(" WHERE 	BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND BK.BKG_NO = ADD_INFO.BKG_NO(+) " ).append("\n"); 
		query.append("   AND ADD_INFO.DES IS NOT NULL" ).append("\n"); 

	}
}
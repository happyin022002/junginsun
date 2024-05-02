/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchBlReIssueInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.28
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchBlReIssueInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBlReIssueInfo
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchBlReIssueInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchBlReIssueInfoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("	 BKG.BKG_NO " ).append("\n"); 
		query.append("	,BL_NO " ).append("\n"); 
		query.append("	,BL_TP_CD " ).append("\n"); 
		query.append("	,SHIPPER_CODE" ).append("\n"); 
		query.append("	,SHIPPER_NAME" ).append("\n"); 
		query.append("	,OBL_ISS_KNT" ).append("\n"); 
		query.append("	,OBL_SRND_FLG" ).append("\n"); 
		query.append("	,OBL_ISS_FLG     " ).append("\n"); 
		query.append("	,DECODE(OTR_DOC_CGOR_FLG, 'Y', 'N', DO_YN) DO_YN" ).append("\n"); 
		query.append("FROM  " ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("		BKG.BKG_NO " ).append("\n"); 
		query.append("		,BKG.BL_NO " ).append("\n"); 
		query.append("		,BKG.BL_TP_CD " ).append("\n"); 
		query.append("	,OBL_ISS_KNT" ).append("\n"); 
		query.append("	,OBL_SRND_FLG" ).append("\n"); 
		query.append("	,OBL_ISS_FLG " ).append("\n"); 
		query.append("	,OTR_DOC_CGOR_FLG                " ).append("\n"); 
		query.append("    ,CASE " ).append("\n"); 
		query.append("	WHEN (SELECT COUNT(BKG_NO) FROM BKG_DO_DTL WHERE BKG_NO =ISS.BKG_NO AND RLSE_STS_CD = 'R' ) > 0 " ).append("\n"); 
		query.append("		THEN 'Y'" ).append("\n"); 
		query.append("		ELSE 'N'" ).append("\n"); 
		query.append("	END  DO_YN" ).append("\n"); 
		query.append("	FROM BKG_BOOKING BKG, BKG_BL_ISS ISS" ).append("\n"); 
		query.append("	WHERE BKG.BKG_NO=@[bkg_no]" ).append("\n"); 
		query.append("AND BKG.BKG_NO = ISS.BKG_NO(+)" ).append("\n"); 
		query.append("	) BKG," ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("		BKG_NO" ).append("\n"); 
		query.append("		,CUST_CNT_CD || CUST_SEQ AS SHIPPER_CODE" ).append("\n"); 
		query.append("		,CUST_NM SHIPPER_NAME" ).append("\n"); 
		query.append("	FROM BKG_CUSTOMER" ).append("\n"); 
		query.append("	WHERE BKG_NO=@[bkg_no]" ).append("\n"); 
		query.append("	AND BKG_CUST_TP_CD = 'S') CST" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	BKG.BKG_NO = CST.BKG_NO(+)" ).append("\n"); 

	}
}
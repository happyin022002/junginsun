/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchDoStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.28
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.28 
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

public class BLIssuanceDBDAOSearchDoStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchDoStatus
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchDoStatusRSQL(){
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
		query.append("FileName : BLIssuanceDBDAOSearchDoStatusRSQL").append("\n"); 
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
		query.append("SELECT 'X' as out_put" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_DO_DTL DTL, BKG_BOOKING BKG, BKG_BL_ISS ISS" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("DTL.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BKG.BKG_NO = DTL.BKG_NO" ).append("\n"); 
		query.append("AND BKG.BKG_NO = ISS.BKG_NO" ).append("\n"); 
		query.append("AND DTL.RLSE_STS_CD = DECODE(SUBSTR(BKG.DEL_CD, 1, 2), 'JP','D', 'R')" ).append("\n"); 
		query.append("AND NVL(ISS.OTR_DOC_CGOR_FLG, '*') <> 'Y'" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT 'X' as out_put" ).append("\n"); 
		query.append("FROM BKG_BOOKING BKG, BKG_CGO_RLSE CGO, BKG_BL_ISS ISS" ).append("\n"); 
		query.append("WHERE BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BKG.BL_NO = CGO.BL_NO" ).append("\n"); 
		query.append("AND BKG.BKG_NO = ISS.BKG_NO" ).append("\n"); 
		query.append("AND CGO.FRT_CLT_FLG = 'Y'" ).append("\n"); 
		query.append("AND CGO.OBL_RDEM_FLG = 'Y'" ).append("\n"); 
		query.append("AND CGO.CSTMS_CLR_CD = 'Y'" ).append("\n"); 
		query.append("AND NVL(ISS.OTR_DOC_CGOR_FLG, '*') <> 'Y'" ).append("\n"); 
		query.append("--AND SUBSTR(BKG.DEL_CD, 1, 2) = 'US'" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchInvoiceEdiVslInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.22 
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

public class BLIssuanceDBDAOSearchInvoiceEdiVslInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BLIssuanceDBDAOSearchInvoiceEdiVslInfo
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchInvoiceEdiVslInfoRSQL(){
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
		query.append("FileName : BLIssuanceDBDAOSearchInvoiceEdiVslInfoRSQL").append("\n"); 
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
		query.append("SELECT '{VSL_INFO' || CHR(10) " ).append("\n"); 
		query.append("       || 'VSL_NM:' ||MDM.VSL_ENG_NM|| CHR(10) " ).append("\n"); 
		query.append("       || 'VSL_CD:' || VVD.VSL_CD||CHR(10) " ).append("\n"); 
		query.append("       || 'VSL_VOY_NO:' ||VVD.SKD_VOY_NO|| CHR(10) " ).append("\n"); 
		query.append("       || 'EX_VOY_REF:' ||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD|| CHR(10) " ).append("\n"); 
		query.append("       || 'VSL_LOYD_CD:' ||MDM.LLOYD_NO|| CHR(10) " ).append("\n"); 
		query.append("       || '}VSL_INFO' || CHR(10)" ).append("\n"); 
		query.append("  FROM BKG_VVD VVD, MDM_VSL_CNTR MDM  " ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND VVD.VSL_CD = MDM.VSL_CD(+)" ).append("\n"); 
		query.append("   AND VVD.VSL_PRE_PST_CD = 'T'" ).append("\n"); 

	}
}
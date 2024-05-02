/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiPodAtaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.30
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.10.30 김영출
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchDblEdiPodAtaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiPodAtaRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration ").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiPodAtaRSQL").append("\n"); 
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
		query.append("SELECT 'POD_ATA:' || NVL(TO_CHAR(ACT_ARR_DT, 'YYYYMMDDHHMMSS'), ' ') || CHR(10)" ).append("\n"); 
		query.append("FROM   VSK_ACT_PORT_SKD A, (SELECT A.VSL_CD" ).append("\n"); 
		query.append(",                                  A.SKD_VOY_NO" ).append("\n"); 
		query.append(",                                  A.SKD_DIR_CD" ).append("\n"); 
		query.append(",                                  A.POD_CD" ).append("\n"); 
		query.append("FROM   BKG_VVD A, BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND A.POD_CD = B.POD_CD) B" ).append("\n"); 
		query.append("WHERE  A.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("AND A.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("AND A.VPS_PORT_CD = B.POD_CD" ).append("\n"); 

	}
}
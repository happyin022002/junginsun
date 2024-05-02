/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLIssuanceDBDAOSearchBlReIssueCollectRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2009.10.19 이진서
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jin Seo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOSearchBlReIssueCollectRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBlReIssueCollect
	  * </pre>
	  */
	public BLIssuanceDBDAOSearchBlReIssueCollectRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOSearchBlReIssueCollectRSQL").append("\n"); 
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
		query.append("BKG_NO" ).append("\n"); 
		query.append(",HIS_SEQ" ).append("\n"); 
		query.append(",ISS_RDEM_KNT" ).append("\n"); 
		query.append(",OBL_RDEM_CFM_FLG" ).append("\n"); 
		query.append(",EVNT_OFC_CD" ).append("\n"); 
		query.append(",EVNT_USR_ID" ).append("\n"); 
		query.append(",TO_CHAR(EVNT_DT, 'YYYY-MM-DD') EVNT_DT" ).append("\n"); 
		query.append("FROM BKG_DOC_ISS_RDEM" ).append("\n"); 
		query.append("WHERE BKG_NO =@[bkg_no]" ).append("\n"); 
		query.append("AND OBL_RDEM_CFM_FLG ='N'" ).append("\n"); 

	}
}
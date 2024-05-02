/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiFnlEta21RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.10.29 김영출
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchDblEdiFnlEta21RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiFnlEta21RSQL(){
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
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiFnlEta21RSQL").append("\n"); 
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
		query.append("SELECT TO_CHAR(MAX(ESTM_DT)+1, 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("FROM   BKG_BOOKING BK, SCE_COP_HDR HDR, SCE_COP_DTL DTL" ).append("\n"); 
		query.append("WHERE  BK.BKG_NO = HDR.BKG_NO" ).append("\n"); 
		query.append("AND HDR.COP_NO = DTL.COP_NO" ).append("\n"); 
		query.append("AND DTL.NOD_CD = BK.DEL_NOD_CD" ).append("\n"); 
		query.append("AND DTL.ACT_CD IN ('FITMDO', 'FITSAD', 'FITYAD', 'FITMAD')" ).append("\n"); 
		query.append("AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BK.POD_CD = 'USLGB'" ).append("\n"); 
		query.append("AND BK.DEL_CD = 'USLAX'" ).append("\n"); 
		query.append("AND BK.DE_TERM_CD = 'Y'" ).append("\n"); 

	}
}
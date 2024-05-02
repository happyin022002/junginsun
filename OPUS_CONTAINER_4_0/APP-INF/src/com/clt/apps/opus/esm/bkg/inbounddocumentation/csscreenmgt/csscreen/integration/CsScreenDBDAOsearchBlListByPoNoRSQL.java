/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CsScreenDBDAOsearchBlListByPoNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.05
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CsScreenDBDAOsearchBlListByPoNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * P.O. No에 둘이상의 B/L 또는 관련 B/L 목록을 List Up하고 아니면 단건의 B/L 항목을 조회한다.
	  * </pre>
	  */
	public CsScreenDBDAOsearchBlListByPoNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("po_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.integration").append("\n"); 
		query.append("FileName : CsScreenDBDAOsearchBlListByPoNoRSQL").append("\n"); 
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
		query.append("SELECT BKGM.BKG_NO" ).append("\n"); 
		query.append(", BKGM.SPLIT_FLG    -- SPLIT Flag" ).append("\n"); 
		query.append(", BKGM.BL_NO" ).append("\n"); 
		query.append(", BKGM.BL_TP_CD" ).append("\n"); 
		query.append(", BCST.CUST_NM   AS CSTMS_DESC   -- CNEE NAME" ).append("\n"); 
		query.append("FROM BKG_BOOKING  BKGM" ).append("\n"); 
		query.append(",BKG_CUSTOMER BCST" ).append("\n"); 
		query.append("WHERE BKGM.BKG_NO IN ( SELECT DISTINCT BKG_NO" ).append("\n"); 
		query.append("FROM BKG_REFERENCE" ).append("\n"); 
		query.append("WHERE BKG_REF_TP_CD IN ('BKPO','CTPO','CMPO')" ).append("\n"); 
		query.append("AND CUST_REF_NO_CTNT = @[po_no]" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT DISTINCT BKG_NO" ).append("\n"); 
		query.append("FROM BKG_REF_DTL BREF" ).append("\n"); 
		query.append("WHERE PO_NO = @[po_no] )" ).append("\n"); 
		query.append("AND BCST.BKG_CUST_TP_CD = DECODE(BKGM.CUST_TO_ORD_FLG, 'Y', 'N', 'C')" ).append("\n"); 
		query.append("AND BKGM.BKG_NO         = BCST.BKG_NO" ).append("\n"); 

	}
}
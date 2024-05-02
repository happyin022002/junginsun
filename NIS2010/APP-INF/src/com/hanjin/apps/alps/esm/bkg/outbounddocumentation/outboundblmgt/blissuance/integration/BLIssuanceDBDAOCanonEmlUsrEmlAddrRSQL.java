/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLIssuanceDBDAOCanonEmlUsrEmlAddrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.10.22 김영출
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

public class BLIssuanceDBDAOCanonEmlUsrEmlAddrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOCanonEmlUsrEmlAddrRSQL(){
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
		query.append("FileName : BLIssuanceDBDAOCanonEmlUsrEmlAddrRSQL").append("\n"); 
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
		query.append("SELECT NVL2(N1ST_EML,N1ST_EML||';','')||NVL2(N2ND_EML,N2ND_EML||';', '')||NVL2(N3RD_EML,N3RD_EML||';', '')||NVL2(N4TH_EML,N4TH_EML||';', '')||NVL2(N5TH_EML,N5TH_EML||';', '') EML_ADDR" ).append("\n"); 
		query.append("FROM   BKG_BOOKING BK, BKG_CUSTOMER BC, BKG_AUTO_EML_CUST BEC, COM_SYS_AREA_GRP_ID SI" ).append("\n"); 
		query.append("WHERE  BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BK.BKG_NO = BC.BKG_NO" ).append("\n"); 
		query.append("AND BK.POL_CD = BEC.POL_CD" ).append("\n"); 
		query.append("AND BC.BKG_CUST_TP_CD = 'S'" ).append("\n"); 
		query.append("AND BC.CUST_CNT_CD = BEC.CUST_CNT_CD" ).append("\n"); 
		query.append("AND BC.CUST_SEQ = BEC.CUST_SEQ" ).append("\n"); 
		query.append("AND SUBSTR (BK.POD_CD, 1, 2) = SI.CNT_CD" ).append("\n"); 
		query.append("AND BEC.DEST_SYS_AREA_GRP_ID = SI.SYS_AREA_GRP_ID" ).append("\n"); 

	}
}
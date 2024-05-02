/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BLIssuanceDBDAOCanonEmlRmkXchRtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.10.14 김영출
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Youngchul
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOCanonEmlRmkXchRtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOCanonEmlRmkXchRtRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration ").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOCanonEmlRmkXchRtRSQL").append("\n"); 
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
		query.append("SELECT 'EXCH. RATE : 1 USD = '||LTRIM(TO_CHAR(VER.INV_XCH_RT, '99,999.9999'))||' '||VER.LOCL_CURR_CD EXCH_RATE" ).append("\n"); 
		query.append("FROM   BKG_BOOKING BK, BKG_VVD VVD, INV_VVD_XCH_RT VER, MDM_CURRENCY CURR" ).append("\n"); 
		query.append("WHERE  BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("AND BK.POL_CD = VVD.POL_CD" ).append("\n"); 
		query.append("AND SUBSTR (BK.POL_CD, 1, 2) = CURR.CNT_CD" ).append("\n"); 
		query.append("AND CURR.CURR_CD = VER.LOCL_CURR_CD" ).append("\n"); 
		query.append("AND VVD.VSL_CD = VER.VSL_CD" ).append("\n"); 
		query.append("AND VVD.SKD_VOY_NO = VER.SKD_VOY_NO" ).append("\n"); 
		query.append("AND VVD.SKD_DIR_CD = VER.SKD_DIR_CD" ).append("\n"); 
		query.append("AND VVD.POL_CD = VER.PORT_CD" ).append("\n"); 
		query.append("AND DECODE (VER.LOCL_CURR_CD," ).append("\n"); 
		query.append("'KRW', CASE" ).append("\n"); 
		query.append("WHEN BK.POL_CD LIKE 'KR%'" ).append("\n"); 
		query.append("AND BK.POD_CD LIKE 'JP%' THEN" ).append("\n"); 
		query.append("'KOJ'" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("'OTH'" ).append("\n"); 
		query.append("END," ).append("\n"); 
		query.append("BK.SVC_SCP_CD) = VER.SVC_SCP_CD" ).append("\n"); 
		query.append("AND VER.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("AND VER.INV_XCH_RT > 0" ).append("\n"); 
		query.append("AND VER.CHG_CURR_CD = 'USD'" ).append("\n"); 

	}
}
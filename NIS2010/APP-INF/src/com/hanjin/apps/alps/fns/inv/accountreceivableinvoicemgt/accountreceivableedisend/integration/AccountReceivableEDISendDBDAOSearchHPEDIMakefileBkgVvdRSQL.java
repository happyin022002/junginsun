/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOSearchHPEDIMakefileBkgVvdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.06
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.10.06 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOSearchHPEDIMakefileBkgVvdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOSearchHPEDIMakefileBkgVvdRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOSearchHPEDIMakefileBkgVvdRSQL").append("\n"); 
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
		query.append("SELECT  BV.VSL_CD||BV.SKD_VOY_NO||BV.SKD_DIR_CD AS VSL_BVVD1" ).append("\n"); 
		query.append("        ,MV.LLOYD_NO AS VSL_LLOYDCODE" ).append("\n"); 
		query.append("        ,MV.VSL_ENG_NM AS VSL_FULLNAME" ).append("\n"); 
		query.append("        ,BC.CUST_CTY_NM AS VSL_ORIGIN" ).append("\n"); 
		query.append("        ,BB.POR_CD AS VSL_POR" ).append("\n"); 
		query.append("        ,BV.POL_CD AS VSL_POL" ).append("\n"); 
		query.append("        ,(SELECT M1.LOC_NM FROM MDM_LOCATION M1 WHERE M1.LOC_CD = BV.POL_CD) AS VSL_POL_FULLNAME" ).append("\n"); 
		query.append("        ,BV.POD_CD AS VSL_POD" ).append("\n"); 
		query.append("        ,BB.DEL_CD AS VSL_DEL" ).append("\n"); 
		query.append("		,BB.PRE_RLY_PORT_CD AS TS_PRE" ).append("\n"); 
		query.append("        ,BB.PST_RLY_PORT_CD AS TS_POST" ).append("\n"); 
		query.append("        ,(SELECT M2.LOC_NM FROM MDM_LOCATION M2 WHERE M2.LOC_CD = BV.POD_CD) AS VSL_POD_FULLNAME" ).append("\n"); 
		query.append("       ,(SELECT TO_CHAR(POL.VPS_ETD_DT, 'yyyymmddhh24mi')	" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD POL" ).append("\n"); 
		query.append("          WHERE BV.VSL_CD = POL.VSL_CD" ).append("\n"); 
		query.append("          AND BV.SKD_VOY_NO = POL.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND BV.SKD_DIR_CD = POL.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND BV.POL_CD = POL.VPS_PORT_CD" ).append("\n"); 
		query.append("          AND POL.CLPT_IND_SEQ = 1 ) AS VSL_POLETD" ).append("\n"); 
		query.append("       ,(SELECT TO_CHAR(POD.VPS_ETD_DT, 'yyyymmddhh24mi')" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD POD" ).append("\n"); 
		query.append("          WHERE BV.VSL_CD = POD.VSL_CD" ).append("\n"); 
		query.append("          AND BV.SKD_VOY_NO = POD.SKD_VOY_NO" ).append("\n"); 
		query.append("          AND BV.SKD_DIR_CD = POD.SKD_DIR_CD" ).append("\n"); 
		query.append("          AND BV.POL_CD = POD.VPS_PORT_CD" ).append("\n"); 
		query.append("          AND POD.CLPT_IND_SEQ = 1 ) AS VSL_PODETD" ).append("\n"); 
		query.append("FROM  BKG_VVD BV" ).append("\n"); 
		query.append("     ,MDM_VSL_CNTR MV" ).append("\n"); 
		query.append("     ,BKG_BOOKING BB" ).append("\n"); 
		query.append("	 ,BKG_CUSTOMER BC" ).append("\n"); 
		query.append("WHERE BV.BKG_NO = @[bkg_no]   --'AEVZ9225006'" ).append("\n"); 
		query.append("AND BV.VSL_PRE_PST_CD ='T'" ).append("\n"); 
		query.append("AND BV.VSL_CD = MV.VSL_CD" ).append("\n"); 
		query.append("AND BV.BKG_NO = BB.BKG_NO" ).append("\n"); 
		query.append("AND BV.BKG_NO = BC.BKG_NO(+)" ).append("\n"); 
		query.append("AND BC.BKG_CUST_TP_CD(+) = 'S'" ).append("\n"); 

	}
}
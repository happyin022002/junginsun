/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOSearchCurrentPatternOrdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.31
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOSearchCurrentPatternOrdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ProductCatalogCreateDBDAOSearchCurrentPatternOrdRSQL.Query
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOSearchCurrentPatternOrdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_mapg_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOSearchCurrentPatternOrdRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("PCTL_NO, BKG_NO, COP_NO, CRNT_FLG, CNTR_NO, CNTR_TPSZ_CD, COP_OP_TP_CD," ).append("\n"); 
		query.append("OB_ITCHG_CTNT, MTY_PKUP_YD_CD, BKG_OP_RMK, MTY_RTN_YD_CD, IB_ITCHG_CTNT," ).append("\n"); 
		query.append("POR_NOD_CD, OCN_ITCHG_CTNT, POL_NOD_CD, BKG_RCV_TERM_CD, BKG_DE_TERM_CD," ).append("\n"); 
		query.append("OB_TRO_FLG, IB_TRO_FLG, COP_PATT_ORD_NO, COP_SO_KNT,COP_MAPG_SEQ" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT " ).append("\n"); 
		query.append("	PCTL_NO, BKG_NO, COP_NO, CRNT_FLG, CNTR_NO, CNTR_TPSZ_CD, COP_OP_TP_CD," ).append("\n"); 
		query.append("	OB_ITCHG_CTNT, MTY_PKUP_YD_CD, BKG_OP_RMK, MTY_RTN_YD_CD, IB_ITCHG_CTNT," ).append("\n"); 
		query.append("	POR_NOD_CD, OCN_ITCHG_CTNT, POL_NOD_CD, BKG_RCV_TERM_CD, BKG_DE_TERM_CD," ).append("\n"); 
		query.append("	OB_TRO_FLG, IB_TRO_FLG, COP_PATT_ORD_NO, COP_SO_KNT,COP_MAPG_SEQ," ).append("\n"); 
		query.append("	row_number() over (partition by COP_PATT_ORD_NO order by COP_PATT_ORD_NO) rn," ).append("\n"); 
		query.append("	COUNT(*) OVER (PARTITION BY COP_PATT_ORD_NO) CNT" ).append("\n"); 
		query.append("	FROM PRD_BKG_COP_MAP M" ).append("\n"); 
		query.append("	WHERE 1 = 1" ).append("\n"); 
		query.append("#if	(${pctl_no} != '')" ).append("\n"); 
		query.append("	AND   PCTL_NO 		= @[pctl_no]" ).append("\n"); 
		query.append("	AND	  BKG_NO 		= @[bkg_no]" ).append("\n"); 
		query.append("	AND	  COP_NO 		= @[cop_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if	(${cop_mapg_seq} != '')" ).append("\n"); 
		query.append("	AND   COP_MAPG_SEQ 	= @[cop_mapg_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if	(${pctl_no} == ''  &&  ${cop_mapg_seq} == '') " ).append("\n"); 
		query.append("	AND 1 = 2" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE RN = 1" ).append("\n"); 
		query.append("ORDER BY COP_PATT_ORD_NO,NVL(POL_NOD_CD,'AAAAA00'), CNT DESC" ).append("\n"); 

	}
}
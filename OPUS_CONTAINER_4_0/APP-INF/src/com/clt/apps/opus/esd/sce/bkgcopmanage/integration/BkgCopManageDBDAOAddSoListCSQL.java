/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCopManageDBDAOAddSoListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.06
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.07.06 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOAddSoListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COP Header 와 Product Catalog number 로 SCE_PLN_SO_LIST 를 생성한다.
	  * </pre>
	  */
	public BkgCopManageDBDAOAddSoListCSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOAddSoListCSQL").append("\n"); 
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
		query.append("INSERT INTO SCE_PLN_SO_LIST" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("COP_NO," ).append("\n"); 
		query.append("COST_ACT_GRP_SEQ," ).append("\n"); 
		query.append("COST_ACT_GRP_CD," ).append("\n"); 
		query.append("CTRL_OFC_CD," ).append("\n"); 
		query.append("N1ST_NOD_PLN_DT," ).append("\n"); 
		query.append("N1ST_NOD_CD," ).append("\n"); 
		query.append("N2ND_NOD_CD," ).append("\n"); 
		query.append("N3RD_NOD_CD," ).append("\n"); 
		query.append("N4TH_NOD_CD," ).append("\n"); 
		query.append("PCTL_IO_BND_CD," ).append("\n"); 
		query.append("PCTL_COST_MOD_CD," ).append("\n"); 
		query.append("N1ST_VNDR_SEQ," ).append("\n"); 
		query.append("TRSP_SO_STS_CD," ).append("\n"); 
		query.append("TRSP_MOD_CD," ).append("\n"); 
		query.append("INLND_ROUT_INV_BIL_PATT_CD," ).append("\n"); 
		query.append("INV_BIL_PATT_DIV_FLG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("DOR_ARR_DT," ).append("\n"); 
		query.append("LST_NOD_PLN_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT COP_NO," ).append("\n"); 
		query.append("COST_ACT_GRP_SEQ," ).append("\n"); 
		query.append("COST_ACT_GRP_CD," ).append("\n"); 
		query.append("CTRL_OFC_CD," ).append("\n"); 
		query.append("N1ST_NOD_PLN_DT," ).append("\n"); 
		query.append("N1ST_NOD_CD," ).append("\n"); 
		query.append("N2ND_NOD_CD," ).append("\n"); 
		query.append("N3RD_NOD_CD," ).append("\n"); 
		query.append("N4TH_NOD_CD," ).append("\n"); 
		query.append("PCTL_IO_BND_CD," ).append("\n"); 
		query.append("PCTL_COST_MOD_CD," ).append("\n"); 
		query.append("N1ST_VNDR_SEQ," ).append("\n"); 
		query.append("TRSP_SO_STS_CD," ).append("\n"); 
		query.append("TRSP_MOD_CD," ).append("\n"); 
		query.append("INLND_ROUT_INV_BIL_PATT_CD," ).append("\n"); 
		query.append("INV_BIL_PATT_DIV_FLG," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT," ).append("\n"); 
		query.append("DOR_ARR_DT," ).append("\n"); 
		query.append("LST_NOD_PLN_DT" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.COP_NO COP_NO ," ).append("\n"); 
		query.append("B.COST_ACT_GRP_SEQ COST_ACT_GRP_SEQ ," ).append("\n"); 
		query.append("MAX(B.COST_ACT_GRP_CD ) COST_ACT_GRP_CD ," ).append("\n"); 
		query.append("MAX(B.CTRL_OFC_CD ) CTRL_OFC_CD ," ).append("\n"); 
		query.append("MAX(B.N1ST_NOD_PLN_DT ) N1ST_NOD_PLN_DT ," ).append("\n"); 
		query.append("MAX(B.N1ST_NOD_CD ) N1ST_NOD_CD ," ).append("\n"); 
		query.append("MAX(B.N2ND_NOD_CD ) N2ND_NOD_CD ," ).append("\n"); 
		query.append("MAX(B.N3RD_NOD_CD ) N3RD_NOD_CD ," ).append("\n"); 
		query.append("MAX(B.N4TH_NOD_CD ) N4TH_NOD_CD ," ).append("\n"); 
		query.append("MAX(B.PCTL_IO_BND_CD ) PCTL_IO_BND_CD ," ).append("\n"); 
		query.append("MAX(B.PCTL_COST_MOD_CD ) PCTL_COST_MOD_CD ," ).append("\n"); 
		query.append("MAX(B.N1ST_VNDR_SEQ ) N1ST_VNDR_SEQ ," ).append("\n"); 
		query.append("MAX(B.TRSP_SO_STS_CD ) TRSP_SO_STS_CD ," ).append("\n"); 
		query.append("MAX(B.TRSP_MOD_CD ) TRSP_MOD_CD ," ).append("\n"); 
		query.append("MAX(B.INLND_ROUT_INV_BIL_PATT_CD) INLND_ROUT_INV_BIL_PATT_CD ," ).append("\n"); 
		query.append("MAX(B.INV_BIL_PATT_DIV_FLG ) INV_BIL_PATT_DIV_FLG ," ).append("\n"); 
		query.append("'SYS' CRE_USR_ID ," ).append("\n"); 
		query.append("SYSDATE CRE_DT ," ).append("\n"); 
		query.append("'SYS' UPD_USR_ID ," ).append("\n"); 
		query.append("SYSDATE UPD_DT ," ).append("\n"); 
		query.append("MAX(B.DOR_ARR_DT ) DOR_ARR_DT ," ).append("\n"); 
		query.append("MAX(B.LST_NOD_ARR_DT ) LST_NOD_PLN_DT" ).append("\n"); 
		query.append("FROM SCE_COP_HDR A ," ).append("\n"); 
		query.append("PRD_PROD_CTL_ACT_GRP_DTL B" ).append("\n"); 
		query.append("WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND A.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND B.PCTL_NO = A.PCTL_NO" ).append("\n"); 
		query.append("GROUP BY A.COP_NO , B.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ((" ).append("\n"); 
		query.append("SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.COP_NO COP_NO ," ).append("\n"); 
		query.append("B.COST_ACT_GRP_SEQ COST_ACT_GRP_SEQ ," ).append("\n"); 
		query.append("MAX(B.COST_ACT_GRP_CD ) COST_ACT_GRP_CD ," ).append("\n"); 
		query.append("MAX(B.CTRL_OFC_CD ) CTRL_OFC_CD ," ).append("\n"); 
		query.append("MAX(B.N1ST_NOD_PLN_DT ) N1ST_NOD_PLN_DT ," ).append("\n"); 
		query.append("MAX(B.N1ST_NOD_CD ) N1ST_NOD_CD ," ).append("\n"); 
		query.append("MAX(B.N2ND_NOD_CD ) N2ND_NOD_CD ," ).append("\n"); 
		query.append("MAX(B.N3RD_NOD_CD ) N3RD_NOD_CD ," ).append("\n"); 
		query.append("MAX(B.N4TH_NOD_CD ) N4TH_NOD_CD ," ).append("\n"); 
		query.append("MAX(B.PCTL_IO_BND_CD ) PCTL_IO_BND_CD ," ).append("\n"); 
		query.append("MAX(B.PCTL_COST_MOD_CD ) PCTL_COST_MOD_CD ," ).append("\n"); 
		query.append("MAX(B.N1ST_VNDR_SEQ ) N1ST_VNDR_SEQ ," ).append("\n"); 
		query.append("MAX(B.TRSP_SO_STS_CD ) TRSP_SO_STS_CD ," ).append("\n"); 
		query.append("MAX(B.TRSP_MOD_CD ) TRSP_MOD_CD ," ).append("\n"); 
		query.append("MAX(B.INLND_ROUT_INV_BIL_PATT_CD) INLND_ROUT_INV_BIL_PATT_CD ," ).append("\n"); 
		query.append("MAX(B.INV_BIL_PATT_DIV_FLG ) INV_BIL_PATT_DIV_FLG ," ).append("\n"); 
		query.append("'SYS' CRE_USR_ID ," ).append("\n"); 
		query.append("SYSDATE CRE_DT ," ).append("\n"); 
		query.append("'SYS' UPD_USR_ID ," ).append("\n"); 
		query.append("SYSDATE UPD_DT ," ).append("\n"); 
		query.append("MAX(B.DOR_ARR_DT ) DOR_ARR_DT ," ).append("\n"); 
		query.append("MAX(B.LST_NOD_ARR_DT ) LST_NOD_PLN_DT" ).append("\n"); 
		query.append("FROM SCE_COP_HDR A ," ).append("\n"); 
		query.append("PRD_PROD_CTL_ACT_GRP_DTL B" ).append("\n"); 
		query.append("WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND A.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND B.PCTL_NO = A.PCTL_NO" ).append("\n"); 
		query.append("GROUP BY A.COP_NO , B.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE NVL(TRSP_SO_STS_CD, 'U') != 'U') > 0" ).append("\n"); 
		query.append("AND NVL(TRSP_SO_STS_CD, 'U') != 'U')" ).append("\n"); 
		query.append("OR ((" ).append("\n"); 
		query.append("SELECT COUNT(*)" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT A.COP_NO COP_NO ," ).append("\n"); 
		query.append("B.COST_ACT_GRP_SEQ COST_ACT_GRP_SEQ ," ).append("\n"); 
		query.append("MAX(B.COST_ACT_GRP_CD ) COST_ACT_GRP_CD ," ).append("\n"); 
		query.append("MAX(B.CTRL_OFC_CD ) CTRL_OFC_CD ," ).append("\n"); 
		query.append("MAX(B.N1ST_NOD_PLN_DT ) N1ST_NOD_PLN_DT ," ).append("\n"); 
		query.append("MAX(B.N1ST_NOD_CD ) N1ST_NOD_CD ," ).append("\n"); 
		query.append("MAX(B.N2ND_NOD_CD ) N2ND_NOD_CD ," ).append("\n"); 
		query.append("MAX(B.N3RD_NOD_CD ) N3RD_NOD_CD ," ).append("\n"); 
		query.append("MAX(B.N4TH_NOD_CD ) N4TH_NOD_CD ," ).append("\n"); 
		query.append("MAX(B.PCTL_IO_BND_CD ) PCTL_IO_BND_CD ," ).append("\n"); 
		query.append("MAX(B.PCTL_COST_MOD_CD ) PCTL_COST_MOD_CD ," ).append("\n"); 
		query.append("MAX(B.N1ST_VNDR_SEQ ) N1ST_VNDR_SEQ ," ).append("\n"); 
		query.append("MAX(B.TRSP_SO_STS_CD ) TRSP_SO_STS_CD ," ).append("\n"); 
		query.append("MAX(B.TRSP_MOD_CD ) TRSP_MOD_CD ," ).append("\n"); 
		query.append("MAX(B.INLND_ROUT_INV_BIL_PATT_CD) INLND_ROUT_INV_BIL_PATT_CD ," ).append("\n"); 
		query.append("MAX(B.INV_BIL_PATT_DIV_FLG ) INV_BIL_PATT_DIV_FLG ," ).append("\n"); 
		query.append("'SYS' CRE_USR_ID ," ).append("\n"); 
		query.append("SYSDATE CRE_DT ," ).append("\n"); 
		query.append("'SYS' UPD_USR_ID ," ).append("\n"); 
		query.append("SYSDATE UPD_DT ," ).append("\n"); 
		query.append("MAX(B.DOR_ARR_DT ) DOR_ARR_DT ," ).append("\n"); 
		query.append("MAX(B.LST_NOD_ARR_DT ) LST_NOD_PLN_DT" ).append("\n"); 
		query.append("FROM SCE_COP_HDR A ," ).append("\n"); 
		query.append("PRD_PROD_CTL_ACT_GRP_DTL B" ).append("\n"); 
		query.append("WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND A.COP_NO = @[cop_no]" ).append("\n"); 
		query.append("AND B.PCTL_NO = A.PCTL_NO" ).append("\n"); 
		query.append("GROUP BY A.COP_NO , B.COST_ACT_GRP_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE NVL(TRSP_SO_STS_CD, 'U') != 'U') = 0" ).append("\n"); 
		query.append("AND COST_ACT_GRP_SEQ = 990)" ).append("\n"); 
		query.append("ORDER BY COP_NO, COST_ACT_GRP_SEQ" ).append("\n"); 

	}
}
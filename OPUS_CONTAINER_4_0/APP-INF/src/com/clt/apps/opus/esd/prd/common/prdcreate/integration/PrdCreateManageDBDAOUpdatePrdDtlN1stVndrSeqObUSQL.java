/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PrdCreateManageDBDAOUpdatePrdDtlN1stVndrSeqObUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.09.09 정선용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author sun yong Jung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCreateManageDBDAOUpdatePrdDtlN1stVndrSeqObUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * updatePrdDtlN1stVndrSeqOb
	  * </pre>
	  */
	public PrdCreateManageDBDAOUpdatePrdDtlN1stVndrSeqObUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.common.prdcreate.integration").append("\n"); 
		query.append("FileName : PrdCreateManageDBDAOUpdatePrdDtlN1stVndrSeqObUSQL").append("\n"); 
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
		query.append("UPDATE PRD_PROD_CTL_ROUT_DTL D SET (D.N1ST_VNDR_SEQ,D.CUST_NOMI_TRKR_FLG,D.TRSP_MOD_CD,D.INLND_ROUT_CMB_FLG)" ).append("\n"); 
		query.append("= ( SELECT C.VNDR_SEQ,'Y','TD','N'" ).append("\n"); 
		query.append("FROM PRD_CUST_PRF C" ).append("\n"); 
		query.append("WHERE C.ORG_LOC_CD =SUBSTR(D.ORG_NOD_CD,1,5)" ).append("\n"); 
		query.append("AND C.DEST_LOC_CD =SUBSTR(D.DEST_NOD_CD,1,5)" ).append("\n"); 
		query.append("AND C.TRSP_MOD_CD = 'TD'" ).append("\n"); 
		query.append("AND C.TRSP_MOD_CD =D.TRSP_MOD_CD" ).append("\n"); 
		query.append("AND D.MTY_YD_FLG ='N'" ).append("\n"); 
		query.append("AND D.NOD_LNK_DIV_CD ='L'" ).append("\n"); 
		query.append("AND D.PCTL_IO_BND_CD ='I'" ).append("\n"); 
		query.append("AND ( C.CUST_CNT_CD, C.CUST_SEQ) = (" ).append("\n"); 
		query.append("SELECT DECODE(M.ACT_CUST_CNT_CD,'',M.CNEE_CNT_CD,M.ACT_CUST_CNT_CD)," ).append("\n"); 
		query.append("DECODE(M.ACT_CUST_SEQ,'',M.CNEE_SEQ,M.ACT_CUST_SEQ)" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_MST M" ).append("\n"); 
		query.append("WHERE M.PCTL_NO LIKE @[hd_pctl_no]||'%'" ).append("\n"); 
		query.append("AND M.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("AND ROWNUM =1   )" ).append("\n"); 
		query.append("AND ROWNUM =1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE EXISTS" ).append("\n"); 
		query.append("(SELECT 'X' FROM PRD_CUST_PRF C" ).append("\n"); 
		query.append("WHERE C.ORG_LOC_CD =SUBSTR(D.ORG_NOD_CD,1,5)" ).append("\n"); 
		query.append("AND C.DEST_LOC_CD =SUBSTR(D.DEST_NOD_CD,1,5)" ).append("\n"); 
		query.append("AND C.TRSP_MOD_CD = 'TD'" ).append("\n"); 
		query.append("AND C.TRSP_MOD_CD =D.TRSP_MOD_CD" ).append("\n"); 
		query.append("AND D.MTY_YD_FLG ='N'" ).append("\n"); 
		query.append("AND D.NOD_LNK_DIV_CD ='L'" ).append("\n"); 
		query.append("AND D.PCTL_IO_BND_CD ='I'" ).append("\n"); 
		query.append("AND ( C.CUST_CNT_CD, C.CUST_SEQ) = (" ).append("\n"); 
		query.append("SELECT DECODE(M.ACT_CUST_CNT_CD,'',M.CNEE_CNT_CD,M.ACT_CUST_CNT_CD)," ).append("\n"); 
		query.append("DECODE(M.ACT_CUST_SEQ,'',M.CNEE_SEQ,M.ACT_CUST_SEQ)" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_MST M" ).append("\n"); 
		query.append("WHERE M.PCTL_NO LIKE @[hd_pctl_no]||'%'" ).append("\n"); 
		query.append("AND M.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("AND ROWNUM =1   )" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND  NOT EXISTS" ).append("\n"); 
		query.append("(SELECT 'X' FROM PRD_PROD_CTL_ROUT_DTL D2" ).append("\n"); 
		query.append("WHERE D2.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("AND D2.TRSP_MOD_CD ='RD'" ).append("\n"); 
		query.append("AND D2.PCTL_IO_BND_CD =D.PCTL_IO_BND_CD" ).append("\n"); 
		query.append("AND D2.INLND_ROUT_INV_BIL_PATT_CD IS NOT  NULL" ).append("\n"); 
		query.append("AND D2.PCTL_SEQ = D.PCTL_SEQ -2" ).append("\n"); 
		query.append("AND D2.PCTL_SEQ = D.PCTL_SEQ +2" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND  D.MTY_YD_FLG ='N'" ).append("\n"); 
		query.append("AND  D.PCTL_NO LIKE @[hd_pctl_no]||'%'" ).append("\n"); 
		query.append("AND  D.PCTL_SEQ < (SELECT MAX(D2.PCTL_SEQ)-2 FROM PRD_PROD_CTL_ROUT_DTL D2" ).append("\n"); 
		query.append("WHERE D2.PCTL_NO = D.PCTL_NO)" ).append("\n"); 

	}
}
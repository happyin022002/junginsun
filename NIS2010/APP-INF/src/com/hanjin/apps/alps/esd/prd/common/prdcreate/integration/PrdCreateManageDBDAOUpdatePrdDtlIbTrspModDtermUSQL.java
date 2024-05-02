/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PrdCreateManageDBDAOUpdatePrdDtlIbTrspModDtermUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.09.09 정선용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.common.prdcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author sun yong Jung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCreateManageDBDAOUpdatePrdDtlIbTrspModDtermUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * updatePrdDtlIbTrspModDterm (  )
	  * </pre>
	  */
	public PrdCreateManageDBDAOUpdatePrdDtlIbTrspModDtermUSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.prd.common.prdcreate.integration").append("\n"); 
		query.append("FileName : PrdCreateManageDBDAOUpdatePrdDtlIbTrspModDtermUSQL").append("\n"); 
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
		query.append("UPDATE PRD_PROD_CTL_ROUT_DTL D" ).append("\n"); 
		query.append("SET (D.N1ST_VNDR_SEQ,D.TRSP_MOD_CD,D.INLND_ROUT_CMB_FLG)" ).append("\n"); 
		query.append("= (SELECT D1.N1ST_VNDR_SEQ,D1.TRSP_MOD_CD,D1.INLND_ROUT_CMB_FLG" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL D1" ).append("\n"); 
		query.append("WHERE D1.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("AND D1.PCTL_SEQ = (SELECT MAX(D2.PCTL_SEQ)-3 FROM PRD_PROD_CTL_ROUT_DTL D2" ).append("\n"); 
		query.append("WHERE D2.PCTL_NO = D.PCTL_NO))" ).append("\n"); 
		query.append("WHERE D.PCTL_NO LIKE @[hd_pctl_no]||'%'" ).append("\n"); 
		query.append("AND D.PCTL_IO_BND_CD ='I'" ).append("\n"); 
		query.append("AND D.PCTL_SEQ = (SELECT MAX(D2.PCTL_SEQ)-1 FROM PRD_PROD_CTL_ROUT_DTL D2" ).append("\n"); 
		query.append("WHERE D2.PCTL_NO = D.PCTL_NO)" ).append("\n"); 
		query.append("AND EXISTS" ).append("\n"); 
		query.append("(SELECT 'X' FROM PRD_PROD_CTL_MST M" ).append("\n"); 
		query.append("WHERE M.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("AND M.BKG_DE_TERM_CD ='D')" ).append("\n"); 

	}
}
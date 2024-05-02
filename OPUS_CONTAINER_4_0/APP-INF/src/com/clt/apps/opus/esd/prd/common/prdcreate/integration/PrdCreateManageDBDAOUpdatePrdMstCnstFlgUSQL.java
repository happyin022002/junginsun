/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PrdCreateManageDBDAOUpdatePrdMstCnstFlgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCreateManageDBDAOUpdatePrdMstCnstFlgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PrdCreateManageDBDAOUpdatePrdMstCnstFlgUSQL
	  * </pre>
	  */
	public PrdCreateManageDBDAOUpdatePrdMstCnstFlgUSQL(){
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
		query.append("FileName : PrdCreateManageDBDAOUpdatePrdMstCnstFlgUSQL").append("\n"); 
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
		query.append("UPDATE PRD_PROD_CTL_MST M															" ).append("\n"); 
		query.append("SET CNST_FLG =																		" ).append("\n"); 
		query.append("	( SELECT MAX(																	" ).append("\n"); 
		query.append("			(CASE																	" ).append("\n"); 
		query.append("				WHEN MST.CNST_FLG = 'X' OR LNK.CNST_FLG = 'X' OR NOD.CNST_FLG = 'X' THEN 'X' " ).append("\n"); 
		query.append("				WHEN MST.CNST_FLG = 'R' THEN											" ).append("\n"); 
		query.append("				(																	" ).append("\n"); 
		query.append("					CASE															" ).append("\n"); 
		query.append("						WHEN LNK.CNST_FLG = 'L' AND NOD.CNST_FLG = 'N' THEN 'A'		" ).append("\n"); 
		query.append("						WHEN LNK.CNST_FLG = 'L' THEN 'O'							" ).append("\n"); 
		query.append("						WHEN NOD.CNST_FLG = 'N' THEN 'P'							" ).append("\n"); 
		query.append("						ELSE 'R'													" ).append("\n"); 
		query.append("					 END															" ).append("\n"); 
		query.append("				)																	" ).append("\n"); 
		query.append("				WHEN LNK.CNST_FLG = 'L' THEN										" ).append("\n"); 
		query.append("				(																	" ).append("\n"); 
		query.append("					CASE															" ).append("\n"); 
		query.append("						WHEN NOD.CNST_FLG = 'N' THEN 'I'							" ).append("\n"); 
		query.append("						ELSE 'L'													" ).append("\n"); 
		query.append("					END																" ).append("\n"); 
		query.append("				)																	" ).append("\n"); 
		query.append("				WHEN NOD.CNST_FLG = 'N' THEN 'N'									" ).append("\n"); 
		query.append("			END																		" ).append("\n"); 
		query.append("		   )) CNST_FLG																" ).append("\n"); 
		query.append("	FROM PRD_PROD_CTL_MST MST,														" ).append("\n"); 
		query.append("		( SELECT PCTL_NO, CNST_FLG FROM PRD_PROD_CTL_ROUT_DTL						" ).append("\n"); 
		query.append("		  WHERE PCTL_NO LIKE @[hd_pctl_no]||'%'													" ).append("\n"); 
		query.append("		  AND NOD_LNK_DIV_CD = 'N'													" ).append("\n"); 
		query.append("		  AND CNST_FLG IN ('N', 'X')												" ).append("\n"); 
		query.append("		) NOD,																		" ).append("\n"); 
		query.append("		( SELECT PCTL_NO, CNST_FLG FROM PRD_PROD_CTL_ROUT_DTL						" ).append("\n"); 
		query.append("		  WHERE PCTL_NO LIKE @[hd_pctl_no]||'%'													" ).append("\n"); 
		query.append("		  AND NOD_LNK_DIV_CD = 'L'													" ).append("\n"); 
		query.append("		  AND CNST_FLG IN ('L', 'X')												" ).append("\n"); 
		query.append("		) LNK																		" ).append("\n"); 
		query.append("	WHERE MST.PCTL_NO = NOD.PCTL_NO(+)												" ).append("\n"); 
		query.append("	AND MST.PCTL_NO = LNK.PCTL_NO(+)												" ).append("\n"); 
		query.append("	AND MST.PCTL_NO = M.PCTL_NO														" ).append("\n"); 
		query.append("	GROUP BY MST.PCTL_NO															" ).append("\n"); 
		query.append(")																					" ).append("\n"); 
		query.append("WHERE M.PCTL_NO LIKE @[hd_pctl_no]||'%'" ).append("\n"); 

	}
}
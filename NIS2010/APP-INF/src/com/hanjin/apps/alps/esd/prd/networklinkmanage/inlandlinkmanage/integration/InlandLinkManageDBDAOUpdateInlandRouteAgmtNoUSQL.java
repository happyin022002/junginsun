/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : InlandLinkManageDBDAOUpdateInlandRouteAgmtNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.23
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InlandLinkManageDBDAOUpdateInlandRouteAgmtNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdateInlandRouteAgmtNo
	  * </pre>
	  */
	public InlandLinkManageDBDAOUpdateInlandRouteAgmtNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_mod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("i_agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.integration").append("\n"); 
		query.append("FileName : InlandLinkManageDBDAOUpdateInlandRouteAgmtNoUSQL").append("\n"); 
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
		query.append("UPDATE  PRD_INLND_ROUT_DTL D " ).append("\n"); 
		query.append("SET   TRSP_AGMT_OFC_CTY_CD = @[cty_cd] , TRSP_AGMT_SEQ= TO_NUMBER( @[i_agmt_seq] )" ).append("\n"); 
		query.append("where  LNK_ORG_NOD_CD= @[org_cd] --'USLGBM1'" ).append("\n"); 
		query.append("and LNK_DEST_NOD_CD= @[dest_cd] --'USCHIR5'" ).append("\n"); 
		query.append("and TRSP_MOD_CD= @[trsp_mod]--'RD'" ).append("\n"); 
		query.append("and VNDR_SEQ= @[vndr_seq] -- 119993   " ).append("\n"); 
		query.append("and 'N' = (SELECT NVL(DELT_FLG,'N') FROM PRD_INLND_ROUT_MST M " ).append("\n"); 
		query.append("            WHERE M.ROUT_ORG_NOD_CD= D.ROUT_ORG_NOD_CD " ).append("\n"); 
		query.append("              AND M.ROUT_DEST_NOD_CD = D.ROUT_DEST_NOD_CD " ).append("\n"); 
		query.append("              AND M.ROUT_SEQ = D.ROUT_SEQ )" ).append("\n"); 

	}
}
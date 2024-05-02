/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InlandLinkManageDBDAOUpdateInlandRouteAgmtNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 김귀진
*@LastVersion : 1.0
* 2009.08.17 김귀진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandlinkmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author kIm kwi-jin
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
		query.append("Path : com.clt.apps.opus.esd.prd.networklinkmanage.inlandlinkmanage.integration ").append("\n"); 
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
		query.append("UPDATE  prd_inlnd_rout_dtl DTL" ).append("\n"); 
		query.append("SET TRSP_AGMT_OFC_CTY_CD = @[cty_cd] , TRSP_AGMT_SEQ= TO_NUMBER( @[i_agmt_seq] )" ).append("\n"); 
		query.append("WHERE EXISTS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("select DISTINCT ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD,ROUT_SEQ," ).append("\n"); 
		query.append("LNK_ORG_NOD_CD,LNK_DEST_NOD_CD,ROUT_DTL_SEQ,TRSP_MOD_CD,VNDR_SEQ" ).append("\n"); 
		query.append("from prd_inlnd_rout_dtl d" ).append("\n"); 
		query.append("where" ).append("\n"); 
		query.append("EXISTS (" ).append("\n"); 
		query.append("SELECT 'X'" ).append("\n"); 
		query.append("FROM PRD_INLND_ROUT_MST M" ).append("\n"); 
		query.append("WHERE m.ROUT_ORG_NOD_CD= d.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("and m.ROUT_DEST_NOD_CD = d.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("and m.ROUT_SEQ = d.ROUT_SEQ" ).append("\n"); 
		query.append("AND NVL(m.DELT_FLG,'N') ='N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND LNK_ORG_NOD_CD= @[org_cd]" ).append("\n"); 
		query.append("and LNK_DEST_NOD_CD= @[dest_cd]" ).append("\n"); 
		query.append("and TRSP_MOD_CD= @[trsp_mod]" ).append("\n"); 
		query.append("and VNDR_SEQ= @[vndr_seq]" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE DTL.ROUT_ORG_NOD_CD =A.ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("AND DTL.ROUT_DEST_NOD_CD = A.ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("AND DTL.ROUT_SEQ = A.ROUT_SEQ" ).append("\n"); 
		query.append("AND DTL.LNK_ORG_NOD_CD = A.LNK_ORG_NOD_CD" ).append("\n"); 
		query.append("AND DTL.LNK_DEST_NOD_CD = A.LNK_DEST_NOD_CD" ).append("\n"); 
		query.append("AND DTL.ROUT_DTL_SEQ = A.ROUT_DTL_SEQ" ).append("\n"); 
		query.append("AND DTL.TRSP_MOD_CD = A.TRSP_MOD_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : COPSearchDBDAOSearchValidSOByCopNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.06
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2012.03.06 김인수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class COPSearchDBDAOSearchValidSOByCopNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COP_NO 로 삭제, Frustrate, Unmatch 처리 되지 않은 S/O 가 해당 Bound 에 존재하는 지 확인한다.
	  * </pre>
	  */
	public COPSearchDBDAOSearchValidSOByCopNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_nod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copmanage.copsearch.integration").append("\n"); 
		query.append("FileName : COPSearchDBDAOSearchValidSOByCopNoRSQL").append("\n"); 
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
		query.append("select REGEXP_REPLACE(PRD_GET_INLND_ROUT_STR_FNC(ROUT_ORG_NOD_CD, ROUT_DEST_NOD_CD, ROUT_SEQ), '-.-', '-') irg" ).append("\n"); 
		query.append("     , DECODE(REPLACE(PRD_GET_COP_BND_SO_STR_FNC(@[cop_no], @[trsp_bnd_cd]), '%', ''), NULL, '#'" ).append("\n"); 
		query.append("                        , REGEXP_REPLACE(PRD_GET_COP_BND_SO_STR_FNC(@[cop_no], @[trsp_bnd_cd]), '-.-...-', '-')  ) so" ).append("\n"); 
		query.append("from prd_inlnd_rout_mst" ).append("\n"); 
		query.append("where " ).append("\n"); 
		query.append("(ROUT_ORG_NOD_CD, ROUT_DEST_NOD_CD) IN " ).append("\n"); 
		query.append("	(SELECT DISTINCT DECODE(@[trsp_bnd_cd], 'O', NVL(@[new_nod], ROUT_ORG_NOD_CD), ROUT_ORG_NOD_CD), " ).append("\n"); 
		query.append("					 DECODE(@[trsp_bnd_cd], 'I', NVL(@[new_nod], ROUT_DEST_NOD_CD), ROUT_DEST_NOD_CD) FROM PRD_PROD_CTL_ROUT_DTL WHERE PCTL_NO = " ).append("\n"); 
		query.append("		(SELECT PCTL_NO FROM SCE_COP_HDR WHERE COP_NO = @[cop_no]) AND PCTL_IO_BND_CD = @[trsp_bnd_cd]" ).append("\n"); 
		query.append("	)" ).append("\n"); 
		query.append("and NVL(DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("AND NVL(AUTO_IRG_FLG,'N') = 'N'" ).append("\n"); 
		query.append("AND REGEXP_LIKE(REGEXP_REPLACE(PRD_GET_INLND_ROUT_STR_FNC(ROUT_ORG_NOD_CD, ROUT_DEST_NOD_CD, ROUT_SEQ), '-.-', '-')" ).append("\n"); 
		query.append("                 , DECODE(REPLACE(PRD_GET_COP_BND_SO_STR_FNC(@[cop_no], @[trsp_bnd_cd]), '%', ''), NULL, '#'" ).append("\n"); 
		query.append("                        , REPLACE( REGEXP_REPLACE(PRD_GET_COP_BND_SO_STR_FNC(@[cop_no], @[trsp_bnd_cd]), '-.-...-', '-') , '%', '(.*)') ))" ).append("\n"); 

	}
}
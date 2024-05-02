/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerSelectPopupDBDAOSearchContainerSelectSubListRSoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 조풍연
*@LastVersion : 1.0
* 2010.04.23 조풍연
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.common.containerselectpopup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author POONG-YEON CHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerSelectPopupDBDAOSearchContainerSelectSubListRSoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/O 번호 조회
	  * </pre>
	  */
	public ContainerSelectPopupDBDAOSearchContainerSelectSubListRSoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkgNo",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eqNo",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.common.containerselectpopup.integration").append("\n"); 
		query.append("FileName : ContainerSelectPopupDBDAOSearchContainerSelectSubListRSoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("A.TRSP_SO_OFC_CTY_CD || A.TRSP_SO_SEQ AS APPLY_SO_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append(",    BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("B.BKG_NO                 = @[bkgNo]" ).append("\n"); 
		query.append("OR B.FM_BKG_NO              = @[bkgNo]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND A.BKG_NO                 = B.BKG_NO" ).append("\n"); 
		query.append("AND A.EQ_NO                  = @[eqNo]" ).append("\n"); 
		query.append("AND SUBSTR(A.COST_ACT_GRP_CD,1,2)     = 'OD'" ).append("\n"); 
		query.append("AND DELT_FLG                 = 'N'" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.TRSP_SO_OFC_CTY_CD || A.TRSP_SO_SEQ AS APPLY_SO_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append(",    BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("B.BKG_NO                 = @[bkgNo]" ).append("\n"); 
		query.append("OR B.FM_BKG_NO              = @[bkgNo]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND A.ORG_BKG_NO             = B.BKG_NO" ).append("\n"); 
		query.append("AND A.EQ_NO                  = @[eqNo]" ).append("\n"); 
		query.append("AND SUBSTR(A.COST_ACT_GRP_CD,1,2)     = 'OD'" ).append("\n"); 
		query.append("AND DELT_FLG                 = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}
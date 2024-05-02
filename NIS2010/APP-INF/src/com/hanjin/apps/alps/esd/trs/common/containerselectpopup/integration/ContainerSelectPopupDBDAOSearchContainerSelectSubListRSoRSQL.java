/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ContainerSelectPopupDBDAOSearchContainerSelectSubListRSoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.11
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2011.11.11 최종혁
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.containerselectpopup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JH CHOI
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
	  * 2011.04.05 김영철 [CHM-201109654-01] Frustrate 처리된 CNTR 에 대해 두번이상 S/O 가 난 건들의 Invoice 처리 가능하도록 수정요청 ( TRO_SEQ을 조건문에 추가 )
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("troSeq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.common.containerselectpopup.integration").append("\n"); 
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
		query.append("AND NVL2(TO_NUMBER(@[troSeq]),A.TRO_SEQ,0) = NVL(@[troSeq],0)" ).append("\n"); 
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
		query.append("AND NVL2(TO_NUMBER(@[troSeq]),A.TRO_SEQ,0) = NVL(@[troSeq],0)" ).append("\n"); 
		query.append("AND SUBSTR(A.COST_ACT_GRP_CD,1,2)     = 'OD'" ).append("\n"); 
		query.append("AND DELT_FLG                 = 'N'" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("A.TRSP_SO_OFC_CTY_CD || A.TRSP_SO_SEQ AS APPLY_SO_SEQ" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("TRS_TRSP_SVC_ORD A" ).append("\n"); 
		query.append(",    BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("B.BKG_NO                 = @[bkgNo]" ).append("\n"); 
		query.append("OR B.BKG_NO IN (SELECT X.BKG_NO" ).append("\n"); 
		query.append("FROM BKG_BOOKING X" ).append("\n"); 
		query.append(",BKG_BOOKING Y" ).append("\n"); 
		query.append("WHERE X.TO_BKG_NO = Y.TO_BKG_NO" ).append("\n"); 
		query.append("AND Y.BKG_NO = @[bkgNo]" ).append("\n"); 
		query.append("AND X.BKG_STS_CD = 'X'" ).append("\n"); 
		query.append("AND Y.BKG_STS_CD = 'X'" ).append("\n"); 
		query.append("AND X.TO_BKG_NO IS NOT NULL" ).append("\n"); 
		query.append("AND Y.TO_BKG_NO IS NOT NULL" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT DISTINCT X.TO_BKG_NO" ).append("\n"); 
		query.append("FROM BKG_BOOKING X" ).append("\n"); 
		query.append(",BKG_BOOKING Y" ).append("\n"); 
		query.append("WHERE X.TO_BKG_NO = Y.TO_BKG_NO" ).append("\n"); 
		query.append("AND Y.BKG_NO = @[bkgNo]" ).append("\n"); 
		query.append("AND X.BKG_STS_CD = 'X'" ).append("\n"); 
		query.append("AND Y.BKG_STS_CD = 'X'" ).append("\n"); 
		query.append("AND X.TO_BKG_NO IS NOT NULL" ).append("\n"); 
		query.append("AND Y.TO_BKG_NO IS NOT NULL" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("AND A.BKG_NO                 = B.BKG_NO" ).append("\n"); 
		query.append("AND A.EQ_NO                  = @[eqNo]" ).append("\n"); 
		query.append("AND NVL2(TO_NUMBER(@[troSeq]),A.TRO_SEQ,0) = NVL(@[troSeq],0)" ).append("\n"); 
		query.append("AND SUBSTR(A.COST_ACT_GRP_CD,1,2)     = 'OD'" ).append("\n"); 
		query.append("AND DELT_FLG                 = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}
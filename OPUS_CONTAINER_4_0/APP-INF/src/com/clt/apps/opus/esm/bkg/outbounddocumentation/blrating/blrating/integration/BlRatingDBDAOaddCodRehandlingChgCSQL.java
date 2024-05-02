/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BlRatingDBDAOaddCodRehandlingChgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.29
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.11.29 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOaddCodRehandlingChgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * bkg_cod_cost에서 bkg_chg_rt 로 rehandling charge를 복사한다.
	  * </pre>
	  */
	public BlRatingDBDAOaddCodRehandlingChgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOaddCodRehandlingChgCSQL").append("\n"); 
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
		query.append("insert into bkg_chg_rt(" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(", RT_SEQ" ).append("\n"); 
		query.append(", DP_SEQ" ).append("\n"); 
		query.append(", FRT_TERM_CD" ).append("\n"); 
		query.append(", CGO_CATE_CD" ).append("\n"); 
		query.append(", CHG_CD" ).append("\n"); 
		query.append(", CURR_CD" ).append("\n"); 
		query.append(", RAT_UT_CD" ).append("\n"); 
		query.append(", RAT_AS_QTY" ).append("\n"); 
		query.append(", CHG_UT_AMT" ).append("\n"); 
		query.append(", CHG_AMT" ).append("\n"); 
		query.append(", PRN_HDN_FLG" ).append("\n"); 
		query.append(", AUTO_RAT_CD" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(")select" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(",(SELECT  NVL(MAX(RT_SEQ),0)+COST_CD_RQST_SEQ AS RTSEQ FROM BKG_CHG_RT WHERE BKG_NO = @[bkg_no] )" ).append("\n"); 
		query.append(",(SELECT  NVL(MAX(DP_SEQ),0)+COST_CD_RQST_SEQ AS DPSEQ FROM BKG_CHG_RT WHERE BKG_NO = @[bkg_no] )" ).append("\n"); 
		query.append(", FRT_TERM_CD" ).append("\n"); 
		query.append(", CGO_CATE_CD" ).append("\n"); 
		query.append(", CHG_CD" ).append("\n"); 
		query.append(", CURR_CD" ).append("\n"); 
		query.append(", RAT_UT_CD" ).append("\n"); 
		query.append(", RAT_AS_QTY" ).append("\n"); 
		query.append(", CHG_UT_AMT" ).append("\n"); 
		query.append(", CHG_AMT" ).append("\n"); 
		query.append(", 'N'" ).append("\n"); 
		query.append(", AUTO_RAT_CD" ).append("\n"); 
		query.append(", @[usr_id]" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append(", @[usr_id]" ).append("\n"); 
		query.append(", sysdate" ).append("\n"); 
		query.append("from bkg_cod_cost" ).append("\n"); 
		query.append("where bkg_no = @[bkg_no]" ).append("\n"); 
		query.append("and cod_rqst_seq = @[cod_rqst_seq]" ).append("\n"); 

	}
}
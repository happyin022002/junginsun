/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BlRatingDBDAOCreateRevenueAmountCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOCreateRevenueAmountCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Revenue와 BKG TEU Qty를 Insert한다
	  * </pre>
	  */
	public BlRatingDBDAOCreateRevenueAmountCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sgl_rev_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("oft_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOCreateRevenueAmountCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_REV_COST" ).append("\n"); 
		query.append("(   BKG_NO," ).append("\n"); 
		query.append("    REV_COST_SEQ," ).append("\n"); 
		query.append("    REV_AMT," ).append("\n"); 
		query.append("    ESTM_COST_AMT," ).append("\n"); 
		query.append("    BKG_TEU_QTY," ).append("\n"); 
		query.append("    CMPB_AMT," ).append("\n"); 
		query.append("    EQ_MGMT_UC_AMT," ).append("\n"); 
		query.append("    OFT_AMT," ).append("\n"); 
		query.append("    DMDT_REV_AMT," ).append("\n"); 
		query.append("    SGL_REV_FLG," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("    UPD_USR_ID," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(   @[bkg_no]," ).append("\n"); 
		query.append("    (SELECT NVL(MAX(REV_COST_SEQ),0) + 1 REV_COST_SEQ" ).append("\n"); 
		query.append("     FROM BKG_REV_COST" ).append("\n"); 
		query.append("     WHERE BKG_NO = @[bkg_no])," ).append("\n"); 
		query.append("    @[rev_amt]," ).append("\n"); 
		query.append("    (SELECT NVL(TTL_EXPN_AMT,0) ESTM_COST_AMT" ).append("\n"); 
		query.append("       FROM PRD_PROD_CTL_MST P" ).append("\n"); 
		query.append("          , BKG_BOOKING B" ).append("\n"); 
		query.append("      WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND B.PCTL_NO = P.PCTL_NO)," ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    (SELECT SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),2,OP_CNTR_QTY,OP_CNTR_QTY*2)) BKG_TEU_QTY" ).append("\n"); 
		query.append("     FROM BKG_QUANTITY" ).append("\n"); 
		query.append("     WHERE BKG_NO = @[bkg_no]) ," ).append("\n"); 
		query.append("     " ).append("\n"); 
		query.append("    ((TO_NUMBER(@[rev_amt]) " ).append("\n"); 
		query.append("      + (SELECT NVL(SUM(A2.ESTM_USD_TTL_AMT),0) DMDT_REV_AMT" ).append("\n"); 
		query.append("           FROM MAS_COM_PARA A1" ).append("\n"); 
		query.append("              , MAS_COM_COST_PARA A2" ).append("\n"); 
		query.append("              , BKG_BOOKING B1" ).append("\n"); 
		query.append("          WHERE 1=1" ).append("\n"); 
		query.append("            AND B1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("            AND B1.BKG_NO = A1.BKG_NO            " ).append("\n"); 
		query.append("            AND A1.PCTL_NO = A2.PCTL_NO    " ).append("\n"); 
		query.append("            AND A2.STND_COST_CD IN('43201011')" ).append("\n"); 
		query.append("            AND ROWNUM = 1)" ).append("\n"); 
		query.append("      - (SELECT NVL(TTL_EXPN_AMT,0) ESTM_COST_AMT" ).append("\n"); 
		query.append("           FROM PRD_PROD_CTL_MST P" ).append("\n"); 
		query.append("              , BKG_BOOKING B" ).append("\n"); 
		query.append("          WHERE B.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("            AND B.PCTL_NO = P.PCTL_NO)" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("     /     " ).append("\n"); 
		query.append("    (SELECT NVL(SUM(DECODE(SUBSTR(CNTR_TPSZ_CD,2,1),2,OP_CNTR_QTY,OP_CNTR_QTY*2)),0)" ).append("\n"); 
		query.append("       FROM BKG_QUANTITY" ).append("\n"); 
		query.append("      WHERE BKG_NO = @[bkg_no])), " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    (SELECT NVL(SUM(A2.RESPB_USD_TTL_AMT),0) EQ_MGMT_UC_AMT" ).append("\n"); 
		query.append("                   FROM MAS_COM_PARA A1" ).append("\n"); 
		query.append("                      , MAS_COM_COST_PARA A2" ).append("\n"); 
		query.append("                      , BKG_BOOKING B1" ).append("\n"); 
		query.append("                  WHERE 1=1" ).append("\n"); 
		query.append("                    AND B1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                    AND B1.BKG_NO = A1.BKG_NO            " ).append("\n"); 
		query.append("                    AND A1.PCTL_NO = A2.PCTL_NO    " ).append("\n"); 
		query.append("                    AND A2.STND_COST_CD IN ('92202012','92202011')" ).append("\n"); 
		query.append("     )," ).append("\n"); 
		query.append("    @[oft_amt]," ).append("\n"); 
		query.append("    (SELECT NVL(SUM(A2.ESTM_USD_TTL_AMT),0) DMDT_REV_AMT" ).append("\n"); 
		query.append("                   FROM MAS_COM_PARA A1" ).append("\n"); 
		query.append("                      , MAS_COM_COST_PARA A2" ).append("\n"); 
		query.append("                      , BKG_BOOKING B1" ).append("\n"); 
		query.append("                  WHERE 1=1" ).append("\n"); 
		query.append("                    AND B1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("                    AND B1.BKG_NO = A1.BKG_NO            " ).append("\n"); 
		query.append("                    AND A1.PCTL_NO = A2.PCTL_NO    " ).append("\n"); 
		query.append("                    AND A2.STND_COST_CD IN('43201011')" ).append("\n"); 
		query.append("                    AND ROWNUM = 1)," ).append("\n"); 
		query.append("    @[sgl_rev_flg]," ).append("\n"); 
		query.append("    @[cre_usr_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    @[upd_usr_id]," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
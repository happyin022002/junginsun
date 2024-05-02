/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PrdCreateManageDBDAOUpdatePrdDtlLnkCnstUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.common.prdcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PrdCreateManageDBDAOUpdatePrdDtlLnkCnstUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PrdCreateManageDBDAOUpdatePrdDtlLnkCnstUSQL
	  * </pre>
	  */
	public PrdCreateManageDBDAOUpdatePrdDtlLnkCnstUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rd_f",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.common.prdcreate.integration").append("\n"); 
		query.append("FileName : PrdCreateManageDBDAOUpdatePrdDtlLnkCnstUSQL").append("\n"); 
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
		query.append("UPDATE PRD_PROD_CTL_ROUT_DTL D2" ).append("\n"); 
		query.append("SET CNST_FLG = (" ).append("\n"); 
		query.append("                SELECT RD_SVC" ).append("\n"); 
		query.append("                FROM (" ).append("\n"); 
		query.append("                    SELECT" ).append("\n"); 
		query.append("                        SVC,PCTL_NO ,ORG_NOD_CD,DEST_NOD_CD,TRSP_MOD_CD, PRI" ).append("\n"); 
		query.append("                        ,DECODE(SUBSTR(CNTR_TPSZ_CD, 1, 1),'R',DECODE(@[rd_f] ,'Y', DECODE( SVC,'X', DECODE(CNTR_TPSZ_CD, CNTR_TP_CD,''),SVC), SVC), SVC) RD_SVC" ).append("\n"); 
		query.append("                    FROM (" ).append("\n"); 
		query.append("                         SELECT  DECODE(NVL(SVC_USE_FLG, 'Y'), 'N', 'X', 'L') SVC ,PCTL_CNST_ITM_NM  ,D.ORG_NOD_CD, D.DEST_NOD_CD,C.CNTR_TP_CD,Q.CNTR_TPSZ_CD,D.TRSP_MOD_CD" ).append("\n"); 
		query.append("                                 , D.PCTL_NO" ).append("\n"); 
		query.append("                                 ,ROW_NUMBER() OVER(PARTITION BY D.PCTL_NO,D.ORG_NOD_CD,D.DEST_NOD_CD,D.TRSP_MOD_CD ORDER BY D.ORG_NOD_CD,D.DEST_NOD_CD,D.TRSP_MOD_CD ,DECODE(NVL(SVC_USE_FLG, 'Y'), 'N', 'X', 'L') DESC) PRI" ).append("\n"); 
		query.append("                         FROM PRD_LNK_CNST_MGMT C, PRD_PROD_CTL_QTY Q , PRD_PROD_CTL_ROUT_DTL D" ).append("\n"); 
		query.append("                             ,PRD_PROD_CTL_MST M, MDM_VSL_SVC_LANE S" ).append("\n"); 
		query.append("                         WHERE d.pctl_no   LIKE @[hd_pctl_no]||'%'" ).append("\n"); 
		query.append("                         AND M.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("                         AND D.NOD_LNK_DIV_CD = 'L'" ).append("\n"); 
		query.append("                         and D.PCTL_NO = Q.PCTL_NO" ).append("\n"); 
		query.append("                         AND D.ORG_NOD_CD LIKE C.LNK_ORG_NOD_CD||'%'" ).append("\n"); 
		query.append("                         AND D.DEST_NOD_CD LIKE C.LNK_DEST_NOD_CD||'%'" ).append("\n"); 
		query.append("                         AND DECODE(D.TRSP_MOD_CD, 'VD', 'WD', D.TRSP_MOD_CD) = DECODE(C.TRSP_MOD_CD, 'AL' ,DECODE(D.TRSP_MOD_CD, 'VD', 'WD', D.TRSP_MOD_CD), C.TRSP_MOD_CD )" ).append("\n"); 
		query.append("                         AND D.VSL_SLAN_CD || ',' || DECODE(S.VSL_SVC_TP_CD, 'O', 'FDR') LIKE '%' || C.VSL_SLAN_CD || '%'" ).append("\n"); 
		query.append("                         AND NVL(D.VSL_CD || D.SKD_VOY_NO || D.SKD_DIR_CD, '#') = DECODE(C.VSL_CD || C.SKD_VOY_NO || C.SKD_DIR_CD, NULL, NVL(D.VSL_CD || D.SKD_VOY_NO || D.SKD_DIR_CD, '#'), C.VSL_CD || C.SKD_VOY_NO || C.SKD_DIR_CD)" ).append("\n"); 
		query.append("                         AND NVL(M.CMDT_CD,'X')  = NVL(C.CMDT_CD, NVL(M.CMDT_CD,'X'))" ).append("\n"); 
		query.append("                         AND NVL(C.DELT_FLG, 'N') <> 'Y'" ).append("\n"); 
		query.append("                         AND NVL(C.CNTR_TP_CD, Q.CNTR_TPSZ_CD)" ).append("\n"); 
		query.append("                            = DECODE(C.CNTR_TP_CD, NULL, Q.CNTR_TPSZ_CD, DECODE(SUBSTR(Q.CNTR_TPSZ_CD, 1, 1), 'T', 'T', 'O', 'S', 'F', 'S'," ).append("\n"); 
		query.append("                                                                                --'D',DECODE(Q.CNTR_TPSZ_CD, 'D5', 'D5', 'D7', 'D7', Q.CNTR_TPSZ_CD)," ).append("\n"); 
		query.append("                                                                                --'R',DECODE(Q.CNTR_TPSZ_CD, 'R2', 'R2', 'R5', 'R5', Q.CNTR_TPSZ_CD)) )" ).append("\n"); 
		query.append("                                                                                'D',Q.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("                                                                                'R',Q.CNTR_TPSZ_CD) )" ).append("\n"); 
		query.append("                         AND (" ).append("\n"); 
		query.append("  				-- 사용자 요청으로 PC생성일 기준으로 변경" ).append("\n"); 
		query.append("                                    TRUNC(TO_DATE(NVL(C.EFF_FM_DT,'19000101'),'yyyy/mm/dd hh24:mi:ss')) <= M.CRE_DT AND" ).append("\n"); 
		query.append("                                    M.CRE_DT < TRUNC(TO_DATE(NVL(C.EFF_TO_DT,'25000101'),'yyyy/mm/dd hh24:mi:ss')+1)" ).append("\n"); 
		query.append("                            )" ).append("\n"); 
		query.append("                         AND S.VSL_SLAN_CD(+) = D.VSL_SLAN_CD" ).append("\n"); 
		query.append("                         )" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("                WHERE PRI = 1 " ).append("\n"); 
		query.append("                AND PCTL_NO = D2.PCTL_NO" ).append("\n"); 
		query.append("                AND ORG_NOD_CD = D2.ORG_NOD_CD" ).append("\n"); 
		query.append("                AND DEST_NOD_CD = D2.DEST_NOD_CD" ).append("\n"); 
		query.append("                AND TRSP_MOD_CD = D2.TRSP_MOD_CD" ).append("\n"); 
		query.append("                AND ROWNUM = 1" ).append("\n"); 
		query.append("               )" ).append("\n"); 
		query.append("WHERE D2.PCTL_NO LIKE DECODE(@[hd_pctl_no], NULL, NULL, @[hd_pctl_no]||'%')" ).append("\n"); 
		query.append("AND D2.NOD_LNK_DIV_CD = 'L'" ).append("\n"); 

	}
}
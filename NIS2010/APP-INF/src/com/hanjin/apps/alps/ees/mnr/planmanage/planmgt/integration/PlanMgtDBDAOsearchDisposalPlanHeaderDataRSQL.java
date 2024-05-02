/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PlanMgtDBDAOsearchDisposalPlanHeaderDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.31
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.08.31 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author WanGyu Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PlanMgtDBDAOsearchDisposalPlanHeaderDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 조회 - Disposal Planning Summary
	  * </pre>
	  */
	public PlanMgtDBDAOsearchDisposalPlanHeaderDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_pln_yr",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_knd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_pln_grp_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_pln_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.integration").append("\n"); 
		query.append("FileName : PlanMgtDBDAOsearchDisposalPlanHeaderDataRSQL").append("\n"); 
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
		query.append("SELECT A.MNR_PLN_SEQ" ).append("\n"); 
		query.append(", TO_CHAR(A.CRE_DT, 'YYYY-MM-DD') CRE_DT" ).append("\n"); 
		query.append(", A.CRE_USR_ID" ).append("\n"); 
		query.append(", A.MNR_PLN_FLG" ).append("\n"); 
		query.append(", A.MNR_PLN_OFC_CD" ).append("\n"); 
		query.append(", A.MNR_PLN_GRP_NO" ).append("\n"); 
		query.append(", B.CTRL_OFC_CD" ).append("\n"); 
		query.append(", B.CTRL_OFC_CD AS OFFICE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#foreach($key IN ${cntr_tpsz_cd_seqs})" ).append("\n"); 
		query.append("#set ($col_name1=\"CNTR\"+$velocityCount+\"_CHG_VAL\")" ).append("\n"); 
		query.append(", SUM(DECODE(B.EQ_TPSZ_CD, '$key', B.EQ_QTY)) AS $col_name1" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", SUM(B.EQ_QTY) AS TOTAL" ).append("\n"); 
		query.append(", 'sheet1' AS SHEET_GUBN" ).append("\n"); 
		query.append("FROM MNR_PLN_HDR A" ).append("\n"); 
		query.append(", MNR_PLN_DTL B" ).append("\n"); 
		query.append("WHERE A.MNR_PLN_SEQ = B.MNR_PLN_SEQ(+)" ).append("\n"); 
		query.append("AND A.MNR_GRP_TP_CD = 'DSP'" ).append("\n"); 
		query.append("AND B.CTRL_OFC_CD = @[mnr_pln_ofc_cd]" ).append("\n"); 
		query.append("AND A.EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND A.MNR_PLN_YR = @[mnr_pln_yr]" ).append("\n"); 
		query.append("AND A.MNR_PLN_GRP_NO = @[mnr_pln_grp_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${mnr_office_level} == 'L2')" ).append("\n"); 
		query.append("AND A.MNR_PLN_FLG = NVL((SELECT MNR_PLN_FLG FROM MNR_PLN_HDR" ).append("\n"); 
		query.append("WHERE MNR_GRP_TP_CD = 'DSP'" ).append("\n"); 
		query.append("AND EQ_KND_CD = @[eq_knd_cd]" ).append("\n"); 
		query.append("AND MNR_PLN_YR = @[mnr_pln_yr]" ).append("\n"); 
		query.append("AND MNR_PLN_GRP_NO = @[mnr_pln_grp_no]" ).append("\n"); 
		query.append("AND MNR_PLN_OFC_CD = @[mnr_pln_ofc_cd]), 'Y')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("GROUP BY A.MNR_PLN_SEQ" ).append("\n"); 
		query.append(", TO_CHAR(A.CRE_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append(", A.CRE_USR_ID" ).append("\n"); 
		query.append(", A.MNR_PLN_FLG" ).append("\n"); 
		query.append(", A.MNR_PLN_OFC_CD" ).append("\n"); 
		query.append(", A.MNR_PLN_GRP_NO" ).append("\n"); 
		query.append(", B.CTRL_OFC_CD" ).append("\n"); 

	}
}
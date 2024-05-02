/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RepairMgtDBDAOaddESTWOCreationDetailDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.25
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2010.05.25 이주현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE JU HYUN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RepairMgtDBDAOaddESTWOCreationDetailDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Repair Work Order List 입력 (Detail)
	  * </pre>
	  */
	public RepairMgtDBDAOaddESTWOCreationDetailDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_ord_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_ver_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rqst_eq_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mnr_ord_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rpr_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_dmg_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.integration").append("\n"); 
		query.append("FileName : RepairMgtDBDAOaddESTWOCreationDetailDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_ORD_DTL(" ).append("\n"); 
		query.append("MNR_ORD_OFC_CTY_CD" ).append("\n"); 
		query.append(",MNR_ORD_SEQ" ).append("\n"); 
		query.append(",ORD_DTL_SEQ" ).append("\n"); 
		query.append(",COST_CD" ).append("\n"); 
		query.append(",ACCT_CD" ).append("\n"); 
		query.append(",COST_DTL_CD" ).append("\n"); 
		query.append(",RPR_OFFH_FLG" ).append("\n"); 
		query.append(",MNR_RT_TP_CD" ).append("\n"); 
		query.append(",MNR_EXPN_DTL_NM" ).append("\n"); 
		query.append(",EQ_NO" ).append("\n"); 
		query.append(",EQ_TPSZ_CD" ).append("\n"); 
		query.append(",RQST_REF_NO" ).append("\n"); 
		query.append(",SPR_PRT_UT_TP_NM" ).append("\n"); 
		query.append(",SPR_PRT_NO" ).append("\n"); 
		query.append(",SPR_PRT_NM" ).append("\n"); 
		query.append(",YD_CD" ).append("\n"); 
		query.append(",RPR_RSLT_DT" ).append("\n"); 
		query.append(",RPR_QTY" ).append("\n"); 
		query.append(",SPR_PRT_UC_AMT" ).append("\n"); 
		query.append(",BZC_AMT" ).append("\n"); 
		query.append(",COST_AMT" ).append("\n"); 
		query.append(",N3PTY_FLG" ).append("\n"); 
		query.append(",N3PTY_BIL_TTL_AMT" ).append("\n"); 
		query.append(",MNR_VRFY_TP_CD" ).append("\n"); 
		query.append(",ORD_DTL_RMK" ).append("\n"); 
		query.append(",INV_NO" ).append("\n"); 
		query.append(",FILE_SEQ" ).append("\n"); 
		query.append(",RPR_RQST_SEQ" ).append("\n"); 
		query.append(",RPR_RQST_VER_NO" ).append("\n"); 
		query.append(",PAY_INV_SEQ" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT @[mnr_ord_ofc_cty_cd]" ).append("\n"); 
		query.append(", @[mnr_ord_seq]" ).append("\n"); 
		query.append(", 1" ).append("\n"); 
		query.append(", NVL(B.COST_CD, DECODE(@[eq_knd_cd], 'U', 'MRDRRC', 'Z', 'MRZSRC', 'G', 'MRGSRC'))" ).append("\n"); 
		query.append(", MNR_COMMON_PKG.MNR_GET_ACCT_CD_FNC(@[eq_knd_cd], NVL(B.COST_CD, DECODE(@[eq_knd_cd], 'U', 'MRDRRC', 'Z', 'MRZSRC', 'G', 'MRGSRC')), @[eq_tpsz_cd], A.RPR_OFFH_FLG) AS ACCT_CD" ).append("\n"); 
		query.append(", 'NR' COST_DTL_CD" ).append("\n"); 
		query.append(", NVL(A.RPR_OFFH_FLG,'N')" ).append("\n"); 
		query.append(", 'NR' MNR_RT_TP_CD" ).append("\n"); 
		query.append(", '' MNR_EXPN_DTL_NM" ).append("\n"); 
		query.append(", A.RQST_EQ_NO" ).append("\n"); 
		query.append(", A.EQ_TPSZ_CD" ).append("\n"); 
		query.append(", A.RQST_REF_NO" ).append("\n"); 
		query.append(", '' SPR_PRT_UT_TP_NM" ).append("\n"); 
		query.append(", '' SPR_PRT_NO" ).append("\n"); 
		query.append(", '' SPR_PRT_NM" ).append("\n"); 
		query.append(", A.RPR_YD_CD" ).append("\n"); 
		query.append(", DECODE(A.RPR_WRK_TP_CD,'A',A.APRO_DT, DECODE(@[mnr_dmg_flg], '0', SYSDATE, '')) AS RPR_RSLT_DT" ).append("\n"); 
		query.append(", 1  RPR_QTY" ).append("\n"); 
		query.append(", '' SPR_PRT_UC_AMT" ).append("\n"); 
		query.append(", B.BZC_AMT" ).append("\n"); 
		query.append(", B.COST_AMT" ).append("\n"); 
		query.append(", A.N3PTY_FLG" ).append("\n"); 
		query.append(", B.N3PTY_BIL_MTRL_COST_AMT" ).append("\n"); 
		query.append(", '' MNR_VRFY_TP_CD" ).append("\n"); 
		query.append(", '' ORD_DTL_RMK" ).append("\n"); 
		query.append(", '' INV_NO" ).append("\n"); 
		query.append(", A.FILE_SEQ" ).append("\n"); 
		query.append(", A.RPR_RQST_SEQ" ).append("\n"); 
		query.append(", A.RPR_RQST_VER_NO" ).append("\n"); 
		query.append(", '' PAY_INV_SEQ" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[upd_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append("FROM MNR_RPR_RQST_HDR A" ).append("\n"); 
		query.append(", ( SELECT B.RQST_EQ_NO" ).append("\n"); 
		query.append(", B.RPR_RQST_SEQ" ).append("\n"); 
		query.append(", B.RPR_RQST_VER_NO" ).append("\n"); 
		query.append(", MAX(B.COST_CD) COST_CD" ).append("\n"); 
		query.append(", SUM(B.MNR_AGMT_AMT) BZC_AMT" ).append("\n"); 
		query.append(", SUM(B.MNR_WRK_AMT)  COST_AMT" ).append("\n"); 
		query.append(", SUM(B.N3PTY_BIL_MTRL_COST_AMT) N3PTY_BIL_MTRL_COST_AMT" ).append("\n"); 
		query.append("FROM MNR_RPR_RQST_DTL B" ).append("\n"); 
		query.append("WHERE B.RQST_EQ_NO = @[rqst_eq_no]" ).append("\n"); 
		query.append("AND B.RPR_RQST_SEQ = @[rpr_rqst_seq]" ).append("\n"); 
		query.append("AND B.RPR_RQST_VER_NO = @[rpr_rqst_ver_no]" ).append("\n"); 
		query.append("GROUP BY B.RQST_EQ_NO, B.RPR_RQST_SEQ ,B.RPR_RQST_VER_NO" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE B.RQST_EQ_NO = A.RQST_EQ_NO" ).append("\n"); 
		query.append("AND B.RPR_RQST_SEQ = A.RPR_RQST_SEQ" ).append("\n"); 
		query.append("AND B.RPR_RQST_VER_NO = A.RPR_RQST_VER_NO" ).append("\n"); 
		query.append("AND A.RQST_EQ_NO = @[rqst_eq_no]" ).append("\n"); 
		query.append("AND A.RPR_RQST_SEQ = @[rpr_rqst_seq]" ).append("\n"); 
		query.append("AND A.RPR_RQST_VER_NO = @[rpr_rqst_ver_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}
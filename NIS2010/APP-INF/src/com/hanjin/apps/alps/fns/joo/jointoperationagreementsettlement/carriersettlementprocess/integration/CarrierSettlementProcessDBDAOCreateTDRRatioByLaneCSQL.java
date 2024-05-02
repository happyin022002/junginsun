/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOCreateTDRRatioByLaneCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.07
*@LastModifier : 
*@LastVersion : 1.0
* 2013.01.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOCreateTDRRatioByLaneCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 1. Ticket No  : CHM-201218380
	  *    개발자 : 김상근
	  *    Ticket Title : [ALPS JOO] TDR Inquiry by VVD
	  *    Description  :  Additional Slot 칼럼 및 Sub Alloc and Ratio 팝업 추가.
	  * 
	  * 2. Ticket No  : CHM-201322276
	  *    개발자 : 이수진
	  *    Ticket Title : [ALPS JOO] 모델링 표준에 맞게 처리 되도록 테이블 칼럼 변경 작업 및 기능 변경
	  *    Description  :  JO_REP_CRR_CD_FLG => JO_REP_CRR_FLG으로 컬럼명 변경 작업
	  * 
	  * 
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOCreateTDRRatioByLaneCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_40ft_sub_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_45ft_n1st_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_rep_crr_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_45ft_sub_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_20ft_sub_teu_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_20ft_n1st_rto",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_rnd_rule_lvl",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("jo_40ft_n1st_rto",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("jo_45ft_n2nd_rto",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOCreateTDRRatioByLaneCSQL").append("\n"); 
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
		query.append("MERGE INTO JOO_TDR_RTO A" ).append("\n"); 
		query.append("USING" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  @[rlane_cd] AS RLANE_CD, @[jo_crr_cd] AS JO_CRR_CD FROM DUAL" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("ON" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("A.RLANE_CD = B.RLANE_CD" ).append("\n"); 
		query.append("AND A.JO_CRR_CD = B.JO_CRR_CD" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("UPDATE SET  A.JO_20FT_N1ST_RTO    = NVL(@[jo_20ft_n1st_rto], 0)" ).append("\n"); 
		query.append(", A.JO_20FT_SUB_TEU_QTY = NVL(@[jo_20ft_sub_teu_qty], 0)" ).append("\n"); 
		query.append(", A.JO_40FT_N1ST_RTO    = NVL(@[jo_40ft_n1st_rto], 0)" ).append("\n"); 
		query.append(", A.JO_40FT_SUB_TEU_QTY = NVL(@[jo_40ft_sub_teu_qty], 0)" ).append("\n"); 
		query.append(", A.JO_45FT_N1ST_RTO    = NVL(@[jo_45ft_n1st_rto], 0)" ).append("\n"); 
		query.append(", A.JO_45FT_N2ND_RTO    = NVL(@[jo_45ft_n2nd_rto], 0)" ).append("\n"); 
		query.append(", A.JO_45FT_SUB_TEU_QTY = NVL(@[jo_45ft_sub_teu_qty], 0)" ).append("\n"); 
		query.append(", A.JO_RND_RULE_LVL     = @[jo_rnd_rule_lvl]" ).append("\n"); 
		query.append(", A.JO_REP_CRR_FLG      = @[jo_rep_crr_flg]" ).append("\n"); 
		query.append(", A.UPD_USR_ID          = @[usr_id]" ).append("\n"); 
		query.append(", A.UPD_DT              = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("INSERT" ).append("\n"); 
		query.append("(   RLANE_CD" ).append("\n"); 
		query.append(", JO_CRR_CD" ).append("\n"); 
		query.append(", JO_20FT_N1ST_RTO" ).append("\n"); 
		query.append(", JO_20FT_SUB_TEU_QTY" ).append("\n"); 
		query.append(", JO_40FT_N1ST_RTO" ).append("\n"); 
		query.append(", JO_40FT_SUB_TEU_QTY" ).append("\n"); 
		query.append(", JO_45FT_N1ST_RTO" ).append("\n"); 
		query.append(", JO_45FT_N2ND_RTO" ).append("\n"); 
		query.append(", JO_45FT_SUB_TEU_QTY" ).append("\n"); 
		query.append(", JO_RND_RULE_LVL" ).append("\n"); 
		query.append(", JO_REP_CRR_FLG" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("VALUES" ).append("\n"); 
		query.append("(   B.RLANE_CD" ).append("\n"); 
		query.append(", B.JO_CRR_CD" ).append("\n"); 
		query.append(", NVL(@[jo_20ft_n1st_rto], 0)" ).append("\n"); 
		query.append(", NVL(@[jo_20ft_sub_teu_qty], 0)" ).append("\n"); 
		query.append(", NVL(@[jo_40ft_n1st_rto], 0)" ).append("\n"); 
		query.append(", NVL(@[jo_40ft_sub_teu_qty], 0)" ).append("\n"); 
		query.append(", NVL(@[jo_45ft_n1st_rto], 0)" ).append("\n"); 
		query.append(", NVL(@[jo_45ft_n2nd_rto], 0)" ).append("\n"); 
		query.append(", NVL(@[jo_45ft_sub_teu_qty], 0)" ).append("\n"); 
		query.append(", @[jo_rnd_rule_lvl]" ).append("\n"); 
		query.append(", @[jo_rep_crr_flg]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[cre_usr_id]" ).append("\n"); 
		query.append(", SYSDATE" ).append("\n"); 
		query.append(", @[usr_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}